package com.example.minority.androidlistviewactivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class allListItem extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] movie = getResources().getStringArray(R.array.film);

        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_film, R.id.label, movie));

        ListView lv = getListView();
        lv.setOnItemClickListener(new OnItemClickListener() {
                                      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                          String name = ((TextView) view).getText().toString();
                                          Intent i = new Intent(getApplicationContext(), SingleListItem.class);
                                          i.putExtra("name", name);
                                          startActivity(i);
                                      }
                                  }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
