package com.example.llistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class RecyclerView extends AppCompatActivity {
       ArrayList<ContactModel> arrContacts = new ArrayList<>();
       androidx.recyclerview.widget.RecyclerView recyclerView;
       FloatingActionButton ftbtn;
    RecyclerContactAdapter adapter;
  private static final String CHANNEL_ID ="My channel";
    private static final int NOTIFICATION_ID = 100;
    private static final int REQ_code =1100;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

         recyclerView = findViewById(R.id.recyclerCont);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ftbtn= findViewById(R.id.ftbtn);
        ftbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(RecyclerView.this);
                dialog.setContentView(R.layout.add_update_layout);
                EditText edtName=dialog.findViewById(R.id.edtName);
               EditText edtNumber = dialog.findViewById(R.id.edtNumber);
                Button btnAction = dialog.findViewById(R.id.btnAction);
                dialog.show();
                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = "",number = "";
                        if(!edtName.getText().toString().equals(""))
                        {
                            name = edtName.getText().toString();
                        } else{
                            Toast.makeText(RecyclerView.this, "Please Enter name", Toast.LENGTH_SHORT).show();}
                        if(!edtNumber.getText().toString().equals(""))
                        {
                            number = edtNumber.getText().toString();
                        }else{
                            Toast.makeText(RecyclerView.this, "Please Enter number", Toast.LENGTH_SHORT).show();}
                        if(!edtName.getText().toString().equals("")&& !edtNumber.getText().toString().equals(""))
                        { arrContacts.add(new ContactModel(R.drawable.img,name,number));
                        adapter.notifyItemChanged(arrContacts.size()-1);
                        recyclerView.scrollToPosition(arrContacts.size()-1);

                        // notification code//

                            NotificationManager nm =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                            Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.img,null);
                            BitmapDrawable bitmapDrawable =(BitmapDrawable) drawable;
                            Bitmap largeIcon = bitmapDrawable.getBitmap();
                            Notification.Builder notification = new Notification.Builder(RecyclerView.this);

                         // customizing   notification

                            Intent iNotify = new Intent(getApplicationContext(), RecyclerView.class);
                            iNotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            PendingIntent pi = PendingIntent.getActivities(getApplicationContext(),REQ_code, new Intent[]{iNotify},PendingIntent.FLAG_UPDATE_CURRENT);

                            //Big picture style
                            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
                                 bigPictureStyle.bigPicture(largeIcon)
                                         .bigLargeIcon(largeIcon)
                                         .setBigContentTitle("big content title")
                                         .setSummaryText("set summary text");
                            // Inbox style
                            Notification.InboxStyle inboxStyle = new Notification.InboxStyle()
                                    .addLine("A")
                                    .addLine("B")
                                    .addLine("C")
                                    .addLine("D")
                                    .addLine("E")
                                    .addLine("F")
                                    .addLine("G")
                                    .addLine("H")
                                    .addLine("I")
                                    .addLine("J")
                                    .setBigContentTitle("big content title")
                                    .setSummaryText("set summary text");



                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            notification.setLargeIcon(largeIcon)
                                        .setSmallIcon(R.drawable.img)
                                        .setContentText(" new contact added!! ")
                                        .setContentTitle("Contact")
                                        .setSubText("subtext he bhai")
                                        .setContentIntent(pi)
                                   // .setStyle(bigPictureStyle)
                                    .setStyle(inboxStyle)
                                    .setAutoCancel(false)
                                    .setOngoing(true)
                                        .setChannelId(CHANNEL_ID)
                                        .build();
                                nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"new channel",NotificationManager.IMPORTANCE_HIGH));

                            }
                            else
                            {
                               notification.setLargeIcon(largeIcon)
                                        .setSmallIcon(R.drawable.img)
                                        .setContentText(" new contact added!! ")
                                        .setContentTitle("Contact")
                                       .setContentIntent(pi)
                                     //  .setStyle(bigPictureStyle)
                                       .setStyle(inboxStyle)
                                       .setAutoCancel(false)
                                       .setOngoing(true)
                                       .setSubText("subtext he bhai")
                                        .build();

                            }
                            nm.notify(NOTIFICATION_ID, notification.build());
                        }
                        dialog.dismiss();
                    }
                });

            }
        });


         arrContacts.add(new ContactModel(R.drawable.img,"A", "9340036762"));
        arrContacts.add(new ContactModel(R.drawable.img,"B", "9340036762"));
        arrContacts.add(new ContactModel(R.drawable.img,"C", "9340036762"));
        arrContacts.add(new ContactModel(R.drawable.img,"D", "9340036762"));
        arrContacts.add(new ContactModel(R.drawable.img,"E", "9340036762"));
        arrContacts.add(new ContactModel(R.drawable.img,"F", "9340036762"));
        arrContacts.add(new ContactModel(R.drawable.img,"G", "9340036762"));
        arrContacts.add(new ContactModel(R.drawable.img,"H", "9340036762"));
        arrContacts.add(new ContactModel(R.drawable.img,"I", "9340036762"));
        arrContacts.add(new ContactModel(R.drawable.img,"J", "9340036762"));
        arrContacts.add(new ContactModel(R.drawable.img,"K", "9340036762"));
        arrContacts.add(new ContactModel(R.drawable.img,"L", "9340036762"));
        arrContacts.add(new ContactModel(R.drawable.img,"M", "9340036762"));
        arrContacts.add(new ContactModel(R.drawable.img,"N", "9340036762"));
        arrContacts.add(new ContactModel(R.drawable.img,"O", "9340036762"));
        arrContacts.add(new ContactModel(R.drawable.img,"P", "9340036762"));
        arrContacts.add(new ContactModel(R.drawable.img,"Q", "9340036762"));

       adapter = new RecyclerContactAdapter(this,arrContacts);
        recyclerView.setAdapter(adapter);

    }
}