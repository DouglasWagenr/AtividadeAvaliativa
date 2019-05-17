package br.org.catolicasc.databasedemo;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvPacientes = findViewById(R.id.lvPacientes);




        DAL dal = new DAL(this);
        final Cursor cursor = dal.loadAll();

        String[] fields = new String[] {CreateDatabase.IDADE, CreateDatabase.NOME};
        int[] ids = {R.id.etIdade, R.id.etNome};



        //Log.d(TAG, "onCreate: id " + cursor.getInt(0) + " title " + cursor.getString(1));
        Log.d(TAG, "onCreate: " + cursor.getCount());
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(MainActivity.this,
                R.layout.activity_main, cursor, fields, ids, 0);



        lvPacientes.setAdapter(adapter);

        lvPacientes.setAdapter(adapter);
        Button btAdicionar = findViewById(R.id.btCadastrar);
        btAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DadosPacientes.class);
                startActivity(intent);
            }
        });


        lvPacientes.setAdapter(adapter);
        lvPacientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DadosPacientes.class);
                EditText etNome = findViewById(R.id.etNome);
                EditText etIdade = findViewById(R.id.etIdade);
                EditText etLeoco = findViewById(R.id.etLeoco);
                EditText etGlicemia = findViewById(R.id.etGlicemia);
                EditText etAst = findViewById(R.id.etAst);
                EditText etLdh = findViewById(R.id.etLdh);

                etNome.setText(toString());
                startActivity(intent);
            }

        });
        }
}
