

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
       //Displaying 10 results per page
        String pageLength = "10";
        // Ask user for API Key and Secret

            FoodTruckRetriever foodTruckRetriever = new FoodTruckRetriever();
            // Fetch the data
            List<FoodTruckData> foodTruckDataList = foodTruckRetriever.retrieveData("0", pageLength);
            //Sort the list alphabetically
            Collections.sort(foodTruckDataList,(a,b)->a.applicant.compareTo(b.applicant));
            // Print with pagination
            printPages(foodTruckDataList, pageLength);



    }

    private static void printPages(List<FoodTruckData> foodTruckDataList, String pageLength) {

        // Ask for user input
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;
        while (true) {

            // Print the page

            for (FoodTruckData foodTruckData : foodTruckDataList) {
                System.out.println(count++ + ": ");
                System.out.println("    Name: " + foodTruckData.applicant);
                System.out.println("    Location: " + foodTruckData.location);
                System.out.println("    Start: " + foodTruckData.start24);
                System.out.println("    End: " + foodTruckData.end24);

                System.out.println("-------------------------------------");
            }

            // Check if page is last
            if (foodTruckDataList.size() < Integer.parseInt(pageLength)) {
                System.out.print("No more results to show");
                break;
            } else {
                System.out.print("q|Q to quit, any other key to continue to view more results: ");

                // Try to get input
                try {
                    char input = (char)br.read();
                    if (input=='q'||input=='Q') {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e);
                    break;
                }
            }
        }
    }
}