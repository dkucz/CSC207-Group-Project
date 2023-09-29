import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OpenweatherAPI {

    public static void main(String[] args) {
        OpenweatherAPI owa = new OpenweatherAPI();
        owa.GetWeatherInfo();
    }

    public void GetWeatherInfo() {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.openweathermap.org/data/3.0/onecall?")
                .addHeader("appid","9b3baf9ec158ac42f468eaa7929bb567" )
                .addHeader("lat", "33")
                .addHeader("lon", "33")
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            System.out.println(response.body().string());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
