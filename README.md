# Text File Metrics

## Build prerequisites

Check that you have Maven and Java installed using the "mvn -v" command.  
For example:

    PS C:\Users\Lewis> mvn -v
    Apache Maven 3.9.5 (57804ffe001d7215b5e7bcb531cf83df38f93546)
    Maven home: C:\Program Files\Maven\apache-maven-3.9.5
    Java version: 17.0.7, vendor: Amazon.com Inc., runtime: C:\Program Files\Amazon Corretto\jdk17.0.7_7
    Default locale: en_US, platform encoding: Cp1252
    OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"

## Build the code

Open a Windows Terminal PowerShell or Command Prompt and build the text-file-metrics project. 
For example:

    PS C:\Users\Lewis\IntelliJ\text-file-metrics> mvn clean install
    [INFO] Scanning for projects...
    [INFO]
    [INFO] ---------------------< groupId:text-file-metrics >----------------------
    [INFO] Building text-file-metrics 1.0-SNAPSHOT
    [INFO]   from pom.xml
    [INFO] --------------------------------[ jar ]---------------------------------
    [INFO]
    [INFO] --- clean:3.2.0:clean (default-clean) @ text-file-metrics ---
    [INFO] Deleting C:\Users\Lewis\IntelliJ\text-file-metrics\target
    [INFO]
    [INFO] --- resources:3.3.1:resources (default-resources) @ text-file-metrics ---
    [INFO] Copying 0 resource from src\main\resources to target\classes
    [INFO]
    [INFO] --- compiler:3.11.0:compile (default-compile) @ text-file-metrics ---
    [INFO] Changes detected - recompiling the module! :source
    [INFO] Compiling 1 source file with javac [debug target 17] to target\classes
    [INFO]
    [INFO] --- resources:3.3.1:testResources (default-testResources) @ text-file-metrics ---
    [INFO] skip non existing resourceDirectory C:\Users\Lewis\IntelliJ\text-file-metrics\src\test\resources
    [INFO]
    [INFO] --- compiler:3.11.0:testCompile (default-testCompile) @ text-file-metrics ---
    [INFO] Changes detected - recompiling the module! :dependency
    [INFO] Compiling 1 source file with javac [debug target 17] to target\test-classes
    [INFO]
    [INFO] --- surefire:3.1.2:test (default-test) @ text-file-metrics ---
    [INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
    [INFO]
    [INFO] -------------------------------------------------------
    [INFO]  T E S T S
    [INFO] -------------------------------------------------------
    [INFO] Running TextFileMetricsTest
    
    Target file name = provided-text-file.txt
    Word count = 9
    Average word length = 4.556
    Number of words of length 1 is 1
    Number of words of length 2 is 1
    Number of words of length 3 is 1
    Number of words of length 4 is 2
    Number of words of length 5 is 2
    Number of words of length 7 is 1
    Number of words of length 10 is 1
    The most frequently occurring word length is 2, for word lengths of 4 & 5
    
    Target file name = bible_daily_extract.txt
    Word count = 2147
    Average word length = 3.889
    Number of words of length 1 is 29
    Number of words of length 2 is 291
    Number of words of length 3 is 781
    Number of words of length 4 is 446
    Number of words of length 5 is 282
    Number of words of length 6 is 153
    Number of words of length 7 is 87
    Number of words of length 8 is 41
    Number of words of length 9 is 26
    Number of words of length 10 is 9
    Number of words of length 11 is 2
    The most frequently occurring word length is 781, for word lengths of 3
    [INFO] Tests run: 34, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.587 s -- in TextFileMetricsTest
    [INFO]
    [INFO] Results:
    [INFO]
    [INFO] Tests run: 34, Failures: 0, Errors: 0, Skipped: 0
    [INFO]
    [INFO]
    [INFO] --- jar:3.3.0:jar (default-jar) @ text-file-metrics ---
    [INFO] Building jar: C:\Users\Lewis\IntelliJ\text-file-metrics\target\text-file-metrics-1.0-SNAPSHOT.jar
    [INFO]
    [INFO] --- install:3.1.1:install (default-install) @ text-file-metrics ---
    [INFO] Installing C:\Users\Lewis\IntelliJ\text-file-metrics\pom.xml to C:\Users\Lewis\.m2\repository\groupId\text-file-metrics\1.0-SNAPSHOT\text-file-metrics-1.0-SNAPSHOT.pom
    [INFO] Installing C:\Users\Lewis\IntelliJ\text-file-metrics\target\text-file-metrics-1.0-SNAPSHOT.jar to C:\Users\Lewis\.m2\repository\groupId\text-file-metrics\1.0-SNAPSHOT\text-file-metrics-1.0-SNAPSHOT.jar
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time:  7.396 s
    [INFO] Finished at: 2023-10-18T14:51:28+01:00
    [INFO] ------------------------------------------------------------------------


## Java Programming Test

Please write, in Java, an API to read the contents of a plain text file and enable the display of the
total number of words, the average word length, the most frequently occurring word length, and a
list of the number of words of each length.

Submit your code, along with unit tests, and Maven POM file, in a zip file or GitHub repository, via
email along with instructions for its installation and use. We will use your POM file to build and run
your solution with a successful build required for progression to grading. Be sure to state any
assumptions that you have made about what defines a word (using as a basis the rules that can be
deduced from the example below).

For example, given a file that contains the following text:

    Hello world & good morning. The date is 18/05/2016

We would expect the following output:

    Word count = 9
    Average word length = 4.556
    Number of words of length 1 is 1
    Number of words of length 2 is 1
    Number of words of length 3 is 1
    Number of words of length 4 is 2
    Number of words of length 5 is 2
    Number of words of length 7 is 1
    Number of words of length 10 is 1
    The most frequently occurring word length is 2, for word lengths of 4 & 5

Note that we will test code submissions with several files of various lengths ranging from the above
example through to large books such as the Bible (https://www.janelwashere.com/files/bible_daily.txt).

Clue – Do not forget to consider formatted numbers.

On the code test:

* This is as much about reading and understanding the problem statement as it is about coding.
* We are looking for eloquent, efficient and machine efficient code.
* Use advanced coding features to help with the above.
* The corollary of the above - do not over complicate the solution.
* Make sure the completed version works!
* We prefer submissions via GitHub.
