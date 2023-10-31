package abir.grissa.mycallerapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MyContactAdapter extends BaseAdapter {
    Context con;
    ArrayList<Contact> data;
    MyContactAdapter(Context con, ArrayList<Contact> data ){
        this.con=con;
        this.data=data;
    }
    @Override
    public int getCount() {
        //return nb des view a crée

        return Acceuil.data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        //TextView tv= new TextView(con);
        //tv.setText(data.get(position).nom);
        //return tv;
        //renvoie un view a crée (un seul vue)
        //creation dun vue
        LinearLayout v=null;
        LayoutInflater inf= LayoutInflater.from(con);
        //parsing code xml
        //View v = inf.inflate(R.layout.view_contact,null);
        v =(LinearLayout) inf.inflate(R.layout.view_contact,null);
        //Recuperation des holders
        TextView tvnom_contact=v.findViewById(R.id.tvNom_Contact);
        TextView tvprenom_contact=v.findViewById(R.id.tvPrenom_contact);
        TextView tvnum_contact=v.findViewById(R.id.tvNum_contact);
        ImageView call= v.findViewById(R.id.ivTel_contact);
        ImageView edit=v.findViewById(R.id.ivEdit_contact);
        ImageView del= v.findViewById(R.id.ivDelete_contact);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.remove(position);
                notifyDataSetChanged();
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel"+tvnom_contact.getText().toString()));
                con.startActivity(i);
            }
        });
        //call
        //Affectation des holders
        tvnom_contact.setText(data.get(position).nom);
        tvprenom_contact.setText(data.get(position).prenom);
        tvnum_contact.setText(data.get(position).num);
        return v;
    }
}
