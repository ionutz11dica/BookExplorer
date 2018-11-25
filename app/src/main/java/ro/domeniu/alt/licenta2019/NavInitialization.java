package ro.domeniu.alt.licenta2019;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class NavInitialization extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    public DrawerLayout drawer;
    Toolbar toolbar;
    NavigationView nav_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principala);
        initializare();

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

//        if(savedInstanceState==null){
//            getSupportFragmentManager().beginTransaction().replace(R.id.frament_container,new .commit();
//            nav_view.setCheckedItem(R.id.nav_view);
//        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_about:

                break;
            case R.id.menu_booksMark:
                Intent intent = new Intent(getApplicationContext(),BooksMarkActivity.class);
                startActivity(intent);
                break;
        }

        return true;
    }


    @Override
    public void onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    public void initializare(){
        toolbar = findViewById(R.id.toolbar_nav);
        drawer = findViewById(R.id.drawerLayout);
        nav_view = findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(this);
    }



}
