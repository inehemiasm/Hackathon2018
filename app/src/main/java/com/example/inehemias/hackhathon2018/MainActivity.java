package com.example.inehemias.hackhathon2018;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<DonationClass> doners;

    private int amount=0;
    private String company="Red Cross";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }



    public void donate_button(View view) {

//        Intent intent = new Intent(MainActivity.this, DonateActivity.class);
//        startActivity(intent);

        String tag= "Main Activity";
        Log.d(tag, "new intent");
        Intent intent = new Intent(MainActivity.this, DonateActivity.class);
        startActivityForResult(intent, 2);


    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {

                amount = data.getIntExtra("amountKey", 0);
                company = data.getStringExtra("compKey");
                Toast.makeText(this.getBaseContext(),"Your choice was "+company +" amount "+amount,
                        Toast.LENGTH_LONG).show();


                }
        }



    }}
