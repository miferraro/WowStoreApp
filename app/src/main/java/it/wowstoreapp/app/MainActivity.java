package it.wowstoreapp.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSP = (Button)findViewById(R.id.buttonSP);
        buttonSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent openListaSP = new Intent(MainActivity.this, ListaSmartphone.class);
                startActivity(openListaSP);
            }
        });

        Button buttonTB = (Button)findViewById(R.id.buttonTB);
        buttonTB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent openListaTB = new Intent(MainActivity.this,ListaTablet.class);
                startActivity(openListaTB);
            }
        });

        Button buttonAW = (Button)findViewById(R.id.buttonAW);
        buttonAW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent openListaAW = new Intent(MainActivity.this,ListaAndroidWear.class);
                startActivity(openListaAW);
            }
        });

        Button buttonAT = (Button)findViewById(R.id.buttonAT);
        buttonAT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent openListaAT = new Intent(MainActivity.this,ListaAndroidTV.class);
                startActivity(openListaAT);
            }
        });

        Button buttonSV = (Button)findViewById(R.id.buttonSV);
        buttonSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent openListaSV = new Intent(MainActivity.this,ListaAccSorveglianza.class);
                startActivity(openListaSV);
            }
        });

        Button buttonINFO = (Button)findViewById(R.id.buttonINFO);
        buttonINFO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent openListaINFO = new Intent(MainActivity.this,InfoActivity.class);
                startActivity(openListaINFO);
            }
        });


    }
}
