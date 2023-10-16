package com.example.llistview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class drawerNavigation extends AppCompatActivity {
DrawerLayout drawerLayout;
NavigationView drawerNavigation;
Toolbar toolbarDrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_navigation);
        drawerLayout = findViewById(R.id.drawerLayout);
        drawerNavigation = findViewById(R.id.drawerNavigation);
        toolbarDrawer= findViewById(R.id.toolbarDrawer);

        setSupportActionBar(toolbarDrawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbarDrawer,R.string.openDrawer,R.string.closeDrawer);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        loadFragment(new frag1(),0);
        drawerNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id= item.getItemId();
                if(id==R.id.navigation_home){
                    loadFragment(new frag1(),1);

                }else if(id==R.id.search){
                    loadFragment(new frag2(),1);

                }else if (id==R.id.settings){
                    loadFragment(new frag3(),1);

                }else if(id==R.id.contact){
                    loadFragment(new frag4(),1);

                }else if (id == R.id.profile){
                    loadFragment(new frag5(),1);

                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }
    public  void loadFragment(Fragment fragment, int flag)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag==0){
            ft.add(R.id.drawerBackFragment,fragment);
        }else {ft.replace(R.id.drawerBackFragment,fragment);}
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {super.onBackPressed();}
        }
    }
