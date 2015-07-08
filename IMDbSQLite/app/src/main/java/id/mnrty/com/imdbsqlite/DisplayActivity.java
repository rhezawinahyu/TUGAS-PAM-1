package id.mnrty.com.imdbsqlite;

/**
 * Created by HEADBANGER on 4/2/2015.
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * activity to display all records from SQLite database
 *
 * @author ketan(Visit my <a
 *href="http://androidsolution4u.blogspot.in/">blog</a>)
 */
public class DisplayActivity extends Activity {

    private DbHelper mHelper;
    private SQLiteDatabase dataBase;

    private ArrayList<String> userId = new ArrayList<String>();
    private ArrayList<String> user_fName = new ArrayList<String>();
    private ArrayList<String> user_lName = new ArrayList<String>();
    private ArrayList<String> user_size = new ArrayList<String>();
    private ArrayList<String> user_pay = new ArrayList<String>();
    private ArrayList<String> user_produce = new ArrayList<String>();
    private ArrayList<String> user_genre = new ArrayList<String>();

    private ListView userList;
    private AlertDialog.Builder build;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_activity);

        userList = (ListView) findViewById(R.id.List);

        mHelper = new DbHelper(this);

        //add new record
        findViewById(R.id.btnAdd).setOnClickListener(new OnClickListener() {

            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),
                        AddActivity.class);
                i.putExtra("update", false);
                startActivity(i);

            }
        });
        findViewById(R.id.keluar1).setOnClickListener(new OnClickListener() {

            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),
                        utama.class);
                i.putExtra("update", false);
                startActivity(i);

            }
        });

        //click to update data
        userList.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {

                Intent i = new Intent(getApplicationContext(),
                        updateActivity.class);
                i.putExtra("Fname", user_fName.get(arg2));
                i.putExtra("Lname", user_lName.get(arg2));
                i.putExtra("size", user_size.get(arg2));
                i.putExtra("pay", user_pay.get(arg2));
                i.putExtra("produce", user_produce.get(arg2));
                i.putExtra("genre", user_genre.get(arg2));
                i.putExtra("ID", userId.get(arg2));
                i.putExtra("update", true);
                startActivity(i);

            }
        });

        //long click to delete data
        userList.setOnItemLongClickListener(new OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           final int arg2, long arg3) {

                build = new AlertDialog.Builder(DisplayActivity.this);
                build.setTitle("Do you want to delete  " + user_fName.get(arg2) + " ?"

                );
                //build.setMessage("Do you want to delete ?");
                build.setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog,
                                                int which) {
                                dataBase.delete(
                                        DbHelper.TABLE_NAME,
                                        DbHelper.KEY_ID + "="
                                                + userId.get(arg2), null);
                                displayData();
                                dialog.cancel();
                            }
                        });

                build.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog,
                                                int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = build.create();
                alert.show();

                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        displayData();
        super.onResume();
    }

    /**
     * displays data from SQLite
     */
    private void displayData() {
        dataBase = mHelper.getWritableDatabase();
        Cursor mCursor = dataBase.rawQuery("SELECT * FROM "
                + DbHelper.TABLE_NAME, null);

        userId.clear();
        user_fName.clear();
        user_lName.clear();
        user_size.clear();
        user_pay.clear();
        user_produce.clear();
        user_genre.clear();
        if (mCursor.moveToFirst()) {
            do {
                userId.add(mCursor.getString(mCursor.getColumnIndex(DbHelper.KEY_ID)));
                user_fName.add(mCursor.getString(mCursor.getColumnIndex(DbHelper.KEY_FNAME)));
                user_lName.add(mCursor.getString(mCursor.getColumnIndex(DbHelper.KEY_LNAME)));
                user_size.add(mCursor.getString(mCursor.getColumnIndex(DbHelper.KEY_SIZE)));
                user_pay.add(mCursor.getString(mCursor.getColumnIndex(DbHelper.KEY_PAY)));
                user_produce.add(mCursor.getString(mCursor.getColumnIndex(DbHelper.KEY_PRODUCE)));
                user_genre.add(mCursor.getString(mCursor.getColumnIndex(DbHelper.KEY_GENRE)));

            } while (mCursor.moveToNext());
        }
        DisplayAdapter disadpt = new DisplayAdapter(DisplayActivity.this, userId, user_fName, user_lName, user_size, user_pay, user_produce, user_genre);
        userList.setAdapter(disadpt);
        mCursor.close();
    }

}
