package com.example.win7.tickettapp;

import android.content.Intent;
import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button Login;
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private int counter = 5;
    private Button button;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btnCAccount);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            openCreateNewAccount ();
            }
        });

        Name = (EditText) findViewById(R.id.etUserName);
        Password = (EditText) findViewById(R.id.etUserPassword);
        Info = (TextView) findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);



        Info.setText("No of attemots remaining: 5 ");



        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });

    }

    private void validate(String userName,String userPassword){
        if ((userName.equals("Nemanja")) || (userPassword.equals("1234"))){
            Intent intent = new Intent(MainActivity.this,Reservation.class);
            startActivity(intent);

        }else{
            counter--;

            Info.setText("No of attempts remaining: " + String.valueOf(counter));

            if (counter == 0){
                Login.setEnabled(false);
            }
        }
    }
 public void openCreateNewAccount (){
        Intent intent = new Intent(this,CreateNewAccount.class);
        startActivity(intent);
 }
}
