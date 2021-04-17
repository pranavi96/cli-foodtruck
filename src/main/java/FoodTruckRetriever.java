import com.google.gson.Gson;
import okhttp3.HttpUrl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FoodTruckRetriever {

    // Global secrets
    // TODO remove later

    public List<FoodTruckData> retrieveData(String offset, String limit) {

        List<FoodTruckData> foodTruckDataList;

        //create the api url
        URICreator uriCreator=new URICreator();
        HttpUrl uri=uriCreator.getURL(offset,limit);

        //call url with basic auth
        RequestProcessor requestProcessor=new RequestProcessor();
        FoodTruckData[] gsonObject=requestProcessor.request(uri, apiKey, apiSecret, FoodTruckData[].class);

        //parse the json and create FoodTruck Objects

        foodTruckDataList=Arrays.asList(gsonObject);
        return foodTruckDataList;
    }
}
