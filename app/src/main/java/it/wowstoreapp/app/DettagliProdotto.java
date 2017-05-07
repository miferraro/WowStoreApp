package it.wowstoreapp.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user01 on 26/05/2016.
 */
public class DettagliProdotto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle dati = getIntent().getExtras();

        int id = dati.getInt("id");
        String tabella = dati.getString("tabella");
        String modelloExtra = dati.getString("modello");
        String marchioExtra = dati.getString("marchio");
        String prezzoExtra = dati.getString("prezzo");
        String descrizioneExtra = dati.getString("descrizione");
        String fotoExtra = dati.getString("foto");

        setContentView(R.layout.dettagli_prodotto);

        TextView modelloView = (TextView) findViewById(R.id.textViewModello);
        TextView marchioView = (TextView) findViewById(R.id.textViewMarchio);
        TextView prezzoView = (TextView) findViewById(R.id.textViewPrezzo);
        TextView descrizioneView = (TextView) findViewById(R.id.textViewDescrizione);
        ImageView fotoView = (ImageView) findViewById(R.id.imageViewDettagli);
/*
        DataBaseHelper dbh = new DataBaseHelper(DettagliProdotto.this);
        Prodotto prod = dbh.getProductByID(tabella,id);
*/
        modelloView.setText(modelloExtra);
        marchioView.setText(marchioExtra);
        prezzoView.setText(prezzoExtra + "0€");
        descrizioneView.setText(descrizioneExtra);

        descrizioneView.setMovementMethod(new ScrollingMovementMethod());

        int drawableId = getResources().getIdentifier(fotoExtra, "drawable", getPackageName());

        fotoView.setImageResource(drawableId);
    }
}
