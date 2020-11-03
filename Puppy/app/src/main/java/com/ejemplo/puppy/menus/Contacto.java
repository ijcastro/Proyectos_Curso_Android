package com.ejemplo.puppy.menus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ejemplo.puppy.R;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Contacto extends AppCompatActivity {
    private EditText etNombre;
    private EditText etCorreo;
    private EditText etMensaje;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        etNombre = (EditText)findViewById(R.id.etNombre);
        etCorreo = (EditText)findViewById(R.id.etCorreo);
        etMensaje = (EditText)findViewById(R.id.etMensaje);
        btnEnviar = (Button)findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarMail();
            }
        });



    }

    public void enviarMail(){
        //Inicializar sesión Jakarta Mail:
        Properties prop = System.getProperties();
        //Hacer un objeto de clase Session:
        Session session = Session.getInstance(prop, null);
        //Construir Mensaje y enviar:
        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(String.valueOf(etCorreo)));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("nachoc_1025@hotmail.com", false));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            msg.setSubject(String.valueOf(etMensaje));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            Transport.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}