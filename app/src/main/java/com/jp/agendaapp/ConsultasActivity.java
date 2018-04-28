package com.jp.agendaapp;

import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.jp.adapter.PageAdapter;
import com.jp.page.PageConfig;
import com.jp.page.PageConsultas;
import com.jp.page.PageNotificacoes;

import java.util.ArrayList;

public class ConsultasActivity extends AppCompatActivity {

    public ViewPager viewPager;
    public PageAdapter pageAdapter;
    BottomNavigationView navigation;
    AppBarLayout.LayoutParams params;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);

        viewPager = findViewById(R.id.pager);
        ArrayList<Fragment> fr_list = new ArrayList<Fragment>();
        fr_list.add(new PageConsultas());
        fr_list.add(new PageNotificacoes());
        fr_list.add(new PageConfig());

        pageAdapter = new PageAdapter(getSupportFragmentManager(), fr_list);

        //BUTTON NAVIGATION
        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(pageChangeListener);
    }

    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    navigation.setSelectedItemId(R.id.navigation_todas);
                    break;
                case 1:
                    navigation.setSelectedItemId(R.id.navigation_meu_local);
                    break;
                case 2:
                    navigation.setSelectedItemId(R.id.navigation_config);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_todas:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_meu_local:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_config:
                    viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };
}
