package com.applications.josep.a2019_scouting_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button pitDataActivityBtn = (Button)findViewById(R.id.PitDataCreate);
        pitDataActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntentP = new Intent(getApplicationContext(),PitDataActivity.class);
                startActivity(startIntentP);
            }
        });

        final Button matchDataActivityBtn = (Button)findViewById(R.id.MatchDataCreate);
        matchDataActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntentM = new Intent(getApplicationContext(),MatchDataActivity.class);
                startActivity(startIntentM);
            }
        });
    }

}
