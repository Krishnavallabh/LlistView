package com.example.llistview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class bottomNavigation extends AppCompatActivity {
BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        bottomNavigation = findViewById(R.id.bottomNavi);
  load(new frag1(),true);
bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.navigation_home){
            load(frag1.newInstance("krishnavallabh","patidar"),true);
        }else if(id==R.id.search)
        {
            load(new frag2(),false);
        }else if(id==R.id.settings)
        {
            load(new frag3(),false);
        }else if(id==R.id.contact)
        {
            load(new frag4(),false);
        }else if(id==R.id.profile){
            load(new frag5(),false);
        }
        return true;
    }
});

        bottomNavigation.setSelectedItemId(R.id.navigation_home);
    }
    public void load(Fragment fragment ,boolean flag)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag){
            ft.add(R.id.bottomNFrame,fragment);
            fm.popBackStackImmediate("root_fragment",FragmentManager.POP_BACK_STACK_INCLUSIVE);
            ft.addToBackStack("root_fragment");
        }
        else{ft.replace(R.id.bottomNFrame,fragment);
         ft.addToBackStack(null);}
        ft.commit();
    }
}