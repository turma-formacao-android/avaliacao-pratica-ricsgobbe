package com.example.administrador.agenda.model.persistencia;


import android.content.ContentValues;
import android.database.Cursor;

import com.example.administrador.agenda.model.entidade.Telefone;

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


    public static ContentValues contentValues(Telefone telefone){
        ContentValues values = new ContentValues();
        values.put(ID, telefone.get_id());
        values.put(ID_AMIGO, telefone.getIdAmigo());
        values.put(TELEFONE, telefone.getTelefone());
        return values;
    }

    public static Telefone getTelefone(Cursor cursor){
        Telefone telefone = new Telefone();
        telefone.set_id(cursor.getLong(cursor.getColumnIndex(TelefoneContract.ID)));
        telefone.setIdAmigo(cursor.getLong(cursor.getColumnIndex(TelefoneContract.ID_AMIGO)));
        telefone.setTelefone(cursor.getString(cursor.getColumnIndex(TelefoneContract.TELEFONE)));
        return telefone;
    }

    public static List<Telefone> getAllTel(Cursor cursor){
        ArrayList<Telefone> telefones = new ArrayList<>();
        while(cursor.moveToNext()){
            telefones.add(getTelefone(cursor));
        }
        return telefones;
    }

}
