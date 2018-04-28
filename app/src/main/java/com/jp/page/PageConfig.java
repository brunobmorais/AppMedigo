package com.jp.page;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;


import com.facebook.login.LoginManager;
import com.jp.agendaapp.R;

/**
 * Created by Bruno Morais2 on 05/12/2017.
 */

public class PageConfig extends Fragment {

    public View view;
    public LinearLayout lytMinhaCidade;
    public LinearLayout lytFazerLogin;
    public LinearLayout lytSair;
    public LinearLayout lytMeusDados;
    public LinearLayout lytSobre;
    public LinearLayout lytFaleConosco;
    public LinearLayout lytTermoDeUso;
    public int COD_LOGIN = 1;

    public Switch swNotificacoes;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.page_config, container, false);


        lytMinhaCidade = (LinearLayout) view.findViewById(R.id.lytMinhaCidade);
        lytSair = (LinearLayout) view.findViewById(R.id.lytContaSair);
        lytMeusDados = (LinearLayout) view.findViewById(R.id.lytContaMeusDados);
        lytSobre = (LinearLayout) view.findViewById(R.id.lytContaSobre);
        lytFaleConosco = (LinearLayout) view.findViewById(R.id.lytContaFaleConosco);
        lytTermoDeUso = (LinearLayout) view.findViewById(R.id.lytContaTermos);
        lytMeusDados = (LinearLayout) view.findViewById(R.id.lytContaMeusDados);



        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
