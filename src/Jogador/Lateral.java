package Jogador;

import java.util.ArrayList;

public class Lateral extends Jogador {

    float cap_cruzar;

    public Lateral() {
        super();
        this.cap_cruzar = 0;
    }

    public Lateral(String nome, float velocidade, float resistencia, float destreza, float impulsao, float jogo_de_cabeca, float remate, float capacidade_de_passe, ArrayList<String> historico_eq, float cap_cruzar) {

        super(nome, velocidade, resistencia, destreza, impulsao, jogo_de_cabeca, remate, capacidade_de_passe, historico_eq);
        this.cap_cruzar = cap_cruzar;
    }

    public Lateral(Lateral l) {
        super(l);
        this.cap_cruzar = l.getCap_cruzar();
    }

    public float getCap_cruzar() {
        return this.cap_cruzar;
    }

    public void setCap_cruzar(float cap_cruzar) {
        this.cap_cruzar = cap_cruzar;
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
                + "\nCapacidade de cruzar ->" + getCap_cruzar() + '\n';
        return str;
    }

    public double calculaCapacidade() {

        return (this.getResistencia() + this.getDestreza()) * 0.8
                + (this.getImpulsao() + this.getRemate() + this.getJogo_de_cabeca()) * 0.6
                + this.getCap_cruzar() + this.getVelocidade() + this.getCapacidade_de_passe();

    }

    public Lateral clone() {
        return new Lateral(this);
    }


}
