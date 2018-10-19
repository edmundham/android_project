package ca.bcit.android_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void map(View v) {
        Intent intent1 = new Intent(this, mapActivity.class);
        startActivity(intent1);
    }

    public void list(View v) {
        Intent intent1 = new Intent(this, listActivity.class);
        startActivity(intent1);
    }
}
