package de.danielluebke.bpelstats.metrics.sublanguagestats;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.tree.Tree;

import es.uca.webservices.xquery.parser.XQueryParser.FlworExprContext;
import es.uca.webservices.xquery.parser.XQueryParser.ForVarContext;
import es.uca.webservices.xquery.parser.XQueryParser.FunctionDeclContext;
import es.uca.webservices.xquery.parser.XQueryParser.IfExprContext;
import es.uca.webservices.xquery.parser.XQueryParser.LetClauseContext;
import es.uca.webservices.xquery.parser.XQueryParser.ModuleContext;
import es.uca.webservices.xquery.parser.util.XQueryParsingException;
import es.uca.webservices.xquery.parser.util.XQueryValidatingParser;

public class XQuerySubLanguageParser {

	private int loc = 0;
	private int complexity = 0;
	private boolean isComplex;
	private HalsteadMetrics halsteadMetrics;
	private int numConditions;
	private int numIterations;

	public void parse(String xquery) throws XQueryParsingException {
		numConditions = 0;
		numIterations = 0;
		
		loc = LOCCalculator.calculateLOC(xquery);
		complexity = calculateComplexity(xquery);
		
		XQueryHalsteadMetricsCalculator xqueryHalsteadCalculator = new XQueryHalsteadMetricsCalculator();
		xqueryHalsteadCalculator.parse(xquery);
		halsteadMetrics = xqueryHalsteadCalculator.getHalsteadMetrics();
	}

	private int calculateComplexity(String xquery)
			throws XQueryParsingException {
		int complexity = 0;
		isComplex = false;

		boolean hasFunction = false;
		ANTLRInputStream csi = new ANTLRInputStream(xquery);
		XQueryValidatingParser parser = new XQueryValidatingParser();
		ModuleContext moduleContext = parser.parse(csi);
		List<Tree> toParse = new ArrayList<Tree>();
		toParse.addAll(moduleContext.children);
		while (toParse.size() > 0) {
			Tree t = toParse.remove(0);
			if (t instanceof FlworExprContext || t instanceof IfExprContext
					|| t instanceof LetClauseContext) {
				isComplex = true;
			}

			if (t instanceof ForVarContext || t instanceof IfExprContext
					|| t instanceof FunctionDeclContext) {
				complexity++;
				hasFunction |= (t instanceof FunctionDeclContext);
			}
			
			if(t instanceof ForVarContext) {
				numIterations++;
			}
			if(t instanceof IfExprContext) {
				numConditions += 2; // else is mandatory in XQuery
			}

			for (int i = 0; i < t.getChildCount(); i++) {
				toParse.add(t.getChild(i));
			}
		}

		// if there is no function, i.e. a "main" module, this has an inherent
		// complexity of 1
		if (!hasFunction) {
			complexity++;
		}

		return complexity;
	}

	public int getLoc() {
		return loc;
	}

	public int getComplexity() {
		return complexity;
	}

	public boolean isComplex() {
		return isComplex;
	}

	public HalsteadMetrics getHalsteadMetrics() {
		return halsteadMetrics;
	}
	
	public int getNumConditions() {
        return numConditions;
    }

    public int getNumIterations() {
        return numIterations;
    }
}
