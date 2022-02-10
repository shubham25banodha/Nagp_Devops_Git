# NAGP_Automation


###Prerequisites
System should have following sets of software to run this project:
1. Java 1.8
2. Maven


###Framework Related Details
Browser name and wait time can be changed from *config.properties* file

Config File Location: src\main\resources\
TestData Location: src\main\resources\testData

*Current Test Report Location:* Current_Report\
*Archive Test Report Location:* Archive_Report

###How to Execute Test
To run test from command line do following steps:
1. Open Terminal
2. Moved to project location (cd /path/to/this/project/folder)
3. run command any of following command: \
   mvn clean test -DtestngXML=AmazonRegression.xml \
   mvn clean test -DtestngXML=AmazonSmoke.xml
   

###Note
1. To show failed test case and screenshot feature I have intentionally failed a test case *Home About_Us*. If you want to execute full suite without any failure please remove 1 from *AboutUsPageTitle* variable from test data file *src\main\resources\testData\homePageTestdata.properties*
2. During scripting time I have seen failure due to Amazon application build fail