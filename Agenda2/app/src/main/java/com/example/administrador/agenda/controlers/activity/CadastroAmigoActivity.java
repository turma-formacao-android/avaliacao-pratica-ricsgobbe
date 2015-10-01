package com.example.administrador.agenda.controlers.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrador.agenda.R;
import com.example.administrador.agenda.model.entidade.Amigo;
import com.example.administrador.agenda.model.persistencia.TelefoneContract;
import com.example.administrador.agenda.service.AmigoBusinessService;

import java.util.List;

/**
 * Created by Administrador on 01/10/2015.
 */
public class CadastroAmigoActivity extends AppCompatActivity {
    public final String PARAM_AMIGO = "amigo";
    private Amigo amigo;
    private EditText nome;
    private EditText cep;
    private EditText rua;
    private EditText bairro;
    private EditText estado;
    private EditText cidade;
    private Button btnTel;
    private Button btnEmail;
    private Button btnRede;
    public static List<String> rede;


    public CadastroAmigoActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cadastro_amigo);

        iniAmigo();
        bindNome();
        bindCep();
        bindRua();
        bindBairro();
        bindEstado();
        bindCidade();
        bindButtonTel();


    }

    private void bindButtonTel() {
        btnTel = (Button) findViewById(R.id.btnTel);
        btnTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToTelForm = new Intent(CadastroAmigoActivity.this, FormTelActivity.class);
                startActivity(goToTelForm);
            }
        });
    }

    private void bindButtonEmail() {
        btnTel = (Button) findViewById(R.id.btnEmail);
        btnTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToTelForm = new Intent(CadastroAmigoActivity.this, FormEmailActivity.class);
                startActivity(goToTelForm);
            }
        });
    }



   /* private void bindButtonRede() {
        btnTel = (Button) findViewById(R.id.btnTel);
        btnTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToTelForm = new Intent(CadastroAmigoActivity.this, FormRedeActivity.class);
                startActivity(goToTelForm);
            }
        });
    }*/


    private void bindCidade() {
        cidade = (EditText) findViewById(R.id.editTxtCidade);
        cidade.setText(amigo.getCidade() == null ? "" : amigo.getCidade());
    }

    private void bindEstado() {
        estado = (EditText) findViewById(R.id.editTxtEstado);
        estado.setText(amigo.getEstado() == null ? "" : amigo.getEstado());
    }

    private void bindBairro() {
        bairro = (EditText) findViewById(R.id.editTxtBairro);
        bairro.setText(amigo.getBairro() == null ? "" : amigo.getBairro());
    }

    private void bindRua() {
        rua = (EditText) findViewById(R.id.editTxtRua);
        rua.setText(amigo.getRua() == null ? "" : amigo.getRua());
    }

    private void bindCep() {
        cep = (EditText) findViewById(R.id.editTxtCep);
        cep.setText(amigo.getCep() == null ? "" : amigo.getCep());
    }

    private void iniAmigo() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.amigo = getIntent().getExtras().getParcelable(PARAM_AMIGO);
        }
        this.amigo = this.amigo == null ? new Amigo() : amigo;
    }

    private void bindNome() {
        nome = (EditText) findViewById(R.id.editTxtNome);
        nome.setText(amigo.getNome() == null ? "" : amigo.getNome());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cadastro_amigo, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_addAmigo:
                addAmigo();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void addAmigo() {
        bindAmigo();
        AmigoBusinessService.save(amigo);
    }

    private void bindAmigo() {
        amigo.setNome(nome.getText().toString() == null ? "" :nome.getText().toString());
        amigo.setCep(cep.getText().toString() == null ? "" : cep.getText().toString());
        amigo.setRua(rua.getText().toString() == null ? "" : rua.getText().toString());
        amigo.setBairro(bairro.getText().toString() == null ? "" : bairro.getText().toString());
        amigo.setCidade(cidade.getText().toString() == null ? "" : cidade.getText().toString());
        amigo.setEstado(estado.getText().toString() == null ? "" : estado.getText().toString());
        CadastroAmigoActivity.this.finish();
    }
}
