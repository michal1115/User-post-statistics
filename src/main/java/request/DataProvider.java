package request;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DataProvider {
    //Class returns json objects after performing successful request to the site at given url

    private static HttpURLConnection establishURLConnection(String urlAsString) throws IOException {
        //establish connection at given url:
        URL url = new URL(urlAsString);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");

        return connection;
    }

    private static String readServerResponse(HttpURLConnection connection) throws IOException {
        //initialize BufferedReader
        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        //read
        String lineReceived;
        StringBuilder responseBuilder = new StringBuilder();

        while((lineReceived = input.readLine()) != null){
            responseBuilder.append(lineReceived);
        }

        return responseBuilder.toString();
    }

    private static JsonArray stringToJsonArray(String rawJsonString){
        Gson g = new Gson();
        JsonArray jsonArray = g.fromJson(rawJsonString, JsonArray.class);
        return jsonArray;
    }

    public static JsonArray getData(String urlAsString) throws IOException {
        HttpURLConnection connection = establishURLConnection(urlAsString);
        String response = readServerResponse(connection);
        return stringToJsonArray(response);
    }
}
