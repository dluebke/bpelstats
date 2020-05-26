BPELStats README
================

BPELStats is a tool for calculating a variety of BPEL Metrics. If you want to get a feeling of your process complexity and different aspects, BPELStats is for you -- both as a practitioner working in BPEL projects as well as a researcher analyzing process sets.

The User Documentation is located under src/main/doc

The rest of this README describes how to build BPELStats.

Building BPELStats
------------------

BPELStats provides a very simple Maven Build. You can clone the repository and simple run: 

   mvn install

If Maven cannot find the xquery dependency you need to clone the source (e.g., from my fork at https://github.com/dluebke/xquery-parser ) and run 

mvn install 

within its directory. Afterwards, change the working directory to the BPELStats checkout directory and run mvn install again.

After a successful build you will find a bpelstats-%VERSION%-jar-with-dependencies.jar (replace %VERSION% with the current version number) in the target directory.

You can run 

   java -jar bpelstats-%VERSION%-jar-with-dependencies.jar --help 

to get started.
