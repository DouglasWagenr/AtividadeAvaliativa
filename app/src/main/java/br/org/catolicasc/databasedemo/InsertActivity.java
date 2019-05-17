package br.org.catolicasc.databasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        Button btCadastrar = findViewById(R.id.btCadastrar);

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                DAL dal = new DAL(InsertActivity.this);
                EditText etNome = findViewById(R.id.etNome);
                EditText etIdade = findViewById(R.id.etIdade);
                EditText etLeoco = findViewById(R.id.etLeoco);
                EditText etGlicemia = findViewById(R.id.etGlicemia);
                EditText etAst = findViewById(R.id.etAst);
                EditText etLdh = findViewById(R.id.etLdh);

                String nome = etNome.getText().toString();
                String idade = etIdade.getText().toString();
                String leoco = etLeoco.getText().toString();
                String glicemia = etGlicemia.getText().toString();
                String ast = etAst.getText().toString();
                String ldh = etLdh.getText().toString();

                if (dal.insert(nome, idade, leoco, glicemia, ast, ldh)) {
                    Toast.makeText(InsertActivity.this,
                            "Registro Inserido com sucesso!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(InsertActivity.this,
                            "Erro ao inserir registro!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

