package dmdulliustisolutions.meuapp.Views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import dmdulliustisolutions.meuapp.Controller.EventoDAO;
import dmdulliustisolutions.meuapp.Modelos.Evento;
import dmdulliustisolutions.meuapp.Modelos.EventoAdapter;
import dmdulliustisolutions.meuapp.R;

public class ListaEventosActivity extends AppCompatActivity {

    ListView listViewEventos;
    ArrayList<Evento> listaEventos;
    Evento objEvento;
    Context context = ListaEventosActivity.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_eventos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //layout da tela
        FloatingActionButton fab = findViewById(R.id.fab_ListaEventos);
        listViewEventos = findViewById(R.id.ltv_eventos);


        //criar e popular o array list
        listaEventos = new ArrayList<>();


        //tornando os itens clicaveis


        //instanciar evento e preencher objeto
        objEvento = new Evento("20/04/2019", "Futebol", "", 22);

        atulizaLista();
        listaEventos.add(objEvento);

        //evento de clique float action button
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //abrir a tela de cadastro de eventos
                Intent intent_cadevento = new Intent(context, CadastroEventosActivity.class);
                startActivity(intent_cadevento);

                objEvento = new Evento("25/04/2019", "Aula inaugural de Informática", "", 30);
                listaEventos.add(objEvento);
                atulizaLista();

            }
        });
    }


    public void atulizaLista() {

        EventoAdapter arrayAdapter = new EventoAdapter(this, listaEventos);
        listViewEventos.setAdapter(arrayAdapter);

        EventoDAO objEventoDao = new EventoDAO(context);
        ArrayList<Evento> lista = objEventoDao.buscarTodos();

    }


}
