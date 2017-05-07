package it.wowstoreapp.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import it.wowstoreapp.app.utils.Email;
import it.wowstoreapp.app.utils.GMailSender;

/**
 * Created by user01 on 19/05/2016.
 */
public class Contattaci extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contattaci_activity);

        Button buttonInvia = (Button)findViewById(R.id.buttonInviaMail);
        buttonInvia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                sendMail();
                Intent returnHome = new Intent(Contattaci.this,MainActivity.class);
               // startActivity(returnHome);
            }
        });
    }

    public void sendMail(){
        final EditText nameField = (EditText) findViewById(R.id.editTextNome);
        String nome = nameField.getText().toString();

        final EditText emailField = (EditText) findViewById(R.id.editTextMail);
        String email = emailField.getText().toString();

        final EditText feedbackField = (EditText) findViewById(R.id.editTextTesto);
        String testo = feedbackField.getText().toString();

        final Spinner feedbackSpinner = (Spinner) findViewById(R.id.SpinnerFeedbackType);
        String oggetto = feedbackSpinner.getSelectedItem().toString();


        try {
            //metodo usato su vecchi progetti
            Email mail = new Email();
            mail.creaMail(oggetto, testo, nome, email);
            mail.invia();
            //metodo su corsoandroid.it
            GMailSender sender = new GMailSender("wowstoreappmail@gmail.com", "treviso123");
            sender.sendMail(oggetto,
                    "Email inviata da "+nome+" con email:"+email+"\n\n"+testo,
                    "wowstoreappmail@gmail.com",
                    "wowstoreappmail@gmail.com");
        } catch (Exception e) {
            Log.e("SendMail", e.getMessage(), e);
        }

        final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setType("plain/text");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"wowstoreappmail@gmail.com"});
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, oggetto);
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, testo+"\n\nMessaggio inviato da: "+nome+"\nEmail: "+email);

        startActivity(Intent.createChooser(emailIntent, "Invia email..."));

        //Toast adv = Toast.makeText(getApplicationContext(),"Messaggio Inviato", Toast.LENGTH_SHORT);
        //adv.setGravity(Gravity.TOP,0,200);
        //adv.show();

    }
}
