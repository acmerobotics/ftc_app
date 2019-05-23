package com.acmerobotics.lib.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

import java.lang.reflect.Field;

public abstract class ConfigurationField {
    protected Field field;
    protected SharedPreferences sharedPreferences;

    protected ConfigurationField () {}

    public ConfigurationField (Field field, SharedPreferences preferences) {
        this.field = field;
        this.sharedPreferences = preferences;
    }

    public abstract View getView (Context context);

    public abstract void apply (Object object);

    protected void putString (String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    protected void putBoolean (String key, boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    protected void putInt (String key, int value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public String getName () {
        return field.getName();
    }
}
