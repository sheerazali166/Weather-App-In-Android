package com.example.weatherapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.weatherapp.API.WeatherInterface;
import com.example.weatherapp.model.WeatherResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "f2dca010adb3916a2d227577afbbdc71";
    private static final String CITY_ID = "1689973";
    private static final String RESPONSE_UNITS = "metric";

    private TextView countryNameTextView;
    private TextView temperatureTextView;
    private TextView pressureTextView;
    private TextView humidityTextView;
    private TextView weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        countryNameTextView = findViewById(R.id.countryName);
        temperatureTextView = findViewById(R.id.temperature);
        pressureTextView = findViewById(R.id.pressure);
        humidityTextView = findViewById(R.id.humadity);
        weather = findViewById(R.id.weather);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Execute AsyncTask
        new GetWeatherInformation().execute();
    }

    private class GetWeatherInformation extends AsyncTask<Void, Void, WeatherResponse> {


        @Override
        protected WeatherResponse doInBackground(Void... voids) {

            /*Retrofit helps us handle the HttpRequests, network calls, etc.
             * Here we give the library the URL which we will query
             * and also a converter, so it'll know what type of response to expect
             * in this case the API will return a JSON object*/

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            WeatherInterface weatherInterface = retrofit.create(WeatherInterface.class);
            Call<WeatherResponse> call = weatherInterface.getWeatherFromCity(CITY_ID, API_KEY, RESPONSE_UNITS);

            /*The call to the Retrofit Interface will return a WeatherResponse object, for which
             * we have created a Object, so the library can convert the response from JSON, to an object
             * we can manipulate*/
            WeatherResponse weatherResponse = null;

            try {
                weatherResponse = call.execute().body();

            } catch (IOException e) {

                e.printStackTrace();
            }

            return weatherResponse;

        }

        @Override
        protected void onPostExecute(WeatherResponse weatherResponse) {
            super.onPostExecute(weatherResponse);

            if (weatherResponse != null) {

                countryNameTextView.setText(weatherResponse.getName());
                temperatureTextView.setText(String.valueOf(weatherResponse.getMain().getTemp()));
                pressureTextView.setText(String.valueOf(weatherResponse.getMain().getPressure()));
                humidityTextView.setText(String.valueOf(weatherResponse.getMain().getHumidity()));
                weather.setText(weatherResponse.getWeather().get(0).getDescription());

            }


        }
    }

}