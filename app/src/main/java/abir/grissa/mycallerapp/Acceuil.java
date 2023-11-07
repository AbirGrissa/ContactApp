package abir.grissa.mycallerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Acceuil extends AppCompatActivity {
    Button btnajt, btnaff;
    public static ArrayList<Contact> data=new ArrayList<Contact>();


    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_acceuil);


        //lv.findViewById(R.id.lv_affiche);
        btnajt=this.findViewById(R.id.btnAjout_Acceuil);
        btnaff=Acceuil.this.findViewById(R.id.btnAffiche_Acceuil);

        btnajt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Acceuil.this,Ajout.class);
                startActivity(i);
            }
        });
        btnaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(Acceuil.this,Affiche.class);
                startActivity(i);
            }
        });
    }
}