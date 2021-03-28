package com.shumikhin.myfirsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Lesson4MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson4_activity_main2);

        // Вывод ресурсов в строки программно
        TextView descriptionLanguage = findViewById(R.id.textVLang);
        //Из текущего контекста
        descriptionLanguage.setText(this.getString(R.string.descriptionLanguage));

        TextView textLanguage = findViewById(R.id.textLang);
        textLanguage.setText(getResources().getString(R.string.language));

    }
}