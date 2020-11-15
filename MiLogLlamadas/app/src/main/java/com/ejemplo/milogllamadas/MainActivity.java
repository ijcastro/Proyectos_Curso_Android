package com.ejemplo.milogllamadas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int CODIGO_SOLICITUD_PERMISO = 1;
    //Atributos
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
    }

    public void mostrarLlamadas(View v){
        if (checkearStatusPermiso()){
            consultarCPLlamadas();
        } else {
            solicitarPermiso();
        }
    }

    public void solicitarPermiso(){
        //RCL = Read Call Log
        //WCL = Write Call Log
        boolean solicitarPermisoRCL = ActivityCompat.shouldShowRequestPermissionRationale(activity,
                Manifest.permission.READ_CALL_LOG);
        boolean solicitarPermisoWCL = ActivityCompat.shouldShowRequestPermissionRationale(activity,
                Manifest.permission.WRITE_CALL_LOG);

        if (solicitarPermisoRCL && solicitarPermisoWCL){
            Toast.makeText(MainActivity.this, "Los permisos fueron otorgados",  Toast.LENGTH_SHORT).show();
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_CALL_LOG,
                    Manifest.permission.WRITE_CALL_LOG}, CODIGO_SOLICITUD_PERMISO);
        }
    }

    public boolean checkearStatusPermiso(){
        boolean aux = false;
        boolean permisoRCL = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG)
                == PackageManager.PERMISSION_GRANTED;
        boolean permisoWCL = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_CALL_LOG)
                == PackageManager.PERMISSION_GRANTED;
        if (permisoRCL && permisoWCL){
            aux = true;
        }
        return aux;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case CODIGO_SOLICITUD_PERMISO:
                if (checkearStatusPermiso()){
                    Toast.makeText(MainActivity.this, "Ya está activo el permiso", Toast.LENGTH_SHORT).show();
                    consultarCPLlamadas();
                    break;
                } else {
                    Toast.makeText(MainActivity.this, "No se activó el permiso", Toast.LENGTH_SHORT).show();
                    break;
                }
        }

    }

    public void consultarCPLlamadas(){
        TextView tvLlamadas = (TextView)findViewById(R.id.tvLlamadas);
        tvLlamadas.setText("");

        Uri direccionUriLlamadas = CallLog.Calls.CONTENT_URI;
        //Campos que queremos recuperar de la tabla "calls": numero, fecha, tipo, duración
        String campos[] = {
                CallLog.Calls.NUMBER,
                CallLog.Calls.DATE,
                CallLog.Calls.TYPE,
                CallLog.Calls.DURATION
        };

        ContentResolver contentResolver = getContentResolver();
        Cursor registros = contentResolver.query(direccionUriLlamadas, campos, null,
                null, CallLog.Calls.DATE + " DESC");
        while (registros.moveToNext()){
            String numero = registros.getColumnName(registros.getColumnIndex(campos[0]));
            long fecha = registros.getLong(registros.getColumnIndex(campos[1]));
            int tipo = registros.getInt(registros.getColumnIndex(campos[2]));
            String duracion = registros.getColumnName(registros.getColumnIndex(campos[3]));
            //Validacion tipo de llamada
            String tipoLlamada = "";
            switch (tipo){
                case CallLog.Calls.INCOMING_TYPE:
                    tipoLlamada = getResources().getString(R.string.entrada);
                    break;
                case CallLog.Calls.MISSED_TYPE:
                    tipoLlamada = getResources().getString(R.string.perdida);
                    break;
                case CallLog.Calls.OUTGOING_TYPE:
                    tipoLlamada = getResources().getString(R.string.salida);
                    break;
                default:
                    tipoLlamada = getResources().getString(R.string.desconocida);
            }
            String detalle = getResources().getString(R.string.etiqueta_numero) + numero + " | " +
                    getResources().getString(R.string.etiqueta_fecha) + DateFormat.format("dd/mm/yy k:mm", fecha) +  " | " +
                    getResources().getString(R.string.etiqueta_tipo) + tipoLlamada +  " | " +
                    getResources().getString(R.string.etiqueta_duracion) + duracion + "s." + "\n";

            tvLlamadas.append(detalle);
        }
    }
}