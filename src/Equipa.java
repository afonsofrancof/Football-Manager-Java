import java.util.ArrayList;

public class Equipa {
    
    public String nome;
    public ArrayList<Jogador> jogadores_titulares;
    public ArrayList<Jogador> jogadores_suplentes;

    public Equipa(){
        this.nome=null;
        this.jogadores_titulares = new ArrayList<Jogador>();
        this.jogadores_suplentes = new ArrayList<Jogador>();
    }

    public Equipa(String nome){
        this.nome=nome;
        this.jogadores_titulares = new ArrayList<Jogador>();
        this.jogadores_suplentes = new ArrayList<Jogador>();
    }

    public Equipa(String nome,ArrayList<Jogador> jogadores_titulares,ArrayList<Jogador> jogadores_suplentes){

        this.nome=nome;
        this.setJogadores_titulares(jogadores_titulares);
        this.setJogadores_suplentes(jogadores_suplentes);

    }

    public Equipa(Equipa e){
        
        this.nome=e.getNome();
        this.setJogadores_titulares(e.getJogadores_titulares());
        this.setJogadores_suplentes(e.getJogadores_suplentes());

    }
    
    public ArrayList<Jogador> getJogadores_titulares(){

        return this.jogadores_titulares;

    }


    public ArrayList<Jogador> getJogadores_suplentes(){

        return this.jogadores_suplentes;

    }


    public String getNome(){

        return this.nome;

    }


    public void setJogadores_titulares(ArrayList<Jogador> lista){

        this.jogadores_titulares = new ArrayList<>();
        for(Jogador j:lista){
            this.jogadores_titulares.add(j);//preciso dar clone
        }


    }

    public void setJogadores_suplentes(ArrayList<Jogador> lista){

        this.jogadores_suplentes = new ArrayList<>();
        for(Jogador j:lista){
            this.jogadores_suplentes.add(j);//preciso dar clone??
        }


    }

    public void adiciona_jogador(Jogador j) {
        this.getJogadores_suplentes().add(j);//adicionei o get em vez de apenas jogadores
    }

    public void remove_jogador(Jogador j){
        
        if(this.getJogadores_suplentes().contains(j)) this.getJogadores_suplentes().remove(j);
        if(this.getJogadores_titulares().contains(j)) this.getJogadores_titulares().remove(j);
        //aqui alteras o historial

    }


    public void mudaParaEquipa(Equipa e,Jogador j){

        this.remove_jogador(j);
        e.adiciona_jogador(j);
        //Falta confirmar se o jogador existe na dada equipa

    }


}