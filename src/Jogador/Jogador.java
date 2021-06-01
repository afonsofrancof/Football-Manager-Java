package Jogador;

import java.util.ArrayList;
import java.util.Comparator;


public abstract class Jogador implements Comparable<Jogador>{
    
    String nome;
    float velocidade;
    float resistencia;
    float destreza;
    float impulsao;
    float jogo_de_cabeca;
    float remate;
    float capacidade_de_passe;
    float cansaco;

    ArrayList<String> historico_eq;

    public Jogador(){

        this.nome="";
        this.velocidade=0;
        this.resistencia=0;
        this.destreza=0;
        this.impulsao=0;
        this.jogo_de_cabeca=0;
        this.remate=0;
        this.capacidade_de_passe = 0;
        this.cansaco=0;
        this.historico_eq=new ArrayList<String>();

        

    }

    public Jogador(String nome,float velocidade,float resistencia,float destreza,float impulsao,float jogo_de_cabeca,float remate,float capacidade_de_passe, ArrayList<String> historico_eq){

        this.nome=nome;
        this.velocidade=velocidade;
        this.resistencia=resistencia;
        this.destreza=destreza;
        this.impulsao=impulsao;
        this.jogo_de_cabeca=jogo_de_cabeca;
        this.remate=remate;
        this.capacidade_de_passe=capacidade_de_passe;
        this.setHistorico_eq(historico_eq);
        this.cansaco=0;

    }

    public Jogador(Jogador j){
        
        this.nome=j.getNome();
        this.velocidade = j.getVelocidade();
        this.resistencia=j.getResistencia();
        this.destreza=j.getDestreza();
        this.impulsao=j.getImpulsao();
        this.jogo_de_cabeca=j.getJogo_de_cabeca();
        this.remate=j.getRemate();
        this.capacidade_de_passe=j.getCapacidade_de_passe();
        this.setHistorico_eq(j.getHistorico_eq());
        this.cansaco=j.getCansaco();



    }

    public float getCansaco() { return cansaco; }

    public void setCansaco(float cansaco) { this.cansaco = cansaco; }

    public float getVelocidade(){ return this.velocidade; }

    public float getDestreza(){ return this.destreza; }

    public float getResistencia(){ return this.resistencia; }

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
        return this.impulsao;
    }


    public void setImpulsao(float impulsao) {
        this.impulsao = impulsao;
    }


    public float getJogo_de_cabeca() {
        return this.jogo_de_cabeca;
    }


    public void setJogo_de_cabeca(float jogo_de_cabeca) {
        this.jogo_de_cabeca = jogo_de_cabeca;
    }


    public float getRemate() {
        return this.remate;
    }


    public void setRemate(float remate) {
        this.remate = remate;
    }


    public float getCapacidade_de_passe() {
        return this.capacidade_de_passe;
    }

    public void setCapacidade_de_passe(float capacidade_de_passe) {
        this.capacidade_de_passe = capacidade_de_passe;
    }

    public void setNome(String nome){ this.nome = nome; }

    public String getNome(){ return this.nome; }

    public ArrayList<String> getHistorico_eq(){
        return this.historico_eq;
    }
    
    public void setHistorico_eq (ArrayList<String> lista){        
        this.historico_eq = new ArrayList<>();
        this.historico_eq.addAll(lista);
    }
    
    public String toString(){
        String str = getNome() + ":"
        + "\nVelocidade ->"           + getVelocidade()
        + "\nDestreza ->"             + getDestreza()
        + "\nImpulsao ->"             + getImpulsao()
        + "\nJogo de cabeca ->"       + getJogo_de_cabeca()
        + "\nRemate ->"               + getRemate()
        + "\nCapacidade de passe ->"  + getCapacidade_de_passe()
        + "\nHistorico de clubes ->" + getHistorico_eq() + '\n'
        + "\nCansaco ->" + getCansaco() + "\n";
        return str;
    }



    public Jogador incrementaCansaco(){
        this.cansaco++;
        return this.clone();
    }

    public abstract double calculaCapacidade();

    public abstract Jogador clone();


    public int compareTo(Jogador j1){
        Double a = this.calculaCapacidade();
        Double b = j1.calculaCapacidade();
        return a.compareTo(b);
    }

    public int compareToo(Jogador j1){
        Float a = this.cansaco;
        Float b = j1.cansaco;
        return a.compareTo(b);
    }

    public static class comparaJogadores implements Comparator<Jogador>{

        public int compare(Jogador j1, Jogador j2){
            return j1.compareTo(j2);

        }

    }

    public static class comparaCansacos implements Comparator<Jogador>{

        public int compare(Jogador j1,Jogador j2){
            return j1.compareToo(j2);
        }

    }



}

