package dmdulliustisolutions.meuapp.Views;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import dmdulliustisolutions.meuapp.R;

public class CalculadoraActivity extends AppCompatActivity {
    //declaração dos conponentes da tela e context
    Context context = CalculadoraActivity.this;

    TextView txtv_titulo, exibeResultado;

    EditText edt_entrada_resultado;

    Button btn_adiciona, btn_subtrai, btn_igual, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6,
            btn_7, btn_8, btn_9, btn_0, btn_ponto, btn_virgula, btn_C, btn_x, btn_dividir;

    int numeroMemoria = 0, numeroAtual, numeroMemoriaAnterior;

    //grava a operacao selecionada
    String operacaoMemoria = "";

    //recebe o resultado
    int resultado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        //layout da tela
        txtv_titulo = findViewById(R.id.txt_titulo_calculadora);

        edt_entrada_resultado = findViewById(R.id.resultado_entrada_calculadora);

        btn_adiciona = findViewById(R.id.btn_adiciona_calculadora);
        btn_subtrai = findViewById(R.id.btn_subtrai_calculadora);
        btn_igual = findViewById(R.id.btn_igual_calculadora);
        btn_1 = findViewById(R.id.btn_1_calculadora);
        btn_2 = findViewById(R.id.btn_2_calculadora);
        btn_3 = findViewById(R.id.btn_3_calculadora);
        btn_4 = findViewById(R.id.btn_4_calculadora);
        btn_5 = findViewById(R.id.btn_5_calculadora);
        btn_6 = findViewById(R.id.btn_6_calculadora);
        btn_7 = findViewById(R.id.btn_7_calculadora);
        btn_8 = findViewById(R.id.btn_8_calculadora);
        btn_9 = findViewById(R.id.btn_9_calculadora);
        btn_0 = findViewById(R.id.btn_0_calculadora);
        btn_virgula = findViewById(R.id.btn_virgula_calculadora);
        btn_ponto = findViewById(R.id.btn_ponto_calculadora);
        btn_C = findViewById(R.id.btn_C_calculadora);
        btn_dividir = findViewById(R.id.btn_dividir_calculadora);
        btn_x = findViewById(R.id.btn_X_calculadora);

        //evento de clique botao adicionar
        btn_adiciona.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                if (edt_entrada_resultado.getText().toString().equals("")) {
                    numeroAtual = 0;
                    edt_entrada_resultado.setText("");
                }
                numeroAtual = Integer.parseInt(edt_entrada_resultado.getText().toString());
                operacaoMemoria = "+";
                if (operacaoMemoria.equals("+")) {
                    resultado = numeroMemoria + numeroAtual;
                    edt_entrada_resultado.setText(String.valueOf(resultado));
                    numeroMemoria = resultado;
                    btn_adiciona.setVisibility(View.INVISIBLE);
                    btn_subtrai.setVisibility(View.INVISIBLE);
                    btn_x.setVisibility(View.INVISIBLE);
                    btn_dividir.setVisibility(View.INVISIBLE);
                }
            }
        });

        //requisita o foco
        edt_entrada_resultado.requestFocus();

        //evento de clique botao subitrair
        btn_subtrai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacaoMemoria = "-";
                if (edt_entrada_resultado.getText().toString().equals("")) {
                    edt_entrada_resultado.setText("0");
                }
                numeroAtual = Integer.parseInt(edt_entrada_resultado.getText().toString());
                if (operacaoMemoria.equals("-")) {
                    resultado = numeroMemoria - numeroAtual;
                    edt_entrada_resultado.setText(String.valueOf(resultado));
                    numeroMemoria = resultado;
                }
                btn_adiciona.setVisibility(View.INVISIBLE);
                btn_subtrai.setVisibility(View.INVISIBLE);
                btn_x.setVisibility(View.INVISIBLE);
                btn_dividir.setVisibility(View.INVISIBLE);


            }
        });

        //evento de clique botão X
        btn_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacaoMemoria = "x";
                if (edt_entrada_resultado.getText().toString().equals("")) {
                    edt_entrada_resultado.setText("0");
                }
                numeroAtual = Integer.parseInt(edt_entrada_resultado.getText().toString());
                if (operacaoMemoria.equals("x")) {
                    resultado = numeroMemoria * numeroAtual;
                    edt_entrada_resultado.setText(String.valueOf(resultado));
                    numeroMemoria = resultado;
                }
                btn_adiciona.setVisibility(View.INVISIBLE);
                btn_subtrai.setVisibility(View.INVISIBLE);
                btn_x.setVisibility(View.INVISIBLE);
                btn_dividir.setVisibility(View.INVISIBLE);
            }
        });

        //evento de clique botao dividir

        btn_dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacaoMemoria = "/";
                if (edt_entrada_resultado.getText().toString().equals("")) {
                    edt_entrada_resultado.setText("0");
                }
                numeroAtual = Integer.parseInt(edt_entrada_resultado.getText().toString());
                if (operacaoMemoria.equals("/")) {
                    resultado = numeroMemoria / numeroAtual;
                    edt_entrada_resultado.setText(String.valueOf(resultado));
                    numeroMemoria = resultado;
                }
                btn_adiciona.setVisibility(View.INVISIBLE);
                btn_subtrai.setVisibility(View.INVISIBLE);
                btn_x.setVisibility(View.INVISIBLE);
                btn_dividir.setVisibility(View.INVISIBLE);
            }
        });


        //evento de clique botao igual
        btn_igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_entrada_resultado.getText().toString().equals("")) {
                    numeroAtual = 0;
                    edt_entrada_resultado.setText("");
                }
                numeroAtual = Integer.parseInt(edt_entrada_resultado.getText().toString());

                if (operacaoMemoria.equals("+")) {
                    resultado = numeroMemoria + numeroAtual;
                    edt_entrada_resultado.setText(String.valueOf(resultado));
                    numeroMemoria = resultado;
                } else if (operacaoMemoria.equals("-")) {
                    if (edt_entrada_resultado.getText().toString().equals("")) {
                        edt_entrada_resultado.setText("0");
                    }
                    numeroAtual = Integer.parseInt(edt_entrada_resultado.getText().toString());
                    if (operacaoMemoria.equals("-")) {
                        resultado = numeroMemoria - numeroAtual;
                        edt_entrada_resultado.setText(String.valueOf(resultado));
                        numeroMemoria = resultado;
                    }
                    btn_adiciona.setVisibility(View.INVISIBLE);
                    btn_subtrai.setVisibility(View.INVISIBLE);
                    btn_x.setVisibility(View.INVISIBLE);
                    btn_dividir.setVisibility(View.INVISIBLE);

                }
                btn_subtrai.setVisibility(View.VISIBLE);
                btn_adiciona.setVisibility(View.VISIBLE);
                btn_x.setVisibility(View.VISIBLE);
                btn_dividir.setVisibility(View.VISIBLE);
            }
        });

        //eventos de clique botoes calculadora
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_entrada_resultado.setText("7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_entrada_resultado.setText("8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_entrada_resultado.setText("9");
            }
        });

        btn_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_entrada_resultado.setText("");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_entrada_resultado.setText("4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_entrada_resultado.setText("5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_entrada_resultado.setText("6");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_entrada_resultado.setText("1");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_entrada_resultado.setText("2");
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_entrada_resultado.setText("3");
            }
        });

        btn_ponto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_entrada_resultado.setText(".");
            }
        });

        btn_virgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_entrada_resultado.setText(",");
            }
        });


    }
}
