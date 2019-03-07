package com.applications.josep.a2019_scouting_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PitDataActivity extends AppCompatActivity {

    String Text_File = "pit_data.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pit_data);

        final Spinner teamNum = (Spinner) findViewById(R.id.TeamNumSpinner);
        ArrayAdapter<String> teamNumAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.team_numbers));
        teamNumAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        teamNum.setAdapter(teamNumAd);

        final Spinner scoring = (Spinner) findViewById(R.id.BallHatchBothSpinner);
        ArrayAdapter<String> scoringAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.ball_hatch_both));
        scoringAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        scoring.setAdapter(scoringAd);

        final Spinner sandstorm = (Spinner) findViewById(R.id.AutoCameraBothSpinner);
        ArrayAdapter<String> sandstormAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.auto_camera_both));
        sandstormAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sandstorm.setAdapter(sandstormAd);

        final Spinner climb = (Spinner) findViewById(R.id.ClimbSpinner);
        ArrayAdapter<String> climbAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.climb));
        climbAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        climb.setAdapter(climbAd);

        final Spinner rocket = (Spinner) findViewById(R.id.RocketSpinner);
        ArrayAdapter<String> rocketAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.rocket_reach));
        rocketAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rocket.setAdapter(rocketAd);

        final Spinner drivetrain = (Spinner) findViewById(R.id.DriveTrainSpinner);
        ArrayAdapter<String> drivetrainAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.drive_train));
        drivetrainAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        drivetrain.setAdapter(drivetrainAd);

        final Button addDataBtn = (Button)findViewById(R.id.AddData);
        addDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sTeamNum = teamNum.getSelectedItem().toString();
                String sScoring = scoring.getSelectedItem().toString();
                String sSandstorm = sandstorm.getSelectedItem().toString();
                String sClimb = climb.getSelectedItem().toString();
                String sRocket = rocket.getSelectedItem().toString();
                String sDrivetrain = drivetrain.getSelectedItem().toString();
                String sBody = sTeamNum + " " + sScoring + " " + sSandstorm + " " + sClimb + " " +
                        sRocket + " " + sDrivetrain + "\n";
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
