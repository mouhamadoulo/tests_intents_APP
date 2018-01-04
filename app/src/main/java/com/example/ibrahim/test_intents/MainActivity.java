package com.example.ibrahim.test_intents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String URL = "url_de_la_page";
    Button mybtn1;
    Button mybtn2;
    EditText myedittext;
    TextView mytextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Récupération des composants de notre GUI
        mybtn1 = (Button) findViewById(R.id.btnSUBMIT);
        mybtn2 = (Button) findViewById(R.id.btnEXIT1);
        myedittext = (EditText) findViewById(R.id.editText1);
        mytextview = (TextView) findViewById(R.id.mytv);

        //Ajout d'événements sur les composants
        mybtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String defaultURL = "http://duckduckgo.com/?android";
                String url = myedittext.getText().toString();
                if(Uri.parse(url).getScheme() == null){
                    mytextview.setText("Enter a valid URL http://...");
                    url = defaultURL;
                }
                //Là on démarre une autre activité bien explicite
                Intent myIntent = new Intent(getApplicationContext(),ExplicitActivity.class);
                myIntent.putExtra(URL,url);
                startActivity(myIntent);
            }
        });
        mybtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
