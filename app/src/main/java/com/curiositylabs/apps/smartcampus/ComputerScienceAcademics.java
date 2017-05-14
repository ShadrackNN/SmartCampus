package com.curiositylabs.apps.smartcampus;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ComputerScienceAcademics extends AppCompatActivity {
    HashMap<String, List<String>> Year_Category;
    List<String> Year_List;
    ExpandableListView cs_exp_list;
    CompScienceAdapter adapter;
    ImageButton buttonReports;
    ImageButton buttonQuestions;
    ImageButton buttonBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_science_academics);

        cs_exp_list = (ExpandableListView) findViewById(R.id.expandable_list_view);
        Year_Category = Cs_List_DataProvider.getInfo();
        Year_List = new ArrayList<>(Year_Category.keySet());
        adapter = new CompScienceAdapter(this, Year_Category, Year_List);


        cs_exp_list.setAdapter(adapter);

        cs_exp_list.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View view, int groupPosition, int childPosition, long id) {
                if (groupPosition == 0) {
                    if (childPosition == 0) {
                        setContentView(R.layout.sem_landing);
                        buttonBooks = (ImageButton) findViewById(R.id.btnBooks);
                        buttonQuestions = (ImageButton) findViewById(R.id.btnQuestions);
                        buttonBooks.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //setContentView(R.layout.books);
                                //displayFiles();
                                Intent intent = new Intent(getApplicationContext(), BooksActivity.class);
                                startActivity(intent);
                            }
                        });


                        buttonQuestions.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });


                    }
                }
                if (groupPosition == 0) {
                    if (childPosition == 1) {
                        setContentView(R.layout.sem_landing);
                        buttonBooks = (ImageButton) findViewById(R.id.btnBooks);
                        buttonQuestions = (ImageButton) findViewById(R.id.btnQuestions);
                        buttonBooks.setOnClickListener(new View.OnClickListener() {
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

                if (groupPosition == 1) {
                    if (childPosition == 0) {
                        setContentView(R.layout.sem_landing);
                        buttonBooks = (ImageButton) findViewById(R.id.btnBooks);
                        buttonQuestions = (ImageButton) findViewById(R.id.btnQuestions);

                        buttonBooks.setOnClickListener(new View.OnClickListener() {
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
                if (groupPosition == 1) {
                    if (childPosition == 1) {
                        setContentView(R.layout.sem_landing);
                        buttonBooks = (ImageButton) findViewById(R.id.btnBooks);
                        buttonQuestions = (ImageButton) findViewById(R.id.btnQuestions);

                        buttonBooks.setOnClickListener(new View.OnClickListener() {
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

                if (groupPosition == 2) {
                    if (childPosition == 0) {
                        setContentView(R.layout.sem_landing);
                        buttonBooks = (ImageButton) findViewById(R.id.btnBooks);
                        buttonQuestions = (ImageButton) findViewById(R.id.btnQuestions);

                        buttonBooks.setOnClickListener(new View.OnClickListener() {
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
                if (groupPosition == 2) {
                    if (childPosition == 1) {
                        setContentView(R.layout.sem_landing);
                        buttonBooks = (ImageButton) findViewById(R.id.btnBooks);
                        buttonQuestions = (ImageButton) findViewById(R.id.btnQuestions);

                        buttonBooks.setOnClickListener(new View.OnClickListener() {
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
                if (groupPosition == 3) {
                    if (childPosition == 0) {
                        setContentView(R.layout.sem_landing);
                        buttonBooks = (ImageButton) findViewById(R.id.btnBooks);
                        buttonQuestions = (ImageButton) findViewById(R.id.btnQuestions);

                        buttonBooks.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(null, "Year 3 sem 1", Toast.LENGTH_LONG).show();
                            }
                        });



                        buttonQuestions.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });

                    }
                }
                if (groupPosition == 3) {
                    if (childPosition == 1) {
                        setContentView(R.layout.sem_landing);
                        buttonBooks = (ImageButton) findViewById(R.id.btnBooks);
                        buttonQuestions = (ImageButton) findViewById(R.id.btnQuestions);

                        buttonBooks.setOnClickListener(new View.OnClickListener() {
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
