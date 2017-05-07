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
public class ListaAndroidWear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_android_wear);
/*
        String url = "http://www.wow-store.it/21-smart-watch";
        WebView wv = (WebView) findViewById(R.id.webViewWear);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl(url);
*/

        DataBaseHelper dbh = new DataBaseHelper(ListaAndroidWear.this);

        ArrayList<Prodotto> lista = dbh.getProducts("WEAR");

        ListView mylist = (ListView) findViewById(R.id.listViewAW);

        ProductAdapter productAdapter = new ProductAdapter(ListaAndroidWear.this,lista);

        mylist.setAdapter(productAdapter);
    }
}
