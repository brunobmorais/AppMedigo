package com.jp.agendaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    //Componentes
    private ImageView imgBack;
    private Button btnEntrar;
    private AutoCompleteTextView txvEmail, txvSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //AutoCompleteTextView
        txvEmail = findViewById(R.id.txvEmail);
        txvSenha = findViewById(R.id.txvSenha);
        txvSenha.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i == EditorInfo.IME_ACTION_GO) {
                    btnEntrar.performClick();
                    return true;
                }
                return false;
            }
        });


        //ImageView
        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Finaliza Activity
                finish();
                overridePendingTransition(R.anim.animacao_vertical2_in, R.anim.animacao_vertical2_out);

            }
        });

        //Button
        btnEntrar = findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!campoVazio(txvEmail))
                    if(!campoVazio(txvSenha))
                        //Incializa activity
                        startActivity(new Intent(LoginActivity.this,ConsultasActivity.class));
                //Finaliza Activity
                finish();
                overridePendingTransition(R.anim.animacao_vertical_in, R.anim.animacao_vertical_out);

            }
        });
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
