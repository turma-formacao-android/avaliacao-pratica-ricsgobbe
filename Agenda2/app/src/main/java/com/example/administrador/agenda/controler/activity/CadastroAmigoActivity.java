package com.example.administrador.agenda.controler.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrador.agenda.R;
import com.example.administrador.agenda.controler.activity.adapter.EmailAdapter;
import com.example.administrador.agenda.controler.activity.adapter.RedeAdapter;
import com.example.administrador.agenda.controler.activity.adapter.TelAdapter;
import com.example.administrador.agenda.model.entidade.Amigo;
import com.example.administrador.agenda.model.entidade.Email;
import com.example.administrador.agenda.model.entidade.RedeSocial;
import com.example.administrador.agenda.model.entidade.Telefone;
import com.example.administrador.agenda.model.http.AmigoService;
import com.example.administrador.agenda.service.AmigoBusinessService;
import com.example.administrador.agenda.service.EmailBusinessService;
import com.example.administrador.agenda.service.RedeBusinessService;
import com.example.administrador.agenda.service.TelefoneBusinessService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrador on 01/10/2015.
 */
public class CadastroAmigoActivity extends AppCompatActivity {
    public static final String PARAM_AMIGO = "amigo";
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
    private Button btnCep;
    private Spinner spnEmail;
    private Spinner spnTel;
    private Spinner spnRede;
    private Email selectedEmail;
    private Telefone selectedTelefone;
    private RedeSocial selectedRede;

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
        bindButtonEmail();
        bindButtonRede();
        bindButtonCep();
        bindEmailList();
        bindTelList();
        bindRedeList();

    }

    private void bindRedeList() {
        List<RedeSocial> redes = new ArrayList<>();
        spnRede = (Spinner) findViewById(R.id.spinnerSociais);
        spnRede.setAdapter(new RedeAdapter(this, redes));
        spnRede.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedRede = (RedeSocial) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void bindTelList() {
        List<Telefone> telefones = new ArrayList<>();
        spnTel = (Spinner) findViewById(R.id.spinnerTel);
        spnTel.setAdapter(new TelAdapter(this, telefones));
        spnTel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedTelefone = (Telefone) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateEmailList();
        updateRedeList();
        updateTelList();
    }

    private void bindEmailList() {
        List<Email> emails = new ArrayList<>();
        spnEmail = (Spinner) findViewById(R.id.spinnerEmail);
        spnEmail.setAdapter(new EmailAdapter(this, emails));
        spnEmail.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedEmail = (Email) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void updateEmailList() {
        List<Email> emails = EmailBusinessService.emailsAmigo(amigo.get_id());
        EmailAdapter adapter = (EmailAdapter) spnEmail.getAdapter();
        adapter.setItens(emails);
        adapter.notifyDataSetChanged();
    }

    private void updateTelList() {
        List<Telefone> telefones = TelefoneBusinessService.telefonesAmigo(amigo.get_id());
        TelAdapter adapter = (TelAdapter) spnTel.getAdapter();
        adapter.setItens(telefones);
        adapter.notifyDataSetChanged();
    }

    private void updateRedeList() {
        List<RedeSocial> redes = RedeBusinessService.redesAmigo(amigo.get_id());
        RedeAdapter adapter = (RedeAdapter) spnRede.getAdapter();
        adapter.setItens(redes);
        adapter.notifyDataSetChanged();
    }


    private void bindButtonCep() {
        btnCep = (Button) findViewById(R.id.btnCep);
        btnCep.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                new GetCep().execute(cep.getText().toString());
            }
        });
    }


    private class GetCep extends AsyncTask<String, Void, Amigo> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Amigo doInBackground(String... params) {
            return AmigoService.getAdressByZipCode(params[0]);
        }

        @Override
        protected void onPostExecute(Amigo amigo) {
            super.onPostExecute(amigo);
            rua.setText(amigo.getRua());
            bairro.setText(amigo.getBairro());
            estado.setText(amigo.getEstado());
            cidade.setText(amigo.getCidade());

        }
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
        btnEmail = (Button) findViewById(R.id.btnEmail);
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToEmailForm = new Intent(CadastroAmigoActivity.this, FormEmailActivity.class);
                startActivity(goToEmailForm);
            }
        });
    }



    private void bindButtonRede() {
        btnRede = (Button) findViewById(R.id.btnRede);
        btnRede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToRedeForm = new Intent(CadastroAmigoActivity.this, FormRedeActivity.class);
                startActivity(goToRedeForm);
            }
        });
    }


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
            case R.id.menu_editEmail:
                editEmail();
                break;
            case R.id.menu_editRede:
                editRede();
                break;
            case R.id.menu_editTel:
                editTel();
                break;
            case R.id.menu_delEmail:
                delEmail();
                break;
            case R.id.menu_delRede:
                delRede();
                break;
            case R.id.menu_delTel:
                delTel();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void delEmail() {
        EmailBusinessService.delete(selectedEmail);
        updateEmailList();
    }

    private void delRede() {
        RedeBusinessService.delete(selectedRede);
        updateRedeList();
    }

    private void delTel() {
        TelefoneBusinessService.delete(selectedTelefone);
        updateTelList();
    }

    private void editTel() {
        Intent goToFormTel = new Intent(CadastroAmigoActivity.this, FormTelActivity.class);
        goToFormTel.putExtra(FormTelActivity.PARAM_TEL, selectedTelefone);
        startActivity(goToFormTel);
    }

    private void editRede() {
        Intent goToFormRede = new Intent(CadastroAmigoActivity.this, FormRedeActivity.class);
        goToFormRede.putExtra(FormRedeActivity.PARAM_REDE, selectedRede);
        startActivity(goToFormRede);
    }

    private void editEmail() {
        Intent goToFormEmail = new Intent(CadastroAmigoActivity.this, FormEmailActivity.class);
        goToFormEmail.putExtra(FormEmailActivity.PARAM_EMAIL, selectedEmail);
        startActivity(goToFormEmail);
    }

    private void addAmigo() {
        bindAmigo();
        AmigoBusinessService.save(amigo);
        Long id = AmigoBusinessService.getIdAmigo(amigo.getNome());
        EmailBusinessService.getEmailNull(id);
        TelefoneBusinessService.getTelNull(id);
        RedeBusinessService.getRedeNull(id);


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
