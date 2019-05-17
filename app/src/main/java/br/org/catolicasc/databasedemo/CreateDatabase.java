package br.org.catolicasc.databasedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.http.SslCertificate;

public class CreateDatabase extends SQLiteOpenHelper {


    public static final String DName = "library.db";
    public static final String ID = "_id";
    public static final String NOME = "nome";
    public static final String IDADE = "idade";
    public static final String LEOCO = "leoco";
    public static final String GLICEMIA = "glicemia";
    public static final String AST = "ast";
    public static final String LDH = "lhd";
    public static final String TABLE = "book";

    private static final int VERSION = 1;

    public CreateDatabase(Context context) {
        super(context, DName, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE + " ( "
                + "_id int primary key autoincrement, " +
                "nome string, " +
                "idade int, " +
                "leoco int," +
                "glicemia int,"+
                "ast int," +
                "ldh int"+
        ")";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }
}
