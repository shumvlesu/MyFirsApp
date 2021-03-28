package com.shumikhin.myfirsapp;

import androidx.annotation.FontRes;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

public class Lesson4MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson4_activity_main2);

        //назначаю шрифт
        //можно просто путь указать к файлу а можно через ассет как здесь
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/VlaShu.otf");


        // Вывод ресурсов в строки программно
        TextView descriptionLanguage = findViewById(R.id.textVLang);
        //Из текущего контекста
        descriptionLanguage.setText(this.getString(R.string.descriptionLanguage));
        //указываю шрифт для TextView
        descriptionLanguage.setTypeface(typeface);

        TextView textLanguage = findViewById(R.id.textLang);
        textLanguage.setText(getResources().getString(R.string.language));


        ImageView imageView = new ImageView(this);
        //Загружаю картинку
        try {
            InputStream inputStream = getAssets().open("catiyaki2.jpg");
            //преобразуем InputStream в Drawable
            Drawable drawable = Drawable.createFromStream(inputStream, null); //null - никакого имени передавть не буду
            //и уже картинке назначаем Drawable
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}