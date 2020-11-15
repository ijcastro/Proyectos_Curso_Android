package com.ejemplo.puppy.menus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ejemplo.puppy.database.Constantes;
import com.ejemplo.puppy.JavaMailAPI;
import com.ejemplo.puppy.R;

import org.apache.commons.lang3.StringUtils;

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
                sendEmail();
            }
        });



    }

    /*public void enviarMail(){
        try {
            //Inicializar sesión Jakarta Mail:
            Properties prop = System.getProperties();
            //Hacer un objeto de clase Session:
            Session session = Session.getInstance(prop, null);
            //Construir Mensaje y enviar:
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(etCorreo.getText().toString()));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("nachoc_1025@hotmail.com", false));
            msg.setText(etMensaje.getText().toString());
            Transport.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }*/

    //Mi método no camina, y el método sendEmail, sacado del py "Tarea Semana 4 - Mascotas", tampoco...

    private void sendEmail() {
        String toEmail = Constantes.email;
        String message = this.formatMessage();
        JavaMailAPI mail = new JavaMailAPI(this, toEmail, message);
        mail.execute();
    }

    private String formatMessage(){
        String contactEmail = etCorreo.getText().toString();
        String message = etMensaje.getText().toString();
        return StringUtils.join(contactEmail, "\n", message);
    }
}