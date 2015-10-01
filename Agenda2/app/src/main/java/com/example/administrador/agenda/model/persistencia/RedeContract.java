package com.example.administrador.agenda.model.persistencia;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrador on 01/10/2015.
 */
public class RedeContract {
    public static final String TABLE = "rede";
    public static final String ID = "id";
    public static final String ID_AMIGO = "id_amigo";
    public static final String REDE = "rede";

    public static final String[] COLUNMS = {ID, ID_AMIGO, REDE};

    public RedeContract() {
        super();
    }

    public static String getCreateTableScript(){
        final StringBuilder create = new StringBuilder();
        create.append(" CREATE TABLE "+ TABLE);
        create.append(" ( ");
        create.append(ID + " INTEGER PRIMARY KEY, ");
        create.append(ID_AMIGO + " LONG NOT NULL, ");
        create.append(REDE + " TEXT NOT NULL ");
        create.append(" ); ");

        return create.toString();
    }


    public static ContentValues contentValues(Long id, String rede){
        ContentValues values = new ContentValues();
        values.put(ID_AMIGO, id);
        values.put(REDE, rede);
        return values;
    }

    public static String getRede(Cursor cursor){
        String rede = cursor.getString(cursor.getColumnIndex(RedeContract.REDE));
        return rede;
    }

    public static List<String> getAllRede(Cursor cursor){
        ArrayList<String> redes = new ArrayList<>();
        while(cursor.moveToNext()){
            redes.add(getRede(cursor));
        }
        return redes;
    }
}
