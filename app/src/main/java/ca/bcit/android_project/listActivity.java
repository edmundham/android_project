package ca.bcit.android_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import ca.bcit.android_project.model.Crime;
import ca.bcit.android_project.service.CsvProcess;

public class listActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        final ArrayList<Crime> crimesList =  CsvProcess.convertCsvToListOfCrimes(this);
        ArrayList<String> crimesAddress = new ArrayList<>();

        for(Crime c : crimesList){
            String detail = "";
            detail += c.getCity() + " (" +c.getReportedDateText() + ")";
            crimesAddress.add(detail);
        }
        ListView lv = findViewById(R.id.list);

        lv.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, crimesAddress));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(listActivity.this, CrimeActivity.class);
//                intent.putExtra("data", crimesList);
//                intent.putExtra("index", i);
//                startActivity(intent);
            }
        });
    }

}
