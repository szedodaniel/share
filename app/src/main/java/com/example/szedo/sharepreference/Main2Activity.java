package com.example.szedo.sharepreference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private Button Button_kovi,Button_nev,Button_info,Button_kilepes;
    private TextView Text_View1;
    private String fajlNev = "adatok";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        SharedPreferences sharedPreferences = getSharedPreferences(fajlNev, Context.MODE_PRIVATE);
        String alapertelmezett = "Írd be a neved!";
        final String adat = sharedPreferences.getString("adat",alapertelmezett);
        Text_View1.setText(adat);

        Button_kovi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next_activity = new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(next_activity);
                finish();

            }
        });

        Button_nev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next_activity = new Intent(Main2Activity.this,Main4Activity.class);
                startActivity(next_activity);
                finish();

            }
        });
        Button_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main2Activity.this, "A neved: "+adat, Toast.LENGTH_SHORT).show();

            }
        });


        Button_kilepes.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                new AlertDialog.Builder(Main2Activity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Biztosan kilépsz")
                        .setMessage("Biztos ki akarsz lépni a programból?")
                        .setPositiveButton("Igen", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }

                        })
                        .setNegativeButton("Nem", null)
                        .show();
            }
        });

    }
    public void init(){
        Button_kovi = (Button)findViewById(R.id.Button_kovi);
        Button_nev = (Button)findViewById(R.id.Button_nev);
        Button_info = (Button)findViewById(R.id.Button_info);
        Button_kilepes = (Button)findViewById(R.id.Button_kilepes);
        Text_View1 =(TextView)findViewById(R.id.Text_View1);
    }


}


