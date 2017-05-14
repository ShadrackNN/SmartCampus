package com.curiositylabs.apps.smartcampus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InfoTechAcademics extends AppCompatActivity  {

    HashMap<String, List<String>> Year_Category;
    List<String> Year_List;
    ExpandableListView info_exp_list;
    ITAdapter adapterIT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_tech_academics);


        info_exp_list=(ExpandableListView)findViewById(R.id.expandable_list_view);
        Year_Category =IT_list_DataProvider.getInfo();
        Year_List = new ArrayList<>(Year_Category.keySet());
        adapterIT = new ITAdapter(this, Year_Category, Year_List);

        info_exp_list.setAdapter(adapterIT);

        info_exp_list.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
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
                        setContentView(R.layout.activity_s1);


                    }
                }
                return false;
            }
        });
    }

}
