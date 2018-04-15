"C:\Program Files\cURL\bin\curl.exe" -X POST http://localhost:8080/MarketPlace/rest/service/initial

"C:\Program Files\cURL\bin\curl.exe" -d "@person.txt" -H "Content-Type: application/json" -X POST http://localhost:8080/MarketPlace/rest/service/persons 

"C:\Program Files\cURL\bin\curl.exe" -d "@project.txt" -H "Content-Type: application/json" -X POST http://localhost:8080/MarketPlace/rest/service/projects

"C:\Program Files\cURL\bin\curl.exe" -d "@bid.txt" -H "Content-Type: application/json" -X POST http://localhost:8080/MarketPlace/rest/service/bids

"C:\Program Files\cURL\bin\curl.exe" -H "Content-Type: application/json" -X GET http://localhost:8080/MarketPlace/rest/service/projects?query=name=Mark

"C:\Program Files\cURL\bin\curl.exe" -H "Content-Type: application/json" -X GET http://localhost:8080/MarketPlace/rest/service/bids?query=name=Jonathan

"C:\Program Files\cURL\bin\curl.exe" -H "Content-Type: application/json" -X GET http://localhost:8080/MarketPlace/rest/service/bids?query=projectName=PCRepair

"C:\Program Files\cURL\bin\curl.exe" -d "@projectupdate.txt" -H "Content-Type: application/json" -X PUT http://localhost:8080/MarketPlace/rest/service/projects

"C:\Program Files\cURL\bin\curl.exe" -d "@bidupdate.txt" -H "Content-Type: application/json" -X PUT http://localhost:8080/MarketPlace/rest/service/bids

"C:\Program Files\cURL\bin\curl.exe" -X POST http://localhost:8080/MarketPlace/rest/service/assign

