package dmdulliustisolutions.meuapp.Views;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import dmdulliustisolutions.meuapp.R;

public class Mega_senaActivity extends AppCompatActivity {
    //define a  activity em que as mensagens serão exibidas
    Context context = Mega_senaActivity.this;

    //componentes graficos
    TextView textView_mega_sena, nomeUsuario;
    Button btn_mega_sena;
    CheckBox Mais_sorteados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mega_sena);

        //layout da tela
        btn_mega_sena = findViewById(R.id.btn_mega_sena_gerar);
        textView_mega_sena = findViewById(R.id.txt_titulo_mostra_numeros);
        nomeUsuario = findViewById(R.id.lbl_nomeUsuario_ms);
        Mais_sorteados = findViewById(R.id.Mais_Sorteados);


        //evento de clique botao mega sena

        btn_mega_sena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gera os números e armazena no array
                int numero;

                Random randomico = new Random();

                //lista de numeros mais sorteados da historia da mega-sena
                List<Integer> MaisSorteados = new ArrayList<Integer>(Arrays.asList(10, 5, 53, 4, 54, 23, 33, 24, 51, 17, 42, 52, 27, 28, 30, 37, 43, 34, 6, 13, 56, 32,
                        44, 2, 16, 29, 36, 41, 18, 35, 50));

                //lista que vai exibir os numeros para a aposta
                List<Integer> exibeNumerosAposta = new ArrayList<>();

                //gerar aposta com os numeros mais sorteados
                List<Integer> ApostaMaisSorteados = new ArrayList<Integer>(6);


                //while para testar se o numero  gerado esta na lista de mais sorteados
                while (exibeNumerosAposta.size() < 6) {
                    numero = randomico.nextInt(60) + 1;

                    //teste condicional
                    if (MaisSorteados.contains(numero) == true) {

                        if (exibeNumerosAposta.contains(numero) == false) {
                            exibeNumerosAposta.add(numero);
                        }

                    }
                }
                if (Mais_sorteados.isChecked()) {
                    //while para aposta com numeros mais sorteados
                    while (ApostaMaisSorteados.size() < 6) {
                        numero = randomico.nextInt(60) + 1;
                        if (MaisSorteados.contains(numero) == true) {
                            if (ApostaMaisSorteados.contains(numero) == false)
                                ApostaMaisSorteados.add(numero);
                        }
                    }
                    Collections.sort(ApostaMaisSorteados);
                    textView_mega_sena.setText("      Sua Aposta é                        " + ApostaMaisSorteados.toString());
                } else {
                    Collections.sort(exibeNumerosAposta);
                    textView_mega_sena.setText("      Sua Aposta é                        " + exibeNumerosAposta.toString());
                }
            }
        });


    }

}