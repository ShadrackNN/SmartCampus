package com.curiositylabs.apps.smartcampus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AcmpAcademics extends AppCompatActivity {

    HashMap<String, List<String>> Year_Category;
    List<String> Year_List;
    ExpandableListView acmp_exp_list;
    AcmpAdapter adapter;
    TextView semester1, semester2;
    ImageButton buttonReports;
    ImageButton buttonQuestions;
    ImageButton buttonBooks;
    TextView downloadUrl;
    FirebaseStorage storage = FirebaseStorage.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acmp_academics);

        buttonBooks = (ImageButton) findViewById(R.id.btnBooks);
        buttonQuestions = (ImageButton) findViewById(R.id.btnQuestions);

        acmp_exp_list=(ExpandableListView)findViewById(R.id.expandable_list_view);
        Year_Category =Acmp_List_DataProvider.getInfo();
        Year_List = new ArrayList<>(Year_Category.keySet());
        adapter = new AcmpAdapter(this, Year_Category, Year_List);

        acmp_exp_list.setAdapter(adapter);

        acmp_exp_list.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View view, int groupPosition, int childPosition, long id) {
                if (groupPosition==0){
                    if (childPosition==0){
                        setContentView(R.layout.sem_landing);

                        buttonBooks.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {


                            }
                        });

                        buttonReports.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });

                        buttonQuestions.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });
                    }
                }
                if (groupPosition==0){
                    if (childPosition==1){
                        setContentView(R.layout.sem_landing);

                        buttonBooks.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });

                        buttonReports.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });

                        buttonQuestions.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });
                    }
                }

                if (groupPosition==1){
                    if (childPosition==0){
                        setContentView(R.layout.sem_landing);

                        buttonBooks.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });

                        buttonReports.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });

                        buttonQuestions.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });
                    }
                }
                if (groupPosition==1){
                    if (childPosition==1){
                        setContentView(R.layout.sem_landing);

                        buttonBooks.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });

                        buttonReports.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });

                        buttonQuestions.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });
                    }
                }

                if (groupPosition==2){
                    if (childPosition==0){
                        setContentView(R.layout.sem_landing);

                        buttonBooks.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });

                        buttonReports.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });

                        buttonQuestions.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });
                    }
                }
                if (groupPosition==2){
                    if (childPosition==1){
                        setContentView(R.layout.sem_landing);

                        buttonBooks.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });

                        buttonReports.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });

                        buttonQuestions.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });
                    }
                }
                if (groupPosition==3){
                    if (childPosition==0){
                        setContentView(R.layout.sem_landing);

                        buttonBooks.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });

                        buttonReports.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });

                        buttonQuestions.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });
                    }
                }
                if (groupPosition==3){
                    if (childPosition==1){
                        setContentView(R.layout.sem_landing);

                        buttonBooks.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });

                        buttonReports.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });

                        buttonQuestions.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });
                    }
                }
                return false;
            }
        });


    }

}
