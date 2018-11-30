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

        String occuranceYear = crimeObject[4];
        String reportedDate = crimeObject[5];
        String offense = crimeObject[8];
        String houseNumber = crimeObject[10].replace('X', '0');
        String streetName = crimeObject[11];
        String city = crimeObject[12];

        if(!houseNumber.trim().equals("")){
            houseNumber += ", ";
        }

        String address = houseNumber + streetName + ", " + city;
        String reportedDateText = crimeObject[13];

        TextView reportedDatetv = findViewById(R.id.textView14);
        TextView offensetv = findViewById(R.id.textView13);
        TextView addresstv = findViewById(R.id.textView11);
        TextView reportedDateTexttv = findViewById(R.id.textView8);

        reportedDatetv.setText(String.format("Date and Time: %s", reportedDate));
        offensetv.setText(String.format("Crime Category: %s", offense));
        addresstv.setText(String.format("Location: %s", address));
        reportedDateTexttv.setText(String.format("Reported Date: %s", reportedDateText));












    }

}
