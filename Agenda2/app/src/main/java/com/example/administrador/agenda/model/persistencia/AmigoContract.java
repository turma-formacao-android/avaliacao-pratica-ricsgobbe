package com.example.administrador.agenda.model.persistencia;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.administrador.agenda.model.entidade.Amigo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrador on 01/10/2015.
 */
public class AmigoContract {

   public static final String TABLE = "amigo";
   public static final String ID = "id";
   public static final String NOME = "nome";
   public static final String CEP = "cep";
   public static final String RUA = "rua";
   public static final String BAIRRO = "bairro";
   public static final String ESTADO = "estado";
   public static final String CIDADE = "cidade";

   public static final String[] COLUNMS = {ID, NOME, CEP, RUA, BAIRRO, ESTADO, CIDADE};


    public AmigoContract() {
        super();
    }

    public static String getCreateTableScript(){
        final StringBuilder create = new StringBuilder();
        create.append(" CREATE TABLE "+ TABLE);
        create.append(" ( ");
        create.append(ID + " INTEGER PRIMARY KEY, ");
        create.append(NOME + " TEXT,  ");
        create.append(CEP + " TEXT, ");
        create.append(RUA + " TEXT, ");
        create.append(BAIRRO + " TEXT, ");
        create.append(ESTADO + " TEXT, ");
        create.append(CIDADE + " TEXT ");
        create.append(" ); ");

        return create.toString();
    }

    public static ContentValues contentValues(Amigo amigo){
        ContentValues values = new ContentValues();

        values.put(AmigoContract.ID, amigo.get_id());
        values.put(AmigoContract.NOME, amigo.getNome());
        values.put(AmigoContract.CEP, amigo.getCep());
        values.put(AmigoContract.RUA, amigo.getRua());
        values.put(AmigoContract.BAIRRO, amigo.getBairro());
        values.put(AmigoContract.ESTADO, amigo.getEstado());
        values.put(AmigoContract.CIDADE, amigo.getCidade());
        return values;
    }

    public static Amigo getAmigo(Cursor cursor){
        if (!cursor.isBeforeFirst() || cursor.moveToNext()) {
            Amigo amigo = new Amigo();

            amigo.set_id(cursor.getLong(cursor.getColumnIndex(AmigoContract.ID)));
            amigo.setNome(cursor.getString(cursor.getColumnIndex(AmigoContract.NOME)));
            amigo.setCep(cursor.getString(cursor.getColumnIndex(AmigoContract.CEP)));
            amigo.setRua(cursor.getString(cursor.getColumnIndex(AmigoContract.RUA)));
            amigo.setBairro(cursor.getString(cursor.getColumnIndex(AmigoContract.BAIRRO)));
            amigo.setEstado(cursor.getString(cursor.getColumnIndex(AmigoContract.ESTADO)));
            amigo.setCidade(cursor.getString(cursor.getColumnIndex(AmigoContract.CIDADE)));

            return amigo;
        }
        return null;
    }


    public static List<Amigo> getEstoques(Cursor cursor){
        ArrayList<Amigo> estoques = new ArrayList<>();
        while(cursor.moveToNext()){
            estoques.add(getAmigo(cursor));
        }
        return estoques;
    }

}
