package com.example.administrador.agenda.model.persistencia;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrador.agenda.model.entidade.Email;
import com.example.administrador.agenda.model.entidade.RedeSocial;

import java.util.List;

/**
 * Created by Administrador on 02/10/2015.
 */
public class RedeRepository {
    public RedeRepository() {
        super();
    }

    public static void save(RedeSocial rede){

        DatabaseHelper databaseHelper =DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = RedeContract.contentValues(rede);
        if(rede.get_id() == null) {
            db.insert(RedeContract.TABLE, null, values);
        } else {
            String where = RedeContract.ID + " = ? ";
            String[] params = {rede.get_id().toString()};
            db.update(RedeContract.TABLE, values, where, params);
        }
        db.close();
        databaseHelper.close();

    }

    public static List<RedeSocial> getAll(){
        DatabaseHelper databaseHelper =DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();


        Cursor cursor = db.query(RedeContract.TABLE, RedeContract.COLUNMS, null, null, null, null, RedeContract.ID);
        List<RedeSocial> rede = RedeContract.getAllRede(cursor);
        db.close();
        databaseHelper.close();
        return rede;
    }

    public static void delete(long id){
        DatabaseHelper databaseHelper =DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String where = RedeContract.ID + " = ? ";
        String[] params = {String.valueOf(id)};
        db.delete(RedeContract.TABLE, where, params);

        db.close();
        databaseHelper.close();
    }

    public static List<RedeSocial> getRedeNull(Long idAmigo){
        DatabaseHelper databaseHelper =DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String where = RedeContract.ID_AMIGO + " IS NULL OR " + RedeContract.ID_AMIGO + " = ?";
        String[] params = {String.valueOf(idAmigo)};

        Cursor cursor = db.query(RedeContract.TABLE, RedeContract.COLUNMS, where, params, null, null, null);

        List<RedeSocial> redes = RedeContract.getAllRede(cursor);

       /* while(cursor.moveToNext()){
            rede = RedeContract.getRede(cursor);
            rede.setIdAmigo(idAmigo);
            save(rede);
        }*/
        return redes;
    }

    public static List<RedeSocial> getRedeAmigo(Long idAmigo) {
        DatabaseHelper databaseHelper =DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String where = RedeContract.ID_AMIGO + " = ? OR "+  RedeContract.ID_AMIGO + " IS NULL";
        String[] params = {String.valueOf(idAmigo)};

        Cursor cursor = db.query(RedeContract.TABLE, RedeContract.COLUNMS, where, params, null, null, null);
        List<RedeSocial> redes = RedeContract.getAllRede(cursor);


        db.close();
        databaseHelper.close();

        return redes;
    }



    public static void deleteRedeContato(Long id){
        DatabaseHelper databaseHelper =DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String where = RedeContract.ID_AMIGO + " = ? ";
        String[] params = {String.valueOf(id)};

        db.delete(RedeContract.TABLE, where, params);

        db.close();
        databaseHelper.close();
    }

    public static void deleteRedeNull(){
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String where = RedeContract.ID_AMIGO + " IS NULL ";
        db.delete(RedeContract.TABLE, where, null);

        db.close();
        databaseHelper.close();
    }

}
