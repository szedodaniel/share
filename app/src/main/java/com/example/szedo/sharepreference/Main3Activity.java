package com.example.szedo.sharepreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {
    private Button Button_Vissza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button_Vissza = (Button)findViewById(R.id.Button_Vissza);


        Button_Vissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next_activity = new Intent(Main3Activity.this,Main2Activity.class);
                startActivity(next_activity);
                finish();

            }
        });

    }
}
