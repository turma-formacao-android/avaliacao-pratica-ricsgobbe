package com.example.administrador.agenda.model.persistencia;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrador.agenda.model.entidade.Amigo;

import java.util.List;

/**
 * Created by Administrador on 01/10/2015.
 */
public class AmigoRepository {
    public AmigoRepository() {
        super();
    }
    public static void save(Amigo estoque){

        DatabaseHelper databaseHelper =DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = AmigoContract.contentValues(estoque);
        if(estoque.get_id() == null) {
            db.insert(AmigoContract.TABLE, null, values);
        } else {
            String where = AmigoContract.ID + " = ? ";
            String[] params = {estoque.get_id().toString()};
            db.update(AmigoContract.TABLE, values, where, params);
        }
        db.close();
        databaseHelper.close();

    }

    public static List<Amigo> getAll(){
        DatabaseHelper databaseHelper =DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();


        Cursor cursor = db.query(AmigoContract.TABLE, AmigoContract.COLUNMS, null, null, null, null, AmigoContract.ID);
        List<Amigo> amigos = AmigoContract.getEstoques(cursor);
        db.close();
        databaseHelper.close();
        return amigos;
    }

    public static void delete(long id){
        DatabaseHelper databaseHelper =DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String where = AmigoContract.ID + " = ? ";
        String[] params = {String.valueOf(id)};
        db.delete(AmigoContract.TABLE, where, params);

        db.close();
        databaseHelper.close();
    }


    public static Long getIdAmigo(String nome) {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String where = AmigoContract.NOME + " = ? ";
        String[] params = {String.valueOf(nome)};

        Cursor cursor = db.query(AmigoContract.TABLE, AmigoContract.COLUNMS, where, params, null, null, null);
        Amigo amigo = AmigoContract.getAmigo(cursor);

        db.close();
        databaseHelper.close();

        return amigo.get_id();
    }
}
