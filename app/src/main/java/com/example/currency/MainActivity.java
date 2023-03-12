package com.example.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Spinner spin;
    EditText et;
    Button btn;
    TextView USD;
    TextView EUR;
    TextView MAD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        USD.findViewById(R.id.USD);
        EUR.findViewById(R.id.EUR);
        MAD.findViewById(R.id.MAD);
        spin.findViewById(R.id.currencyspin);
        et.findViewById(R.id.txtamount);
        btn.findViewById(R.id.ConvertBtn);


        String [] spinData={"MAD","EUR","USD"};
        ArrayAdapter ad = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,spinData);
        spin.setAdapter(ad);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double EditText_VALUE = Double.valueOf(et.getText().toString()).doubleValue();

                if(spin.getSelectedItem().toString()=="USD"){
                    Double MAD_CONVERT =  EditText_VALUE * 10.34;
                    Double EUR_CONVERT = EditText_VALUE * 0.94;
                    USD.setText(EditText_VALUE.toString()+" USD");
                    MAD.setText(MAD_CONVERT.toString()+" MAD");
                    EUR.setText(EUR_CONVERT.toString()+" EUR");
                }

                if(spin.getSelectedItem().toString()=="EUR"){
                    Double MAD_CONVERT =  EditText_VALUE * 11.01;
                    Double USD_CONVERT = EditText_VALUE / 1.06;
                    EUR.setText(EditText_VALUE.toString()+" EUR");
                    MAD.setText(MAD_CONVERT.toString()+" MAD");
                    USD.setText(USD_CONVERT.toString()+" USD");
                }

                if(spin.getSelectedItem().toString()=="MAD"){
                    Double USD_CONVERT =  EditText_VALUE /0.097;
                    Double EUR_CONVERT = EditText_VALUE / 0.091;
                    MAD.setText(EditText_VALUE.toString()+" MAD");
                    USD.setText(USD_CONVERT.toString()+" USD");
                    EUR.setText(EUR_CONVERT.toString()+" EUR");
                }
            }
        });
    }
}