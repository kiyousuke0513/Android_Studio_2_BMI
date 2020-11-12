package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    EditText h;                //宣告全域變數
    EditText w;                //宣告全域變數
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        h = findViewById(R.id.Height_Text);   // 取得身高物件
        w = findViewById(R.id.Weight_Text);   // 取得體重物件
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public void Calc_BTN_Click(View view) {
        TextView result = findViewById(R.id.Ans_Text);

        if (   !h.getText().toString().equals("")
        &&     !w.getText().toString().equals(""))
        {
            double Height = Double.parseDouble(h.getEditableText().toString());//取得身高輸入值
            double Weight = Double.parseDouble(w.getEditableText().toString());//取得體重輸入值
            double BMI = Weight/Math.pow((Height/100),2);// 計算BMI

            result.setText("您的BMI為 : " + String.format("%.2f",BMI));// 顯示BMI計算結果
        }
        else
            Toast.makeText(this,"輸入欄位不得為空",Toast.LENGTH_SHORT).show();

    }
}