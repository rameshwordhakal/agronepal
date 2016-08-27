package com.rameshwor.agronepal.activities;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


import com.rameshwor.agronepal.R;
import com.rameshwor.agronepal.fragments.CashCrops;
import com.rameshwor.agronepal.fragments.home;
import com.rameshwor.agronepal.fragments.todays_price;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager=getSupportFragmentManager();

       final DrawerLayout drawerLayout= (DrawerLayout) findViewById(R.id.mainDrawer);
        final Toolbar toolbar= (Toolbar) findViewById(R.id.mainToolbar);
        final NavigationView navigationView= (NavigationView) findViewById(R.id.mainNavigationView);

        setSupportActionBar(toolbar);


        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();


        manager.beginTransaction().add(R.id.mainFragmentHolder,new home()).commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        manager.beginTransaction().replace(R.id.mainFragmentHolder,new home()).commit();
                        break;
                    case R.id.cashcrop:
                        manager.beginTransaction().replace(R.id.mainFragmentHolder,new CashCrops()).commit();
                        break;

                    case R.id.setting:
                        startActivity(new Intent(MainActivity.this,SettingActivity.class));
                        break;
                    case R.id.todayprice:
                        manager.beginTransaction().replace(R.id.mainFragmentHolder,new todays_price()).commit();
                        break;
                    case R.id.aboutus:
                        startActivity(new Intent(MainActivity.this,AboutusActivity.class));
                        break;

                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }
}
