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


public class MainActivity extends AppCompatActivity {

    //componentes graficos
    Button btn_numero;
    TextView txtV_numero, nomeUsuario;

    //gera os números
    double numero;

    //define activity em que as mensagens devem aparecer
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;

        //layout da tela
        btn_numero = findViewById(R.id.btn_numero);
        txtV_numero = findViewById(R.id.lbl_txtV);


        //verifica se possui extras
        Intent extras = getIntent();//captura os extras
        if (extras.hasExtra("login_main")) {
            String userName = extras.getStringExtra("login_main");
            nomeUsuario.setText("Usuário Conectado: " + userName);
        } else {

        }

        //evento de clique botão "gerar numero"
        btn_numero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //recebe o valor a ser usado para limitar a quantidade de numeros gerados
                int maximo = 100;

                //gera os números
                numero = (int) (Math.random() * maximo);

                //exibe na tela os numeros gerados(um por vez)
                txtV_numero.setText("Número Gerado: " + (int) numero);

                //exibe mensagem na tela
                Msg.toast_Main(context, "número gerado com sucesso \uD83D\uDC4D \uD83D\uDE09 ", 1);
            }
        });


    }
}
