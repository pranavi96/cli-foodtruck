import com.google.gson.Gson;
import okhttp3.*;


public class RequestProcessor {

    public static <P> P request(HttpUrl url, Class<P> genericClass) {

        Gson gson = new Gson();

        // Initialize OKHTTP client
        OkHttpClient client = new OkHttpClient();

        // Make request
        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            ResponseBody responseBody = client.newCall(request).execute().body();

            String json = responseBody.string();

            // Return data
            return gson.fromJson(json, genericClass);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return gson.fromJson("[{}]", genericClass);
    }

}
