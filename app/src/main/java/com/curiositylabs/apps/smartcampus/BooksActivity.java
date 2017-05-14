package com.curiositylabs.apps.smartcampus;


import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class BooksActivity extends AppCompatActivity {
    private static final String TAG = "BooksActivity";
    private BooksAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.books);
        ListView list = (ListView) findViewById(R.id.books_list);
        registerForContextMenu(list);
        final ArrayList<Book> books = new ArrayList<>();
        //Reference to our files Url in our Real time database
        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Books");
        adapter = new BooksAdapter(
                getApplicationContext(), R.layout.books, books
        );
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(BooksActivity.this, "Long Press to View menu options ", Toast.LENGTH_SHORT).show();
            }
        });
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String desc = (String) dataSnapshot.child("Description").getValue();
                String urL = (String) dataSnapshot.child("DownloadUrl").getValue();
                Book t = new Book();
                t.setDescription(desc);
                t.setDownloadURL(urL);
                books.add(t);
                adapter.notifyDataSetChanged();
                Log.e(TAG, "onChildAdded: " + t);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflator = getMenuInflater();
        inflator.inflate(R.menu.books_context_files, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Book temp = adapter.getItem(info.position);
        switch (item.getItemId()) {
            case R.id.share_bk:
                Toast.makeText(this, "Share book", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.download_bk:
                Uri myUri = Uri.parse(temp.getDownloadURL());
                long downloadReference;


                // Create request for android download manager
                DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                DownloadManager.Request request = new DownloadManager.Request(myUri);
                //Setting title of request

                //Setting description of request...
                request.setDescription("Android Data download using DownloadManager.");

                //Set the local destination for the downloaded file to a path within the application's external files directory
                request.setDestinationInExternalFilesDir(getApplicationContext(), Environment.DIRECTORY_DOCUMENTS,"Document_0SC.pdf");
                //Enqueue download and save into referenceId....
                downloadReference = downloadManager.enqueue(request);
                Uri t_url=downloadManager.getUriForDownloadedFile(downloadReference);
                Intent t=new Intent();
                t.setDataAndType(t_url, "application/pdf");
                t.setPackage("com.adobe.reader");
                t.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                t.setData(t_url);
                //startActivity(t);
                Log.e(TAG, "onContextItemSelected: " + downloadReference);
                return true;
            case R.id.open_bk:
                Toast.makeText(this, "Open book", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }
}