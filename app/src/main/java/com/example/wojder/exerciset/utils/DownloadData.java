package com.example.wojder.exerciset.utils;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by wojder on 25.02.16.
 */
public class DownloadData extends AsyncTask<String, Void, String> {

    private String mFileContents;

    public String getmFileContents() {
        return mFileContents;
    }

    @Override
    protected String doInBackground(String... params) {

        mFileContents = downloadXmlFile(params[0]);

        return mFileContents;
    }

    private String downloadXmlFile(String urlPath) {
        StringBuilder tempBuffer = new StringBuilder();

        try {
            URL url = new URL(urlPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int response = connection.getResponseCode();
            Log.d("DownloadData", "The response was: " + response);

            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);

            int charRead;
            char[] inputBuffer = new char[500];

            while (true) {
                charRead = isr.read(inputBuffer);
                if (charRead <= 0) {
                    break;
                }
                tempBuffer.append(String.copyValueOf(inputBuffer, 0, charRead));
            }

            return tempBuffer.toString();

        } catch (IOException e) {
            Log.d("DownloadData", "IO Exception while reading data: " + e.getMessage());

        } catch (SecurityException e) {
            Log.d("DownloadData", "Security while downloading " + e.getMessage());
        }
        return null;
            }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        Log.d("DownloadData", "Result was: " + result);
    }
}
