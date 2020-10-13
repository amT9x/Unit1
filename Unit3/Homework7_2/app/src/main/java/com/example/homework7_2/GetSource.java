package com.example.homework7_2;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetSource extends AsyncTask<String, Void, String> {

    private static final String TAG = "_GetSource";

    private TextView mGetSource;

    public GetSource(TextView mGetSource) {
        this.mGetSource = mGetSource;
    }

    @Override
    protected String doInBackground(String... strings) {
        String html = "";
        try{
            URL url = new URL(strings[0]);
            HttpURLConnection response = (HttpURLConnection) url.openConnection();

            InputStream inputStream = response.getInputStream();    //what do? what get?

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder stringBuilder = new StringBuilder();
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            html = stringBuilder.toString();
            inputStream.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return html;
    }

    @Override
    protected void onPostExecute(String s) {
        mGetSource.setText(s);
        Log.d(TAG, "onPostExecute: " + s);
    }
}
