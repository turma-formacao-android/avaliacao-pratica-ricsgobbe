package com.example.administrador.agenda.controler.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrador.agenda.R;
import com.example.administrador.agenda.model.entidade.Amigo;

import java.util.List;

/**
 * Created by Administrador on 02/10/2015.
 */
public class AmigoAdapter extends BaseAdapter {

    Activity context;
    List<Amigo> amigos;

    public AmigoAdapter(Activity context, List<Amigo> amigos) {
        this.context = context;
        this.amigos = amigos;
    }

    public void setItens(List<Amigo> amigos){
        this.amigos.clear();
        this.amigos.addAll(amigos);
    }

    @Override
    public int getCount() {
        return amigos.size();
    }

    @Override
    public Amigo getItem(int position) {
        return amigos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Amigo amigo = getItem(position);
        View view = context.getLayoutInflater().inflate(R.layout.layout_list_amigo, parent, false);

        TextView nome = (TextView) view.findViewById(R.id.txtViewListAmigoNome);
        nome.setText(amigo.getNome());

        return view;
    }
}
