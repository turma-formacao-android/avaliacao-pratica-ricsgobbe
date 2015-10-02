package com.example.administrador.agenda.controler.activity.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrador.agenda.R;
import com.example.administrador.agenda.model.entidade.Email;
import com.example.administrador.agenda.model.entidade.RedeSocial;

import java.util.List;

/**
 * Created by Administrador on 02/10/2015.
 */
public class RedeAdapter extends BaseAdapter {
    Activity context;
    List<RedeSocial> redes;

    public RedeAdapter(Activity context, List<RedeSocial> redes) {
        this.context = context;
        this.redes = redes;
    }

    public void setItens(List<RedeSocial> redes){
        this.redes.clear();
        this.redes.addAll(redes);
    }

    @Override
    public int getCount() {
        return redes.size();
    }

    @Override
    public RedeSocial getItem(int position) {
        return redes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RedeSocial rede = getItem(position);
        View view = context.getLayoutInflater().inflate(R.layout.list_rede, parent, false);

        TextView redeTxt = (TextView) view.findViewById(R.id.listTxtRede);
        redeTxt.setText(rede.getRede() == null ? "" : rede.getRede());

        return view;
    }
}
