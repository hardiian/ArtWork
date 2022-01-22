package com.example.artwork;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.artwork.Fragment.HomeFragment;
import com.example.artwork.Model.Post;
import com.example.artwork.Model.Report;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class ReportActivity extends AppCompatActivity {

    public Context mContext;
    public List<Post> mPost;
    public List<Report> mReport;

    Report reportclass;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getInstance().getReference();
    DatabaseReference ref = reference.child("Report");

    Button submit,cencel;
    RadioButton sexualRB,violentRB,bullyRB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        submit = findViewById(R.id.submit_report);
        cencel = findViewById(R.id.cencel_report);

        sexualRB = findViewById(R.id.sexual_report);
        violentRB = findViewById(R.id.violent_report);
        bullyRB = findViewById(R.id.bully_report);
        reportclass = new Report();

        getActivityResultRegistry();

        Post post = new Post();

        cencel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), HomeFragment.class);
                startActivity(intent);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                report(reportclass.getId(), reportclass.getPostImage(), reportclass.getTime());
            }
        });
    }

    private void report(String id,String postImage,String time){

        if (sexualRB.isChecked()){

            reportclass.setReport("sexual content");
            reportclass.setId(id);
            reportclass.setPostImage(postImage);
            reportclass.setTime(time);

            String key = reference.push().getKey();

            ref.child(key).setValue(reportclass).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(ReportActivity.this,"report success",Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(ReportActivity.this,"failed",Toast.LENGTH_SHORT).show();
                }
            });


        }else if(violentRB.isChecked()){

            reportclass.setReport("violent content");
            reportclass.setId(id);
            reportclass.setPostImage(postImage);
            reportclass.setTime(time);

            String key = reference.push().getKey();
            assert key != null;
            ref.child(key).setValue(reportclass).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(ReportActivity.this,"report success",Toast.LENGTH_LONG).show();
                }
            });
        }else {

            reportclass.setReport("bullying content");
            reportclass.setId(id);
            reportclass.setPostImage("postImage");
            reportclass.setTime(time);

            String key = reference.push().getKey();
            assert key != null;
            ref.child(key).setValue(reportclass).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(ReportActivity.this,"report success",Toast.LENGTH_LONG).show();
                }
            });
        }

    }
}