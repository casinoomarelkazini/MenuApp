package com.example.menuapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private int cpt=0;
    private int[] images={R.drawable.img1,R.drawable.img2,R.drawable.img3};
    private ImageView img1, img2, img3, imgp;
    private Button btnPrev;
    private Button btnNext;


    private Toolbar toolbar;
private DrawerLayout drawerLayout;
private NavigationView navigationView;
private ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);
        drawerLayout= findViewById(R.id.myDrawer);
        navigationView = findViewById(R.id.myNav);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.myframeLayout,new HomeFragment()).commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.gallery:
                        getSupportFragmentManager().beginTransaction().replace(R.id.myframeLayout,new GalerieFragment()).commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.convert:
                        getSupportFragmentManager().beginTransaction().replace(R.id.myframeLayout,new ConvertFragment()).commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                }
                return true;
            }
        });


    }
}