package com.ejemplo.puppy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.ejemplo.puppy.adapters.MascotaAdaptador;
import com.ejemplo.puppy.adapters.ViewPageAdapter;
import com.ejemplo.puppy.fragments.FragmentFavorito;
import com.ejemplo.puppy.fragments.FragmentListado;
import com.ejemplo.puppy.menus.AcercaDe;
import com.ejemplo.puppy.menus.Contacto;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MascotasListado extends AppCompatActivity {
    //Atributos:
    private Toolbar miActionBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_listado);

        miActionBar = (Toolbar)findViewById(R.id.miActionBar);
        if (miActionBar != null){
            setSupportActionBar(miActionBar);
        }
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);

        viewPager = (ViewPager)findViewById(R.id.viewPager);

        ImageButton ibAvanzar = (ImageButton)findViewById(R.id.ibAvanzar);
        ibAvanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MascotasListado.this, MascotasFavoritos.class);
                startActivity(i);
            }
        });

        setUpViewPager();

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mContacto:
                Intent intent = new Intent(MascotasListado.this, Contacto.class);
                startActivity(intent);
                break;
            case R.id.mAcercaDe:
                Intent intent2 = new Intent(MascotasListado.this, AcercaDe.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments (){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new FragmentListado());
        fragments.add(new FragmentFavorito());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new ViewPageAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_left_arrow);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_right_arrow);
    }
}