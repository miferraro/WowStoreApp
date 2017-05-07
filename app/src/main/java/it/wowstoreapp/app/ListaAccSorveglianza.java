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
public class ListaAccSorveglianza extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_acc_sorveglianza);
/*      // MODALITA' WEBVIEW
        String url = "http://www.wow-store.it/14-sorveglianza";
        WebView wv = (WebView) findViewById(R.id.webViewSorveglianza);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl(url);
*/
/*      SEMPLICE LISTVIEW CON ARRAYLIST DEL CAZZO
        // definisco un ArrayList
        final ArrayList<String> listp = new ArrayList<String>();
        for (int i = 1; i < 11; ++i) {
            listp.add("Prodotto"+i);
        }
        // recupero la lista dal layout
        final ListView mylist = (ListView) findViewById(R.id.listViewSV);

        // creo e istruisco l'adattatore
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listp);

        // inietto i dati
        mylist.setAdapter(adapter);

        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> adattatore, final View componente, int pos, long id){
                // qui dentro stabilisco cosa fare dopo il click
                final String titoloriga = (String) adattatore.getItemAtPosition(pos);

                Toast adv = Toast.makeText(getApplicationContext(),"Hai cliccato sul prodotto:"+titoloriga, Toast.LENGTH_SHORT);
                adv.setGravity(Gravity.TOP,0,200);
                adv.show();


            }

        }); */

        DataBaseHelper dbh = new DataBaseHelper(ListaAccSorveglianza.this);

        ArrayList<Prodotto> lista = dbh.getProducts("SORVEGLIANZA");

        ListView mylist = (ListView) findViewById(R.id.listViewSV);

        ProductAdapter productAdapter = new ProductAdapter(ListaAccSorveglianza.this,lista);

        mylist.setAdapter(productAdapter);




    }

}
