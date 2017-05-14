package com.curiositylabs.apps.smartcampus;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class BooksAdapter extends ArrayAdapter<Book> {

    private static final String TAG = "BooksAdapter";
    private Context context;
    private List<Book> data;
    public BooksAdapter(Context context, int resource, List<Book> data) {
        super(context,resource,data);
        this.context = context;
        this.data = data;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View bookRow = convertView;
        if (bookRow == null) {
            LayoutInflater inflator = LayoutInflater.from(context);
            bookRow = inflator.inflate(R.layout.booksdetails, parent, false);
        }

        TextView desc = (TextView) bookRow.findViewById(R.id.desc);
        TextView url = (TextView) bookRow.findViewById(R.id.durl);
        Book bk = data.get(position);
        desc.setText(bk.getDescription());
        url.setText(bk.getDownloadURL());

        Log.e(TAG, "getView: " + bk.toString());
        return bookRow;
    }
}
