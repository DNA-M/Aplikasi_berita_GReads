package com.example.greads.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SettingPreference {

    private static final String PREFS_NAME = "setting_pref";
    private static final String DAILY_REMINDER = "isDaily";
    private final SharedPreferences mSharedPreferences;

    public SettingPreference(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void setDailyReminder(boolean isActive) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(DAILY_REMINDER, isActive);
        editor.apply();
    }

    public boolean getDailyReminder() {
        return mSharedPreferences.getBoolean(DAILY_REMINDER, false);
    }
}