package com.example.administrador.agenda.model.persistencia;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrador.agenda.model.entidade.Email;

import java.util.List;

/**
 * Created by Administrador on 02/10/2015.
 */
public class EmailRepository {
    public EmailRepository() {
        super();
    }

    public static void save(Email email){

        DatabaseHelper databaseHelper =DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = EmailContract.contentValues(email);
        if(email.get_id() == null) {
            db.insert(EmailContract.TABLE, null, values);
        } else {
            String where = EmailContract.ID + " = ? ";
            String[] params = {email.get_id().toString()};
            db.update(EmailContract.TABLE, values, where, params);
        }
        db.close();
        databaseHelper.close();

    }

    public static List<Email> getAll(){
        DatabaseHelper databaseHelper =DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();


        Cursor cursor = db.query(EmailContract.TABLE, EmailContract.COLUNMS, null, null, null, null, EmailContract.ID);
        List<Email> email = EmailContract.getAllEmail(cursor);
        db.close();
        databaseHelper.close();
        return email;
    }

    public static void delete(long id){
        DatabaseHelper databaseHelper =DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String where = EmailContract.ID + " = ? ";
        String[] params = {String.valueOf(id)};
        db.delete(EmailContract.TABLE, where, params);

        db.close();
        databaseHelper.close();
    }

    public static void getEmailNull(Long idAmigo){
        DatabaseHelper databaseHelper =DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String where = EmailContract.ID_AMIGO + " IS NULL";
        //String[] params = null;

        Cursor cursor = db.query(EmailContract.TABLE, EmailContract.COLUNMS, where, null, null, null, null);
        Email email = new Email();
        while(cursor.moveToNext()){
            email = EmailContract.getEmail(cursor);
            email.setIdAmigo(idAmigo);
            save(email);
        }
    }
}
