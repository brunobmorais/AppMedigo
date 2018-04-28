package com.jp.agendaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {
    //Componentes
    private Button btnFacebook, btnConta;
    private TextView txvEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Button
        btnFacebook = findViewById(R.id.btnFacebook);
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PrincipalActivity.this,ConsultasActivity.class));
                overridePendingTransition(R.anim.animacao_horizontal_in, R.anim.animacao_horizontal_out);
            }
        });

        btnConta = findViewById(R.id.btnConta);
        btnConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PrincipalActivity.this, CadastroActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animacao_vertical_in, R.anim.animacao_vertical_out);

            }
        });

        //TextView
        txvEntrar = findViewById(R.id.txvEntrar);
        txvEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PrincipalActivity.this, LoginActivity.class));
                overridePendingTransition(R.anim.animacao_vertical_in, R.anim.animacao_vertical_out);

            }
        });
    }
}
