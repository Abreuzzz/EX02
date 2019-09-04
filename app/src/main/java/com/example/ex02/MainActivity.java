package com.example.ex02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    private NumberFormat percentFormat = NumberFormat.getPercentInstance();

    private TextView gasolinaTextView ;
    private TextView etanolTextView ;
    private TextView resultadoTextView ;
    private TextView precoEtanolTextView;
    private TextView precoGasolinaTextView;
    private ImageView combustivelImageView;

    private double gasolinaPreco = 0.0;
    private double etanolPreco = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gasolinaTextView = findViewById(R.id.gasosaTextView);
        etanolTextView = findViewById(R.id.etanolTextView);
        resultadoTextView = findViewById(R.id.resultadoTextView);
        precoEtanolTextView = findViewById(R.id.etanolPrecoTextView);
        precoGasolinaTextView = findViewById(R.id.gasolinaPrecoTextView);
        combustivelImageView = findViewById(R.id.combustivelImageView);
        SeekBar etanolSeekBar = findViewById(R.id.etanolSeekBar);
        etanolSeekBar.setOnSeekBarChangeListener(alcoolOnSeekBarChangeListener);
        SeekBar gasolinaSeekBar = findViewById(R.id.gasolinaSeekBar);
        gasolinaSeekBar.setOnSeekBarChangeListener(gasolinaOnSeekBarChangeListener);
    }

    private SeekBar.OnSeekBarChangeListener alcoolOnSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
            etanolPreco = progress/10D;
            precoEtanolTextView.setText(currencyFormat.format(etanolPreco));
            if(etanolPreco/gasolinaPreco >= 0.7){
                resultadoTextView.setText(getResources().getString(R.string.escolhaGasolina));
                combustivelImageView.setImageResource(R.drawable.gasolina);
            }else {
                resultadoTextView.setText(getResources().getString(R.string.escolhaEtanol));
                combustivelImageView.setImageResource(R.drawable.etanol);
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private SeekBar.OnSeekBarChangeListener gasolinaOnSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
            gasolinaPreco = progress/10D;
            precoGasolinaTextView.setText( currencyFormat.format(gasolinaPreco));
            if(etanolPreco/gasolinaPreco >= 0.7){
                resultadoTextView.setText(getResources().getString(R.string.escolhaGasolina));
                combustivelImageView.setImageResource(R.drawable.gasolina);
            }else {
                resultadoTextView.setText(getResources().getString(R.string.escolhaEtanol));
                combustivelImageView.setImageResource(R.drawable.etanol);
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
}
