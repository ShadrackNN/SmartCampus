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

public class MediaAcademics extends AppCompatActivity {

    HashMap<String, List<String>> Year_Category;
    List<String> Year_List;
    ExpandableListView media_exp_list;
    MediaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_academics);

        media_exp_list=(ExpandableListView)findViewById(R.id.expandable_list_view);
        Year_Category =Media_list_DataProvider.getInfo();
        Year_List = new ArrayList<>(Year_Category.keySet());
        adapter = new MediaAdapter(this, Year_Category, Year_List);

        media_exp_list.setAdapter(adapter);

        media_exp_list.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View view, int groupPosition, int childPosition, long id) {
                if (groupPosition==0){
                    if (childPosition==0){
                        startActivity(new Intent(MediaAcademics.this, s1.class));                    }
                }
                if (groupPosition==0){
                    if (childPosition==1){
                        startActivity(new Intent(MediaAcademics.this, s2.class));                    }
                }

                if (groupPosition==1){
                    if (childPosition==0){
                        Toast.makeText(MediaAcademics.this,  "Year 1 Sem 1 ", Toast.LENGTH_SHORT).show();
                    }
                }
                if (groupPosition==1){
                    if (childPosition==1){
                        Toast.makeText(MediaAcademics.this,  "Year 1 Sem 2 ", Toast.LENGTH_SHORT).show();
                    }
                }

                if (groupPosition==2){
                    if (childPosition==0){
                        Toast.makeText(MediaAcademics.this,  "Year 2 Sem 1 ", Toast.LENGTH_SHORT).show();
                    }
                }
                if (groupPosition==2){
                    if (childPosition==1){
                        Toast.makeText(MediaAcademics.this,  "Year 2 Sem 2 ", Toast.LENGTH_SHORT).show();
                    }
                }
                if (groupPosition==3){
                    if (childPosition==0){
                        Toast.makeText(MediaAcademics.this,  "Year 3 Sem 1 ", Toast.LENGTH_SHORT).show();
                    }
                }
                if (groupPosition==3){
                    if (childPosition==1){
                        Toast.makeText(MediaAcademics.this,  "Year 3 Sem 2 ", Toast.LENGTH_SHORT).show();
                    }
                }
                return false;
            }
        });
    }


}
