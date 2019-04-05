package com.example.exercicio6;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int contador = 0;
    private Button botaoProfessor;
    private Button botaoAluno;
    private Button botaoExterno;
    private TextView contagem;

    private ArrayList<Participante> participantes = new ArrayList<>();

    public static final int REQUEST_MAIN = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoProfessor = findViewById(R.id.botaoProfessor);
        botaoAluno = findViewById(R.id.botaoAluno);
        botaoExterno = findViewById(R.id.botaoExterno);
        contagem = findViewById(R.id.textNumeroParticipantes);

        botaoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, alunoActivity.class);
                startActivityForResult(intent, MainActivity.REQUEST_MAIN);
            }
        });

        botaoProfessor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, professorActivity.class);
                startActivityForResult(intent, MainActivity.REQUEST_MAIN);
            }
        });

        botaoExterno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, externoActivity.class);
                startActivityForResult(intent, MainActivity.REQUEST_MAIN);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Participante participante = new Participante();
        if (requestCode == MainActivity.REQUEST_MAIN){
            if (resultCode == Activity.RESULT_OK){
                if (data != null) {
                    contador++;
                    contagem.setText("O numero de participante é: " + contador);
                    Bundle bundle = data.getExtras();
                    String nome = (String) bundle.get("nome");
                    participante.setNome(nome);
                    String cod = (String) bundle.get("cod");
                    participante.setCodigo(cod);
                    participantes.add(participante);
                }
            }
        }
    }
}
