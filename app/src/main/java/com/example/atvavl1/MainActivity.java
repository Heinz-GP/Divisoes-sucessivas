package com.example.atvavl1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText valor1;
    private TextInputEditText valor2;
    private TextInputEditText valor3;
    private TextInputEditText valor4;
    private Button btn_calcular;
    private Button btn_limpar;
    private Button btn_proxTela;
    private TextView resultado;
    private float aux;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor1 = findViewById(R.id.v1);
        valor2 = findViewById(R.id.v2);
        valor3 = findViewById(R.id.v3);
        valor4 = findViewById(R.id.v4);
        btn_calcular = findViewById(R.id.btn_calcular);
        btn_limpar = findViewById(R.id.btn_limpar);
        btn_proxTela = findViewById(R.id.btn_proxTela);
        resultado = findViewById(R.id.resultado);

        btn_calcular.setOnClickListener(this);
        btn_limpar.setOnClickListener(this);
        btn_proxTela.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == btn_calcular){
            calcular();
        }else if(view == btn_limpar){
            limpar();
        }else if(view == btn_proxTela){
            proxTela();
        }
    }

    private void calcular(){
        try {
            float v1 = Float.valueOf(String.valueOf(valor1.getText()));
            float v2 = Float.valueOf(String.valueOf(valor2.getText()));
            float v3 = Float.valueOf(String.valueOf(valor3.getText()));
            float v4 = Float.valueOf(String.valueOf(valor4.getText()));

            aux = ((v1 / v2) / v3) / v4;

            resultado.setText("Resultado: " + aux);

        }catch (NumberFormatException e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    public void limpar(){
        valor1.setText("");
        valor2.setText("");
        valor3.setText("");
        valor4.setText("");
        resultado.setText("Resultado:");
    }

    public void proxTela(){
        try {
            Intent intent = new Intent(this, proxTela.class);
            Bundle params = new Bundle();
            params.putString("valor1", valor1.getText().toString());
            params.putString("valor2", valor2.getText().toString());
            params.putString("valor3", valor3.getText().toString());
            params.putString("valor4", valor4.getText().toString());
            params.putString("resultado", resultado.getText().toString());
            intent.putExtras(params);
            startActivity(intent);
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }
}