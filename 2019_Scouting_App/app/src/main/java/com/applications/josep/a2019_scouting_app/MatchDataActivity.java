package com.applications.josep.a2019_scouting_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MatchDataActivity extends AppCompatActivity {

    String Text_File = "match_data.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_data);

        final Spinner matchNum = (Spinner) findViewById(R.id.matchNumSpinner);

        ArrayAdapter<String> matchNumAd = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.match_num));
        matchNumAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        matchNum.setAdapter(matchNumAd);

        final Spinner redNum1 = (Spinner) findViewById(R.id.redTeam1);
        ArrayAdapter<String> red1NumAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.team_numbers));
        red1NumAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        redNum1.setAdapter(red1NumAd);

        final Spinner redNum2 = (Spinner) findViewById(R.id.redTeam2);
        ArrayAdapter<String> red2NumAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.team_numbers));
        red2NumAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        redNum2.setAdapter(red2NumAd);

        final Spinner redNum3 = (Spinner) findViewById(R.id.redTeam3);
        ArrayAdapter<String> red3NumAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.team_numbers));
        red3NumAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        redNum3.setAdapter(red3NumAd);

        final Spinner blueNum1 = (Spinner) findViewById(R.id.blueTeam1);
        ArrayAdapter<String> blue1NumAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.team_numbers));
        blue1NumAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        blueNum1.setAdapter(blue1NumAd);

        final Spinner blueNum2 = (Spinner) findViewById(R.id.blueTeam2);
        ArrayAdapter<String> blue2NumAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.team_numbers));
        blue2NumAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        blueNum2.setAdapter(blue2NumAd);

        final Spinner blueNum3 = (Spinner) findViewById(R.id.blueTeam3);
        ArrayAdapter<String> blue3NumAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.team_numbers));
        blue3NumAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        blueNum3.setAdapter(blue3NumAd);

        final Spinner bestBlue = (Spinner) findViewById(R.id.bestBlueSpinner);
        ArrayAdapter<String> bestBlueAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.team_numbers));
        bestBlueAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bestBlue.setAdapter(bestBlueAd);

        final Spinner bestRed = (Spinner) findViewById(R.id.bestRedSpinner);
        ArrayAdapter<String> bestRedAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.team_numbers));
        bestRedAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bestRed.setAdapter(bestRedAd);

        final Spinner winner = (Spinner) findViewById(R.id.winningTeamSpinner);
        ArrayAdapter<String> winnerAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.winners));
        winnerAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        winner.setAdapter(winnerAd);

        final Button addMDataBtn = (Button)findViewById(R.id.addData);
        addMDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sWinner = winner.getSelectedItem().toString();
                save("Match Num: " + matchNum.getSelectedItem().toString() + "\n");
                if(sWinner.equals("Red Alliance")){
                    save("Winners: " + redNum1.getSelectedItem().toString() + " " +
                            redNum2.getSelectedItem().toString() + " " +
                            redNum3.getSelectedItem().toString() + "\n");
                    save("Losers: " + blueNum1.getSelectedItem().toString() + " " +
                            blueNum2.getSelectedItem().toString() + " " +
                            blueNum3.getSelectedItem().toString() + "\n");
                } else if(sWinner.equals("Blue Alliance")){
                    save("Winners: " + blueNum1.getSelectedItem().toString() + " " +
                            blueNum2.getSelectedItem().toString() + " " +
                            blueNum3.getSelectedItem().toString() + "\n");
                    save("Losers: " + redNum1.getSelectedItem().toString() + " " +
                            redNum2.getSelectedItem().toString() + " " +
                            redNum3.getSelectedItem().toString() + "\n");
                } else {
                    save("Tie: " + redNum1.getSelectedItem().toString() + " " +
                            redNum2.getSelectedItem().toString() + " " +
                            redNum3.getSelectedItem().toString() + " " +
                            blueNum1.getSelectedItem().toString() + " " +
                            blueNum2.getSelectedItem().toString() + " " +
                            blueNum3.getSelectedItem().toString() + "\n");
                }
                save("Best Blue: " + bestBlue.getSelectedItem().toString() + "\n");
                save("Best Red: " + bestRed.getSelectedItem().toString() + "\n\n");
            }
        });
    }

    private void save(String text){
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(Text_File,MODE_APPEND);
            fos.write(text.getBytes());
            Toast.makeText(this,"Saved at " + getFilesDir() + "/" + Text_File,Toast.LENGTH_LONG).show();
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
