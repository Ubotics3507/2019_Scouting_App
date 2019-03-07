package com.applications.josep.a2019_scouting_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TeamMatchScouting extends AppCompatActivity {

    String matchNumber;
    String teamNumber;
    String Text_File = "team_match_data.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_match_scouting);

        //These are the edit texts
        final EditText hatches = (EditText)findViewById(R.id.hatchetET);
        final EditText cargo = (EditText)findViewById(R.id.cargoET);
        final EditText penalties = (EditText)findViewById(R.id.penaltiesET);

        //This gets and sets the match number
        TextView matchNum = (TextView)findViewById(R.id.matchNumber);
        matchNumber = getIntent().getStringExtra("match_num");
        matchNum.setText("Match: " + matchNumber);

        //This gets and sets the team number
        TextView teamName = (TextView)findViewById(R.id.teamName);
        teamNumber = getIntent().getStringExtra("team_num");
        teamName.setText(teamNumber);

        //This sets the issues spinner
        final Spinner issues = (Spinner) findViewById(R.id.issuesSpinner);
        ArrayAdapter<String> issuesAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.issues));
        issuesAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        issues.setAdapter(issuesAd);

        //This sets the hab climb spinner
        final Spinner habClimb = (Spinner) findViewById(R.id.habClimbSpinner);
        ArrayAdapter<String> habClimbAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.hab_climb));
        issuesAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        habClimb.setAdapter(habClimbAd);

        //This sets the rocket spinner
        final Spinner rocket = (Spinner) findViewById(R.id.rocketSpinner);
        ArrayAdapter<String> rocketAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.rocket));
        issuesAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rocket.setAdapter(rocketAd);

        //This sets the hab climb spinner
        final Spinner defense = (Spinner) findViewById(R.id.defenseSpinner);
        ArrayAdapter<String> defenseAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.defense));
        defenseAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        defense.setAdapter(defenseAd);

        //This saves the match data
        final Button addMDataBtn = (Button)findViewById(R.id.addData);
        addMDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sIssues = issues.getSelectedItem().toString();
                String sHatches = hatches.getText().toString();
                String sCargo = cargo.getText().toString();
                String sHabClimb = habClimb.getSelectedItem().toString();
                String sRocket = rocket.getSelectedItem().toString();
                String sDefense = defense.getSelectedItem().toString();
                String sPenalties = penalties.getText().toString();
                String sBody = sIssues + " " + sHatches + " " + sCargo + " " +
                        sHabClimb + " " + sRocket + " " + sDefense + " " + sPenalties + "\n";
                save(sBody);
            }
        });
    }

    private void save(String text){
        Logger logger = new Logger("pit_data.txt");
        logger.log(text);
        Toast.makeText(getBaseContext(),"saved",Toast.LENGTH_LONG);
    }
}
