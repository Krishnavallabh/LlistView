package com.example.llistview;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {
    Context context;
    ArrayList<ContactModel> arrContacts;
    private int lastPosition =-1;

    RecyclerContactAdapter(Context context , ArrayList<ContactModel> arrContacts)
    {
        this.context= context;
       this.arrContacts = arrContacts;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup ViewGroup, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.contact_row,ViewGroup,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position )
    {
        holder.imgContact.setImageResource(arrContacts.get(position).img);
        holder.txtName.setText(arrContacts.get(position).name);
        holder.txtNumber.setText(arrContacts.get(position).number);

        setAnimation(holder.itemView, holder.getAdapterPosition());


        holder.llRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_update_layout);
                EditText edtName=dialog.findViewById(R.id.edtName);
                EditText edtNumber = dialog.findViewById(R.id.edtNumber);
                Button btnAction = dialog.findViewById(R.id.btnAction);
                TextView dialogType =dialog.findViewById(R.id.dialogType);
                dialogType.setText("Update Contact");
                btnAction.setText("Update");
                edtName.setText(arrContacts.get(holder.getAdapterPosition()).name);
                edtNumber.setText(arrContacts.get(holder.getAdapterPosition()).number);
                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = "",number = "";
                        if(!edtName.getText().toString().equals(""))
                        {
                            name = edtName.getText().toString();
                        } else{
                            Toast.makeText(context, "Please Enter name", Toast.LENGTH_SHORT).show();}
                        if(!edtNumber.getText().toString().equals(""))
                        {
                            number = edtNumber.getText().toString();
                        }else{
                            Toast.makeText(context, "Please Enter number", Toast.LENGTH_SHORT).show();}
                        if(!edtName.getText().toString().equals("")&& !edtNumber.getText().toString().equals(""))
                        { arrContacts.set(holder.getAdapterPosition(),new ContactModel(R.drawable.img,name,number));
                            notifyItemChanged(holder.getAdapterPosition());
                           }
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        holder.llRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //for single button use
               // AlertDialog alert = new AlertDialog.Builder(context).create();


                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                          builder .setTitle("Delete Contact");
                         builder.setMessage("Are you sure want to delete?")
                           .setIcon(R.drawable.ic_baseline_delete_24)
                             .setCancelable(false)
                           .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                arrContacts.remove(holder.getAdapterPosition());
                                notifyItemRemoved(holder.getAdapterPosition());
                            }
                             })
                           .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                             });
                      builder.show();



                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName,txtNumber;
        ImageView imgContact;
        LinearLayout llRow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName= itemView.findViewById(R.id.txtName);
            txtNumber= itemView.findViewById(R.id.txtNumber);
            imgContact = itemView.findViewById(R.id.imgContact);
            llRow = itemView.findViewById(R.id.llRow);

        }
    }

    private void setAnimation(View v,int position)
    {   if(position>lastPosition)
       {
        Animation slideIn = AnimationUtils.loadAnimation(context,R.anim.slide_in);
        v.startAnimation(slideIn);
        lastPosition = position;
       }
    }
}
