package com.jp.agendaapp;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jp.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    //Componentes
    private ViewPager viewPager;
    private TextView[] dots;
    private LinearLayout dotsLayout;
    private ImageView btnAction;

    //Variaveis
    private Context context;
    private Intromanager intromanager;
    private int[] layouts;
    private ViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intromanager = new Intromanager(this);
        //Verifica se introducao ja foi concluida
        if(!intromanager.check()) {
            intromanager.setFirst(true);
            Intent intent = new Intent(MainActivity.this, PrincipalActivity.class);
            startActivity(intent);
            finish();
            overridePendingTransition(R.anim.animacao_vertical_in, R.anim.animacao_vertical_out);

        }

        //FullScreen
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
            actionBar.hide();

        setContentView(R.layout.activity_main);

        context = this;

        //ViewPager
        viewPager = findViewById(R.id.viewPager);

        //LinearLayout
        dotsLayout = findViewById(R.id.layoutDots);

        //ImageView
        btnAction = findViewById(R.id.btnNext);

        //Referencia dos Layouts
        layouts = new int[] {R.layout.layout_tela_1, R.layout.layout_tela_2, R.layout.layout_tela_3};

        //Adiciona pontos
        addBottomDots(0);

        //Instancia PagerAdapter
        adapter = new ViewPagerAdapter(context, layouts);

        //Seta o adapter no ViewPager
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(pagerListener);

        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int current = getItem(1);
                if(current < layouts.length) {
                    viewPager.setCurrentItem(current);
                } else {
                    intromanager.setFirst(false);
                    Intent intent = new Intent(MainActivity.this, PrincipalActivity.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(R.anim.animacao_vertical_in, R.anim.animacao_vertical_out);

                }
            }
        });
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    private void addBottomDots(int position) {
        dots = new TextView[layouts.length];
        dotsLayout.removeAllViews();
        for (int i=0; i<dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.dot_inactive));
            dotsLayout.addView(dots[i]);
        }

        if(dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.dot_active));
        }
    }

    ViewPager.OnPageChangeListener pagerListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            //Adiciona os pontos
            addBottomDots(position);
            if(position == layouts.length -1) {
                btnAction.setImageResource(R.drawable.ic_close);
            } else {
                btnAction.setImageResource(R.drawable.ic_next);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
