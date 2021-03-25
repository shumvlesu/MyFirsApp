package com.shumikhin.myfirsapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.Locale;

public class Lesson3MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "Lesson3MainActivity";

    Lesson3Counters counters;
    //private int counter1 = 0; // первый счетчик
    private TextView textCounter1; // пользовательский элемент 1-го счетчика
    //private int counter2 = 0;
    private TextView textCounter2; // пользовательский элемент 2-го счетчика

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_3_activity2);

        String instanceState;

        if (savedInstanceState == null) {
            instanceState = "Первый запуск!";
        } else {
            instanceState = "Повторный запуск!";
        }

        makeToast(instanceState + " - onCreate()");

        counters = new Lesson3Counters();

        initView();

//        findViewById(R.id.button).setOnClickListener(view -> {
//            Intent intent = new Intent();
//            ComponentName componentName = new ComponentName("com.shumikhin.myfirsapp", "com.shumikhin.myfirsapp.Lesson3MainActivity2");
//            intent.setComponent(componentName);
//            startActivity(intent);
//        });

    }

    private void initView() {
        textCounter1 = findViewById(R.id.textView1);
        textCounter2 = findViewById(R.id.textView2);

        findViewById(R.id.button2).setOnClickListener(view -> {
            counters.incrementCounter2();
            textCounter2.setText(String.format(Locale.getDefault(), "%d", counters.getCounter2()));
        });

//        Button button1 = findViewById(R.id.button1);
//        button1.setOnClickListener(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        makeToast("onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        makeToast("onStart()");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        makeToast("onRestoreInstanceState()");
        //counters = (Lesson3Counters) savedInstanceState.getSerializable("COUNTERS");
        //используем методику с Parcelable
        counters = savedInstanceState.getParcelable("COUNTERS");
        textCounter1.setText(String.format(Locale.getDefault(), "%d", counters.getCounter1()));
        textCounter2.setText(String.format(Locale.getDefault(), "%d", counters.getCounter2()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        makeToast("onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        makeToast("onPause()");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
       super.onSaveInstanceState(outState);
       makeToast("onSaveInstanceState()");
       //Если нужно сохранить в BUNDLE класс объект класса то надо импелементировать в классе - implements Serializable
       //И можно будет сохранять в бандл.
       //outState.putSerializable("COUNTERS", counters);

       //используем методику с Parcelable (типа она быстрее так как не сипользует сериализацию)
       outState.putParcelable("COUNTERS", counters);

    }

    @Override
    protected void onStop() {
        super.onStop();
        makeToast("onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        makeToast("onDestroy()");
    }


    private void makeToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        Log.d(TAG, message); //d - уровень debug
    }

    public void button1_onClick(View view) {
        counters.incrementCounter1();
        textCounter1.setText(String.format(Locale.getDefault(), "%d", counters.getCounter1()));
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(), "Нажали какуюто кнопку", Toast.LENGTH_SHORT).show();
    }
}
