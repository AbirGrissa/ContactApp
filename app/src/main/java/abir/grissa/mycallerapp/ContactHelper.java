package abir.grissa.mycallerapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ContactHelper extends SQLiteOpenHelper {
    public static final String contact_table="Contacts";
    public static final String col_nom="Nom";
    public static final String col_prenom="Prenom";
    public static final String col_num="Numéro";
    String req="create table "+contact_table +" ("+ col_num +" Text primary key," +
            col_nom+" Text ,"+col_prenom+" Text )";

    public ContactHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //lors de l'ouverture de la base pour la premier fois
        sqLiteDatabase.execSQL(req);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //modification des vesions
        sqLiteDatabase.execSQL("drop table "+contact_table);
        onCreate(sqLiteDatabase);

    }
}
