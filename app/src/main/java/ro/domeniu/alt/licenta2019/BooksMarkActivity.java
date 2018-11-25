package ro.domeniu.alt.licenta2019;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class BooksMarkActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public DrawerLayout drawer;
    Toolbar toolbar;
    NavigationView nav_view;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_mark);
        initializare();



        if(savedInstanceState==null){
            nav_view.setCheckedItem(R.id.menu_booksMark);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_about:

                break;
            case R.id.menu_Shelf:
                Intent intent = new Intent(getApplicationContext(),PaginaPrincipala.class);
                nav_view.setCheckedItem(R.id.menu_Shelf);
                startActivity(intent);
                finish();
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
        drawer = findViewById(R.id.drawerLayoutBooksmark);
        nav_view = findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(this);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        String titlu = getText(R.string.menu_bookmarks).toString();
        this.setTitle(titlu);
    }


}
