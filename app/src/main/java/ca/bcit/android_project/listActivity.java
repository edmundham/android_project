package ca.bcit.android_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ca.bcit.android_project.model.Crime;
import ca.bcit.android_project.service.CsvProcess;
import ca.bcit.android_project.service.FilterService;

public class listActivity extends AppCompatActivity {
    private List<Crime> crimesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        crimesList = CsvProcess.convertCsvToListOfCrimes(this);

        EditText searchBox = findViewById(R.id.searchBox);
        searchBox.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    performSearch(v.getText().toString());
                    return true;
                }
                return false;
            }
        });

        List<String> crimesAddress = new ArrayList<>();
        int i = 1;
        for(Crime c : crimesList){
            String detail = "" + i + ". ";
            detail += c.getCity() + " (" +c.getReportedDateText() + ")";
            crimesAddress.add(detail);
            i++;
        }
        ListView lv = findViewById(R.id.crimesList);

        TextView crimeSize = findViewById(R.id.results);
        crimeSize.setText(String.format("%s Crimes", String.valueOf(crimesList.size())));

        lv.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, crimesAddress));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(listActivity.this, CrimeActivity.class);
                String data = crimesList.get(i).toString();
                intent.putExtra("data", data);
                startActivity(intent);
            }
        });
    }

    private void performSearch(String input) {
        FilterService filterService = new FilterService(this);
        crimesList = filterService.search(input);

        List<String> crimesAddress = new ArrayList<>();

        int i = 1;
        for(Crime c : crimesList){
            String detail = "" + i + ". ";
            detail += c.getCity() + " (" +c.getReportedDateText() + ")";
            crimesAddress.add(detail);
            i++;
        }
        ListView lv = findViewById(R.id.crimesList);

        lv.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, crimesAddress));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(listActivity.this, CrimeActivity.class);
                String data = crimesList.get(i).toString();
                intent.putExtra("data", data);
                startActivity(intent);
            }
        });

        TextView crimeSize = findViewById(R.id.results);
        crimeSize.setText(String.format("%s Crimes", String.valueOf(crimesList.size())));
    }
}
