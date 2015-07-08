package id.mnrty.com.imdbsqlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class utama extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        findViewById(R.id.masuk).setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),
                        DisplayActivity.class);
                i.putExtra("update", false);
                startActivity(i);

            }
        });
        findViewById(R.id.About).setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),
                        About.class);
                i.putExtra("update", false);
                startActivity(i);

            }
        }); findViewById(R.id.exit).setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

            finish();

                System.exit(0);

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.utama, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
