package com.example.taxadeservio;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private  TextView textSeekBar;
    private  TextView textGorjeta;
    private  TextView textTotal;
    private EditText textConta;
    private SeekBar seekBarEscala;
    private double porcentagem = 0;
    private Button btnLimpo;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textConta = findViewById(R.id.textConta);
        textGorjeta = findViewById(R.id.textGorjeta);
        textTotal = findViewById(R.id.textTotal);
        textSeekBar = findViewById(R.id.textSeekBar);
        seekBarEscala = findViewById(R.id.seekBarEscala);
        btnLimpo = findViewById(R.id.btnLimpo);





        seekBarEscala.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                porcentagem = progress;
                textSeekBar.setText(Math.round(porcentagem) + "%");
                calcular();




            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
    }
    @Override
    protected void onPause() {
        seekBarEscala.setProgress(0);
        super.onPause();

    }

    public void btnLimpar( View view) {


        textGorjeta.setText("R$ 0");
        textConta.setText("");
        textTotal.setText("R$ 0.00");
        textSeekBar.setText("0%");
        onPause();

    }

    private void onProgressChanged() {
    }


    public  void calcular(){
        String valorRecuperado = textConta.getText().toString();
        if(valorRecuperado == null ||valorRecuperado.equals("")){
            Toast.makeText(
                    getApplicationContext(),
                    "Digite um valor",
                    Toast.LENGTH_LONG


            ).show();
        }else{
            double valorDigitado = Double.parseDouble(valorRecuperado);
            double gorjeta = valorDigitado * (porcentagem/100);
            double total = gorjeta + valorDigitado;
            textGorjeta.setText("R$ " + Math.round(gorjeta));
            textTotal.setText("R$ " + Math.round(total));


        }

        }



}