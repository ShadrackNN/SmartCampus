package com.curiositylabs.apps.smartcampus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class GeneralNotice extends AppCompatActivity {

    String displayName;
    private static final String TAG = "NoticeGen";
    private NoticeGen adapter;

   //private FirebaseListAdapter<GeneralNoticeModel> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_notice);

        ListView list = (ListView) findViewById(R.id.general_notice_list);
        registerForContextMenu(list);
        final ArrayList<GeneralNoticeModel> gens = new ArrayList<>();
        //Reference to our files Url in our Real time database

        //displayNotice();

        //ref =  FirebaseDatabase.getInstance().getReference().child("General Notices");
        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("General Notices");
        adapter = new NoticeGen(
                getApplicationContext(), R.layout.activity_general_notice, gens
        );
        list.setAdapter(adapter);

        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null) {
            displayName = user.getEmail();
        }
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String sender = (String) dataSnapshot.child("NoticeSender").getValue();
                String notice = (String) dataSnapshot.child("Notice").getValue();
                Long time = (Long) dataSnapshot.child("NoticeTime").getValue();
                GeneralNoticeModel c = new GeneralNoticeModel();
                c.setNoticeSender(sender);
                c.setNotice(notice);
                c.setNoticeTime(time);
                gens.add(c);
                adapter.notifyDataSetChanged();
                Log.e(TAG, "onChildAdded: " + c);
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
    /*
    private void displayNotice() {

        ListView listOfnotices = (ListView)findViewById(R.id.general_notice_list);

        adapter = new FirebaseListAdapter<GeneralNoticeModel>(this,
                GeneralNoticeModel.class,
                R.layout.activity_exam_notices,
                FirebaseDatabase.getInstance().getReference()) {

            @Override
            protected void populateView(View v, GeneralNoticeModel model, int position) {
                TextView noticeText = (TextView)v.findViewById(R.id.notice_text);
                TextView noticeUser = (TextView)v.findViewById(R.id.notice_sender);
                TextView noticeTime = (TextView)v.findViewById(R.id.notice_time);

                // Set their text
                noticeText.setText(model.getNotice());
                noticeUser.setText(model.getNoticeSender());

                // Format the date before showing it
                noticeTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)",
                        model.getNoticeTime()));
            }
        };
        listOfnotices.setAdapter(adapter);
        // ----Set autoscroll of listview when a new message arrives----//
        listOfnotices.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        listOfnotices.setStackFromBottom(true);


    }
    */



}

/*


{
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
 */
