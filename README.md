# cli-foodtruck
A Java based cli to get foodtruck data from data.sfgov.org

## Prerequisites

* Java 11 should be installed
* `mvn` should be installed

## Instructions to run
* Download the zip
* Export the zip to a local folder and change your current working directory to that
```BASH

# This will build and package all the depdendencies
# in a single jar
mvn package shade:shade

# Now we execute the program
java -jar ./target/FoodTruckSF-1.0-SNAPSHOT.jar
```


