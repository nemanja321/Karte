package com.example.win7.tickettapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Payment extends AppCompatActivity {

private Button button ;
private Button button1;
private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment2);

        button2 = (Button)findViewById(R.id.btnKupi) ;
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTicket ();
            }
        });

        button1 = (Button)findViewById(R.id.btnCreditCard);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCreditCard ();
            }
        });

        button = (Button) findViewById(R.id.btnPayPal);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPayPal ();
            }
        });
    }
    public void openPayPal (){
        Intent intent = new Intent(this,PayPal.class);
        startActivity(intent);

    }
    public void openCreditCard (){
        Intent intent1 = new Intent(this,CreditCard.class);
        startActivity(intent1);
    }
    public void openTicket (){
        Intent intent2 = new Intent(this,Ticket.class);
        startActivity(intent2);
    }
}
