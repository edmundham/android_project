package ca.bcit.android_project;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

public class MarkerService extends IntentService {
    public MarkerService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
