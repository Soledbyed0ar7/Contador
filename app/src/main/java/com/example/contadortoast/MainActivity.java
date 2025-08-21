package com.example.contadortoast;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView num ;
    Button add;
    Button remove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        num = findViewById(R.id.num);
        add = findViewById(R.id.add);
        remove = findViewById(R.id.remove);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void remove (View v){
        int num=Integer.parseInt(this.num.getText().toString());// pega o valor do objeto num e coloca dentro de uma variavel local chamada num
        this.num.setText(Integer.toString(num-1));// o valor do text do  objeto num é settado como variavel local num-1
        if (Integer.parseInt(this.num.getText().toString())<0){ //se o num for menor que 1 a cor do objeto num vai ficar vermelha
            this.num.setTextColor(Color.rgb(255,0,0));
        }
    }
    public void add (View v){
        int num=Integer.parseInt(this.num.getText().toString());// pega o valor do objeto num e coloca dentro de uma variavel local chamada num
        this.num.setText(Integer.toString(num+1));// o valor do text do  objeto num é settado como variavel local num+1
        if (Integer.parseInt(this.num.getText().toString())>=0){//se o num for maior que 1 a cor do objeto num vai ficar azul
            this.num.setTextColor(Color.rgb(20,100,255));
        }

        if (Integer.parseInt(this.num.getText().toString())==10){//se o num for maior que 1 a cor do objeto num vai ficar azul
            Toast.makeText(this,"chegou aos 10",Toast.LENGTH_SHORT).show();//como esse linha nao era de meu conhecimento utilizei de IA para escreve-la mas aprendi a fazer
        }
    }
    public void reset(View v){
        this.num.setText("0");//objeto recebe valor de String igual a "0"
        this.num.setTextColor(Color.rgb(20,100,255));//cor volta a ficar azul
    }
}