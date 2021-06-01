package Jogador;

import java.util.ArrayList;
import java.util.Comparator;

public class Defesa extends Jogador {

    float cap_defesa;

    public Defesa() {
        super();
        this.cap_defesa = 0;
    }

    public Defesa(String nome, float velocidade, float resistencia, float destreza, float impulsao, float jogo_de_cabeca, float remate, float capacidade_de_passe, ArrayList<String> historico_eq, float cap_defesa) {

        super(nome, velocidade, resistencia, destreza, impulsao, jogo_de_cabeca, remate, capacidade_de_passe, historico_eq);
        this.cap_defesa = cap_defesa;

    }

    public Defesa(Defesa d) {
        super(d);
        this.cap_defesa = d.getCap_defesa();
    }

    public float getCap_defesa() {
        return this.cap_defesa;
    }

    public void setCap_defesa(float cap_defesa) {
        this.cap_defesa = cap_defesa;
    }


    public String toString() {
        String str = getNome() + ":"
                + "\nVelocidade ->" + getVelocidade()
                + "\nDestreza ->" + getDestreza()
                + "\nImpulsao ->" + getImpulsao()
                + "\nJogo de cabeca ->" + getJogo_de_cabeca()
                + "\nRemate ->" + getRemate()
                + "\nCapacidade de passe ->" + getCapacidade_de_passe()
                + "\n Historico de clubes ->" + getHistorico_eq()
                + "\nCapacidade de defesa ->" + getCap_defesa() + '\n'
                + "\nCansaco ->" + getCansaco() + "\n";
        return str;
    }


    public double calculaCapacidade() {
        return (this.velocidade + this.resistencia + this.destreza + this.capacidade_de_passe) * 0.8
                + (this.impulsao + this.remate + this.jogo_de_cabeca) * 0.6
                + this.cap_defesa - 0.1*getCansaco();

    }

    public Defesa clone() {
        return new Defesa(this);
    }



}
