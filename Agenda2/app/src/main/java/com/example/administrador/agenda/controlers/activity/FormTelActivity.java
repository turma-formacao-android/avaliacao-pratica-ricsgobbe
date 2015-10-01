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
public class FormTelActivity extends AppCompatActivity {
    private EditText tel1;
  

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_form_telefone);
        bindTel1();

    }

    private void bindTel1() {
        tel1 = (EditText) findViewById(R.id.editTxtTelefone1);
        tel1.setText("");
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
