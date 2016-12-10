package com.appsco.bunch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;

    private TextView textViewUserEmail;
    private Button buttonLogout;

    private DatabaseReference databaseReference;

    private EditText editFirstName, editLastName;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

//        if (databaseReference.child("Users").child(user.getUid()).child("Profile") != null){
//            finish();
//            startActivity(new Intent(this,UserThread.class));
//        }

        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        textViewUserEmail.setText("Welcome "+user.getEmail());

        databaseReference = FirebaseDatabase.getInstance().getReference();

        editFirstName = (EditText) findViewById(R.id.editFirstName);
        editLastName = (EditText) findViewById(R.id.editLastName);
        buttonSave = (Button) findViewById(R.id.buttonSave);

        buttonLogout = (Button) findViewById(R.id.buttonLogout);

        buttonLogout.setOnClickListener(this);
        buttonSave.setOnClickListener(this);



    }

    private void saveUserInformation() {
        String firstName = editFirstName.getText().toString().trim();
        String lastName = editLastName.getText().toString().trim();
        User userInformation  = new User(firstName,lastName);

        //gets the unique id of the current user
        FirebaseUser user = firebaseAuth.getCurrentUser();

        //saves the information of the users into the child, "Users"
        databaseReference.child("Users").child(user.getUid()).child("Profile").setValue(userInformation);

        Toast.makeText(this,"Information Saved...",Toast.LENGTH_LONG).show();

    }


    @Override
    public void onClick(View v) {

        if(v == buttonLogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }
        if (v == buttonSave){
            saveUserInformation();
//            startActivity(new Intent(this,PostActivity.class));
        }
    }
}
