# Vulnerability Analysis

## A1:2017 Injection

### Description
Injection is an attacker's attempt to send data to an application in a way that will change the meaning of commands being sent to an interpreter. The common example is a SQL injection. For example this can be done by writing SQL code in a user registration form and using this to get data which isn't meant to be received. 

### Risk
There is a risk for this type of vulnerability in this project. Since the project uses a database to store and hold data this could be exploited through the use of an SQL injection. The upside is that the data that is stored does not contain any sensitive or personal information. Once authentication and authorisation is added the entire threat can be mitigated. This is because the project doesn't really heavily on multiple requests and there is really only one area of code that needs to be covered.
Assessment of risk. Discussion of authentication and authorization.

### Counter-measures
The project is secure against injections because the way it's built ensures that the data input is never in direct contact with the database. The data always goes through a certain amount of methods/filters. This insures that a SQL query will be picked apart before it can have any effect. 
There are also API's that secure applications against these types of vulnerabilities. For example: https://www.soapui.org/docs/security-testing/security-scans/sql-injection/
The API above simulates SQL injection attacks. You can use this to detect where the vulnerabilities in your application are and to fix them. You can also use Object Relational Mapping(ORM) to prevent SQL injections. 

## A2:2017 Broken Authetication 

### Description
Authentication is “broken” when attackers are able to compromise passwords, keys or session tokens, user account information, and other details to assume user identities.

### Risk
There is a risk for this type of vulnerability in this project. The database saves games using ID's and these games can be loaded just using the ID. It doens't require further authorisation. This could mean that I could load any game if I get the ID right. If authorisation and authentication were added the risk could be lowered substantially. 

### Counter-measures
The project is currently not secure against this vulnerability. However this could be prevented by an additional form of identification which is unique to the user. These forms of authetication could additionaly be strenghtened by checking for weak passwords. Two factor authentication and secure session ID's. There are a few sources that could be used to help with this. For example: https://github.com/danielmiessler/SecLists/tree/master/Passwords.

## A3:2017 Sensitive Data Exposure

### Description
Sensitive data exposure occurs when an application, company, or other entity inadvertently exposes personal data. Sensitive data exposure differs from a data breach, in which an attacker accesses and steals information.

### Risk
There is no risk for this vulnerability within this project. This is because there is no sensitive data that is stored or shown at any times. Authentication and authorisation could prevent the exposure of senstive data to those who aren't meant to receive it. If senstive data is only allowed to see by for example admins and their is a very strong authentication and authorisation system in place this could severely limit the threat this vulnerability poses. 

### Counter-measures
The project is currently secure against this vulnerability as there is really no data shown except for the feedback/hints the user gets from the game while playing. Sensitive Data Exposure could be prevented by making sure all sensitive data that is stored is also encrypted, for this BCrypt could be used: https://en.wikipedia.org/wiki/Bcrypt. It is also important to identify which data is senstive and which is not. 
