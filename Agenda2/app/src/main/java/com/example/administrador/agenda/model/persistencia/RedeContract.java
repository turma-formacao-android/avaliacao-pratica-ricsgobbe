package com.example.administrador.agenda.model.persistencia;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.administrador.agenda.model.entidade.RedeSocial;

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
        create.append(ID_AMIGO + " LONG, ");
        create.append(REDE + " TEXT  ");
        create.append(" ); ");

        return create.toString();
    }


    public static ContentValues contentValues(RedeSocial rede){
        ContentValues values = new ContentValues();
        values.put(ID, rede.get_id());
        values.put(ID_AMIGO, rede.getIdAmigo());
        values.put(REDE, rede.getRede());
        return values;
    }

    public static RedeSocial getRede(Cursor cursor){
        RedeSocial rede = new RedeSocial();
        rede.set_id(cursor.getLong(cursor.getColumnIndex(RedeContract.ID)));
        rede.setIdAmigo(cursor.getLong(cursor.getColumnIndex(RedeContract.ID_AMIGO)));
        rede.setRede(cursor.getString(cursor.getColumnIndex(RedeContract.REDE)));
        return rede;
    }

    public static List<RedeSocial> getAllRede(Cursor cursor){
        ArrayList<RedeSocial> redes = new ArrayList<>();
        while(cursor.moveToNext()){
            redes.add(getRede(cursor));
        }
        return redes;
    }
}
