package com.sagar.cricketnepal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView LiveScore= (TextView)findViewById(R.id.viewScore);
        Button ScheduleBtn= (Button)findViewById(R.id.schedule);
        Button ResultBtn= (Button)findViewById(R.id.result);
        Button NewsBtn= (Button)findViewById(R.id.news);
        Button TeamBtn= (Button)findViewById(R.id.team);
        Button GalleryBtn= (Button)findViewById(R.id.gallery);

        ImageView teamA= (ImageView)findViewById(R.id.imageteamA);
        ImageView teamB= (ImageView)findViewById(R.id.imageteamB);

        Picasso.get().load("https://raw.githubusercontent.com/sagarparajuli02/LiveCricktetData/master/one.png").into(teamA);
        Picasso.get().load("https://raw.githubusercontent.com/sagarparajuli02/LiveCricktetData/master/two.png").into(teamB);


        LiveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent live= new Intent(MainActivity.this,LiveScore.class);
                startActivity(live);
            }
        });

        ScheduleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sch= new Intent(MainActivity.this,Schedule.class);
                startActivity(sch);
            }
        });
        ResultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result= new Intent(MainActivity.this,Result.class);
                startActivity(result);
            }
        });
        NewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent news= new Intent(MainActivity.this,News.class);
                startActivity(news);
            }
        });
        TeamBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent team= new Intent(MainActivity.this,Team.class);
                startActivity(team);
            }
        });
        GalleryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallry= new Intent(MainActivity.this,PhotoGallery.class);
                startActivity(gallry);
            }
        });
    }
}
