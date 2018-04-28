package com.jp.page;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.jp.agendaapp.R;

/**
 * Created by Bruno Morais2 on 05/12/2017.
 */

public class PageNotificacoes extends Fragment {

    public View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.page_notificacoes, container, false);


        return view;
    }


}
