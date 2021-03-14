package com.shumikhin.myfirsapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Integer.valueOf;

public class MainActivity extends AppCompatActivity {

    private Integer arg1;
    private Integer arg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO
        //FIXME

        Button button = findViewById(R.id.button);
        final EditText editText1 = findViewById(R.id.editText1);
        final EditText editText2 = findViewById(R.id.editText2);
        final TextView textView = findViewById(R.id.textView);

        button.setOnClickListener(v -> {
            try {
                arg1 = valueOf(editText1.getText().toString());
                arg2 = valueOf(editText2.getText().toString());
                if (arg1.equals(arg2)) {
                    textView.setText("Равно!");
                } else {
                    textView.setText("НЕ Равно!");
                }
            } catch (NumberFormatException ex) {
                Log.e("MyApp","Это не число!", ex);
            }

        });


    }
}