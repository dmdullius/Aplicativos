package dmdulliustisolutions.meuapp.Ferramentas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbOpenHelper_evento extends SQLiteOpenHelper {

    private static final String NM_BANCO = "cadastro_eventos";
    private static final int VERSION = 1;
    private static final String TABELA_EVENTOS = "eventos";

    public DbOpenHelper_evento(Context context) {
        super(context, NM_BANCO, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Cria as tabelas do banco de dados
        StringBuilder sql = new StringBuilder();
        sql.append(" CREATE TABLE IF NOT EXISTS " + TABELA_EVENTOS + "( ");
        sql.append(" id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sql.append(" titulo VARCHAR(50) NOT NULL DEFAULT (''), ");
        sql.append(" descricao VARCHAR(100) NOT NULL DEFAULT (''), ");
        sql.append(" data VARCHAR(12) NOT NULL DEFAULT (''), ");
        sql.append(" vagas INTEGER NOT NULL DEFAULT ('') ");


        sql.append(" ); ");

        db.execSQL(sql.toString());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table eventos;");
        onCreate(db);
    }
}