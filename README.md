# most_active_cookie

This project is created for Quantcast interview.


## Folders
- src:  this folder contains all the .java files. e.g. ActiveCookie.java, ActiveCookieTest.java
- bin: this folder has the .class files
- root: here I put .class files as well as the .csv file


## How to run

Go to the root location of project from command line. Run the command :
>  java ActiveCookie cookie_log.csv -d 2018-12-09

First parameter takes the relative file path of the csv file. 2nd and 3rd parameter is the date format and the search date respectively.

## Testing 

There are multiple junit test cases in the ActiveCookieTest.java. Once one can load the project in any java supported IDE can run the test cases as a Junit test case.