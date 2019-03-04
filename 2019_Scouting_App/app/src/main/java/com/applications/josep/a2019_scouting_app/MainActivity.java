package com.applications.josep.a2019_scouting_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String Text_File1 = "pit_data.txt";
    String Text_File2 = "match_data.txt";

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

        final Button clearDataBtn = (Button)findViewById(R.id.clearData);
        clearDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });
    }

    private void clear(){
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(Text_File1,MODE_PRIVATE);
            fos.close();
            fos = openFileOutput(Text_File2,MODE_PRIVATE);
            fos.close();
            Toast.makeText(this,"data cleared",Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
