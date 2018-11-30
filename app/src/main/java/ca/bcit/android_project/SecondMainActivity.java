package ca.bcit.android_project;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import ca.bcit.android_project.model.Crime;
import ca.bcit.android_project.service.CsvProcess;

public class SecondMainActivity extends AppCompatActivity {

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    public void calculateAlertLevel(Location userLocation) {
        List<Crime> crimes = CsvProcess.convertCsvToListOfCrimes(this);
        int counter = 0;
        for (Crime crime : crimes) {
            Location crimeLocation = new Location("CrimeLocation");
            crimeLocation.setLatitude(Double.parseDouble(crime.getLat()));
            crimeLocation.setLongitude(Double.parseDouble(crime.getLon()));
            if (userLocation.distanceTo(crimeLocation) < 500) {
                counter++;
            }
        }
        if (counter > 100) {
            counter = 100;
        }
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText(String.valueOf(counter));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkLocationPermission();
        }

        final LocationListener mLocationListener = new LocationListener() {
            @Override
            public void onLocationChanged(final Location location) {
                calculateAlertLevel(location);
            }
            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {}
            @Override
            public void onProviderEnabled(String s) {}
            @Override
            public void onProviderDisabled(String s) {}
        };
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 0, mLocationListener);
        calculateAlertLevel(locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER));
    }

    public void map(View v) {
        Intent intent1 = new Intent(this, MapActivity.class);
        startActivity(intent1);
    }

    public void list(View v) {
        Intent intent1 = new Intent(this, listActivity.class);
        startActivity(intent1);
    }

    public void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
        }
    }
}
