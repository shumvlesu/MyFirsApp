package com.shumikhin.myfirsapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class Lesson4MainActivity2 extends AppCompatActivity {

    // Имя настроек
    private static final String NameSharedPreference = "LOGIN";
    // Имя параметра в настройках
    private static final String appTheme = "APP_THEME";
    private static final int MyCoolCodeStyle = 0;
    private static final int AppThemeLightCodeStyle = 1;
    private static final int AppThemeCodeStyle = 2;
    private static final int AppThemeDarkCodeStyle = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.MyCoolStyle));
        setContentView(R.layout.lesson4_activity_main5);

        initThemeChooser();
    }


    // Инициализация радиокнопок
    private void initThemeChooser() {
        initRadioButton(findViewById(R.id.radioButtonMyCoolStyle),
                MyCoolCodeStyle);
        initRadioButton(findViewById(R.id.radioButtonMaterialDark),
                AppThemeDarkCodeStyle);
        initRadioButton(findViewById(R.id.radioButtonMaterialLight),
                AppThemeLightCodeStyle);
        initRadioButton(findViewById(R.id.radioButtonMaterialLightDarkAction),
                AppThemeCodeStyle);
        RadioGroup rg = findViewById(R.id.radioButtons);
        ((MaterialRadioButton) rg.getChildAt(getCodeStyle(MyCoolCodeStyle))).setChecked(true);
    }

    // Все инициализации кнопок очень похожи, поэтому создадим метод для переиспользования
    private void initRadioButton(View button, final int codeStyle) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // сохраним настройки
                setAppTheme(codeStyle);
                // пересоздадим активити, чтобы тема применилась
                recreate();
            }
        });
    }

    // Сохранение настроек
    private void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        // Настройки сохраняются посредством специального класса editor.
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(appTheme, codeStyle);
        editor.apply();
    }

    private int getAppTheme(int codeStyle) {
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }

    private int getCodeStyle(int codeStyle) {
        // Работаем через специальный класс сохранения и чтения настроек
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        //Прочитать тему, если настройка не найдена - взять по умолчанию
        return sharedPref.getInt(appTheme, codeStyle);
    }

    private int codeStyleToStyleId(int codeStyle) {
        switch (codeStyle) {
            case AppThemeCodeStyle:
                return R.style.AppTheme;
            case AppThemeLightCodeStyle:
                return R.style.AppThemeLight;
            case AppThemeDarkCodeStyle:
                return R.style.AppThemeDark;
            default:
                return R.style.MyCoolStyle;
        }
    }

}