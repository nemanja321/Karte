package com.example.win7.tickettapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class Reservation extends AppCompatActivity {
    private Button buttonres;

    String[] SPINNERLIST = {"Bar", "Budva", "Herceg Novi", "Kotor", "Tivat", "Ulcinj", "Podgorica", "Cetinje", "Niksic", "Danilovgrad", "Berane", "Bijelo Polje", "Kolasin", "Mojkovac"};
    String[] list = {"Lasta Montenegro", "Glunex, Nikšić", "Vujović, Danilovgrad", "Royal Travel,Cetinje", "Božur, Podgorica", "Striković, Nikšić","Lalatović travel, Budva"};




    int startPoint = -1;
    int destinationPoint = -1;
    double izabranaCijena = -1;
    TextView cijenaUsluge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        buttonres = (Button) findViewById(R.id.btnRez);
        buttonres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPayment ();
            }
        });



        cijenaUsluge = (TextView) findViewById(R.id.cijenaUsluge);
        cijenaUsluge.setVisibility(View.INVISIBLE);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, SPINNERLIST);
        MaterialBetterSpinner betterSpinner = (MaterialBetterSpinner) findViewById(R.id.android_material_design_spinner);
        betterSpinner.setAdapter(arrayAdapter);

        MaterialBetterSpinner betterSpinnerDestinationPoint = (MaterialBetterSpinner) findViewById(R.id.android_material_design_spinner1);
        betterSpinnerDestinationPoint.setAdapter(arrayAdapter);

        MaterialBetterSpinner betterSpinnerCarrier = (MaterialBetterSpinner)findViewById(R.id.android_material_design_spinnerr);
        betterSpinnerCarrier.setAdapter(arrayAdapter);



        final double cjenovnik[][] = new double [14][14];
        int a = 10;

        for(int i = 0; i < cjenovnik.length; i++) {
            for(int j = 0; j < cjenovnik[i].length; j++) {
                if(j > i) {
                    cjenovnik[i][j] = a;
                    cjenovnik[j][i] = a;
                    a += 1;
                }
            }
        }

        betterSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String spinner_value = position + "";
                startPoint = position;

                if(startPoint == destinationPoint) {
                    /*
                     * izabrana ista polazna i krajnja tacka
                     */
                    Toast.makeText(getApplicationContext(),"The same starting and end point has been selected!",Toast.LENGTH_SHORT).show();
                } else if(startPoint > -1 && destinationPoint > -1) {
                    izabranaCijena = cjenovnik[startPoint][destinationPoint];
                    /*
                    * prikazati cijenu
                     */
                    cijenaUsluge.setText("The price of the ticket is " + izabranaCijena + " eur.");
                    cijenaUsluge.setVisibility(View.VISIBLE);
                }

            }
        });

        betterSpinnerDestinationPoint.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String spinner_value = position + "";
                destinationPoint = position;

                if (startPoint == destinationPoint) {
                    /*
                     * izabrana ista polazna i krajnja tacka
                     */
                    Toast.makeText(getApplicationContext(), "The same starting and end point has been selected!", Toast.LENGTH_SHORT).show();
                }

                if (startPoint == -1) {
                    /*
                     * ako nije izabran start point
                     */
                    Toast.makeText(getApplicationContext(), "You must select the starting station", Toast.LENGTH_SHORT).show();
                } else if (startPoint > -1 && destinationPoint > -1) {
                    izabranaCijena = cjenovnik[startPoint][destinationPoint];
                    /*
                     * prikazati cijenu
                     */
                    cijenaUsluge.setText("The price of the ticket is " + izabranaCijena + " eur.");
                    cijenaUsluge.setVisibility(View.VISIBLE);
                }


            }
        });

    }
public void openPayment(){
        Intent intent = new Intent(this,Payment.class);
        startActivity(intent);
}

}


