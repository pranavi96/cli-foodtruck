import okhttp3.HttpUrl;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class URICreator {
    public HttpUrl getURL(String offset, String limit) {

        // Get timestamp in LA timezone
        ZonedDateTime timeInZone = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        int dayOfTheWeek = timeInZone.getDayOfWeek().getValue() % 7;

        // Create query filter string
        String time24 = timeInZone.format(DateTimeFormatter.ofPattern("HH:mm"));
        String queryFilter = "start24<=\"" + time24 + "\" and end24>=\"" + time24 + "\"";


        // Build url
        //made use of the query parameters available on the San Fransisco API
        //instead of querying everything and then filtering
        HttpUrl httpUrl = HttpUrl.parse("https://data.sfgov.org/resource/jjew-r69b.json")
                .newBuilder()
                .addQueryParameter("dayorder", Integer.toString(dayOfTheWeek))
                .addQueryParameter("$limit", limit)
                .addQueryParameter("$offset", offset)
                .addQueryParameter("$where", queryFilter)
                .build();

        return httpUrl;
    }
}
