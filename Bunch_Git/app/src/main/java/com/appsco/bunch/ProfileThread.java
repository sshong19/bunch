package com.appsco.bunch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.*;
import com.google.firebase.database.DatabaseReference;

public class ProfileThread extends AppCompatActivity {

    private DatabaseReference mCollegeReference;
    private TextView mValueView;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_thread);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();


        // Initialize Database
        mCollegeReference = FirebaseDatabase.getInstance().getReference().child("Users").child(user.getUid()).child("Profile").child("college");

        // Initialize View
        mValueView = (TextView) findViewById(R.id.ValueView);

        ValueEventListener mCollegeListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String college = dataSnapshot.getValue(String.class);
                mValueView.setText(college);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };

        mCollegeReference.addValueEventListener(mCollegeListener);
    }
}
