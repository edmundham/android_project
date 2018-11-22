package ca.bcit.android_project;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import java.util.ArrayList;
import android.support.v7.widget.Toolbar;
import ca.bcit.android_project.model.Crime;
import ca.bcit.android_project.service.CsvProcess;

public class listActivity extends AppCompatActivity {
    private Toolbar mTopToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mTopToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mTopToolbar);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.list_menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
//                Intent i = new Intent(this, PersonFormActivity.class);
//                i.putExtra("edit", false); // not necessary; for readability
//                startActivity(i);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
