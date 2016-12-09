package com.appsco.bunch;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //facebook login is not implemented
//    LoginButton loginButton;
//    TextView textView;
//    CallbackManager callbackManager;
//    ProfileTracker profileTracker;
    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignin;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is already registered the user would be directed to profile activity
        if (firebaseAuth.getCurrentUser() != null){
            //profile activity here
            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }

        progressDialog = new ProgressDialog(this);
//        loginButton = (LoginButton)findViewById(R.id.fb_login_bn);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassWord);
        textViewSignin = (TextView) findViewById(R.id.textViewSignin);
//        textView = (TextView)findViewById(R.id.textView);
        buttonRegister.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);
//        callbackManager = CallbackManager.Factory.create();
//        profileTracker = new ProfileTracker() {
//            @Override
//            protected void onCurrentProfileChanged(
//                    Profile oldProfile,
//                    Profile currentProfile
//            ){
//                String firstName = currentProfile.getFirstName();
//                String lastName = currentProfile.getLastName();
//                currentProfile.getProfilePictureUri(40,30);
//            }
//        };
//        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                finish();
//                startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
//            }
//
//            @Override
//            public void onCancel() {
//
//            }
//
//            @Override
//            public void onError(FacebookException error) {
//
//            }
//        });
    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        callbackManager.onActivityResult(requestCode,resultCode,data);
//    }
//
//    @Override
//    public void onDestroy(){
//        super.onDestroy();
//        profileTracker.stopTracking();
//    }

    private void registerUser (){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            //email is empty
            Toast.makeText(this,"Please enter email",Toast.LENGTH_SHORT).show();
            //stopping the function execution
        }

        if (TextUtils.isEmpty(password)){
            //password is empty
            Toast.makeText(this,"Please enter password",Toast.LENGTH_SHORT).show();
            //stopping the function execution
        }

        //if validation are ok
        progressDialog.setMessage("Registering User...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //user is successfully
                            // we will start the profile activity here
                            //right now lets display a toast only
                            finish();
                            startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                            Toast.makeText(MainActivity.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this,"Failed to Register...Please Try Again...",Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if (v == buttonRegister){
            registerUser();
            startActivity(new Intent(this,ProfileActivity.class));
        }
        if (v == textViewSignin){
         //Signin
            startActivity(new Intent(this,LoginActivity.class));
        }
    }
}

