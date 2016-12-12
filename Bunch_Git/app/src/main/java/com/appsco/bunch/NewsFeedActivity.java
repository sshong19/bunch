package com.appsco.bunch;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class NewsFeedActivity extends AppCompatActivity{

    private RecyclerView mStudyGroupList;
    private DatabaseReference mDatabase;
    private Button studygroup_post;
    private Button logout;

    // public Button join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("StudyGroups");
        mStudyGroupList = (RecyclerView) findViewById(R.id.studygroup_post);
        mStudyGroupList.setHasFixedSize(true);
        mStudyGroupList.setLayoutManager(new LinearLayoutManager(this));
        studygroup_post = (Button) findViewById(R.id.action_add);
        logout = (Button) findViewById(R.id.logout);

//        join  = (Button) findViewById(R.id.join);
//
//        join.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(NewsFeedActivity.this,PostActivity_2.class));
//            }
//        });
        studygroup_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),PostActivity_2.class));
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();

        FirebaseRecyclerAdapter<groupEvent,GroupViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<groupEvent, GroupViewHolder>(

                groupEvent.class,
                R.layout.studygroup_row,
                GroupViewHolder.class,
                mDatabase

        ) {


            @Override
            protected void populateViewHolder(GroupViewHolder viewHolder, groupEvent model, int position) {
                float intensity = model.getIntensity();
                String sIntensity = String.valueOf(intensity);

                //viewHolder.setName(model.getFirstName());
                viewHolder.setDate(model.getDate());
                viewHolder.setLocation(model.getLocation());
                viewHolder.setCourse(model.getCourse());
                viewHolder.setIntensity("Intensity: " + sIntensity);
                viewHolder.setMaxMember("Max People: " + model.getMaximumppl());
                viewHolder.setTime(model.getTime());

            }
        };

        mStudyGroupList.setAdapter(firebaseRecyclerAdapter);

    }


    public static class GroupViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public GroupViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }
       /* public void setName(String name){
            TextView userName = (TextView) mView.findViewById(R.id.username);
            userName.setText(name);
        }*/

        public void setCourse(String course){
            TextView userCourse = (TextView) mView.findViewById(R.id.course);
            userCourse.setText(course);
        }

        public void setDate(String date){
            TextView userDate = (TextView) mView.findViewById(R.id.date);
            userDate.setText(date);
        }

        public void setTime(String time){
            TextView userTime = (TextView) mView.findViewById(R.id.time);
            userTime.setText(time);
        }
        public void setIntensity(String intensity){
            TextView userIntensity = (TextView) mView.findViewById(R.id.intensity);
            String myIntensity = String.valueOf(intensity);
            userIntensity.setText(myIntensity);
    }

        public void setLocation(String location){
            TextView userLocation = (TextView) mView.findViewById(R.id.location);
            userLocation.setText(location);
        }

        public void setMaxMember(String maximumppl){
            TextView userName = (TextView) mView.findViewById(R.id.maxpeople);
            userName.setText(maximumppl);
        }




    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//
//        getMenuInflater().inflate(R.menu.main_menu,menu);
//        return super.onCreateOptionsMenu(menu);
//
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_add){
            startActivity(new Intent(NewsFeedActivity.this,PostActivity_2.class));
        }

        return super.onOptionsItemSelected(item);

    }

}
