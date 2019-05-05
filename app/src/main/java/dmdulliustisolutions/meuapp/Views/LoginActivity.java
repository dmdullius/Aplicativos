package dmdulliustisolutions.meuapp.Views;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import dmdulliustisolutions.meuapp.Ferramentas.Msg;
import dmdulliustisolutions.meuapp.R;

public class LoginActivity extends AppCompatActivity {
    //componentes graficos
    EditText edt_usr_name, edt_senha;
    Button btn_login;
    CheckBox cb_megaSena;
    SharedPreferences sharedPreferences;
    String Usuario;


    //define a activity que vai exibir as mensagens
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        context = LoginActivity.this;


        //layout da tela
        edt_usr_name = findViewById(R.id.txtLogin_usuario);
        edt_senha = findViewById(R.id.txtSenha_usuario);
        btn_login = findViewById(R.id.btnLogin_usuario);


        //capturar shared preferences
        sharedPreferences = getSharedPreferences("padrao", MODE_PRIVATE);
        final String sharedUsuario = sharedPreferences.getString("usuario", "");
        edt_usr_name.setText(sharedUsuario);


        //evento de clique "btn_login"
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String senha_user = String.valueOf(edt_senha.getText());
                String user = String.valueOf(edt_usr_name.getText());
                if (senha_user.equals(getString(R.string.senhaUsuario)) && user.toLowerCase().equals(getString(R.string.nomeUsuario))) {

                    //armazena no shared preferences
                    sharedPreferences = getSharedPreferences("padrao", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("usuario", edt_usr_name.getText().toString());
                    editor.apply();
                    Usuario = edt_usr_name.getText().toString();

                    //verifica se a check box "mega sena" esta marcada


                    //se a check box "mega sena" esta marcada cria a intent para exibir a activity Mega_senaActivity

                    Intent intent_menu = new Intent(context, MenuActivity.class);


                    intent_menu.putExtra("login_main", Usuario);
                    startActivity(intent_menu);

                    //finaliza a intent atual
                    finish();

                    //exibe mensgem de boas vindas
                    Msg.toast_login(context, "✅ Bem Vindo " + edt_usr_name.getText(), 0);
                } else {
                    //informa o usuario que a senha ou o usuario não estão corretos
                    Msg.toast_padrao(context, "⛔ Usúario ou senha incorretos, verifique e tente novamente", 0);
                }

            }

        });

    }
}



