package com.ejemplo.menuopcionescontextopopup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvNombre = (TextView)findViewById(R.id.tvNombre);
        registerForContextMenu(tvNombre);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAbout:
                Intent i = new Intent(MainActivity.this, ActivityAbout.class);
                startActivity(i);
                break;
            case R.id.mSettings:
                Intent intent = new Intent(MainActivity.this, ActivitySettings.class);
                startActivity(intent);
                break;
            case R.id.mRefresh:
                Toast.makeText(this, getResources().getString(R.string.mRefresh), Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contexto, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mEditar:
                Toast.makeText(this, getResources().getString(R.string.mEditar), Toast.LENGTH_SHORT).show();
                break;
            case R.id.mEliminar:
                Toast.makeText(this, getResources().getString(R.string.mEliminar), Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }

    public void levantarMenuPopUp(View v){
        ImageView imagen = (ImageView)findViewById(R.id.ivImagen);
        PopupMenu menu = new PopupMenu(this, imagen);
        menu.getMenuInflater().inflate(R.menu.menu_popup, menu.getMenu());

        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.mView:
                        Toast.makeText(MainActivity.this, getResources().getString(R.string.mView),
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.mViewDetails:
                        Toast.makeText(MainActivity.this, getResources().getString(R.string.mViewDetails),
                                Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });

        menu.show();

    }



}