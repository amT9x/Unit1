package com.example.simpleasynctask;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;


public class SimpleAsyncTask extends AsyncTask<Void, Integer, String> {

    private WeakReference<TextView> mTextView, mPercent;
    private ProgressBar progressBar;

    private static final String TAG = "SimpleAsyncTask";

    public SimpleAsyncTask(TextView tv, ProgressBar progressBar) {
        this.mTextView = new WeakReference<>(tv);
        this.progressBar = progressBar;
//        this.mPercent = new WeakReference<>(percent);
    }

    @Override
    protected String doInBackground(Void... voids) {

        Random r = new Random();
        int n = r.nextInt(11);
//        Log.d(TAG, "doInBackground: n = " + n);
        int s = n * 1500;
        int b = s/10;
        Log.d(TAG, "doInBackground: b = " + b);
        progressBar.setMax(s);
        Log.d(TAG, "doInBackground: s =  " + s);
        int i = b;
        while (i <= s) {
//            Log.d(TAG, "doInBackground: hear");
            try {
                Thread.sleep(b);
                Log.d(TAG, "doInBackground: i = " + i);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);
            i = i + b;
        }

        return "Awake at last after sleeping for " + s + " milliseconds!";
    }

    @Override
    protected void onProgressUpdate(final Integer... values) {
        progressBar.setProgress(values[0]);
        Log.d(TAG, "onProgressUpdate: " + values[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        mTextView.get().setText(s);
    }
}
