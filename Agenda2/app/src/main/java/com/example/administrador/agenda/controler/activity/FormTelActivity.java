package com.example.administrador.agenda.controler.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.administrador.agenda.R;
import com.example.administrador.agenda.model.entidade.Telefone;
import com.example.administrador.agenda.service.TelefoneBusinessService;

/**
 * Created by Administrador on 01/10/2015.
 */
public class FormTelActivity extends AppCompatActivity {

    public static final String PARAM_TEL = "telefone";
    private EditText tel;
    private Telefone telefone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_form_telefone);
        iniTel();
        bindTel();

    }

    private void iniTel() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.telefone = getIntent().getExtras().getParcelable(PARAM_TEL);
        }
        this.telefone = this.telefone == null ? new Telefone() : telefone;
    }

    private void bindTel() {
        tel = (EditText) findViewById(R.id.editTxtTelefone);
        tel.setText(telefone.getTelefone() == null ? "" : telefone.getTelefone());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_telefone, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_addTel:
                addTel();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addTel() {
        bindTelefone();
        TelefoneBusinessService.save(telefone);
        this.finish();
    }

    private void bindTelefone() {
        telefone.setIdAmigo(null);
        telefone.setTelefone(tel.getText().toString() == null ? "" : tel.getText().toString());
    }
}
