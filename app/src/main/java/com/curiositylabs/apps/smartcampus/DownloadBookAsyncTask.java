package com.curiositylabs.apps.smartcampus;


import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

public class DownloadBookAsyncTask extends AsyncTask<String,Void,Uri> {

    private Context context;

    public DownloadBookAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();


    }

    @Override
    protected Uri doInBackground(String... params) {
      return null;
    }

    @Override
    protected void onPostExecute(Uri uri) {
        super.onPostExecute(uri);
    }
}
