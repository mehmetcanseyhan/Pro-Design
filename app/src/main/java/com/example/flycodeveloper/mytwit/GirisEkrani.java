package com.example.flycodeveloper.mytwit;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class GirisEkrani extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_ekrani);

        ImageView image = findViewById(R.id.imageView1);
        Window window=getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        WindowManager wm=window.getWindowManager();
        Display ekran = wm.getDefaultDisplay();

        Point point = new Point();
        ekran.getSize(point);

        int genislik=point.x;
        int yukseklik=point.y;

        //en boy oranı 1.67
        image.getLayoutParams().width= (int) (yukseklik*1.67);
        image.getLayoutParams().height=yukseklik;

        ObjectAnimator animator = ObjectAnimator.ofFloat(image,"x",0,-(yukseklik*1.67f-genislik),0,-(yukseklik*1.67f-genislik));
        animator.setDuration(210000);
        animator.setInterpolator(new LinearInterpolator());
        animator.start();

    }

    public void click(View view){
        switch (view.getId()) {
            case  R.id.button2:
                startActivity(new Intent(GirisEkrani.this,KayitEkrani.class));
                break;
        }
    }
}
