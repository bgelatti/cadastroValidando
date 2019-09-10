package com.example.cadastrovalidando;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.widget.VectorEnabledTintResources;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edtNome = findViewById(R.id.edtNome);
        edtNome.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN &&
                        edtNome.getText().toString().equals("Nome Completo")) {
                    edtNome.setText("");
                }

                return false;
            }

        });

        final EditText edtIdade = findViewById(R.id.edtIdade);
        edtIdade.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN &&
                        edtIdade.getText().toString().equals("Idade")) {
                    edtIdade.setText("");
                }

                return false;
            }
        });

        final EditText edtEndereco = findViewById(R.id.edtEndereco);
        edtEndereco.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN &&
                        edtEndereco.getText().toString().equals("Endereço")) {
                    edtEndereco.setText("");
                }

                return false;
            }
        });

        final EditText edtComplemento = findViewById(R.id.edtComplemento);
        edtComplemento.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN &&
                        edtComplemento.getText().toString().equals("Complemento")) {
                    edtComplemento.setText("");
                }

                return false;
            }
        });

        final EditText edtCidade = findViewById(R.id.edtCidade);
        edtCidade.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN &&
                        edtCidade.getText().toString().equals("Cidade")) {
                    edtCidade.setText("");
                }

                return false;
            }
        });

        final EditText edtEstado = findViewById(R.id.edtEstado);
        edtEstado.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN &&
                        edtEstado.getText().toString().equals("Estado")) {
                    edtEstado.setText("");
                }

                return false;
            }
        });

        final EditText edtRg = findViewById(R.id.edtRg);
        edtRg.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN &&
                        edtRg.getText().toString().equals("RG")) {
                    edtRg.setText("");
                }

                return false;
            }
        });

        final EditText edtCpf = findViewById(R.id.edtCpf);
        edtCpf.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN &&
                        edtCpf.getText().toString().equals("CPF")) {
                    edtCpf.setText("");
                }

                return false;
            }
        });


        final Button btnCadastro = findViewById(R.id.btnCadastrar);
        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final List<String> listaCampos = new ArrayList<>();
                boolean menorIdade = false;

                if (edtNome.getText().toString().equals("Nome Completo") ||
                        edtNome.getText().toString().equals("")) {
                    listaCampos.add("Nome Completo");
                }

                if (edtIdade.getText().toString().equals("Idade") ||
                        edtIdade.getText().toString().equals("")) {
                    listaCampos.add("Idade");
                } else {
                    int idade = Integer.valueOf(edtIdade.getText().toString());
                    if (idade < 18) {
                        menorIdade = true;
                    }
                }

                if (edtCpf.getText().toString().equals("CPF") ||
                        edtCpf.getText().toString().equals("")) {
                    listaCampos.add("CPF");
                }

                String mensagemIncorreta = "";

                if (listaCampos.size() > 0) {
                    mensagemIncorreta = "O(s) campo(s) ";
                    for (String campo : listaCampos) {
                        mensagemIncorreta = mensagemIncorreta + campo + " ";
                    }
                    mensagemIncorreta = mensagemIncorreta + "não esta(ão) preenchido(s).";
                }

                if (menorIdade) {
                    mensagemIncorreta = mensagemIncorreta + " Não pode ser menor de idade.";
                }

                if (mensagemIncorreta.equals("")) {
                    Toast.makeText(MainActivity.this,
                            "Pessoa cadastrada com sucesso",
                            Toast.LENGTH_SHORT).show();
                    edtNome.setText("Nome Completo");
                    edtIdade.setText("Idade");
                    edtEndereco.setText("Endereço");
                    edtComplemento.setText("Complemento");
                    edtCidade.setText("Cidade");
                    edtEstado.setText("Estado");
                    edtRg.setText("RG");
                    edtCpf.setText("CPF");
                } else {
                    Toast.makeText(MainActivity.this,
                            mensagemIncorreta,
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
