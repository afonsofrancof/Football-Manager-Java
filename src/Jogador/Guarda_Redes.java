package Jogador;

import java.util.ArrayList;

public class Guarda_Redes extends Jogador {

    float elasticidade;

    public Guarda_Redes() {
        super();
        this.elasticidade = 0;
    }

    public Guarda_Redes(String nome, float velocidade, float resistencia, float destreza, float impulsao, float jogo_de_cabeca, float remate, float capacidade_de_passe, ArrayList<String> historico_eq, float elasticidade) {

        super(nome, velocidade, resistencia, destreza, impulsao, jogo_de_cabeca, remate, capacidade_de_passe, historico_eq);
        this.elasticidade = elasticidade;

    }

    public Guarda_Redes(Guarda_Redes g) {
        super(g);
        this.elasticidade = g.getElasticidade();
    }


    public float getElasticidade() {
        return this.elasticidade;
    }

    public void setElasticidade(float elasticidade) {
        this.elasticidade = elasticidade;
    }


    public String toString() {
        String str = getNome() + ":"
                + "\nVelocidade ->" + getVelocidade()
                + "\nDestreza ->" + getDestreza()
                + "\nImpulsao ->" + getImpulsao()
                + "\nJogo de cabeca ->" + getJogo_de_cabeca()
                + "\nRemate ->" + getRemate()
                + "\nCapacidade de passe ->" + getCapacidade_de_passe()
                + "\nElasticidade ->" + getElasticidade()
                + "\n Historico de clubes ->" + getHistorico_eq() + '\n';
        return str;
    }

    public double calculaCapacidade() {

        return (this.getResistencia() + this.getVelocidade() + this.getRemate() + this.getJogo_de_cabeca()) * 0.4
                + (this.getDestreza()) * 0.6
                + this.getElasticidade() + this.getImpulsao();

    }

    public Guarda_Redes clone() {
        return new Guarda_Redes(this);
    }


}
