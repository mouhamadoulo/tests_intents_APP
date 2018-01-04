package com.example.ibrahim.test_intents;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExplicitActivity extends AppCompatActivity {

    TextView tv;
    Button button1;
    Button button2;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);

        tv = (TextView) findViewById(R.id.txtVIEW1);
        button1 = (Button) findViewById(R.id.btnSTART);
        button2 = (Button) findViewById(R.id.btnEXIT2);

        Intent intent = getIntent();
        url = intent.getStringExtra(MainActivity.URL);
        tv.setText(url);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Là on démarre une autre activité de manière implicite
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(webIntent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
