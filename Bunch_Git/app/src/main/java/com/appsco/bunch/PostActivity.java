
package com.appsco.bunch;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

public class PostActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private Button addEvent;
    private DatabaseReference databaseReference;
    private EditText editDate, time, editWhere, editClass, editMaxPeople;
    private RatingBar ratingBar;
//    private ProgressDialog progressDialog;
    private Button cancelButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        FirebaseUser user = firebaseAuth.getCurrentUser();
        firebaseAuth = FirebaseAuth.getInstance();

        //looks if the user is done with building profile
//        if (databaseReference.child("Users").child(user.getUid()).child("Profile") == null ){
//            finish();
//            startActivity(new Intent(this,ProfileActivity.class));
//        }

        //date of study group
        editDate = (EditText) findViewById(R.id.editDate);

        //time of event
        time = (EditText) findViewById(R.id.time);

        //place of event
        editWhere = (EditText) findViewById(R.id.editWhere);

        //which class that they are studying for
        editClass = (EditText) findViewById(R.id.editClass);

        //maximum people in study group
        editMaxPeople = (EditText) findViewById(R.id.editMaxPeople);

        //rate of intensity
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        //button for creating the event
        addEvent = (Button) findViewById(R.id.addEvent);
        cancelButton = (Button) findViewById(R.id.cancel);

//      progressDialog = new ProgressDialog(this);

        addEvent.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
    }

    private void addStudyGroupEvent(){
        float intensity = ratingBar.getRating();
        String date = editDate.getText().toString().trim();
        String startTime = time.getText().toString().trim();
        String studyClass = editClass.getText().toString().trim();
        String maxPeople = editMaxPeople.getText().toString().trim();
        String location = editWhere.getText().toString().trim();
        FirebaseUser myUser = firebaseAuth.getCurrentUser();
        DatabaseReference mFirstName;
        DatabaseReference mLastName;

        mFirstName = FirebaseDatabase.getInstance().getReference().child("Users").child(myUser.getUid()).child("Profile").child("firstName");
        mLastName = FirebaseDatabase.getInstance().getReference().child("Users").child(myUser.getUid()).child("Profile").child("lastName");

        String email = myUser.getEmail();
        

        studyGroup myStudyGroup  = new studyGroup(email, intensity, studyClass, maxPeople, date, startTime);
        databaseReference.child("StudyGroups").child("Group "+ myUser.getUid()).setValue(myStudyGroup);

        Toast.makeText(this,"Study Group Made...",Toast.LENGTH_LONG).show();
    }


    @Override
    public void onClick(View v) {
        if (v == addEvent){
            addStudyGroupEvent();
        }
        if (v == cancelButton){
            startActivity(new Intent(this,ProfileActivity.class));
        }
    }
}


