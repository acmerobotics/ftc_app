package org.firstinspires.ftc.robotcontroller.internal.configuration;

import android.content.Context;
import android.content.SharedPreferences;

import com.qualcomm.robotcore.util.Range;

public class OpModeConfiguration {

    public static final String PREFS_NAME = "opmode";
    public static final String PREFS_COLOR = "alliance_color";
    public static final String PREFS_LOCATION = "start_location";
    public static final String PREFS_DELAY = "delay";
    public static final String PREFS_MATCH_TYPE = "match_type";
    public static final String PREFS_MATCH_NUMBER = "match_number";
    public static final String PREFS_LATCHED = "latched";
    public static final String PREFS_SAMPLE_BOTH = "sample_both";
    public static final String PREFS_PLAY_MUSIC = "play_music";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public OpModeConfiguration (Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

//    public AllianceColor getAllianceColor() {
//        return AllianceColor.fromIndex(sharedPreferences.getInt(PREFS_COLOR, 0));
//    }
//
//    public void setAllianceColor(AllianceColor color) {
//        editor.putInt(PREFS_COLOR, color.getIndex());
//        editor.commit();
//    }

    public StartLocation getStartLocation() {
        return StartLocation.fromIndex(sharedPreferences.getInt(PREFS_LOCATION, 0));
    }

    public void setStartLocation(StartLocation loc) {
        editor.putInt(PREFS_LOCATION, loc.getIndex());
        editor.commit();
    }

    public int getDelay() {
        return sharedPreferences.getInt(PREFS_DELAY, 0);
    }

    public void setDelay(int delay) {
        delay = Range.clip(delay, 0, 30);
        editor.putInt(PREFS_DELAY, delay);
        editor.commit();
    }

//    public MatchType getMatchType() {
//        return MatchType.fromIndex(sharedPreferences.getInt(PREFS_MATCH_TYPE, 0));
//    }
//
//    public void setMatchType (MatchType type) {
//        editor.putInt(PREFS_MATCH_TYPE, type.getIndex());
//        editor.commit();
//    }
//
//    public int getMatchNumber() {
//        return sharedPreferences.getInt(PREFS_MATCH_NUMBER, 0);
//    }
//
//    public void setMatchNumber (int num) {
//        num = num > 0 ? num : 1;
//        editor.putInt(PREFS_MATCH_NUMBER, num);
//        editor.commit();
//    }

    public boolean getLatched() {
        return sharedPreferences.getBoolean(PREFS_LATCHED, false);
    }

    public void setLatched (boolean latched) {
        editor.putBoolean(PREFS_LATCHED, latched);
        editor.commit();
    }

    public boolean getSampleBoth() {
        return sharedPreferences.getBoolean(PREFS_SAMPLE_BOTH, false);
    }

    public void setSampleBoth(boolean sampleBoth) {
        editor.putBoolean(PREFS_SAMPLE_BOTH, sampleBoth);
        editor.commit();
    }

    public boolean getPlayMusic() {
        return sharedPreferences.getBoolean(PREFS_PLAY_MUSIC, false);
    }

    public void setPlayMusic(boolean playMusic) {
        editor.putBoolean(PREFS_PLAY_MUSIC, playMusic);
        editor.commit();
    }
}
