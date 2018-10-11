package com.parcial.connector;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;

@Service
public class AlphaVantageConnector implements Connector {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String DEFAULT_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=MSFT&interval=5min&apikey=54UY5IM903FGUCQT";


    @Override
    public StringBuffer Fetch(String Symbol, String Mode) throws IOException {
        URL obj = new URL("https://www.alphavantage.co/query?function="+Mode+"&symbol="+Symbol+"&interval=5min&apikey=54UY5IM903FGUCQT");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        StringBuffer response = new StringBuffer();
        System.out.println(obj);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;


            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            ;
            System.out.println(response.toString());

        } else {
            System.out.println("GET request not worked");
            response.append("not worked");
        }
        return response;
    }
}
