import com.google.gson.Gson;
import okhttp3.*;


public class RequestProcessor {

    public static <T> T request(HttpUrl url, String apiKey, String apiSecret, Class<T> genericClass) {

        Gson gson = new Gson();

        // Initialize OKHTTP client
        OkHttpClient client = new OkHttpClient();

        // Add credentials
        String credentials = Credentials.basic(apiKey, apiSecret);

        // Make request
        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", credentials)
                .build();

        try {
            ResponseBody responseBody = client.newCall(request).execute().body();

            // TODO handle character encoding
            String json = responseBody.string();

            // Return data
            return gson.fromJson(json, genericClass);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return gson.fromJson("[{}]", genericClass);
    }

}
