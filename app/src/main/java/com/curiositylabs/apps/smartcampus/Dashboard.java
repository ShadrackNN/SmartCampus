package com.curiositylabs.apps.smartcampus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {
    private ImageButton logOutUser;
    private ImageButton educational;
    private FirebaseAuth firebaseAuth;
    private ImageButton buttonDiscussion;
    private ImageButton buttonAboutUs;
    private ImageButton buttonGeneral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        MobileAds.initialize(getApplicationContext(), getString(R.string.google_ad_id));
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        firebaseAuth =FirebaseAuth.getInstance();
        logOutUser = (ImageButton) findViewById(R.id.btnLogOut);
        logOutUser.setOnClickListener(this);
        educational = (ImageButton) findViewById(R.id.btnEducational);
        educational.setOnClickListener(this);
        buttonDiscussion = (ImageButton)findViewById(R.id.btnDiscussion);
        buttonDiscussion.setOnClickListener(this);
        buttonAboutUs = (ImageButton) findViewById(R.id.btnAboutUs);
        buttonAboutUs.setOnClickListener(this);
        buttonGeneral = (ImageButton) findViewById(R.id.btnGeneralNotice);
        buttonGeneral.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view==logOutUser){
            Toast.makeText(this, "You have successfully logged out.", Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();

            startActivity(new Intent(this, Login.class));
        }
        if(view ==educational){
            startActivity(new Intent(this, EducationDashboard.class));
        }
        if (view==buttonDiscussion){
            startActivity(new Intent(this, ChatRoom.class));
        }
        if (view ==buttonAboutUs){
            setContentView(R.layout.aboutus);
        }
        if (view ==buttonGeneral){
            startActivity(new Intent(this, GeneralNotice.class));
        }
    }
}
