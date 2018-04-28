package com.jp.agendaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class CadastroActivity extends AppCompatActivity {
    //Componentes
    private AutoCompleteTextView txvNome, txvEmail, txvCidade, txvSenha;
    private ImageView imgBack;
    private Spinner spnGenero;
    private Button btnSalvar;

    //Variaveis
    private ArrayAdapter adapter;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //AutoCompleteTextView
        txvNome = findViewById(R.id.txvNome);
        txvEmail = findViewById(R.id.txvEmail);
        txvCidade = findViewById(R.id.txvCidade);
        txvSenha = findViewById(R.id.txvSenha);

        //Button
        btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!campoVazio(txvNome))
                    if(!campoVazio(txvEmail))
                        if(!campoVazio(txvCidade))
                            if(!campoVazio(txvSenha)) {
                                Toast.makeText(CadastroActivity.this, "Sucesso", Toast.LENGTH_SHORT).show();
                                finish();
                                overridePendingTransition(R.anim.animacao_vertical2_in, R.anim.animacao_vertical2_out);

                            }

            }
        });

        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.animacao_vertical2_in, R.anim.animacao_vertical2_out);

            }
        });

        list = new ArrayList<>();
        list.addAll(Arrays.asList(getResources().getStringArray(R.array.genero)));

        //Spinner
        spnGenero = findViewById(R.id.spnGenero);
        adapter = new ArrayAdapter(this, R.layout.layout_spinner_item, list);
        spnGenero.setAdapter(adapter);
    }

    private boolean campoVazio(TextView textView) {
        if(textView.getText().toString().equals("")) {
            textView.setError("campo vazio");
            textView.requestFocus();
            return true;
        }
        return false;
    }
}
