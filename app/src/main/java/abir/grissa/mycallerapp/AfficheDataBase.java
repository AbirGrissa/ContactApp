package abir.grissa.mycallerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class AfficheDataBase extends AppCompatActivity {
    RecyclerView rv_aff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_data_base);
        setContentView(R.layout.activity_affiche);
        rv_aff= findViewById(R.id.list);

    }
}