package com.example.szedo.sharepreference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button Button_kuldes1;
    private TextView Text_View1;
    private EditText Edit_Text1;
    private String fajlNev = "adatok";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        SharedPreferences sharedPreferences = getSharedPreferences(fajlNev, Context.MODE_PRIVATE);
        String alapertelmezett = "Írd be a neved!";
        String adat = sharedPreferences.getString("adat",alapertelmezett);

        Text_View1.setText(adat);
        if(!adat.matches("")){
            Edit_Text1.setText(adat);
            new AlertDialog.Builder(MainActivity.this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Üdvözöllek újra "+adat+"!")
                    .setMessage("Folytatod ezen a néven vagy újat akarsz?")
                    .setPositiveButton("Folytatom", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent next_activity = new Intent(MainActivity.this,Main2Activity.class);
                            startActivity(next_activity);
                        }

                    })
                    .setNegativeButton("Újat kérek!", null)
                    .show();
        }
        Button_kuldes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String adat = Edit_Text1.getText().toString();


                if (adat.matches("")) {
                    Toast.makeText(MainActivity.this, "Nem adtál meg nevet!", Toast.LENGTH_SHORT).show();
                    return;
                }else
                    {
                        Intent next_activity = new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(next_activity);

                        SharedPreferences sharedPreferences = getSharedPreferences(fajlNev, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("adat",adat);
                        editor.commit();


                    }

                Toast.makeText(MainActivity.this, Edit_Text1.getText().toString(), Toast.LENGTH_SHORT).show();
                finish();



            }
        });

    }
    public void init(){
        Button_kuldes1 = (Button)findViewById(R.id.Button_kuldes1);
        Edit_Text1 = (EditText)findViewById(R.id.Edit_Text1);
        Text_View1 =(TextView)findViewById(R.id.Text_View1);
    }
}
