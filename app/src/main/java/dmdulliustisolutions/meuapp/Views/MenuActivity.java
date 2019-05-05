package dmdulliustisolutions.meuapp.Views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import dmdulliustisolutions.meuapp.Ferramentas.Msg;
import dmdulliustisolutions.meuapp.R;

public class MenuActivity extends AppCompatActivity {

    Button opcaoMain, opcaoCalc, opcaoMegaSena, opcaoListaEventos;
    Context context = MenuActivity.this;
    TextView txt_titulo, txt_nomeUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //layout da tela
        opcaoMain = findViewById(R.id.btn_menu_main);
        opcaoCalc = findViewById(R.id.btn_menu_calc);
        opcaoMegaSena = findViewById(R.id.btn_menu_mega_sena);
        txt_titulo = findViewById(R.id.txt_titulo_mn);
        txt_nomeUsuario = findViewById(R.id.txt_nomeUsuario);
        opcaoListaEventos = findViewById(R.id.btn_menu_ListaEventos);


        //evento de clique botão tela main
        opcaoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_main = new Intent(context, MenuActivity.class);
                startActivity(intent_main);
                finish();//finaliza a intent atual
            }
        });

        //evento de clique botao calculadora
        opcaoCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_calc = new Intent(context, CalculadoraActivity.class);
                startActivity(intent_calc);

            }
        });

        //evento de clique botao mega sena
        opcaoMegaSena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_mega_sena = new Intent(context, Mega_senaActivity.class);
                startActivity(intent_mega_sena);
                Msg.toast_login(context, "✅ Estes podem ser seus numeros da sorte!!! ", 0);
            }
        });

        //evento de clique botao lista eventos
        opcaoListaEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_ListaEventos = new Intent(context, ListaEventosActivity.class);
                startActivity(intent_ListaEventos);
                Msg.toast_padrao(context, "\uD83D\uDCC6 Cadastre ou Edite seus eventos aqui:", 0);

            }
        });
    }
}
