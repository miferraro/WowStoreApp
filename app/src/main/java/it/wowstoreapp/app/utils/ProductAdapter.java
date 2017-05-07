package it.wowstoreapp.app.utils;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import it.wowstoreapp.app.DettagliProdotto;
import it.wowstoreapp.app.R;
import it.wowstoreapp.app.products.Prodotto;

/**
 * Created by user01 on 25/05/2016.
 */
public class ProductAdapter extends ArrayAdapter<Prodotto> {
    Context context;
    String table;

    public ProductAdapter(Context context, ArrayList<Prodotto> prodotti) {
        super(context, 0, prodotti);
        this.context=context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Prodotto prod = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);
        }
        // Lookup view for data population
        TextView tvProdottoMM = (TextView) convertView.findViewById(R.id.prodotto);
        TextView tvDescrizione = (TextView) convertView.findViewById(R.id.descrizione);
        TextView tvPrezzo = (TextView) convertView.findViewById(R.id.prezzo);
        ImageView ivFoto = (ImageView) convertView.findViewById(R.id.list_image);

        // Populate the data into the template view using the data object

        String title = prod.getMarchio()+" "+prod.getModello();

        if(title.length()>35) {
            tvProdottoMM.setText(title.substring(0,32)+"...");
        }else {
            tvProdottoMM.setText(title);
        }

        if(prod.getDescrizione().length()>53) {
            tvDescrizione.setText(prod.getDescrizione().substring(0, 50) + "...");
        }else {
            tvDescrizione.setText(prod.getDescrizione());
        }

        tvPrezzo.setText(prod.getPrezzo()+"0€");

        int drawableId = context.getResources().getIdentifier(prod.getFoto(),"drawable",context.getPackageName());
        ivFoto.setImageResource(drawableId);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "You Clicked " + prod.getModello()+" "+prod.getMarchio()+" from "+prod.getTabella(), Toast.LENGTH_LONG).show();

                Intent dett = new Intent(context, DettagliProdotto.class);
                dett.putExtra("id", prod.getId());
                dett.putExtra("tabella", prod.getTabella());
                dett.putExtra("modello", prod.getModello());
                dett.putExtra("marchio", prod.getMarchio());
                dett.putExtra("prezzo", prod.getPrezzo()+"");
                dett.putExtra("descrizione", prod.getDescrizione());
                dett.putExtra("foto", prod.getFoto());
                context.startActivity(dett);
            }
        });

        // Return the completed view to render on screen
        return convertView;
    }
}