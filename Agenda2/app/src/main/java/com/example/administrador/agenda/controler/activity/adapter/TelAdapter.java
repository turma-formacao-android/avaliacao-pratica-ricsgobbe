package com.example.administrador.agenda.controler.activity.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrador.agenda.R;
import com.example.administrador.agenda.model.entidade.Email;
import com.example.administrador.agenda.model.entidade.RedeSocial;
import com.example.administrador.agenda.model.entidade.Telefone;
import com.fasterxml.jackson.databind.deser.Deserializers;

import java.util.List;

/**
 * Created by Administrador on 02/10/2015.
 */
public class TelAdapter extends BaseAdapter {
    Activity context;
    List<Telefone> telefones;

    public TelAdapter(Activity context, List<Telefone> telefones) {
        this.context = context;
        this.telefones = telefones;
    }

    public void setItens(List<Telefone> telefones){
        this.telefones.clear();
        this.telefones.addAll(telefones);
    }
    @Override
    public int getCount() {
        return telefones.size();
    }

    @Override
    public Telefone getItem(int position) {
        return telefones.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Telefone telefone = getItem(position);
        View view = context.getLayoutInflater().inflate(R.layout.list_tel, parent, false);

        TextView telTxt = (TextView) view.findViewById(R.id.listTxtTel);
        telTxt.setText(telefone.getTelefone()  == null ? "" : telefone.getTelefone());

        return view;
    }
}
