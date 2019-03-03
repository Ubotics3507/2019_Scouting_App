package com.applications.josep.a2019_scouting_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

public class PitDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pit_data);

        Spinner teamNum = (Spinner) findViewById(R.id.TeamNumSpinner);
        ArrayAdapter<String> teamNumAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.team_numbers));
        teamNumAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        teamNum.setAdapter(teamNumAd);

        Spinner scoring = (Spinner) findViewById(R.id.BallHatchBothSpinner);
        ArrayAdapter<String> scoringAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.ball_hatch_both));
        scoringAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        scoring.setAdapter(scoringAd);

        Spinner sandstorm = (Spinner) findViewById(R.id.AutoCameraBothSpinner);
        ArrayAdapter<String> sandstormAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.auto_camera_both));
        sandstormAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sandstorm.setAdapter(sandstormAd);

        Spinner climb = (Spinner) findViewById(R.id.ClimbSpinner);
        ArrayAdapter<String> climbAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.climb));
        climbAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        climb.setAdapter(climbAd);

        Spinner rocket = (Spinner) findViewById(R.id.RocketSpinner);
        ArrayAdapter<String> rocketAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.rocket_reach));
        rocketAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rocket.setAdapter(rocketAd);

        Spinner drivetrain = (Spinner) findViewById(R.id.DriveTrainSpinner);
        ArrayAdapter<String> drivetrainAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.drive_train));
        drivetrainAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        drivetrain.setAdapter(drivetrainAd);
    }
}
