package it.wowstoreapp.app.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by user01 on 23/05/2016.
 */
public class Email {
    private static final String SMTP_HOST_NAME = "smtp.gmail.com";
    private static final String SMTP_AUTH_USER = "wowstoreappmail@gmail.com";
    private static final String SMTP_AUTH_PWD = "treviso123";
    private static final String PORT = "25";

    private String mailMittente="wowstoreappmail@gmail.com";
    private String mailDestinatario="wowstoreappmail@gmail.com";
    private String subject;
    private String body;

    public Email(){}

    public Email(String mailDestinatario, String subject, String body){
        this.setMailDestinatario(mailDestinatario);
        this.setSubject(subject);
        this.setBody(body);
    }

    public String getMailDestinatario() {
        return mailDestinatario;
    }

    public void setMailDestinatario(String mailDestinatario) {
        this.mailDestinatario = mailDestinatario;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Caricamento delle informazioni per l'invio di mail da un account gmail
     * @return una property contenente le informazioni necessarie:
     * 	- tipo di protocollo utilizzato
     * 	- nome del server mail
     * 	- autenticazione
     * 	- numero di porta
     */
    private Properties loadGmailProperties() {
        //istanziamento properties: è un'hashMap
        Properties property = new Properties();
        //protocollo utilizzato
        property.put("mail.transport.protocol", "smtp");
        //server mail
        property.put("mail.smtp.host", SMTP_HOST_NAME);
        //attiva autenticazione
        property.put("mail.smtp.auth", "true");
        //numero della porta
        property.put("mail.smtp.port", PORT);
        //
        property.put("mail.smtp.starttls.enable", "true");
        return property;
    }

    public void creaMail(String oggetto, String testo, String nome, String mail) {
        this.setSubject(oggetto);
        this.setBody("<h3>Messaggio inviato da: "+ nome +"("+mail+"),</h3><p>"
                + "\n"+testo+"</p></font>");
    }


    /**
     * Invio della mail
     * @throws MessagingException
     */
    public void invia() throws MessagingException {
		/*
		 * creazione sessione mail, richiede 2 parametri: - Properties -
		 * Authenticator quest'ultimo è una classe astratta che, non potendo
		 * essere istanziata, utilizza una classe detta anonima, cioé senza
		 * nome, al cui interno vengono implementati direttamente i metodi
		 * astratti della classe astratta!
		 **/
        Session mailSession = Session.getDefaultInstance(loadGmailProperties(), new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SMTP_AUTH_USER, SMTP_AUTH_PWD);
            }
        });

		/* con questo parametro settato a true sono inseriti nello standard output i log dell'invio mail
		 * DA CANCELLARE IN SEGUITO LE VARIE SYSTEM
		 */
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();
        //creazione del messaggio
        MimeMessage message = new MimeMessage(mailSession);
        message.setContent(body, "text/html; charset=utf-8");
        message.setSubject(subject);
        message.setFrom(new InternetAddress(mailMittente));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailDestinatario));
        transport.connect();
        //System.out.println("Invio....");
        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
        transport.close();
        //System.out.println("Inviato....");
    }
}
