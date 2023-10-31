package abir.grissa.mycallerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.time.Clock;

public class Ajout extends AppCompatActivity {
    Button btnqte, btnvld;
    EditText ednom,edprenom,edtel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
        btnqte=findViewById(R.id.btnQt_Ajout);
        btnvld= findViewById(R.id.btnVld_Ajout);
        ednom=findViewById(R.id.edNom_Ajout);
        edprenom=findViewById(R.id.edprenom_Ajout);
        edtel=findViewById(R.id.edtel_ajout);

        btnqte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnvld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom=ednom.getText().toString();
                String prenom=edprenom.getText().toString();
                String tel=edtel.getText().toString();
                //Contact c= new Contact(nom,prenom,tel);

                Log.i("aajjhhggfddsd","");
                long ajout = MainActivity.cm.ajout(tel, nom, prenom);
                Log.i("aaa",":"+ajout);


                //Acceuil.data.add(c);
                //Intent i=new Intent(Ajout.this,list.class);
                //i.putExtra("nom",nom);
                //startActivity(i);


            }
        });

    }
}