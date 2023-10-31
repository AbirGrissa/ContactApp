package abir.grissa.mycallerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Affiche extends AppCompatActivity {
    RecyclerView rv_aff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche);
        rv_aff= findViewById(R.id.rv_affiche);
        //Création des view
        //MyContactAdapter ad=new MyContactAdapter(Affiche.this, android.R.layout.simple_list_item_1,Acceuil.data);
        MyContactRecyclerAdaptrer ad ;

        //Log.i("","taille:"+MainActivity.cm.showAll().get(0).num);
        ad=new MyContactRecyclerAdaptrer(Affiche.this,Acceuil.data);
        GridLayoutManager manager = new GridLayoutManager(this,1,GridLayoutManager.VERTICAL, false);
        rv_aff.setLayoutManager(manager);
        rv_aff.setAdapter(ad);


    }
}