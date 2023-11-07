package abir.grissa.mycallerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Affiche extends AppCompatActivity {
    RecyclerView rv_aff;
    Button rech;
    EditText recherche;

    public static ArrayList<Contact> res=new ArrayList<Contact>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche);
        rv_aff= findViewById(R.id.rv_affiche);

        rech=findViewById(R.id.btnRech_aff);
        recherche=findViewById(R.id.etRechAff);
        //Création des view
        //MyContactAdapter ad=new MyContactAdapter(Affiche.this, android.R.layout.simple_list_item_1,Acceuil.data);

        //Log.i("","taille:"+MainActivity.cm.showAll().get(0).num);
        MyContactRecyclerAdaptrer ad ;
        Acceuil.data=MainActivity.cm.showAll();
        ad=new MyContactRecyclerAdaptrer(Affiche.this,Acceuil.data);
        GridLayoutManager manager = new GridLayoutManager(this,1,GridLayoutManager.VERTICAL, false);
        rv_aff.setLayoutManager(manager);
        rv_aff.setAdapter(ad);
        rech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res = MainActivity.cm.find(recherche.getText().toString());
                if (!res.isEmpty()){
                    Acceuil.data=res;
                    MyContactRecyclerAdaptrer ad ;
                    ad = new MyContactRecyclerAdaptrer(Affiche.this, Acceuil.data);
                    rv_aff.setAdapter(ad);
                }
            }
        });

    }
}