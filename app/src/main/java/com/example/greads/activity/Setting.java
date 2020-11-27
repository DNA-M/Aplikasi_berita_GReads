package com.example.greads.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.example.greads.R;
import com.example.greads.Utils.SettingPreference;
import com.example.greads.notify.NotificationDailyReceiver;

public class Setting extends AppCompatActivity {

    private SwitchCompat switchReminder;
    private NotificationDailyReceiver notificationDailyReceiver;
    private SettingPreference settingPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        switchReminder = findViewById(R.id.swDailyReminder);

        notificationDailyReceiver = new NotificationDailyReceiver();

        settingPreference = new SettingPreference(this);

        setSwitchReminder();

        // Switch Reminder OnClick
        switchReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchReminder.isChecked()) {
                    notificationDailyReceiver.setDailyAlarm(getApplicationContext());
                    settingPreference.setDailyReminder(true);
                    Toast.makeText(getApplicationContext(), "Pengingat harian diaktifkan", Toast.LENGTH_SHORT).show();
                } else {
                    notificationDailyReceiver.cancelAlarm(getApplicationContext());
                    settingPreference.setDailyReminder(false);
                    Toast.makeText(getApplicationContext(), "Pengingat harian dinonaktifkan", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    private void setSwitchReminder() {
        if (settingPreference.getDailyReminder()) switchReminder.setChecked(true);
        else switchReminder.setChecked(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}