package dmdulliustisolutions.meuapp.Modelos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import dmdulliustisolutions.meuapp.R;
import dmdulliustisolutions.meuapp.Views.CadastroEventosActivity;


public class EventoAdapter extends ArrayAdapter<Evento> {

    private final Context context;
    private final ArrayList<Evento> elementos;


    public EventoAdapter(Context context, ArrayList<Evento> elementos) {
        super(context, R.layout.item_lista_eventos, elementos);
        this.context = context;
        this.elementos = elementos;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final Evento objEvento = elementos.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //toda vez que passa por um item da lista, os elementos são associados
        View rowView = inflater.inflate(R.layout.item_lista_eventos, parent, false);

        TextView lblData = rowView.findViewById(R.id.lblData_itemEvento);
        TextView lblVagas = rowView.findViewById(R.id.lblVagas_itemEvento);
        TextView lblTitulo = rowView.findViewById(R.id.lblTitulo_itemEvento);

        //codigo.setText(elementos.get(position).getId() + "");
        lblData.setText(objEvento.getData());
        lblVagas.setText("Total Vagas = " + objEvento.getVagas());
        lblTitulo.setText(objEvento.getNome());

        //clique na linha do ListView
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nova_tela = new Intent(context, CadastroEventosActivity.class);
                nova_tela.putExtra("codigo_evento", String.valueOf(objEvento.getId()));
                context.startActivity(nova_tela);
            }
        });

        return rowView;
    }
}