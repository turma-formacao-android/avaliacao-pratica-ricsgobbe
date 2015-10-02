package com.example.administrador.agenda.model.persistencia;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrador.agenda.model.entidade.Amigo;
import com.example.administrador.agenda.model.entidade.RedeSocial;
import com.example.administrador.agenda.model.entidade.Telefone;

import java.util.List;

/**
 * Created by Administrador on 01/10/2015.
 */
public class TelefoneRepository {
    public TelefoneRepository() {
        super();
    }

    public static void save(Telefone telefone){

        DatabaseHelper databaseHelper =DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = TelefoneContract.contentValues(telefone);
        if(telefone.get_id() == null) {
            db.insert(TelefoneContract.TABLE, null, values);
        } else {
            String where = TelefoneContract.ID + " = ? ";
            String[] params = {telefone.get_id().toString()};
            db.update(TelefoneContract.TABLE, values, where, params);
        }
        db.close();
        databaseHelper.close();

    }

    public static List<Telefone> getAll(){
        DatabaseHelper databaseHelper =DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();


        Cursor cursor = db.query(TelefoneContract.TABLE, TelefoneContract.COLUNMS, null, null, null, null, TelefoneContract.ID);
        List<Telefone> telefone = TelefoneContract.getAllTel(cursor);
        db.close();
        databaseHelper.close();
        return telefone;
    }

    public static void delete(long id){
        DatabaseHelper databaseHelper =DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String where = TelefoneContract.ID + " = ? ";
        String[] params = {String.valueOf(id)};
        db.delete(TelefoneContract.TABLE, where, params);

        db.close();
        databaseHelper.close();
    }

    public static void getTelNull(Long idAmigo) {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String where = TelefoneContract.ID_AMIGO + " IS NULL";
        //String[] params = null;

        Cursor cursor = db.query(TelefoneContract.TABLE, TelefoneContract.COLUNMS, where, null, null, null, null);
        Telefone telefone = new Telefone();
        while (cursor.moveToNext()) {
            telefone = TelefoneContract.getTelefone(cursor);
            telefone.setIdAmigo(idAmigo);
            save(telefone);
        }
    }
}
