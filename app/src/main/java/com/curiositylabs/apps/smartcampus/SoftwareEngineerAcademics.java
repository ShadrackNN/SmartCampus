package com.curiositylabs.apps.smartcampus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SoftwareEngineerAcademics extends AppCompatActivity{
    HashMap<String, List<String>> Year_Category;
    List<String> Year_List;
    ExpandableListView software_exp_list;
    SoftwareAdapter adapter;
    TextView tvSem1, tvSem2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_software_engineer_academics);


        software_exp_list=(ExpandableListView)findViewById(R.id.expandable_list_view);
        Year_Category =Software_list_Dataprovider.getInfo();
        Year_List = new ArrayList<>(Year_Category.keySet());
        adapter = new SoftwareAdapter(this, Year_Category, Year_List);

        software_exp_list.setAdapter(adapter);

        software_exp_list.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View view, int groupPosition, int childPosition, long id) {
                if (groupPosition==0){
                    if (childPosition==0){
                        setContentView(R.layout.activity_s1);

                    }
                }
                if (groupPosition==0){
                    if (childPosition==1){
                        setContentView(R.layout.activity_s2);

                    }
                }
                if (groupPosition==1){
                    if (childPosition==0){
                        setContentView(R.layout.activity_s1);

                    }
                }
                if (groupPosition==1){
                    if (childPosition==1){
                        setContentView(R.layout.activity_s2);

                    }
                }

                if (groupPosition==2){
                    if (childPosition==0){
                        setContentView(R.layout.activity_s1);

                    }
                }
                if (groupPosition==2){
                    if (childPosition==1){
                        setContentView(R.layout.activity_s2);

                    }
                }
                if (groupPosition==3){
                    if (childPosition==0){
                        setContentView(R.layout.activity_s1);

                    }
                }
                if (groupPosition==3){
                    if (childPosition==1){
                        setContentView(R.layout.activity_s2);

                    }
                }
                return false;
            }
        });
    }
}
