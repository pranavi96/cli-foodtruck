# cli-foodtruck
A Java based cli to get foodtruck data from data.sfgov.org

The application should return names and addresses open at that time. At a time 10 results are displayed. Made use of the query parameters available on the San Fransisco API instead of querying everything and then filtering.The user can chose to proceed to the next page to view more results  or quit.
## Prerequisites

* Java 11 should be installed
* `mvn` should be installed

## Instructions to run
* Download the zip
* Export the zip to a local folder and change your current working directory to that


# This will build and package all the depdendencies in a single jar and execute the program
mvn package shade:shade
java -jar ./target/FoodTruckSF-1.0-SNAPSHOT.jar






