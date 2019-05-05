package dmdulliustisolutions.meuapp.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import dmdulliustisolutions.meuapp.Database.DbOpenHelper_evento;
import dmdulliustisolutions.meuapp.Database.DbOpenHelper_evento.*;
import dmdulliustisolutions.meuapp.Ferramentas.Msg;
import dmdulliustisolutions.meuapp.Modelos.Evento;


public class EventoDAO {

    Evento evento;
    private static SQLiteDatabase conexao;
    Context context;
    private String TAG = "EventoDAO";


    public EventoDAO(Context ctx) {

        DbOpenHelper_evento db = new DbOpenHelper_evento(ctx);
        conexao = db.getWritableDatabase();

    }


    public boolean inserir(Evento evento) {
        try {
            ContentValues valores = new ContentValues();
            valores.put("nome", evento.getTitulo());
            valores.put("data", evento.getData());
            valores.put("descricao", evento.getDescricao());
            valores.put("vagas", evento.getVagas());

            long result = conexao.insertOrThrow(DbOpenHelper_evento.TABELA_EVENTOS, null, valores);

            if (result > 0) {
                Log.i(TAG, "Registro excluído com Sucesso");
                return true;
            }


            return false;

        } catch (SQLException ex) {
            Msg.ultimoErro = ex.getMessage();
            Log.e(TAG, ex.getMessage());
            return false;
        }

    }

    public boolean excluir(int codigo) {

        try {


            String[] parametros = new String[1];

            parametros[0] = String.valueOf(codigo);


            int result = conexao.delete(DbOpenHelper_evento.TABELA_EVENTOS, "codigo = ?", parametros);
            if (result > 0) {
                Log.i(TAG, "Registro excluído com Sucesso");
                return true;
            }

            return false;
        } catch (SQLException ex) {

            Log.e(TAG, ex.getMessage());

            Msg.toast_padrao(context, "O ultimo erro foi: " + Msg.ultimoErro, 0);

            return false;

        }


    }


    public boolean alterar(Evento evento) {
        try {

            ContentValues valores = new ContentValues();

            valores.put("nome", evento.getTitulo());
            valores.put("data", evento.getData());
            valores.put("descricao", evento.getDescricao());
            valores.put("vagas", evento.getVagas());


            String[] parametros = new String[1];

            parametros[0] = String.valueOf(evento.getId());


            long result = conexao.update(DbOpenHelper_evento.TABELA_EVENTOS, valores, "codigo = ? ", parametros);

            if (result < 0) {
                Log.i(TAG, "Registro alterado com sucesso!!!");
                return true;
            } else if (result > 0) {
                return false;

            }
            return false;
        } catch (SQLException ex) {
            Log.e(TAG, ex.getMessage());
            Msg.toast_padrao(context, "O ultimo erro foi: " + Msg.ultimoErro, 0);
            return false;
        }


        /*public ArrayList<Evento> buscarTodos(){
            ArrayList<Evento> lista = new ArrayList<Evento>();


            StringBuilder sql = new StringBuilder();

            sql.append("SELECT codigo, nome FROM " + DbOpenHelper_evento.TABELA_EVENTOS);


            Cursor resultado = conexao.rawQuery(sql.toString(), null);


            if (resultado.getCount() > 0) {

                resultado.moveToFirst();


                do {

                    evento = new Evento();

                    evento.setId(resultado.getInt(resultado.getColumnIndexOrThrow("codigo")));

                    evento.setTitulo(resultado.getString(resultado.getColumnIndexOrThrow("nome")));


                    lista.add(evento);


                } while (resultado.moveToNext());

            }


        }

    }




        public Evento buscarEvento ( int codigo){


            evento = new Evento();


            StringBuilder sql = new StringBuilder();

            sql.append(" SELECT codigo, nome FROM " + DbOpenHelper_evento.TABELA_EVENTOS);

            sql.append(" WHERE codigo = " + codigo);


            Cursor resultado = conexao.rawQuery(sql.toString(), null);

            if (resultado.getCount() > 0) {

                resultado.moveToFirst();


                evento.setId(resultado.getInt(resultado.getColumnIndex("codigo")));

                evento.setTitulo(resultado.getString(resultado.getColumnIndex("nome")));


            }*/


    }

}
