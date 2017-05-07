package it.wowstoreapp.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by user01 on 18/05/2016.
 */
public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_activity);

        Button buttonCS = (Button)findViewById(R.id.buttonCS);
        buttonCS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent openChiSiamo = new Intent(InfoActivity.this, ChiSiamoActivity.class);
                startActivity(openChiSiamo);
            }
        });

        Button buttonPV = (Button)findViewById(R.id.buttonPV);
        buttonPV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent openPuntiVendita = new Intent(InfoActivity.this, NegoziActivity.class);
                startActivity(openPuntiVendita);
            }
        });

        Button buttonC = (Button)findViewById(R.id.buttonContact);
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent openContattaci = new Intent(InfoActivity.this, Contattaci.class);
                startActivity(openContattaci);
            }
        });

        Button buttonConsegne = (Button)findViewById(R.id.buttonConsegne);
        buttonConsegne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent openConsegne = new Intent(InfoActivity.this, ConsegneActivity.class);
                startActivity(openConsegne);
            }
        });

        Button buttonRip = (Button)findViewById(R.id.buttonRip);
        buttonRip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent openRiparazioni = new Intent(InfoActivity.this, RiparazioniActivity.class);
                startActivity(openRiparazioni);
            }
        });

    }
}
