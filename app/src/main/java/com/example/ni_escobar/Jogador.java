package com.example.ni_escobar;

import java.util.ArrayList;

public class Jogador {
    public String nome;
    public int hp = 100;
    public ArrayList<Item> equipamentos = new ArrayList<>();

    public void equiparItem(Item item){
        this.equipamentos.add(item);
        if(item.status.equals("HP")){
            this.hp += item.modificador;
        }


    }
    public void atacar(Jogador inimigo){
        inimigo.hp-= this.valorAtaque();

    }


    public int valorAtaque(){
        int ataque = 0;
        for(Item item: this.equipamentos){
            if(item.status.equals("ATK")){
                ataque+= item.modificador;
            }
        }
        return  ataque;
    }

}
