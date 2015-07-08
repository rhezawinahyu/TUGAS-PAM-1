package id.mnrty.com.imdbsqlite;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by HEADBANGER on 4/2/2015.
 */
public class AddActivity extends Activity implements OnClickListener {
    private Button btn_save;
    private EditText edit_first,edit_last,edit_size,edit_pay,edit_produce,edit_genre;
    private DbHelper mHelper;
    private SQLiteDatabase dataBase;
    private String id,fname,lname,size,pay,produce,genre;
    private boolean isUpdate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

        btn_save=(Button)findViewById(R.id.save_btn);
        edit_first=(EditText)findViewById(R.id.frst_editTxt);
        edit_last=(EditText)findViewById(R.id.last_editTxt);
        edit_size=(EditText) findViewById(R.id.edittext_size);
        edit_pay=(EditText) findViewById(R.id.edittext_pay);
        edit_produce=(EditText) findViewById(R.id.edittext_produce);
        edit_genre=(EditText) findViewById(R.id.edittext_genre);

        isUpdate=getIntent().getExtras().getBoolean("update");
        if(isUpdate)
        {
            id=getIntent().getExtras().getString("ID");
            fname=getIntent().getExtras().getString("Fname");
            lname=getIntent().getExtras().getString("Lname");
            size=getIntent().getExtras().getString("size");
            pay=getIntent().getExtras().getString("pay");
            produce=getIntent().getExtras().getString("produce");
            genre=getIntent().getExtras().getString("genre");

            edit_first.setText(fname);
            edit_last.setText(lname);
            edit_size.setText(size);
            edit_pay.setText(pay);
            edit_produce.setText(produce);
            edit_genre.setText(genre);

        }

        btn_save.setOnClickListener(this);

        mHelper=new DbHelper(this);

    }

    // saveButton click event
    public void onClick(View v) {
        fname=edit_first.getText().toString().trim();
        lname=edit_last.getText().toString().trim();
        size=edit_size.getText().toString().trim();
        pay=edit_pay.getText().toString().trim();
        produce=edit_produce.getText().toString().trim();
        genre=edit_genre.getText().toString().trim();
        if(fname.length()>0 && lname.length()>0 &&  size.length()>0&&  pay.length()>0&&  produce.length()>0&&  genre.length()>0)
        {
            saveData();
        }
        else
        {
            AlertDialog.Builder alertBuilder=new AlertDialog.Builder(AddActivity.this);
            alertBuilder.setTitle("Invalid Data");
            alertBuilder.setMessage("Please, Enter valid data");
            alertBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();

                }
            });
            alertBuilder.create().show();
        }

    }

    /**
     * save data into SQLite
     */
    private void saveData(){
        dataBase=mHelper.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put(DbHelper.KEY_FNAME,fname);
        values.put(DbHelper.KEY_LNAME,lname );
        values.put(DbHelper.KEY_SIZE,size );
        values.put(DbHelper.KEY_PAY,pay );
        values.put(DbHelper.KEY_PRODUCE,produce );
        values.put(DbHelper.KEY_GENRE,genre );

        System.out.println("");
        if(isUpdate)
        {
            //update database with new data
            dataBase.update(DbHelper.TABLE_NAME, values, DbHelper.KEY_ID+"="+id, null);
        }
        else
        {
            //insert data into database
            dataBase.insert(DbHelper.TABLE_NAME, null, values);
        }
        //close database
        dataBase.close();
        finish();


    }

}
