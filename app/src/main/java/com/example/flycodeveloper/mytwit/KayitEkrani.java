package com.example.flycodeveloper.mytwit;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Point;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class KayitEkrani extends AppCompatActivity {

    private TextInputLayout tiladsoyad,tilmail,tilsifre,tilkullaniciadi;
    private TextInputEditText adsoyad,mail,sifre,kullaniciadi;
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ekrani);

        init();


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

        findViewById(R.id.zatenhesabimvar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KayitEkrani.this,GirisEkrani.class);
                NavUtils.navigateUpTo(KayitEkrani.this,intent);
            }
        });
        findViewById(R.id.fabKayit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean durumadsoyad = TextUtils.isEmpty(adsoyad.getText());
               boolean durummail = TextUtils.isEmpty(mail.getText());
               boolean durumkullaniciadi = TextUtils.isEmpty(kullaniciadi.getText());
               boolean durumsifre = TextUtils.isEmpty(sifre.getText());

               tilkullaniciadi.setError(null);
               tilmail.setError(null);
               tiladsoyad.setError(null);
               tilsifre.setError(null);

               if(durumadsoyad || durummail || durumsifre || durumkullaniciadi || !mail.getText().toString().trim().contains("@")){

                   if(durumadsoyad)
                       tiladsoyad.setError(" Lütfen ad ve soyadınızı giriniz");
                   if(durumsifre)
                       tilsifre.setError("Lütfen şifrenizi giriniz");
                   if (durumkullaniciadi)
                       tilkullaniciadi.setError("Lütfen kullanıcı adınızı giriniz");
                   if (durummail)
                       tilmail.setError("Lütfen mail adresinizi giriniz");
                   else if (!mail.getText().toString().trim().contains("@"))
                       tilmail.setError("Lütfen geçerli bir mail adresi giriniz");

               } else {


                   //kayıt isteği gönderilecek

               }

            }
        });

    }
    public void init(){
        image = findViewById(R.id.imageKayit);
        tiladsoyad = findViewById(R.id.tiladsoyad);
        tilmail=findViewById(R.id.tilmail);
        tilsifre=findViewById(R.id.tilsifre);
        tilkullaniciadi=findViewById(R.id.tilkullaniciadi);
        adsoyad=findViewById(R.id.adsoyad);
        mail=findViewById(R.id.mail);
        sifre=findViewById(R.id.sifre);
        kullaniciadi=findViewById(R.id.kullaniciadi);
    }

}
