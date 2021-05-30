package Jogador;

import java.util.ArrayList;

public class Medio extends Jogador {

    float cap_medio;

    public Medio() {
        super();
        this.cap_medio = 0;
    }

    public Medio(String nome, float velocidade, float resistencia, float destreza, float impulsao, float jogo_de_cabeca, float remate, float capacidade_de_passe, ArrayList<String> historico_eq, float cap_medio) {

        super(nome, velocidade, resistencia, destreza, impulsao, jogo_de_cabeca, remate, capacidade_de_passe, historico_eq);
        this.cap_medio = cap_medio;
    }

    public Medio(Medio m) {
        super(m);
        this.cap_medio = m.getCap_medio();
    }

    public float getCap_medio() {
        return this.cap_medio;
    }

    public void setCap_medio(float cap_medio) {
        this.cap_medio = cap_medio;
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
                + "\nCapacidade de Jogador.Medio ->" + getCap_medio() + '\n';
        return str;
    }

    public double calculaCapacidade() {

        return (this.getResistencia() + this.getVelocidade()) * 0.8
                + (this.getImpulsao() + this.getRemate() + this.getJogo_de_cabeca()) * 0.6
                + this.getDestreza() + this.getCapacidade_de_passe();

    }

    public Medio clone() {
        return new Medio(this);
    }


}
