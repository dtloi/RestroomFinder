package com.example.cmps121bdd.restroomfinder;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BackTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... strings) {
        StringBuilder jsonResults = new StringBuilder();

        URL url;
        HttpURLConnection conn = null;
        try {
            url = new URL(strings[0]);
            conn = (HttpURLConnection) url.openConnection();
            InputStreamReader in = new InputStreamReader(conn.getInputStream());

            int read;
            char[] buff = new char[1024];
            while ((read = in.read(buff)) != -1) { // read json output
                jsonResults.append(buff, 0, read);
            }
            return jsonResults.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        //MainActivity.textView.setText(s);
        super.onPostExecute(s);
        MapsActivity.placeMarkers(s);
    }
}