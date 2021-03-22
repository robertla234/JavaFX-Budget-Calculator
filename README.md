# JavaFX-Budget-Calculator
This project utilizes a PostgreSQL database connected to a Java Spring Boot API that is accessed by a JavaFX GUI client.

It's original intent is to keep track of multiple "Wallets", logs of money flow, for multiple different users. 
This is the first attempt to use Java Spring Boot's Starter Web package. Upon establishing a successful connection and 
extracting a response from the API, I had realized security would be an issue.

3/19/2021 -
I am currently researching Spring Security implementation and beginning an API v2 that includes an RBAC, basic database tables
to support those roles, and a Kerberos-style authentication layer. 
