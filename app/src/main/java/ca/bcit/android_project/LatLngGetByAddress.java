package ca.bcit.android_project;

import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LatLngGetByAddress extends AsyncTask<String, String, LatLng> {

    private static final String REQUEST_METHOD = "GET";
    private static final int READ_TIMEOUT = 15000;
    private static final int CONNECTION_TIMEOUT = 15000;

    @Override
    protected LatLng doInBackground(String... strings) {
        String address = strings[0];
        double lat;
        double lon;
        String inputLine;
        String result;
        LatLng returnVal = null;

        try {
            //Create a URL object holding our url
            URL myUrl = new URL("https://maps.googleapis.com/maps/api/geocode/json?address="
                    + address + "&key=AIzaSyA2TtDkGZKxBjFHHMGtNcHWtIlokAYavvo");

            //Create a connection
            HttpURLConnection connection =(HttpURLConnection)
                    myUrl.openConnection();

            //Set methods and timeouts
            connection.setRequestMethod(REQUEST_METHOD);
            connection.setReadTimeout(READ_TIMEOUT);
            connection.setConnectTimeout(CONNECTION_TIMEOUT);

            //Connect to our url
            connection.connect();

            //Create a new InputStreamReader
            InputStreamReader streamReader = new
                    InputStreamReader(connection.getInputStream());

            //Create a new buffered reader and String Builder
            BufferedReader reader = new BufferedReader(streamReader);
            StringBuilder stringBuilder = new StringBuilder();

            //Check if the line we are reading is not null
            while((inputLine = reader.readLine()) != null){
                stringBuilder.append(inputLine);
            }

            //Close our InputStream and Buffered reader
            reader.close();
            streamReader.close();

            //Set our result equal to our stringBuilder
            result = stringBuilder.toString();

            JSONObject jsonObject = new JSONObject(result);
            if (jsonObject.getString("error_message") != null) {
                Log.e("ha", jsonObject.getString("error_message"));
            }
            JSONArray jsonArray = jsonObject.getJSONArray("result");
            JSONObject firstLocation = jsonArray.getJSONObject(0);
            lat = firstLocation.getJSONObject("geometry").getJSONObject("location").getDouble("lat");
            lon = firstLocation.getJSONObject("geometry").getJSONObject("location").getDouble("lon");


            
            returnVal = new LatLng(lat, lon);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return returnVal;
    }
}
