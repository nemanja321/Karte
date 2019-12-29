package com.example.win7.tickettapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class CreditCard extends AppCompatActivity implements View.OnClickListener {
    Button btnCredValid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card);

        btnCredValid=findViewById(R.id.btnCardValid);
        btnCredValid.setOnClickListener(this);
    }

    public void onClick (View view) {
        Toast.makeText(CreditCard.this,"Congratulations, you successfully verified your data",Toast.LENGTH_SHORT).show();
    }
}
