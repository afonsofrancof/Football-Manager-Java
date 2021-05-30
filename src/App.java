import Jogador.*;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws InterruptedException {


        ArrayList<String> l = new ArrayList<>();
        l.add("FC Santana");
        Jogador j1 = new Lateral("Mona Grossa", 9f, 9f, 9f, 9f, 9f, 9f, 9f, l, 5f);
        Jogador j2 = new Guarda_Redes("Mãe do Pipi", 1f, 1f, 1f, 1f, 1f, 1f, 1f, l, 5f);
        Jogador j3 = new Avancado("Gambi", 5f, 5f, 5f, 5f, 5f, 10f, 5f, l, 10f);
        Jogador j4 = new Medio("Gatinho Gordo", 2f, 2f, 2f, 2f, 2f, 2f, 2f, l, 4f);
        Jogador j5 = new Defesa("Garanito", 10f, 10f, 5f, 1f, 1f, 100f, 1f, l, 10f);

        Equipa e = new Equipa("FC Cabouco");

        e.adiciona_jogador(j1);
        e.adiciona_jogador(j2);
        e.adiciona_jogador(j3);
        e.adiciona_jogador(j4);
        e.adiciona_jogador(j5);
        e.adiciona_jogador(j5);


        //SEGUNDA EQUIPA


        Jogador jj1 = new Lateral("Mona Grossa2", 9f, 9f, 9f, 9f, 9f, 9f, 9f, l, 5f);
        Jogador jj2 = new Guarda_Redes("Mãe do Pipi2", 1f, 1f, 1f, 1f, 1f, 1f, 1f, l, 5f);
        Jogador jj3 = new Avancado("Gambi2", 5f, 5f, 5f, 5f, 5f, 10f, 5f, l, 10f);
        Jogador jj4 = new Medio("Gatinho Gordo2", 2f, 2f, 2f, 2f, 2f, 2f, 2f, l, 4f);
        Jogador jj5 = new Defesa("Garanito2", 10f, 10f, 5f, 1f, 1f, 100f, 1f, l, 10f);

        Equipa a = new Equipa("FC Santana");

        a.adiciona_jogador(jj1);
        a.adiciona_jogador(jj2);
        a.adiciona_jogador(jj3);
        a.adiciona_jogador(jj4);
        a.adiciona_jogador(jj5);
        a.adiciona_jogador(jj5);


        Jogo b = new Jogo();
        b.simulaJogo(e,a);


        //System.out.println(e.getJogadores_suplentes().size());
        //System.out.println(e.getJogadores_suplentes().get(j5.getNome()).toString());


        //System.out.println("Old team:");


        //e.mudaParaEquipa(a, j2.getNome());


        //System.out.println("New team:");
        //System.out.println(a.getJogadores_suplentes());
        //System.out.println("Old team:");
        //System.out.println(e.getJogadores_suplentes());
//
        //e.remove_jogador(j1.getNome());
        //e.remove_jogador(j2.getNome());
        //e.remove_jogador(j3.getNome());
        //e.remove_jogador(j4.getNome());
        //e.remove_jogador(j5.getNome());
//
        //
        //System.out.println(e.getJogadores_suplentes());


    }

}