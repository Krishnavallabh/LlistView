package com.example.llistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class frameLayout extends AppCompatActivity {
Button frame1,frame2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);
        frame1=findViewById(R.id.frame1);
        frame2=findViewById(R.id.frame2);
        loadFrame(new frag1(),0);
        frame1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFrame(new frag1(),0);
                Toast.makeText(frameLayout.this, "Frame 1", Toast.LENGTH_SHORT).show();
            }
        });
        frame2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               loadFrame(new frag2(),1);
                Toast.makeText(frameLayout.this, "Frame 2", Toast.LENGTH_SHORT).show();

            }
        });

    }
    public void loadFrame(Fragment fragment,int flag)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag==0)
        ft.add(R.id.frameLayout, fragment);
        else
            //  no difference in add and replace
            ft.replace(R.id.frameLayout,fragment);


        ft.commit();
    }
}