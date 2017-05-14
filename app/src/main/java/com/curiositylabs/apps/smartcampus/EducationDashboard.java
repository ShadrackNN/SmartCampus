package com.curiositylabs.apps.smartcampus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class EducationDashboard extends AppCompatActivity implements View.OnClickListener{
    private ImageButton btnCs;
    private ImageButton btnSoen;
    private ImageButton btnAcmp;
    private ImageButton btnMediaComms;
    private ImageButton btnInfo;
    private ImageButton btnExamsNotice;

    private TextView cs;
    private TextView soen;
    private TextView acmp;
    private TextView media;
    private TextView exam;
    private TextView it;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_dashboard);



        btnCs=(ImageButton)findViewById(R.id.btnComputerScience);
        btnCs.setOnClickListener(this);
        btnSoen=(ImageButton)findViewById(R.id.btnSoftwareEngineering);
        btnSoen.setOnClickListener(this);
        btnAcmp=(ImageButton)findViewById(R.id.btnAppliedScience);
        btnAcmp.setOnClickListener(this);
        btnMediaComms=(ImageButton)findViewById(R.id.btnMedia);
        btnMediaComms.setOnClickListener(this);
        btnInfo=(ImageButton)findViewById(R.id.btnInfoTech);
        btnInfo.setOnClickListener(this);
        btnExamsNotice=(ImageButton)findViewById(R.id.btnExam);
        btnExamsNotice.setOnClickListener(this);

        cs = (TextView) findViewById(R.id.tvCS);
        cs.setOnClickListener(this);
        soen = (TextView) findViewById(R.id.tvSoen);
        soen.setOnClickListener(this);
        acmp = (TextView) findViewById(R.id.tvAcmp);
        acmp.setOnClickListener(this);
        media = (TextView) findViewById(R.id.tvMedia);
        media.setOnClickListener(this);
        exam = (TextView) findViewById(R.id.tvExamNotices);
        exam.setOnClickListener(this);
        it = (TextView) findViewById(R.id.tvIT);
        it.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view ==btnCs || view ==cs){
            startActivity(new Intent(EducationDashboard.this, ComputerScienceAcademics.class));
        }

        if (view ==btnSoen || view ==soen){
            startActivity(new Intent(EducationDashboard.this, SoftwareEngineerAcademics.class));
        }
        if (view ==btnAcmp || view ==acmp){
            startActivity(new Intent(EducationDashboard.this, AcmpAcademics.class));
        }
        if (view ==btnMediaComms || view ==media){
            startActivity(new Intent(EducationDashboard.this, MediaAcademics.class));
        }
        if (view ==btnInfo || view ==it){
            startActivity(new Intent(EducationDashboard.this, InfoTechAcademics.class));
        }
        if (view ==btnExamsNotice || view ==exam){
            startActivity(new Intent(EducationDashboard.this, ExamNotices.class));
        }
    }
}