package com.example.administrador.agenda.model.persistencia;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.administrador.agenda.model.entidade.Email;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrador on 01/10/2015.
 */
public class EmailContract {
    public static final String TABLE = "email";
    public static final String ID = "id";
    public static final String ID_AMIGO = "id_amigo";
    public static final String EMAIL = "email";

    public static final String[] COLUNMS = {ID, ID_AMIGO, EMAIL};

    public EmailContract() {
        super();
    }

    public static String getCreateTableScript(){
        final StringBuilder create = new StringBuilder();
        create.append(" CREATE TABLE "+ TABLE);
        create.append(" ( ");
        create.append(ID + " INTEGER PRIMARY KEY, ");
        create.append(ID_AMIGO + " LONG, ");
        create.append(EMAIL + " TEXT ");
        create.append(" ); ");

        return create.toString();
    }


    public static ContentValues contentValues(Email email){
        ContentValues values = new ContentValues();
        values.put(ID, email.get_id());
        values.put(ID_AMIGO, email.getIdAmigo());
        values.put(EMAIL, email.getEmail());
        return values;
    }

    public static Email getEmail(Cursor cursor){
        Email email = new Email();
        email.set_id(cursor.getLong(cursor.getColumnIndex(EmailContract.ID)));
        email.setIdAmigo(cursor.getLong(cursor.getColumnIndex(EmailContract.ID_AMIGO)));
        email.setEmail(cursor.getString(cursor.getColumnIndex(EmailContract.EMAIL)));
        return email;
    }

    public static List<Email> getAllEmail(Cursor cursor){
        ArrayList<Email> emails = new ArrayList<>();
        while(cursor.moveToNext()){
            emails.add(getEmail(cursor));
        }
        return emails;
    }
}
