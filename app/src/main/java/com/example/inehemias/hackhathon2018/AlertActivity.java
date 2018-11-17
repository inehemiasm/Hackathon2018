package com.example.inehemias.hackhathon2018;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Telephony;
import android.view.View;

public class AlertActivity extends android.support.v7.app.AppCompatActivity {


    public String location = "Lehman College";
    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.inehemias.hackhathon2018.R.layout.alert_layout);

        alright();
    }

    public void alright() {

        final android.support.v7.app.AlertDialog.Builder alertDialog =
                new android.support.v7.app.AlertDialog.Builder(AlertActivity.this);
        alertDialog.setTitle("Are You Safe?");
        alertDialog.setCancelable(false);
        alertDialog.setMessage("Let us know, are you in a safe place?");
        alertDialog.setPositiveButton("Yes", new android.content.DialogInterface.OnClickListener() {
            @Override
            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                finish();
            }
        });
        alertDialog.setNegativeButton("No", new android.content.DialogInterface.OnClickListener() {
            @Override
            public void onClick(android.content.DialogInterface dialogInterface, int i) {



            }
        });
        alertDialog.show();
    }

    public void find_fire_dept(View view) {

        // Search for soccer arena nearby
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=Fire Department near me");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);

    }

    public void send_message(View view) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) // At least KitKat
        {
            String defaultSmsPackageName = Telephony.Sms.getDefaultSmsPackage(this); // Need to change the build to API 19

            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.setType("text/plain");
            sendIntent.putExtra(Intent.EXTRA_TEXT, " Need Help "+location);


            if (defaultSmsPackageName != null)// Can be null in case that there is no default, then the user would be able to choose
            // any app that support this intent.
            {
                sendIntent.setPackage(defaultSmsPackageName);
            }
            startActivity(sendIntent);

        }
        else // For early versions
        {
            Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW);
            smsIntent.setType("vnd.android-dir/mms-sms");
            smsIntent.setData(Uri.parse("smsto: " + "914-203-3982"));
            smsIntent.putExtra("emergency","Im in danger: "+"message");

            startActivity(smsIntent);
        }


    }
}
