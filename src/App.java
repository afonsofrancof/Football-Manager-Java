import Jogador.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws InterruptedException {


        ArrayList<String> l = new ArrayList<>();
        l.add("FC Santana");
        Jogador j1 = new Lateral("Mona Grossa", 6f, 9f, 5f, 6f, 8f, 4f, 8f, l, 5f);
        Jogador j2 = new Guarda_Redes("Mãe do Pipi", 8f, 7f, 8f, 3f, 5f, 8f, 5f, l, 4f);
        Jogador j3 = new Avancado("Gambi", 10f, 5f, 5f, 4f, 2f, 7f, 5f, l, 8f);
        Jogador j4 = new Medio("Gatinho Gordo", 4f, 5f, 10f, 9f, 7f, 2f, 4f, l, 4f);
        Jogador j5 = new Medio("Nelsu", 5f, 8f, 8f, 5f, 9f, 9f, 6f, l, 10f);
        Jogador j6 = new Medio("Tiago", 6f, 4f, 6f, 3f, 7f, 4f, 4f, l, 4f);
        Jogador j7 = new Defesa("Garanito", 8f, 7f, 3f, 7f, 8f, 4f, 7f, l, 10f);
        Jogador j8 = new Defesa("Pickly", 7f, 6f, 5f, 8f, 7f, 2f, 5f, l, 5f);
        Jogador j9 = new Defesa("Fred", 9f, 8f, 7f, 8f, 9f, 3f, 9f, l, 10f);
        Jogador j10 = new Defesa("Lucas", 5f, 5f, 5f, 9f, 1f, 10f, 1f, l, 7f);
        Jogador j11 = new Lateral("JBB", 8f, 7f, 5f, 3f, 7f, 6f, 9f, l, 2f);
        Jogador j12 = new Medio("PLEB1", 0f, 0f, 0f, 0f, 0f, 6f, 0f, l, 10f);
        Jogador j13 = new Medio("PLEB2", 0f, 0f, 6f, 0f, 7f, 8f, 0f, l, 0f);
        Jogador j14 = new Medio("PLEB3", 0f, 9f, 0f, 0f, 7f, 8f, 0f, l, 0f);
        Jogador j15 = new Lateral("PLEB4", 0f, 0f, 0f, 0f, 0f, 0f, 0f, l, 0f);



        Equipa e = new Equipa("FC Cabouco");

        e.adiciona_jogador(j1);
        e.adiciona_jogador(j2);
        e.adiciona_jogador(j3);
        e.adiciona_jogador(j4);
        e.adiciona_jogador(j5);
        e.adiciona_jogador(j5);
        e.adiciona_jogador(j6);
        e.adiciona_jogador(j7);
        e.adiciona_jogador(j8);
        e.adiciona_jogador(j9);
        e.adiciona_jogador(j10);
        e.adiciona_jogador(j11);
        e.adiciona_jogador(j12);
        e.adiciona_jogador(j13);
        e.adiciona_jogador(j14);
        e.adiciona_jogador(j15);



        //SEGUNDA EQUIPA


        Jogador jj1 = new Lateral("Mona Grossa2", 6f, 9f, 5f, 6f, 8f, 4f, 8f, l, 5f);
        Jogador jj2 = new Guarda_Redes("Mãe do Pipi2", 8f, 7f, 8f, 3f, 5f, 8f, 5f, l, 4f);
        Jogador jj3 = new Avancado("Gambi2", 10f, 5f, 5f, 4f, 2f, 7f, 5f, l, 8f);
        Jogador jj4 = new Medio("Gatinho Gordo2", 4f, 5f, 10f, 9f, 7f, 2f, 4f, l, 4f);
        Jogador jj5 = new Medio("Nelsu2", 5f, 8f, 8f, 5f, 9f, 9f, 6f, l, 10f);
        Jogador jj6 = new Medio("Tiago2", 6f, 4f, 6f, 3f, 7f, 4f, 4f, l, 4f);
        Jogador jj7 = new Defesa("Garanito2", 8f, 7f, 3f, 7f, 8f, 4f, 7f, l, 10f);
        Jogador jj8 = new Defesa("Pickly2", 7f, 6f, 5f, 8f, 7f, 2f, 5f, l, 5f);
        Jogador jj9 = new Defesa("Fred2", 9f, 8f, 7f, 8f, 9f, 3f, 9f, l, 10f);
        Jogador jj10 = new Defesa("Lucas2", 5f, 5f, 5f, 9f, 1f, 10f, 1f, l, 7f);
        Jogador jj11 = new Lateral("JBB2", 8f, 7f, 5f, 3f, 7f, 6f, 9f, l, 2f);
        Jogador jj12 = new Medio("PLEB11", 0f, 0f, 0f, 0f, 0f, 3f, 0f, l, 3f);
        Jogador jj13 = new Medio("PLEB22", 0f, 0f, 0f, 0f, 0f, 0f, 0f, l, 0f);
        Jogador jj14 = new Medio("PLEB33", 0f, 0f, 0f, 0f, 0f, 0f, 0f, l, 0f);
        Jogador jj15 = new Medio("PLEB44", 0f, 0f, 0f, 0f, 0f, 0f, 0f, l, 0f);


        Equipa a = new Equipa("FC Santana");

        a.adiciona_jogador(jj1);
        a.adiciona_jogador(jj2);
        a.adiciona_jogador(jj3);
        a.adiciona_jogador(jj4);
        a.adiciona_jogador(jj5);
        a.adiciona_jogador(jj5);
        a.adiciona_jogador(jj6);
        a.adiciona_jogador(jj7);
        a.adiciona_jogador(jj8);
        a.adiciona_jogador(jj9);
        a.adiciona_jogador(jj10);
        a.adiciona_jogador(jj11);
        a.adiciona_jogador(jj12);
        a.adiciona_jogador(jj13);
        a.adiciona_jogador(jj14);
        a.adiciona_jogador(jj15);


        LocalDate date = LocalDate.of(2021, 5, 31);
        Jogo j = new Jogo(e,a,date);
        j.simulaJogo();
        for(Jogador aa:e.jogadores_titulares.values()){
            System.out.println(aa.toString());
        }


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