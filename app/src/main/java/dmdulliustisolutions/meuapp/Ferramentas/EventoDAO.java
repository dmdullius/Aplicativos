package dmdulliustisolutions.meuapp.Ferramentas;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import dmdulliustisolutions.meuapp.Database.DbOpenHelper_evento;
import dmdulliustisolutions.meuapp.Modelos.Evento;


public class EventoDAO {

    private static final String TABELA = "eventos";
    private static SQLiteDatabase conexao;
    Context context;
    private String TAG;


    public EventoDAO(Context ctx) {

        DbOpenHelper_evento db = new DbOpenHelper_evento(ctx);

        conexao = db.getWritableDatabase();

    }


    public void inserir(Evento evento) {
        try {
            ContentValues valores = new ContentValues();
            valores.put("nome", evento.getNome());
            valores.put("data", evento.getData());
            valores.put("descricao", evento.getDescricao());
            valores.put("vagas", evento.getVagas());
            valores.put("id", evento.getId());


            conexao.insertOrThrow(TABELA, null, valores);


        } catch (SQLException ex) {

        }

    }

    public boolean excluir(int codigo) {

        try {


            String[] parametros = new String[1];

            parametros[0] = String.valueOf(codigo);


            conexao.delete(TABELA, "codigo = ?", parametros);

            Log.i(TAG, "Excluído com Sucesso");
        } catch (SQLException ex) {

            Log.e(TAG, ex.getMessage());

            Msg.toast_padrao(context, "O ultimo erro foi: " + Msg.ultimoErro, 0);

            return false;

        }


        return true;


    }


    public void alterar(Evento evento) {


        ContentValues valores = new ContentValues();

        valores.put("nome", evento.getNome());


        String[] parametros = new String[1];

        parametros[0] = String.valueOf(evento.getId());


        conexao.update(TABELA, valores, "codigo = ? ", parametros);


    }


    public ArrayList<Evento> buscarTodos() {


        ArrayList<Evento> lista = new ArrayList<Evento>();


        return lista;


    }


}