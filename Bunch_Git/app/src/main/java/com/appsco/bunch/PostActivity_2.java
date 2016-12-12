package com.appsco.bunch;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.Rating;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RatingBar;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class PostActivity_2 extends AppCompatActivity {

    private EditText editDate;
    private EditText editTime;
    private EditText editLocation;
    private EditText editClass;
    private RatingBar ratingBar;
    private EditText editMaxPeople;

    private Button cancel;
    private Button addEvent;

    private ProgressDialog mProgress;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private FirebaseUser mCurrentUser;
    private DatabaseReference mDatabaseUser;

    private StorageReference mStorage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        mAuth = FirebaseAuth.getInstance();
        mCurrentUser = mAuth.getCurrentUser();
        mStorage = FirebaseStorage.getInstance().getReference();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("StudyGroups");
        mDatabaseUser = FirebaseDatabase.getInstance().getReference().child("Users").child(mCurrentUser.getUid());

        editDate = (EditText) findViewById(R.id.editDate);
        editTime = (EditText) findViewById(R.id.editTime);
        editLocation = (EditText) findViewById(R.id.editLocation);
        editClass = (EditText) findViewById(R.id.editClass);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        editMaxPeople = (EditText) findViewById(R.id.editMaxPeople);
        addEvent = (Button) findViewById(R.id.addEvent);
        cancel = (Button) findViewById(R.id.cancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),NewsFeedActivity.class));
            }
        });

        mProgress = new ProgressDialog(this);

        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPosting();
                startActivity(new Intent(PostActivity_2.this,NewsFeedActivity.class));
            }
        });
    }

    private void startPosting(){

        mProgress.setMessage("Posting to Newsfeed");
        mProgress.show();

        final String date_val = editDate.getText().toString().trim();
        final String time_val = editTime.getText().toString().trim();
        final String location_val = editLocation.getText().toString().trim();
        final String course_val = editClass.getText().toString().trim();
        final String maxpeople_val = editMaxPeople.getText().toString().trim();
        final float   intensity_val = ratingBar.getRating();

        if(!TextUtils.isEmpty(date_val) && !TextUtils.isEmpty(time_val)
            && !TextUtils.isEmpty(location_val) && !TextUtils.isEmpty(course_val)
            && !TextUtils.isEmpty(maxpeople_val)) {

            final DatabaseReference newPost = mDatabase.push();

            mDatabaseUser.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    newPost.child("date").setValue(date_val);
                    newPost.child("time").setValue(time_val);
                    newPost.child("location").setValue(location_val);
                    newPost.child("course").setValue(course_val);
                    newPost.child("maximumppl").setValue(maxpeople_val);
                    newPost.child("intensity").setValue(intensity_val);
                    newPost.child("uid").setValue(FirebaseAuth.getInstance().getCurrentUser().getUid());

                    newPost.child("username").setValue(dataSnapshot.child("firstName")).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){

                                startActivity(new Intent(getApplicationContext(),NewsFeedActivity.class));

                            }
                        }
                    });

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            mProgress.dismiss();


        }
    }

}
