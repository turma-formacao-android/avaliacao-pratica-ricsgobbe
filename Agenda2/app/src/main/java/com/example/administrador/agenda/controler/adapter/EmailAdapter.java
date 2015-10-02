package com.example.administrador.agenda.controler.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrador.agenda.R;
import com.example.administrador.agenda.model.entidade.Email;
import com.example.administrador.agenda.model.entidade.Telefone;

import java.util.List;

/**
 * Created by Administrador on 02/10/2015.
 */
public class EmailAdapter extends BaseAdapter {
    Activity context;
    List<Email> emails;



    public void setItens(List<Email> emails){
        this.emails.clear();
        this.emails.addAll(emails);
    }

    public EmailAdapter(Activity context, List<Email> emails) {
        this.context = context;
        this.emails = emails;
    }

    @Override
    public int getCount() {
        return emails.size();
    }

    @Override
    public Email getItem(int position) {
        return emails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Email email = getItem(position);
        View view = context.getLayoutInflater().inflate(R.layout.list_email, parent, false);

        TextView emailTxt = (TextView) view.findViewById(R.id.listTxtEmail);
        emailTxt.setText(email.getEmail() == null ? "" : email.getEmail());

        return view;
    }
}
