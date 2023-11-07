package abir.grissa.mycallerapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyContactRecyclerAdaptrer extends RecyclerView.Adapter<MyContactRecyclerAdaptrer.MyViewHolder> {
    Context con;
    ArrayList<Contact> data;

    public MyContactRecyclerAdaptrer(Context con, ArrayList<Contact> data) {
        this.con = con;
        this.data = data;
    }

    @NonNull
    @Override
    public MyContactRecyclerAdaptrer.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inf= LayoutInflater.from(con);
        v = inf.inflate(R.layout.view_contact,null);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyContactRecyclerAdaptrer.MyViewHolder holder, int position) {
        Log.i("","onBindViewHolder");
        holder.tvnom_contact.setText(data.get(position).num);
        holder.tvprenom_contact.setText(data.get(position).prenom);
        holder.tvnum_contact.setText(data.get(position).nom);
    }

    @Override
    public int getItemCount() {
        return Acceuil.data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvnom_contact,tvprenom_contact,tvnum_contact;
        EditText nomD,prenomD,telD;
        ImageView call,edit,del;
        public MyViewHolder(@NonNull View v) {//objet v
             super(v);
             tvnom_contact=v.findViewById(R.id.tvNom_Contact);
             tvprenom_contact=v.findViewById(R.id.tvPrenom_contact);
             tvnum_contact=v.findViewById(R.id.tvNum_contact);
             call= v.findViewById(R.id.ivTel_contact);
             edit=v.findViewById(R.id.ivEdit_contact);
             del= v.findViewById(R.id.ivDelete_contact);
            del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //data.remove(getAdapterPosition());//indice de l'element selectionner
                    //notifyDataSetChanged();
                    int p=getAdapterPosition();
                    if (p != RecyclerView.NO_POSITION) {
                        MainActivity.cm.supprimer(tvnum_contact.getText().toString());
                        //data.remove(p); // Remove the item from the data list.
                        Acceuil.data=MainActivity.cm.showAll();
                        data=MainActivity.cm.showAll();
                        notifyDataSetChanged();
                    }
                }
            });
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //int indice=getAdapterPosition();
                    Intent i=new Intent(Intent.ACTION_DIAL);
                    i.setData(Uri.parse("tel:"+tvnum_contact.getText().toString()));
                    con.startActivity(i);
                }
            });
            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int indice=getAdapterPosition();
                    AlertDialog.Builder alert=new AlertDialog.Builder(con);
                    alert.setTitle("Modification");
                    alert.setMessage("Modiffier vos informations");
                    View v_d;
                    LayoutInflater inf= LayoutInflater.from(con);
                    v_d = inf.inflate(R.layout.view_dialogue,null);
                    String nom=tvnom_contact.getText().toString();
                    String prenom=tvprenom_contact.getText().toString();
                    String tel=tvnum_contact.getText().toString();

                    nomD=v_d.findViewById(R.id.et_nomD);
                    nomD.setText(nom);
                    prenomD=v_d.findViewById(R.id.et_prenomD);
                    prenomD.setText(prenom);
                    telD=v_d.findViewById(R.id.et_telD);
                    telD.setText(tel);
                    Button btnvld= v_d.findViewById(R.id.btn_validerD);
                    Button btnqte= v_d.findViewById(R.id.btn_qteD);

                    btnvld.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Contact c= new Contact(nomD.getText().toString(),prenomD.getText().toString(),telD.getText().toString());
                            MainActivity.cm.modifier(c);
                            data=MainActivity.cm.showAll();
                            notifyDataSetChanged();
                        }
                    });
                    alert.setView(v_d);
                    alert.show();
                }
            });

        }
    }
}
