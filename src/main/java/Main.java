import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String pageLength = "10";
        // Ask user for API Key and Secret


        // Fetch the data
        FoodTruckRetriever foodTruckRetriever = new FoodTruckRetriever();
        List<FoodTruckData> foodTruckDataList = foodTruckRetriever.retrieveData("0", pageLength);


        // Print with pagination
        printPages(foodTruckDataList, pageLength);
    }

    private static void printPages(List<FoodTruckData> foodTruckDataList, String pageLength) {

        // Ask for user input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            // Print the page
            int count = 1;
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
                break;
            } else {
                System.out.print("q to quit, any other key to continue to next page: ");

                // Try to get input
                try {
                    char input = (char)br.read();
                    if (input=='q') {
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