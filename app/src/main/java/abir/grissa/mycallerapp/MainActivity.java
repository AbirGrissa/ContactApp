package abir.grissa.mycallerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //declaration
    Button btnqte, btnvld;
    EditText edemail,edpwd;
    public static ContactManager cm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mettre un xml sur l'ecran

        setContentView(R.layout.activity_main);

        //récuperation
        btnqte=findViewById(R.id.btnQuitter_auth);
        btnvld= findViewById(R.id.btnValider_auth);
        edemail=findViewById(R.id.edEmail_auth);
        edpwd=findViewById(R.id.edPassword_auth);
        btnqte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnvld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail=edemail.getText().toString();
                String pwd=edpwd.getText().toString();
                if (mail.equals("test") && pwd.equals("test"))
                {
                    //passage entre activité/acceuil
                    //pour lancer l'activité il faut  declarer l'intention puis lancer votre intention
                    /*Intent i=new Intent();
                    i.setAction(Intent.ACTION_DIAL);
                    i.setData(Uri.parse("tel:23456789"));
                    startActivity(i);*/
                    cm=new ContactManager(MainActivity.this);
                    cm.ouvrir();
                    Intent i=new Intent(MainActivity.this,Acceuil.class);
                    startActivity(i);
                }else
                {
                    //message d'erreur
                    Toast.makeText(MainActivity.this, "verifier vos données", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}