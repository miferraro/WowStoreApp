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
public class ListaTablet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_tablet);
/*
        String url = "http://www.wow-store.it/4-tablet";
        WebView wv = (WebView) findViewById(R.id.webViewTablet);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl(url);
*/

        DataBaseHelper dbh = new DataBaseHelper(ListaTablet.this);

        ArrayList<Prodotto> lista = dbh.getProducts("TABLET");

        ListView mylist = (ListView) findViewById(R.id.listViewTB);

        ProductAdapter productAdapter = new ProductAdapter(ListaTablet.this,lista);

        mylist.setAdapter(productAdapter);
    }
}
