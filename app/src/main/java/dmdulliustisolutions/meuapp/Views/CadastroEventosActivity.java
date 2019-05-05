package dmdulliustisolutions.meuapp.Views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import dmdulliustisolutions.meuapp.Ferramentas.EventoDAO;
import dmdulliustisolutions.meuapp.Modelos.Evento;
import dmdulliustisolutions.meuapp.R;

public class CadastroEventosActivity extends AppCompatActivity {
    TextView dataEvento, tituloEvento, descricaoEvento, idEvento, vagasEvento;
    EditText edt_idEvento, edt_vagasEvento, edt_dataEvento, edt_tituloEvento, edt_descricaoEvento;
    Button btn_cadastra, btn_cancela;
    Context context = CadastroEventosActivity.this;
    Evento objEvento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_eventos);

        //layout da tela
        dataEvento = findViewById(R.id.txt_data_evento);
        tituloEvento = findViewById(R.id.txt_titulo_evento);
        descricaoEvento = findViewById(R.id.txt_descricao_evento);
        idEvento = findViewById(R.id.txt_id_evento);
        vagasEvento = findViewById(R.id.txt_vagas_evento);
        edt_dataEvento = findViewById(R.id.edt_data_evento);
        edt_descricaoEvento = findViewById(R.id.edt_descricao_evento);
        edt_idEvento = findViewById(R.id.edt_id_evento);
        edt_tituloEvento = findViewById(R.id.edt_titulo_evento);
        edt_descricaoEvento = findViewById(R.id.edt_descricao_evento);
        btn_cadastra = findViewById(R.id.btn_cadastra_evento);
        btn_cancela = findViewById(R.id.btn_cancelar_evento);


//evento de clique botao cadastro

        btn_cadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EventoDAO conecta = new EventoDAO(CadastroEventosActivity.this);
                objEvento = new Evento("02/05/2019", "Evento 4", "teste", 20);
                conecta.inserir(objEvento);
            }
        });

//evento de clique botão cancela
        btn_cancela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_menu = new Intent(context, MenuActivity.class);


                startActivity(intent_menu);

                //finaliza a intent atual
                finish();
            }
        });
    }
}