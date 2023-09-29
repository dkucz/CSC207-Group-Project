package api;

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
                .url("https://api.openweathermap.org/data/3.0/onecall?lat=33&lon=33&appid=4f85438c9d278629158c7d8380d0d69f&unitsZz")
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
