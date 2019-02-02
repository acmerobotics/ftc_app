package org.firstinspires.ftc.robotcontroller.internal;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;

import com.qualcomm.ftcrobotcontroller.R;
import com.sun.tools.javac.comp.Check;

import org.firstinspires.ftc.robotcontroller.internal.configuration.OpModeConfiguration;
import org.firstinspires.ftc.robotcontroller.internal.configuration.StartLocation;

public class OpModeConfigurationActivity extends Activity {

    private OpModeConfiguration configuration;
    private static final StartLocation LOCATION_ON = StartLocation.CRATER;
    private static final StartLocation LOCATION_OFF = StartLocation.DEPOT;

    @Override
    protected void onCreate(Bundle savedInstancesState) {
        configuration = new OpModeConfiguration(this);
        super.onCreate(savedInstancesState);

        setContentView(R.layout.activity_opmode_configuration);

        Switch startLocation = (Switch) findViewById(R.id.opmode_start_location);
        Switch latched = (Switch) findViewById(R.id.opmode_start_latched);
        SeekBar delay = (SeekBar) findViewById(R.id.opmode_delay);
        CheckBox music = (CheckBox) findViewById(R.id.opmode_music);
        CheckBox both = (CheckBox) findViewById(R.id.opmode_sample_both);

        startLocation.setChecked(configuration.getStartLocation() == LOCATION_ON);
        latched.setChecked(configuration.getLatched());
        delay.setProgress(configuration.getDelay());
        music.setChecked(configuration.getPlayMusic());
        both.setChecked(configuration.getSampleBoth());

        startLocation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                configuration.setStartLocation(isChecked ? LOCATION_ON : LOCATION_OFF);
            }
        });

        latched.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                configuration.setLatched(isChecked);
            }
        });

        music.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                configuration.setPlayMusic(isChecked);
            }
        });

        both.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                configuration.setSampleBoth(isChecked);
            }
        });

        delay.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                configuration.setDelay(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

}
