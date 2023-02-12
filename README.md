# Phrase Springboot homework

### How to compile and run

* The project uses Java 17 (tested on Amazon Corretto 18.0.2_9), Maven 3+ (tested on 3.8.1)
* In the root of the project run **mvn clean package** to compile and build the application
* To run the application from an IDE, run the main app class ...\phrase\src\main\java\com\pz\phrase\ **PhraseApplication.java**
* To run the application from the command line, run the following: ...\phrase\target> **java -jar phrase-0.0.1-SNAPSHOT.jar** 

Open the following page in your browser (tested in Chrome):
* http://localhost:8080/ to get to the main page of the application or go directly to
  * http://localhost:8080/config to access the TMS Account Config page
    * You can use **pzemanek73/Letmein12345**
  * http://localhost:8080/projects to access the Projects page (TMS account needs to be set up first)

---

*Original assignment description:*


You will need a Phrase TMS developer account to finish the assignment.

* Register at https://cloud.memsource.com/web/organization/signup?e=DEVELOPER
If you use “Sign up via Google”, you will need to set the password by visiting the password recovery page. Password is needed to generate an API token later.
* This is an opportunity to get in touch with the Phrase TMS application.
You may work on this application later if you are a successful candidate.
Create a few projects in your Phrase account. There is no need to upload any jobs to the projects.
* The application, which you will create in this assignment, will use Phrase APIs described at https://support.phrase.com/hc/en-us/articles/5709706916124 .
You may extend and improve these APIs later if you are a successful candidate.
Most of the API calls require the user to authenticate first in order to obtain the authentication token.
There is no need to take the token expiration into account.
https://cloud.memsource.com/web/docs/api
https://cloud.memsource.com/web/docs/api#operation/listProjects

### Assignment
Create Spring Boot application.
The application will have 2 pages.
Do not bother by frontend much and Implement it as simple as possible.

### Setup Page
Phrase TMS account can be configured here.
The configuration should be represented as a Spring entity class.
Two text fields for username and password.
No need to care about the security of a password.
Optional: Configuration can be edited and saved on persistent storage (H2 database, for example).

### Projects Page
List projects retrieved from https://cloud.memsource.com/web/docs/api#operation/listProjects
You will need a token from https://cloud.memsource.com/web/docs/api#operation/login
Name, status, source language and target languages should be displayed
You should load and render the projects in JavaScript
You will need to implement an endpoint in your application that will provide the data for an AJAX call

### Requirements
You should create production quality code.
Besides the functional requirements described above, please try to show that you:
Understand AJAX.
Can work with Git by providing us your solution as a link to your Git repo.
Provide instructions on how to compile and run.

### Notes
Don’t spend more than 4-8 hours on the assignment.
Inform us about the amount of time it took you to finish.
Any extra features going beyond the requirements are appreciated.


