//package com.appsco.bunch;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.TextView;
//
//
//public class NewsFeedActivity extends AppCompatActivity {
//
//    private RecyclerView mStudyGroupList;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_news_feed);
//        mStudyGroupList = (RecyclerView) findViewById(R.id.studygroup_post);
//        mStudyGroupList.setHasFixedSize(true);
//        mStudyGroupList.setLayoutManager(new LinearLayoutManager(this));
//
//    }
//
//    @Override
//    protected void onStart(){
//        super.onStart();
//
//         FirebaseBaseRecyclerAdapter<groupEvent,GroupViewHolder> firebaseRecyclerAdapter = new FireBaseRecyclerAdapter<groupEvent, GroupViewHolder>(){
//
//    }
//
//    }
//
//    public static class GroupViewHolder extends RecyclerView.ViewHolder{
//        View mView;
//        public GroupViewHolder(View itemView) {
//            super(itemView);
//            itemView = mView;
//        }
//        public void setName(String name){
//            TextView userName = (TextView) mView.findViewById(R.id.name);
//            userName.setText(name);
//
//        }
//        public void setCourse(String course){
//            TextView userCourse = (TextView) mView.findViewById(R.id.course);
//            userCourse.setText(course);
//        }
//
//        public void setDate(String date){
//            TextView userDate = (TextView) mView.findViewById(R.id.date);
//            userDate.setText(date);
//
//        }
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//
//        getMenuInflater().inflate(R.menu.main_menu,menu);
//        return super.onCreateOptionsMenu(menu);
//
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        if (item.getItemId() == R.id.action_add){
//            startActivity(new Intent(NewsFeedActivity.this,PostActivity.class));
//        }
//
//        return super.onOptionsItemSelected(item);
//
//    }
//
//}
