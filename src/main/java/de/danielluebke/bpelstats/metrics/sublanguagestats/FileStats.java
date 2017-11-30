package de.danielluebke.bpelstats.metrics.sublanguagestats;

import java.io.File;

public class FileStats {

	public File absoluteFileName;
	
	public String fileType;
	
	public int xquerySimpleExpressionLOCs;
	public int xquerySimpleQueryLOCs;
	public int xqueryExternalLOCs;
	public int xqueryReuseLOCs;
	public int xsltExternalLOCs;
	public int xsltReuseLOCs;
	public int xpathExpressionsLOCs;
	public int xpathQueriesLOCs;
	public int xqueryComplexExpressionLOCs;
	public int xqueryComplexQueryLOCs;
	public int xquerySimpleExpressionOccurrences = 0;
	public int xqueryComplexExpressionOccurrences = 0;
	public int xquerySimpleQueryOccurrences = 0;
	public int xqueryComplexQueryOccurrences = 0;
	public int xpathQueryOccurrences = 0;
	public int xpathExpressionOccurrences = 0;
	public int xqueryComplexity = 0;
	public int xsltComplexity = 0;
	public int javaExpressionLOCs = 0;
	public int javaExpressionSLOCs = 0;
	public int javaExpressionOccurrences = 0;
	public int wpsBuiltInOccurences = 0;
	public HalsteadMetrics xpathHalstead = new HalsteadMetrics();
	public HalsteadMetrics xsltHalstead = new HalsteadMetrics();
	public HalsteadMetrics xqueryHalstead = new HalsteadMetrics();

	@Override
	public String toString() {
		return absoluteFileName.getName() + ": XQ=" + (xquerySimpleExpressionLOCs+xquerySimpleQueryLOCs+xqueryExternalLOCs+xqueryReuseLOCs) + ", XSLT=" + (xsltReuseLOCs+xsltExternalLOCs) + ", XPath:" + (xpathExpressionsLOCs+xpathQueriesLOCs);
	}
	
	public void add(FileStats f) {
		xquerySimpleExpressionLOCs += f.xquerySimpleExpressionLOCs;
		xquerySimpleQueryLOCs += f.xquerySimpleQueryLOCs;
		xqueryExternalLOCs += f.xqueryExternalLOCs;
		xqueryReuseLOCs += f.xqueryReuseLOCs;
		xsltExternalLOCs += f.xsltExternalLOCs;
		xsltReuseLOCs += f.xsltReuseLOCs;
		xpathExpressionsLOCs += f.xpathExpressionsLOCs;
		xpathQueriesLOCs += f.xpathQueriesLOCs;
		xqueryComplexExpressionLOCs += f.xqueryComplexExpressionLOCs;
		xqueryComplexQueryLOCs += f.xqueryComplexQueryLOCs;
		xquerySimpleExpressionOccurrences += f.xquerySimpleExpressionOccurrences;
		xqueryComplexExpressionOccurrences += f.xqueryComplexExpressionOccurrences;
		xquerySimpleQueryOccurrences += f.xquerySimpleQueryOccurrences;
		xqueryComplexQueryOccurrences += f.xqueryComplexQueryOccurrences;
		xpathQueryOccurrences += f.xpathQueryOccurrences;
		xpathExpressionOccurrences += f.xpathExpressionOccurrences;
		xqueryComplexity += f.xqueryComplexity;
		xsltComplexity += f.xsltComplexity;
		javaExpressionLOCs += f.javaExpressionLOCs;
		javaExpressionSLOCs += f.javaExpressionSLOCs;
		javaExpressionOccurrences += f.javaExpressionOccurrences;
		wpsBuiltInOccurences += f.wpsBuiltInOccurences;
		xpathHalstead.add(f.xpathHalstead);
		xsltHalstead.add(f.xsltHalstead);
		xqueryHalstead.add(f.xqueryHalstead);
	}
}
