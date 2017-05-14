package com.curiositylabs.apps.smartcampus;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Register extends AppCompatActivity implements View.OnClickListener {
    private TextView toLogin;
    private Button regButton;
    private EditText studentPass;
    private EditText studentEmail;
    private ProgressDialog progressDialog;
    private FirebaseAuth.AuthStateListener authStateListener;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth =FirebaseAuth.getInstance();
        /*
        authStateListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser()!=null){
                    startActivity(new Intent(Register.this, Dashboard.class));
                }
            }
        };

        */
        toLogin = (TextView) findViewById(R.id.link_login);
        toLogin.setOnClickListener(this);

        regButton =(Button)findViewById(R.id.btn_signup);
        regButton.setOnClickListener(this);

        studentPass = (EditText)findViewById(R.id.studentPassword);
        studentPass.setOnClickListener(this);

        studentEmail = (EditText)findViewById(R.id.studentEmail);
        studentEmail.setOnClickListener(this);

        progressDialog = new ProgressDialog(this);

    }

    @Override
    public void onClick(View view) {
        if (view == toLogin){
            Intent loginScreen = new Intent(Register.this, Login.class);

            loginScreen.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            loginScreen.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            loginScreen.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(loginScreen);

        }
        if (view==regButton){
            final String regEmail = studentEmail.getText().toString();
            final String regPassword = studentPass.getText().toString();

            if (TextUtils.isEmpty(regEmail)) {
                Toast.makeText(getApplicationContext(), "Enter your email!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(regPassword)) {
                Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                return;
            }
            progressDialog.setMessage("Registering user...");
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(regEmail, regPassword)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Register.this, "Successfully registered to Smart Campus", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Register.this, Dashboard.class));
                            }
                            else if (!task.isSuccessful()){
                                Toast.makeText(Register.this, "Unable to create account", Toast.LENGTH_LONG).show();
                            }
                        }
                    });






        }
    }

}
