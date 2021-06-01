package Jogador;

import java.util.ArrayList;

public class Avancado extends Jogador {

    float cap_marcar;

    public Avancado() {
        super();
        this.cap_marcar = 0;
    }

    public Avancado(String nome, float velocidade, float resistencia, float destreza, float impulsao, float jogo_de_cabeca, float remate, float capacidade_de_passe, ArrayList<String> historico_eq, float cap_marcar) {

        super(nome, velocidade, resistencia, destreza, impulsao, jogo_de_cabeca, remate, capacidade_de_passe, historico_eq);
        this.cap_marcar = cap_marcar;
    }

    public Avancado(Avancado a) {
        super(a);
        this.cap_marcar = a.getCap_marcar();

    }

    public float getCap_marcar() {
        return this.cap_marcar;
    }

    public void setCap_marcar(float cap_marcar) {
        this.cap_marcar = cap_marcar;
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
                + "\nCapacidade de marcar ->" + getCap_marcar()
                + "\nCansaco ->" + getCansaco() + '\n';
        return str;
    }

    public double calculaCapacidade() {

        return (this.getResistencia() + this.getCapacidade_de_passe()) * 0.8
                + this.getVelocidade() + this.getImpulsao() + this.getRemate() + this.getJogo_de_cabeca() + this.getDestreza() + this.getCap_marcar() - 0.1*getCansaco();

    }

    public Avancado clone() {
        return new Avancado(this);
    }

}
