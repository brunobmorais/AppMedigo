package com.jp.agendaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class CadastroActivity extends AppCompatActivity {
    //Componentes
    private AutoCompleteTextView txvNome, txvEmail, txvSenha;
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
        txvSenha = findViewById(R.id.txvSenha);

        //Button
        btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        list = new ArrayList<>();
        list.addAll(Arrays.asList(getResources().getStringArray(R.array.genero)));

        //Spinner
        spnGenero = findViewById(R.id.spnGenero);
        adapter = new ArrayAdapter(this, R.layout.layout_spinner_item, list);
        spnGenero.setAdapter(adapter);
    }
}
