package com.example.administrador.agenda.controler.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.administrador.agenda.R;
import com.example.administrador.agenda.model.entidade.Email;
import com.example.administrador.agenda.service.EmailBusinessService;

/**
 * Created by Administrador on 01/10/2015.
 */
public class FormEmailActivity extends AppCompatActivity {

    public final String PARAM_EMAIL = "email";
    private EditText emailTxt;
    Email email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_form_email);
        iniEmail();
        bindEmailTxt();


    }

    private void bindEmailTxt() {
        emailTxt = (EditText) findViewById(R.id.editTxtEmail);
        emailTxt.setText(email.getEmail() == null ? "" : email.getEmail() );
    }


    private void bindEmail() {
        email.setEmail(emailTxt.getText().toString() == null ? "" : emailTxt.getText().toString());
        email.setIdAmigo(null);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_email, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_addEmail:
                addEmail();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addEmail() {
        bindEmail();
        EmailBusinessService.save(email);
        this.finish();
    }

    private void iniEmail() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.email = getIntent().getExtras().getParcelable(PARAM_EMAIL);
        }
        this.email = this.email == null ? new Email() : email;
    }

}
