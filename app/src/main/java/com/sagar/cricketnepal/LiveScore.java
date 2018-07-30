package com.sagar.cricketnepal;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;

public class LiveScore extends AppCompatActivity {


    // URL Address
    String url = "https://cricnepal.com/matchcenter/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_score);
      new GetLiveScore().execute();

ImageView teamA= (ImageView)findViewById(R.id.imageteamA);
        ImageView teamB= (ImageView)findViewById(R.id.imageteamB);

        Picasso.get().load("https://raw.githubusercontent.com/sagarparajuli02/LiveCricktetData/master/two.png").into(teamA);
        Picasso.get().load("https://raw.githubusercontent.com/sagarparajuli02/LiveCricktetData/master/two.png").into(teamB);

    }


    private class GetLiveScore extends AsyncTask<Void, Void, Void> {
        String title;
        String desc;
        String teamA;
        String teamB;
        String imgSrcc;



        @Override
        protected Void doInBackground(Void... params) {
            try {
                // Connect to the web site
                Document document = Jsoup.connect(url).get();

              Element link= document.select("[class=owl-item active]").first();
                Elements aa= link.select("a");
               imgSrcc=aa.attr("href");
               // Toast.makeText(LiveScore.this, imgSrcc, Toast.LENGTH_SHORT).show();

           //     Document imgsrc = Jsoup.connect(imgSrc).get();
                // Get the html document title
                Element description = document
                        .select("[class=score score-team-b]").first();


                Element titlee = document
                        .select("[class=score score-team-a]").first();

                Element table = document
                        .select("table").first();

                Element tableteamA = table
                        .select("td").first();
                Element tableteamB = table
                        .select("td").get(2);




                teamA=tableteamA.text();
                teamB=tableteamB.text();
                desc = description.text();


                title = titlee.text();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Set title into TextView


            Toast.makeText(LiveScore.this,"fuck u" +imgSrcc, Toast.LENGTH_SHORT).show();
            TextView txttitle = (TextView) findViewById(R.id.titletxt);
            txttitle.setText(title);
            TextView txtdesc = (TextView) findViewById(R.id.desctxt);
            txtdesc.setText(desc);

            TextView txtteamA = (TextView) findViewById(R.id.teamNameA);
            txtteamA.setText(teamA);

            TextView txtteamB = (TextView) findViewById(R.id.teamNameB);
            txtteamB.setText(teamB);
        }

    }


}