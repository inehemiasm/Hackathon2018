package com.example.inehemias.hackhathon2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DonateActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    private EditText diferent_amount;

    ArrayList<DonationClass> doners;
    public String tag="doner ";
    public int previous_donation= 500;

    String company="Red Cross";
    private int amount =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        Intent intent = getIntent();
        diferent_amount=(EditText) findViewById(R.id.amount_input);
        //amount=Integer.parseInt(String.valueOf(diferent_amount.getText()));




        DonationClass doner1= new DonationClass("Jhon Doe", "email@example.com", "916-900-3345",150);

        Spinner spinner = (Spinner) findViewById(R.id.image_selector);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Red Cross");
        categories.add("Americares");
        categories.add("Fema");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,categories );

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);


       // sendResult();



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        company=item;
        Toast.makeText(this.getBaseContext(),"Your choice was "+company,
                Toast.LENGTH_LONG).show();

    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    public void generateDoner()
    {
        DonationClass currDoner;
        for (int i=0; i<5; ++i)

    {
        currDoner = new DonationClass("doner"+i,"email@example.com", "347-345"+i, 10/previous_donation);
        doners.add(currDoner);

    }


    }


    public void onClickok(View view) {
        Intent data = new Intent();
        this.amount=Integer.parseInt(String.valueOf(diferent_amount.getText()));
        data.putExtra("amountKey", amount);
        data.putExtra("compKey", company);
        setResult(RESULT_OK,data);
        finish();
    }

    public void onClickCancel(View view) {
        finishAndRemoveTask();
    }



    public void different_amount(View view) {

        this.amount=Integer.parseInt(String.valueOf(diferent_amount.getText()));

    }

    public void $5(View view) {

        amount=5;


    }


    public void donate_20(View view) {
        amount=20;

    }

    public void donate_10(View view) {
        amount=10;

    }


//    //Function thqt will start the new intent and
//    // start the next activity once a team reaches 5 points.
    private void sendResult(){
        Intent intent = new Intent(DonateActivity.this, ThankYouActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("compKey",company);
        bundle.putInt("amountKey", amount);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void open_thank_you(View view) {

        sendResult();
    }
}
