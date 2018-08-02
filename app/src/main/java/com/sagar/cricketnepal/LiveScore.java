package com.sagar.cricketnepal;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;

public class LiveScore extends AppCompatActivity {


    // URL Address
    String url ="https://cricnepal.com/matchcenter/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_score);
        new GetLiveScore().execute();


        ImageView teamA = (ImageView) findViewById(R.id.imageteamA);
        ImageView teamB = (ImageView) findViewById(R.id.imageteamB);

        Picasso.get().load("https://raw.githubusercontent.com/sagarparajuli02/LiveCricktetData/master/one.png").into(teamA);
        Picasso.get().load("https://raw.githubusercontent.com/sagarparajuli02/LiveCricktetData/master/two.png").into(teamB);

    }



    private class GetLiveScore extends AsyncTask<Void, Void, Void> {
        String title;
        String desc;
        String teamA;
        String teamB;
        String Status;


        @Override
        protected Void doInBackground(Void... params) {
            try {

                //  Toast.makeText(LiveScore.this, mResponse, Toast.LENGTH_SHORT).show();
                Document document = Jsoup.connect(url).get();

                //    Elements elements = document.select("div.owl-item.active > a");


                //  imgSrcc=elements.text();
                //   imgSrcc =  document.select("div.owl-item.active").first().attr("abs:href");
                //  Elements link2= document.select("a");

                //   imgSrcc = link.attr("href");


                // Toast.makeText(LiveScore.this, imgSrcc, Toast.LENGTH_SHORT).show();

                //     Document imgsrc = Jsoup.connect(imgSrc).get();
                // Get the html document title


                Element status = document
                        .select("[class=status alert alert-danger]").first();


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


                teamA = tableteamA.text();
                teamB = tableteamB.text();
                desc = description.text();
                Status = status.text();


                title = titlee.text();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Set title into TextView
            

            TextView txttitle = (TextView) findViewById(R.id.titletxt);
            txttitle.setText(title);
            TextView txtdesc = (TextView) findViewById(R.id.desctxt);
            txtdesc.setText(desc);

            TextView txtteamA = (TextView) findViewById(R.id.teamNameA);
            txtteamA.setText(teamA);

            TextView txtteamB = (TextView) findViewById(R.id.teamNameB);
            txtteamB.setText(teamB);

            TextView txtStatus = (TextView) findViewById(R.id.status);
            txtStatus.setText(Status);
        }


    }}

