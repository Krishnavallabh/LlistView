package com.example.llistview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
Spinner spinner;
Button btn,btnIntent;
AutoCompleteTextView actxt;
Toolbar toolBar;

ArrayList<String> arrId = new ArrayList<>();
ArrayList<String> arrNames = new ArrayList<>();
    ArrayList<String> language = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

     super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        listView = findViewById(R.id.listView);
        spinner = findViewById(R.id.spinner);
        btn = findViewById(R.id.btn);
        btnIntent = findViewById(R.id.btnIntent);
      actxt = findViewById(R.id.actxt);


        // for Impicit intent passing
        btnIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), ImpicitIntent.class);
//                startActivity(intent);
//                Intent iFragmemt = new Intent(getApplicationContext(),Fragment.class);
//                startActivity(iFragmemt);
            }
        });
        arrNames.add("vallabh");
        arrNames.add("krishna");
        arrNames.add("krishnaPatidar");
        arrNames.add("krishnavallabh");
        arrNames.add("vallabh");
        arrNames.add("krishna");
        arrNames.add("krishnaPatidar");
        arrNames.add("krishnavallabhPatidar");
        arrNames.add("vallabh");
        arrNames.add("krishna");
        arrNames.add("krishnaPatidar");
        ArrayAdapter<String> adapterList = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,arrNames);
   listView.setAdapter(adapterList);

listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(i==0) {
            Toast.makeText(MainActivity.this, "first button clicked", Toast.LENGTH_SHORT).show();
        }
    }
});
       arrId.add("Aadhar card");
        arrId.add("pan card");
        arrId.add("voter card");
        arrId.add("ration card");
        arrId.add("xth score card");
        arrId.add("xiith score card");

        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arrId);

  spinner.setAdapter(adapterSpinner);


    language.add("c");
        language.add("c++");
        language.add("c#");
        language.add("objective c");
        language.add("java");
        language.add("dart");
        language.add("php");

        ArrayAdapter<String> adapterl = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,language);
        actxt.setAdapter(adapterl);
        //threshold for after how many letter suggestion should start
         actxt.setThreshold(1);

         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 // for custom toast

                 Toast toast= new Toast(getApplicationContext());
                 View v = getLayoutInflater().inflate(R.layout.custom_toast_layout,findViewById(R.id.layoutId));
                 toast.setView(v);
                 TextView txtMsg = v.findViewById(R.id.txtMsg);
                 txtMsg.setText("recycler View opened");
                 toast.show();
                 toast.setDuration(Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER|Gravity.TOP,0,0);

                 Intent intent = new Intent(getApplicationContext(),RecyclerView.class);
                 startActivity(intent);
             }
         });
      //for tool bar

        toolBar= findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("My toolbar");}
     //   toolBar.setTitle("My Toolbar");
        toolBar.setSubtitle("sub title");



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId==R.id.btnDial)
        {
            Toast.makeText(this,"create new file",Toast.LENGTH_SHORT).show();
            Intent iDail = new Intent(Intent.ACTION_DIAL);
            iDail.setData(Uri.parse("tel: +919340036762"));
            startActivity(iDail);



        }else if(itemId==R.id.btnEmail){
            Toast.makeText(this, "file open", Toast.LENGTH_SHORT).show();
        Intent iEmail= new Intent(Intent.ACTION_SEND);
        iEmail.setType("message/rtc822");
        iEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"hiralalpatidar570@gamil.com"});
        iEmail.putExtra(Intent.EXTRA_SUBJECT,"Queries");
        iEmail.putExtra(Intent.EXTRA_TEXT,"please solve this issue");
        startActivity(Intent.createChooser(iEmail,"Email By"));

        }
        else if(itemId==R.id.btnShare){
            Toast.makeText(this, "save file", Toast.LENGTH_SHORT).show();

            Intent iShare = new Intent(Intent.ACTION_SEND);
            iShare.setType("text/plain");
            iShare.putExtra(Intent.EXTRA_TEXT,"This is Amazing app");
            startActivity(Intent.createChooser(iShare,"Share By"));
        }else if(itemId==R.id.btnMsg){
            Toast.makeText(this, "send message", Toast.LENGTH_SHORT).show();
            Intent iMsg = new Intent(Intent.ACTION_SENDTO);
            iMsg.setData(Uri.parse("smsto:"+Uri.encode("+919340036762")));
            iMsg.putExtra("sms_body","please solve this problem asap!!");
            startActivity(iMsg);


        }else if(itemId==R.id.btnFragment){
            Intent iFragmemt = new Intent(getApplicationContext(),Fragment.class);
            startActivity(iFragmemt);
        }else if(itemId==R.id.btnFrame)
        {
            Intent iFrame = new Intent(getApplicationContext(),frameLayout.class);
            startActivity(iFrame);
        }else if(itemId== R.id.btnTab)
        {
            Intent iTab = new Intent(getApplicationContext(),tabLayout.class);
            startActivity(iTab);
        }else if (itemId==R.id.bottomNavigation){
            Intent ibNavigation = new Intent(getApplicationContext(),bottomNavigation.class);
            startActivity(ibNavigation);
        }else if(itemId==R.id.drawerNavigation)
        {
            Intent idNavigation = new Intent(getApplicationContext(),drawerNavigation.class);
            startActivity(idNavigation);
        }

        else if(itemId==android.R.id.home){super.onBackPressed();}
        return super.onOptionsItemSelected(item);
    }
}