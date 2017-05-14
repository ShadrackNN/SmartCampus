package com.curiositylabs.apps.smartcampus;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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

public class Login extends AppCompatActivity{
    private TextView toSignUp;
    private EditText email;
    private TextView forgot_pass;
    private EditText password;
    private Button bLogin;
    private FirebaseAuth auth;
    private ProgressDialog progressDialog;
    private FirebaseAuth.AuthStateListener authStateListener;


    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (authStateListener!=null){
            auth.removeAuthStateListener(authStateListener);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        authStateListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser()!=null){

                    //If user doesn't want to keep logging in, kindly uncheck this line
                    Intent dashIntent = new Intent(Login.this, Dashboard.class);


                    dashIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    dashIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    dashIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    startActivity(dashIntent);

                }
            }
        };

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        //Remember to rectify below
        forgot_pass = (TextView) findViewById(R.id.link_reset_password);
        forgot_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, ResetPassword.class));
            }
        });
        toSignUp =(TextView) findViewById(R.id.link_signup);
        toSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSignUpScreen = new Intent(Login.this, Register.class);
                startActivity(toSignUpScreen);
            }
        });

        email = (EditText) findViewById(R.id.input_email);
        password = (EditText)findViewById(R.id.input_password);
        bLogin = (Button)findViewById(R.id.btn_login);
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userEmail = email.getText().toString();
                final String userPassword = password.getText().toString();

                //Checking if email and password are empty
                if (TextUtils.isEmpty(userEmail)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(userPassword)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressDialog.setMessage("Trying to login...");
                progressDialog.show();

                auth.signInWithEmailAndPassword(userEmail, userPassword)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()){
                                    Toast.makeText(Login.this, "Unable to login user", Toast.LENGTH_LONG).show();
                                    progressDialog.dismiss();
                                }

                                else if (task.isSuccessful()){
                                    startActivity(new Intent(Login.this, Dashboard.class));
                                }
                            }
                        });
            }
        });

    }

}
