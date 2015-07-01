package com.example.minority.androidlistviewactivity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class about extends Activity{
    Button call1;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        call1 = (Button)  findViewById(R.id.call);
        call();
    }

    private void call(){
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("+628561859160"));
        try{
            startActivity(intent);
        }catch(ActivityNotFoundException x){
            Toast.makeText(getApplicationContext(), "Gagal Menelpon", Toast.LENGTH_SHORT).show();
        }

    }
}
