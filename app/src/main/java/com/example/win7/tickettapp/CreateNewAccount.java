package com.example.win7.tickettapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateNewAccount extends AppCompatActivity {
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_account);

        button1 = (Button) findViewById(R.id.btnCreate);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity ();
            }
        });
    }
    public void openMainActivity (){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
