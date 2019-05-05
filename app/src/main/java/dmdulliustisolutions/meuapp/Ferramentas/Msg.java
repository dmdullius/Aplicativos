package dmdulliustisolutions.meuapp.Ferramentas;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/* aqui estarão todos os metodos auxiliares,
afim de reduzir o numeros de linhas de codigo
e aumentar a produtividade. :-D */


public class Msg {
    public static String ultimoErro;

    //metodo generico para exibir mensagens personalizadas
    public static void toast_padrao(Context c, String s, int tempo) {
        Toast.makeText(c, s, tempo).show();

    }

    //metodo generico para exibir mensagens pré-definidas para telas de login
    public static void toast_login(Context c, String s, int tempo) {
        Toast t = Toast.makeText(c, s,
                tempo);
        t.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
        t.show();
    }

    //metodo generico para exibir mensagens pré-definidas para telas principais
    public static void toast_Main(Context c, String s, int tempo) {
        Toast t = Toast.makeText(c, s,
                tempo);
        t.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
        t.show();
    }


}

