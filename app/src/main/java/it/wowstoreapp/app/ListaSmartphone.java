package it.wowstoreapp.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import it.wowstoreapp.app.products.Prodotto;
import it.wowstoreapp.app.utils.DataBaseHelper;
import it.wowstoreapp.app.utils.ProductAdapter;

/**
 * Created by user01 on 18/05/2016.
 */
public class ListaSmartphone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_smartphone);
/*
        String url = "http://www.wow-store.it/3-smartphone";
        WebView wv = (WebView) findViewById(R.id.webViewSmartphone);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl(url);
*/

        DataBaseHelper dbh = new DataBaseHelper(ListaSmartphone.this);

        ArrayList<Prodotto> lista = dbh.getProducts("SMARTPHONE");

        ListView mylist = (ListView) findViewById(R.id.listViewSP);

        ProductAdapter productAdapter = new ProductAdapter(ListaSmartphone.this,lista);

        mylist.setAdapter(productAdapter);

    }

}
