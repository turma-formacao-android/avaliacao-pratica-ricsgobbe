package com.example.administrador.agenda.controlers.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.administrador.agenda.R;

import java.util.List;

/**
 * Created by Administrador on 01/10/2015.
 */
public class FormEmailActivity extends AppCompatActivity {

    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_form_telefone);
        bindEmail1();


    }

    private void bindEmail1() {
        email = (EditText) findViewById(R.id.editTxtEmail1);
        email.setText("");
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

    }

}
