# Text File Metrics

Please write, in Java, an API to read the contents of a plain text file and enable the display of the
total number of words, the average word length, the most frequently occurring word length, and a
list of the number of words of each length.

## Build prerequisites

Check that you have Maven and Java installed using the "mvn -v" command.  
For example:

    > mvn -v
    Apache Maven 3.9.5 (57804ffe001d7215b5e7bcb531cf83df38f93546)
    Maven home: C:\Program Files\Maven\apache-maven-3.9.5
    Java version: 17.0.7, vendor: Amazon.com Inc., runtime: C:\Program Files\Amazon Corretto\jdk17.0.7_7
    Default locale: en_US, platform encoding: Cp1252
    OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"

## Download the repository

Download the text-file-metrics repository from GitHub at https://github.com/badgerbeyond/text-file-metrics

## Build the Java code and run the Junit tests

Open a Windows Terminal PowerShell or Command Prompt in the project directory and build the text-file-metrics project using Maven. 
For example:

    > cd C:\Users\Lewis\IntelliJ\text-file-metrics
    > mvn clean install

## Run from the command line

The TextFileMetrics class can be run from the command line using a file name as a parameter. 

For example, the command shown here runs TextFileMetrics against a text file provided in the root directory of the project :

    PS C:\Users\Lewis\IntelliJ\text-file-metrics> java -cp target\text-file-metrics-1.0-SNAPSHOT.jar TextFileMetrics "bible_daily_extract.txt"

the command shown here runs TextFileMetrics against a text file provided in the user's \Documents directory :

    PS C:\Users\Lewis\IntelliJ\text-file-metrics> java -cp target\text-file-metrics-1.0-SNAPSHOT.jar TextFileMetrics "C:\Users\Lewis\Documents\provided-text-file.txt"

## Assumptions

The following assumptions have been made about what defines a word (using as a basis the rules that can be deduced from the example) :

* Any number of whitespace characters " " and the comma character ",", are considered to be word delimiters and are not counted as part of a word.
* A full stop character "." is considered to be a word delimiter character, except where it is embedded in a number. For example " 12.34 " is counted as one word, whereas " ab.cd " is counted as two words.
* The forward slash character "/" is considered to be part of a word. For example " 18/05/2016 " is counted as one word.

## The Java programming test assignment description in full

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
