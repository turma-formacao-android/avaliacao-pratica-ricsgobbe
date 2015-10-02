package com.example.administrador.agenda.controler.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.administrador.agenda.R;
import com.example.administrador.agenda.model.entidade.RedeSocial;
import com.example.administrador.agenda.service.RedeBusinessService;

/**
 * Created by Administrador on 02/10/2015.
 */
public class FormRedeActivity extends AppCompatActivity {
    public final String PARAM_REDE = "redeSocial";
    private EditText redeTxt;
    RedeSocial rede;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_form_rede);
        iniRede();
        bindRedeTxt();


    }

    private void bindRedeTxt() {
        redeTxt = (EditText) findViewById(R.id.editTxtRede);
        redeTxt.setText(rede.getRede() == null ? "" : rede.getRede() );
    }


    private void bindRede() {
        rede.setRede(redeTxt.getText().toString() == null ? "" : redeTxt.getText().toString());
        rede.setIdAmigo(null);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_rede, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_addRede:
                addRede();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addRede() {
        bindRede();
        RedeBusinessService.save(rede);
        this.finish();
    }

    private void iniRede() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.rede = getIntent().getExtras().getParcelable(PARAM_REDE);
        }
        this.rede = this.rede == null ? new RedeSocial() : rede;
    }
}
