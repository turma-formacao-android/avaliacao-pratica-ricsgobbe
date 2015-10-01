package com.example.administrador.agenda.model.persistencia;


import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrador on 01/10/2015.
 */
public class TelefoneContract {
    public static final String TABLE = "telefone";
    public static final String ID = "id";
    public static final String ID_AMIGO = "id_amigo";
    public static final String TELEFONE = "telefone";

    public static final String[] COLUNMS = {ID, ID_AMIGO, TELEFONE};

    public TelefoneContract() {
        super();
    }

    public static String getCreateTableScript(){
        final StringBuilder create = new StringBuilder();
        create.append(" CREATE TABLE "+ TABLE);
        create.append(" ( ");
        create.append(ID + " INTEGER PRIMARY KEY, ");
        create.append(ID_AMIGO + " LONG, ");
        create.append(TELEFONE + " TEXT ");
        create.append(" ); ");

        return create.toString();
    }


    public static ContentValues contentValues(Long id, String telefone){
        ContentValues values = new ContentValues();
        values.put(ID_AMIGO, id);
        values.put(TELEFONE, telefone);
        return values;
    }

    public static String getTelefone(Cursor cursor){
        String telefone = cursor.getString(cursor.getColumnIndex(TelefoneContract.TELEFONE));
        return telefone;
    }

    public static List<String> getAllTel(Cursor cursor){
        ArrayList<String> telefones = new ArrayList<>();
        while(cursor.moveToNext()){
            telefones.add(getTelefone(cursor));
        }
        return telefones;
    }



}
