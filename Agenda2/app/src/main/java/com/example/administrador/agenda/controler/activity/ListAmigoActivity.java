package com.example.administrador.agenda.controler.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import android.widget.ListView;
import android.widget.Toast;

import com.example.administrador.agenda.R;
import com.example.administrador.agenda.controler.activity.adapter.AmigoAdapter;
import com.example.administrador.agenda.model.entidade.Amigo;
import com.example.administrador.agenda.service.AmigoBusinessService;

import java.util.List;

/**
 * Created by Administrador on 02/10/2015.
 */
public class ListAmigoActivity extends AppCompatActivity{
    ListView amigoView;
    Amigo selectedAmigo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_amigo_activity);


        bindListView();
    }


    @Override
    protected void onResume() {
        super.onResume();
        updateListAmigo();
    }

    private void updateListAmigo() {
        List<Amigo> values = AmigoBusinessService.findAll();
        amigoView.setAdapter(new AmigoAdapter(this, values));
        AmigoAdapter adapter = (AmigoAdapter) amigoView.getAdapter();
        adapter.notifyDataSetChanged();

    }

    private void bindListView() {
            amigoView = (ListView) findViewById(R.id.amigoList);
            registerForContextMenu(amigoView);
            amigoView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
            /*Boolean indica se ele consumiu ou nao elemento, senao ele passar pra frente*/
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    AmigoAdapter adapter = (AmigoAdapter) amigoView.getAdapter();
                    selectedAmigo = adapter.getItem(position);
                    return false;
                }
            });
        }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context_amigo_activity, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                onMenuDeleteClick();
                break;
            case R.id.menu_update:
                onMenuEditClick();
                break;
        }

        return super.onContextItemSelected(item);
    }

    private void onMenuDeleteClick() {
        new AlertDialog.Builder(ListAmigoActivity.this).setTitle("Confirm")
                .setMessage("Delete ? ").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                AmigoBusinessService.delete(selectedAmigo);
                selectedAmigo = null;
                String message = "Deletado";
                updateListAmigo();
                Toast.makeText(ListAmigoActivity.this, message, Toast.LENGTH_LONG).show();
            }

        }).setNeutralButton("no", null)
                .create()
                .show();
    }

    private void onMenuEditClick() {
        Intent goToTaskForm = new Intent(ListAmigoActivity.this, CadastroAmigoActivity.class);
        goToTaskForm.putExtra(CadastroAmigoActivity.PARAM_AMIGO, selectedAmigo);
        startActivity(goToTaskForm);
    }

}
