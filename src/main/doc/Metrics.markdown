Metrics
=======

BPEL Element Counts
-------------------

BPELUnit can calculate counts for all BPEL elements, namely the basic activities (assign, invoke, receive, reply, empty, throw, rethrow, exit, validate), structured activities (sequence, if, forEach, while, repeatUntil, flow, pick), links, pick branches, scopes, variables, various handlers, and various extension activities, including WS-HT, ActiveVOS and WPS speicfic extensions.

Nonlinear activities are those than branch or merge the control-flow: all structured activities except sequence and handlers.

BPEL Complexity Metrics
-----------------------

Sublanguage Complexity Metrics (Data Flow)
------------------------------------------

Metrics for XPath:

* total number of lines of code
* number of queries
* lines of code in queries
* number of expressions
* lines of code in expressions
* Halstead complexity

Metrics for XSLT:
* lines of code
* McCabe complexity					}
* Halstead complexity
* number of conditions (if, switch, ...)
* number of loops

Metrics for XQuery:
* number of simple expressions (those without ifs or flowr statements)
* number of complex expressions (those which include ifs or flowr statements)
* lines of code for simple expressions
* lines of code for complex expressions
* lines of code for simple queries
* lines of code for complex queries
* number of ifs 
* number of loops
* McCabe complexity for expressions
* McCabe complexity for queries
* McCabe complexity for queries and expressions
* Halstead complexity for expressions
* Halstead complexity for queries
* Halstead complexity for queries and expressions

Metrics for Java:

* lines of code
* source lines of code (without comments and whitespace)
* McCabe Complexity
* Halstead complexity
* number of conditions
* number of loops
* number of Java fragments

Metrics for WPS:

* Number of WPS Built-Ins
* Number of BOMaps
* Number of XMLMaps


