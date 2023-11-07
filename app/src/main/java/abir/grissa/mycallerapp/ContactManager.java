package abir.grissa.mycallerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class ContactManager {
    SQLiteDatabase db=null;
    Context con;
    public ContactManager(Context c) {
        this.con = c;
    }
    public void ouvrir(){ 
        ContactHelper c = new ContactHelper(con,"myDB", null, 1);
        //ouvrir la base
        db=c.getWritableDatabase();
    }
    public long ajout(String num,String nom,String prenom){
        long x=0;
        ContentValues values= new ContentValues();
        values.put(ContactHelper.col_nom,nom);
        values.put(ContactHelper.col_num,num);
        values.put(ContactHelper.col_prenom,prenom);
        x=db.insert(ContactHelper.contact_table,null,values);
        return x;
    }
    public ArrayList<Contact> showAll(){
        ArrayList <Contact> x =new ArrayList<Contact>();
        Cursor c=db.query(ContactHelper.contact_table,
                new String[]{ContactHelper.col_num,ContactHelper.col_nom,ContactHelper.col_prenom},
                null,
                null,null,null,null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            String i1=c.getString(0);
            Log.i("","nom"+c.getString(0)+"prenom"+c.getString(1)+"tel"+c.getString(2));
            String i2=c.getString(1);
            String i3=c.getString(2);
            x.add(new Contact(i1,i2,i3));
            c.moveToNext();
        }

        return x;
    }
    public ArrayList<Contact> find(String s){
        ArrayList <Contact> x =new ArrayList<Contact>();
        Cursor c=db.query(ContactHelper.contact_table,
                new String[]{ContactHelper.col_num,ContactHelper.col_nom,ContactHelper.col_prenom},
                null,
                null,null,null,null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            String i1=c.getString(0);
            //Log.i("","nom"+c.getString(0)+"prenom"+c.getString(1)+"tel"+c.getString(2));
            String i2=c.getString(1);
            String i3=c.getString(2);
            if(i2.contains(s)||i3.contains(s)){
                x.add(new Contact(i1,i2,i3));
            }
            c.moveToNext();
        }
        return x;
    }

    public void supprimer(String num){
        db.delete(ContactHelper.contact_table,ContactHelper.col_num+" =?", new String[]{num});
    }
    public void modifier(Contact c){
        ContentValues values = new ContentValues();
        values.put(ContactHelper.col_nom, c.nom);
        values.put(ContactHelper.col_prenom, c.prenom);
        db.update(ContactHelper.contact_table,
                values,
                ContactHelper.col_num+" =?",
                new String[]{c.num});

    }
    public void fermer(){

    }
}
