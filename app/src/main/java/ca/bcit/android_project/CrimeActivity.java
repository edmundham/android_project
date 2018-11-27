package ca.bcit.android_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CrimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        String[] crimeObject = data.split(",");

        String objectId = crimeObject[2];
        String occuranceYear = crimeObject[4];
        String reportedDate = crimeObject[5];
        String offense = crimeObject[8];
        String offenseCategory = crimeObject[9];
        String houseNumber = crimeObject[10].replace('X', '0');
        String streetName = crimeObject[11];
        String city = crimeObject[12];
        String reportedDateText = crimeObject[13];
        String lat = crimeObject[15];
        String lon = crimeObject[16];

        TextView objectIdtv = findViewById(R.id.textView16);
        TextView occuranceYeartv = findViewById(R.id.textView15);
        TextView reportedDatetv = findViewById(R.id.textView14);
        TextView offensetv = findViewById(R.id.textView13);
        TextView offenseCategorytv = findViewById(R.id.textView12);
        TextView houseNumbertv = findViewById(R.id.textView11);
        TextView streetNametv = findViewById(R.id.textView10);
        TextView citytv = findViewById(R.id.textView9);
        TextView reportedDateTexttv = findViewById(R.id.textView8);
        TextView lattv = findViewById(R.id.textView7);
        TextView lontv = findViewById(R.id.textView6);

        objectIdtv.setText(objectId);
        occuranceYeartv.setText(occuranceYear);
        reportedDatetv.setText(reportedDate);
        offensetv.setText(offense);
        offenseCategorytv.setText(offenseCategory);
        houseNumbertv.setText(houseNumber);
        streetNametv.setText(streetName);
        citytv.setText(city);
        reportedDateTexttv.setText(reportedDateText);
        lattv.setText(lat);
        lontv.setText(lon);











    }

}
