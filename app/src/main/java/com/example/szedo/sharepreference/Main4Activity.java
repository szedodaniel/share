package com.example.szedo.sharepreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    private Button reButton_kuldes;
    private EditText reEdit_Text;
    private String fajlNev = "adatok";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        init();
        reButton_kuldes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next_activity = new Intent(Main4Activity.this,Main2Activity.class);
                startActivity(next_activity);

                String adat = reEdit_Text.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences(fajlNev, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("adat",adat);
                editor.commit();
                Toast.makeText(Main4Activity.this, "A neved mentve!", Toast.LENGTH_SHORT).show();
                finish();



            }
        });
    }
    public void init(){
        reButton_kuldes = (Button)findViewById(R.id.reButton_kuldes);
        reEdit_Text = (EditText)findViewById(R.id.reEdit_Text);

    }
}
