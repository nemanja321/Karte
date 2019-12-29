package com.example.win7.tickettapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PayPal extends AppCompatActivity implements View.OnClickListener {

    Button btnVerification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_pal);

        btnVerification = findViewById(R.id.btnVerification);
        btnVerification.setOnClickListener(this);
    }

    public void onClick(View view) {
        Toast.makeText(PayPal.this, "Congratulations, you successfully verified your data", Toast.LENGTH_SHORT).show();
    }
}

