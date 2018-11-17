package com.example.inehemias.hackhathon2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ThankYouActivity extends AppCompatActivity {

    public  TextView Company;
    public  TextView Amount;
    private ImageView imageView;


    public static int localAmount=0;
    public static String TAG = "Second Activity Log";
    private String messageOut="";
    public String company=" ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);
        settingViews();
        extractingData();
        settingMessage();
        settingImage();


    }

    //Initializes the intent and checks if data exists.
    // If there is data then it will extract it and save it in this activity.
    private void extractingData() {

        Intent intent = getIntent();
        Bundle bundle =  intent.getExtras();

        if(bundle!=null)
        localAmount= bundle.getInt("amountKey");
        company= bundle.getString("compKey");

    }



    private void settingViews() {
        Company=(TextView)findViewById(R.id.winner);
        Amount=(TextView) findViewById(R.id.Difference);
        imageView=(ImageView)findViewById(R.id.imageView);

    }

    //Sets the message to be print on the winner view.
    private String settingMessage() {
        //setting the score difference message

            messageOut=  " Thanks you for your Donation ";

        return messageOut;
    }

    //Sets the corect image depending on who's the winner.
    private void settingImage() {
            imageView.setImageResource(R.drawable.thank_you);
            Company.setText(company);
            Amount.setText(messageOut);


        }
    }

