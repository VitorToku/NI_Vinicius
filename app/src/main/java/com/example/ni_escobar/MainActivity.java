package com.example.ni_escobar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int itemEscolhido;
    private TextView txtTeste;
    ArrayList<Item> listaItems = new ArrayList<Item>();
    Random rnd = new Random();
    String[] nomes = new String[]{"Espada","Escudo", "Guarda-Chuva", "Pedra", "Armadura"};
    String[] status = new String[]{"ATK", "HP", "ATK","ATK", "HP"};
    int[] modificador = new int[]{4, 3,2,2,4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTeste = findViewById(R.id.txtTeste);
        //popula a lista de itens
        for(int i = 0; i < nomes.length;i++){

            Item item = new Item(nomes[i], status[i],modificador[i]);
            System.out.println(item.nome);
            listaItems.add(item);
        }


    }

    public void nome(View view) {
        txtTeste.setText(listaItems.get(rnd.nextInt(listaItems.size())).nome);
    }

    public void arsenalAleatorio(View view){
        int[] numerosSorteados = {-1,-1,-1,-1,-1};

        for(int i = 0;i< numerosSorteados.length;){
            int numero = rnd.nextInt(listaItems.size());

            if(!foiSorteado(numero,numerosSorteados)){
                numerosSorteados[i] = numero;
                i++;
            }
        }
        mostrarArsenal(numerosSorteados);
    }

    private void mostrarArsenal(int[] lista){

        String[] itensSorteados = new String[5];
        for(int i =0; i< itensSorteados.length;i++){
            itensSorteados[i] = listaItems.get(lista[i]).nome;
        }

        AlertDialog.Builder arsenal = new AlertDialog.Builder(MainActivity.this);
        arsenal.setTitle("Arsenal");
        arsenal.setSingleChoiceItems(itensSorteados, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                itemEscolhido = i;
            }
        });
        arsenal.setPositiveButton("Escolher", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, descricaoItem(lista,itemEscolhido), Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alert = arsenal.create();
        alert.setCancelable(false);
        alert.show();
    }
    private String descricaoItem(int[] lista, int i){
        String nome = listaItems.get(lista[i]).nome;
        int modificador = listaItems.get(lista[i]).modificador;
        String status = listaItems.get(lista[i]).status;
        return nome + " + " + modificador + " " + status;
    }
    private boolean foiSorteado(int numero, int[] lista){
        for(int n: lista){
            if(numero == n){
                return true;
            }
        }
        return false;
    }
}