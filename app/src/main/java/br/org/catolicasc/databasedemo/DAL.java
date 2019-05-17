package br.org.catolicasc.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.zip.CRC32;

public class DAL {
    private static final String TAG = "DAL";

    private SQLiteDatabase db;
    private CreateDatabase database;

    public DAL(Context context) {
        database = new CreateDatabase(context);
    }

    public boolean insert(String nome, String idade, String leoco, String glicemia, String ast, String ldh) {
        ContentValues values;
        long result;

        db = database.getWritableDatabase();
        values = new ContentValues();
        values.put(CreateDatabase.NOME,nome);
        values.put(CreateDatabase.IDADE, idade);
        values.put(CreateDatabase.LEOCO, leoco);
        values.put(CreateDatabase.GLICEMIA, glicemia);
        values.put(CreateDatabase.AST, ast);
        values.put(CreateDatabase.LDH, ldh);

        result = db.insert(CreateDatabase.NOME, null, values);
        db.close();


        if (result == -1) {
            Log.e(TAG, "insert: Erro inserindo registro");
            return false;
        }

        return true;
    }

    public Cursor loadAll() {
        Cursor cursor;
        String [] fields = {CreateDatabase.ID, CreateDatabase.NOME};
        db = database.getReadableDatabase();

        // SELECT _id, title FROM book
        // String sql = "SELECT _id, title FROM book";
        //cursor = db.rawQuery(sql, null);
        cursor = db.query(CreateDatabase.TABLE, fields, null,
                null, null, null,
                null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }
}
