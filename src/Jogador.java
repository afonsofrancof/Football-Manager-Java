import java.util.ArrayList;

public class Jogador {
    
    public float velocidade;
    public float resistencia;
    public float destreza;
    public float impulsao;
    public float jogo_de_cabeca;
    public float remate;
    public float capacidade_de_passe;
    public ArrayList<String> equipas_anteriores;

    public Jogador(){

        this.velocidade=0;
        this.resistencia=0;
        this.destreza=0;
        this.impulsao=0;
        this.jogo_de_cabeca=0;
        this.remate=0;
        this.capacidade_de_passe = 0;

    }

    public Jogador(float velocidade,float resistencia,float destreza,float impulsao,float jogo_de_cabeca,float remate,float capacidade_de_passe){

        this.velocidade=velocidade;
        this.resistencia=resistencia;
        this.destreza=destreza;
        this.impulsao=impulsao;
        this.jogo_de_cabeca=jogo_de_cabeca;
        this.remate=remate;
        this.capacidade_de_passe=capacidade_de_passe;

    }

    public Jogador(Jogador j){
        
        this.velocidade = j.getVelocidade();
        this.resistencia=j.getResistencia();
        this.destreza=j.getDestreza();
        this.impulsao=j.getImpulsao();
        this.jogo_de_cabeca=j.getJogo_de_cabeca();
        this.remate=j.getRemate();
        this.capacidade_de_passe=j.getCapacidade_de_passe();



    }
    

    public float getVelocidade(){

        return this.velocidade;

    }

    public float getDestreza(){

        return this.destreza;

    }

    public float getResistencia(){

        return this.resistencia;

    }



    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }


    public void setResistencia(float resistencia) {
        this.resistencia = resistencia;
    }


    public void setDestreza(float destreza) {
        this.destreza = destreza;
    }


    public float getImpulsao() {
        return impulsao;
    }


    public void setImpulsao(float impulsao) {
        this.impulsao = impulsao;
    }


    public float getJogo_de_cabeca() {
        return jogo_de_cabeca;
    }


    public void setJogo_de_cabeca(float jogo_de_cabeca) {
        this.jogo_de_cabeca = jogo_de_cabeca;
    }


    public float getRemate() {
        return remate;
    }


    public void setRemate(float remate) {
        this.remate = remate;
    }


    public float getCapacidade_de_passe() {
        return capacidade_de_passe;
    }

    public void setCapacidade_de_passe(float capacidade_de_passe) {
        this.capacidade_de_passe = capacidade_de_passe;
    }

    



}

class Defesa extends Jogador{

    public Defesa(){
        super();
    } 

    public Defesa(float velocidade,float resistencia,float destreza,float impulsao,float jogo_de_cabeca,float remate,float capacidade_de_passe){

        super(velocidade,resistencia,destreza,impulsao,jogo_de_cabeca,remate,capacidade_de_passe);

    }

    public Defesa(Defesa d){
        super(d);
    }

}

class Lateral extends Jogador{

    public Lateral(){
        super();
    } 

    public Lateral(float velocidade,float resistencia,float destreza,float impulsao,float jogo_de_cabeca,float remate,float capacidade_de_passe){

        super(velocidade,resistencia,destreza,impulsao,jogo_de_cabeca,remate,capacidade_de_passe);

    }

    public Lateral(Lateral l){
        super(l);
    }


}

class Avancado extends Jogador{

    public Avancado(){
        super();
    } 

    public Avancado(float velocidade,float resistencia,float destreza,float impulsao,float jogo_de_cabeca,float remate,float capacidade_de_passe){

        super(velocidade,resistencia,destreza,impulsao,jogo_de_cabeca,remate,capacidade_de_passe);

    }

    public Avancado(Avancado a){
        super(a);
    }


}

class Medio extends Jogador{

    public Medio(){
        super();
    } 

    public Medio(float velocidade,float resistencia,float destreza,float impulsao,float jogo_de_cabeca,float remate,float capacidade_de_passe){

        super(velocidade,resistencia,destreza,impulsao,jogo_de_cabeca,remate,capacidade_de_passe);

    }

    public Medio(Medio m){
        super(m);
    }


}

class Guarda_Redes extends Jogador{

    private float elasticidade;

    public Guarda_Redes(){
        super();
        this.elasticidade=0;
    } 

    public Guarda_Redes(float velocidade,float resistencia,float destreza,float impulsao,float jogo_de_cabeca,float remate,float capacidade_de_passe,float elasticidade){

        super(velocidade,resistencia,destreza,impulsao,jogo_de_cabeca,remate,capacidade_de_passe);
        this.elasticidade=elasticidade;

    }

    public Guarda_Redes(Guarda_Redes g){
        super(g);
        this.elasticidade=g.getElasticidade();
    }


    public float getElasticidade() {
        return elasticidade;
    }

    public void setElasticidade(float elasticidade) {
        this.elasticidade = elasticidade;
    }

}

