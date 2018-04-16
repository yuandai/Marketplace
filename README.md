# Marketplace
Marketplace Project


Marketplace is a sample web application, to allow owner posting project online with description, budget and ending date, allow engineer biding the project with proposal and amount, upon project ending date, the system will automatically assign projects to the engineer with lowest amount proposal.


Marketplace application was developed using Spring, Hibernate, Postgres and Tomcat, with Java, SQL/HQL, JavaScript, JSON, XML, jQuery, Jersey, RestAPI, AJAX, Maven, Git and Eclipse.


The following are the RestAPIs provided:


1. Initialize Person, Project and Bid database:
POST
http://localhost:8080/MarketPlace/rest/service/initial


2. Create Objects:


Register a Person:
POST
http://localhost:8080/MarketPlace/rest/service/persons
{
  "name": "Lee",
  "contactInfo": "408-8796543"
}


Create a project:
POST
http://localhost:8080/MarketPlace/rest/service/projects
{
  "projectName": "NetworkInstall",
  "description": "Network install for new home",
  "budget": "1000",
  "endingDate": "2018-04-15",
  "ownerName": "Mark"
}


Create a bid:
POST
http://localhost:8080/MarketPlace/rest/service/bids
{
  "projectName": "NetworkInstall",
  "engineerName": "Jonathan",
  "amount": "1000",
  "proposal": "5 years network install experience."
}


3. Retrieve Objects:


Retrieve all Projects of a person:
GET
http://localhost:8080/MarketPlace/rest/service/projects?query=name=Mark


Retrieve all Bids of a person:
GET
http://localhost:8080/MarketPlace/rest/service/bids?query=name=Jonathan


Retrieve all Bids of a project:
GET
http://localhost:8080/MarketPlace/rest/service/bids?query=projectName=PCRepair


4. Update Objects


Update a project:
PUT
http://localhost:8080/MarketPlace/rest/service/projects
{
  "projectName": "PCRepair",
  "description": "PC cannot connect to network install for new home",
  "budget": "1000",
  "endingDate": "2018-04-16",
  "ownerName": "Mark"
}


Update a bid:
PUT
http://localhost:8080/MarketPlace/rest/service/bids
{
  "projectName": "PCRepair",
  "engineerName": "Jonathan",
  "amount": "900",
  "proposal": "5 years network install experience."
}


5. Assign


Assign project to lowest bid
POST
http://localhost:8080/MarketPlace/rest/service/assign
