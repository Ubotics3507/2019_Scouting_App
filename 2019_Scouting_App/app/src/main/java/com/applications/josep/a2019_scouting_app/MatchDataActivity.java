package com.applications.josep.a2019_scouting_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MatchDataActivity extends AppCompatActivity {

    String Text_File = "match_data.txt";
    String red1;
    String red2;
    String red3;
    String blue1;
    String blue2;
    String blue3;
    String[][][] teamsOnMatch =
            {{{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0011","0012","0110"},{"0330","0000","0000"}},
            {{"0000","0010","0000"},{"0001","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}},
            {{"0000","0000","0000"},{"0000","0000","0000"}}};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_data);

        //These are the team buttons
        final Button red1Btn = (Button)findViewById(R.id.red1);
        final Button red2Btn = (Button)findViewById(R.id.red2);
        final Button red3Btn = (Button)findViewById(R.id.red3);
        final Button blue1Btn = (Button)findViewById(R.id.blue1);
        final Button blue2Btn = (Button)findViewById(R.id.blue2);
        final Button blue3Btn = (Button)findViewById(R.id.blue3);

        //This is for choosing the match number
        final Spinner matchNum = (Spinner) findViewById(R.id.matchNumSpinner);
        ArrayAdapter<String> matchNumAd = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.match_num));
        matchNumAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        matchNum.setAdapter(matchNumAd);

        //These are the spinners
        final Spinner bestBlue = (Spinner) findViewById(R.id.bestBlueSpinner);
        final Spinner bestRed = (Spinner) findViewById(R.id.bestRedSpinner);
        final Spinner winner = (Spinner) findViewById(R.id.winningTeamSpinner);


        //These set the spinner choices
        ArrayAdapter<String> bestBlueAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.team_numbers));
        bestBlueAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bestBlue.setAdapter(bestBlueAd);

        ArrayAdapter<String> bestRedAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.team_numbers));
        bestRedAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bestRed.setAdapter(bestRedAd);

        ArrayAdapter<String> winnerAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.winners));
        winnerAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        winner.setAdapter(winnerAd);


        //This saves the match data
        final Button addMDataBtn = (Button)findViewById(R.id.addData);
        addMDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sWinner = winner.getSelectedItem().toString();
                save("MatchNum: " + matchNum.getSelectedItem().toString() + "\n");
                if(sWinner.equals("Red Alliance")){
                    save("Winners: " + red1 + " " + red2 + " " + red3 + "\n");
                    save("Losers: " + blue1 + " " + blue2 + " " + blue3 + "\n");
                } else if(sWinner.equals("Blue Alliance")){
                    save("Winners: " + red1 + " " + red2 + " " + red3 + "\n");
                    save("Losers: " + blue1 + " " + blue2 + " " + blue3 + "\n");
                } else {
                    save("Tied: " + red1 + " " + red2 + " " + red3 + " " + blue1 + " " +
                            blue2 + " " + blue3 + "\n");
                }
                save("BestBlue: " + bestBlue.getSelectedItem().toString() + "\n");
                save("BestRed: " + bestRed.getSelectedItem().toString() + "\n\n");
            }
        });

        //This sets the match number and changes the team options
        matchNum.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    red1Btn.setText("");
                    red2Btn.setText("");
                    red3Btn.setText("");
                    blue1Btn.setText("");
                    blue2Btn.setText("");
                    blue3Btn.setText("");
                } else{
                    red1 = teamsOnMatch[position-1][0][0];
                    red1Btn.setText(red1);
                    red2 = teamsOnMatch[position-1][0][1];
                    red2Btn.setText(red2);
                    red3 = teamsOnMatch[position-1][0][2];
                    red3Btn.setText(red3);
                    blue1 = teamsOnMatch[position-1][1][0];
                    blue1Btn.setText(blue1);
                    blue2 = teamsOnMatch[position-1][1][1];
                    blue2Btn.setText(blue2);
                    blue3 = teamsOnMatch[position-1][1][2];
                    blue3Btn.setText(blue3);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                red1Btn.setText("");
                red2Btn.setText("");
                red3Btn.setText("");
                blue1Btn.setText("");
                blue2Btn.setText("");
                blue3Btn.setText("");
            }
        });

        //These navigate to the teamMatchScouting page
        red1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),TeamMatchScouting.class);
                startIntent.putExtra("match_num",matchNum.getSelectedItem().toString());
                startIntent.putExtra("team_num",red1);
                startActivity(startIntent);
            }
        });
        red2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),TeamMatchScouting.class);
                startIntent.putExtra("match_num",matchNum.getSelectedItem().toString());
                startIntent.putExtra("team_num",red2);
                startActivity(startIntent);
            }
        });
        red3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),TeamMatchScouting.class);
                startIntent.putExtra("match_num",matchNum.getSelectedItem().toString());
                startIntent.putExtra("team_num",red3);
                startActivity(startIntent);
            }
        });
        blue1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),TeamMatchScouting.class);
                startIntent.putExtra("match_num",matchNum.getSelectedItem().toString());
                startIntent.putExtra("team_num",blue1);
                startActivity(startIntent);
            }
        });
        blue2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),TeamMatchScouting.class);
                startIntent.putExtra("match_num",matchNum.getSelectedItem().toString());
                startIntent.putExtra("team_num",blue2);
                startActivity(startIntent);
            }
        });
        blue3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),TeamMatchScouting.class);
                startIntent.putExtra("match_num",matchNum.getSelectedItem().toString());
                startIntent.putExtra("team_num",blue3);
                startActivity(startIntent);
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
