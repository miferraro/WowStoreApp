package it.wowstoreapp.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import it.wowstoreapp.app.products.Prodotto;
import it.wowstoreapp.app.utils.DataBaseHelper;
import it.wowstoreapp.app.utils.ProductAdapter;

/**
 * Created by user01 on 20/05/2016.
 */
public class RiparazioniActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.riparazioni_activity);

        DataBaseHelper dbh = new DataBaseHelper(RiparazioniActivity.this);

        ArrayList<Prodotto> lista = dbh.getProducts("RIPARAZIONI");

        ListView mylist = (ListView) findViewById(R.id.listViewRip);

        ProductAdapter productAdapter = new ProductAdapter(RiparazioniActivity.this,lista);

        mylist.setAdapter(productAdapter);

    }
}
