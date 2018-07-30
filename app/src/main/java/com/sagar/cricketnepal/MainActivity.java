package com.sagar.cricketnepal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView LiveScore= (TextView)findViewById(R.id.viewScore);

        LiveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent live= new Intent(MainActivity.this,LiveScore.class);
                startActivity(live);
            }
        });
    }
}
