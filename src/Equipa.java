import Jogador.Jogador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Equipa {

    public String nome;
    //public ArrayList<Jogador.Jogador> jogadores_titulares;
    //public ArrayList<Jogador.Jogador> jogadores_suplentes;
    public Map<String, Jogador> jogadores_titulares;
    public Map<String, Jogador> jogadores_suplentes;

    public Equipa() {
        this.nome = null;
        this.jogadores_titulares = new HashMap<>();
        this.jogadores_suplentes = new HashMap<>();
    }

    public Equipa(String nome) {
        this.nome = nome;
        this.jogadores_titulares = new HashMap<>();
        this.jogadores_suplentes = new HashMap<>();
    }

    public Equipa(String nome, Map<String, Jogador> jogadores_titulares, Map<String, Jogador> jogadores_suplentes) {

        this.nome = nome;
        this.setJogadores_titulares(jogadores_titulares);
        this.setJogadores_suplentes(jogadores_suplentes);

    }

    public Equipa(Equipa e) {

        this.nome = e.getNome();
        this.setJogadores_titulares(e.getJogadores_titulares());
        this.setJogadores_suplentes(e.getJogadores_suplentes());

    }

    public Map<String, Jogador> getJogadores_titulares() {

        return this.jogadores_titulares.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().clone()));

    }


    public Map<String, Jogador> getJogadores_suplentes() {

        return this.jogadores_suplentes.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().clone()));

    }


    public String getNome() {

        return this.nome;

    }


    public void setJogadores_titulares(Map<String, Jogador> map) {

        this.jogadores_titulares = new HashMap<>();
        this.jogadores_titulares = map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().clone()));

    }


    public void setJogadores_suplentes(Map<String, Jogador> map) {

        this.jogadores_suplentes = new HashMap<>();
        this.jogadores_suplentes = map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().clone()));


    }

    public void adiciona_jogador(Jogador j) {

        if ((this.jogadores_suplentes.putIfAbsent(j.getNome(), j)) != null) {
            System.out.println("jogador já existe\n");//falta criar exeption
        }

    }


    public Jogador remove_jogador(String nome) {

        Jogador j = this.getJogadores_suplentes().remove(nome);
        if (j == null) {
            j = this.jogadores_titulares.remove(nome);
            if (j == null) {
                System.out.println("jogador não existe\n");//falta criar exeption
                return null;
            }
            return null;
        }


        ArrayList<String> historico = new ArrayList<>(j.getHistorico_eq());
        historico.add(this.getNome());
        j.setHistorico_eq(historico);

        return j;

    }


    public void mudaParaEquipa(Equipa e, String nome) {
        Jogador j;
        if (!(e.jogadores_suplentes.containsKey(nome)) || !(e.jogadores_titulares.containsKey(nome))) {

            j = this.remove_jogador(nome);
            if (j == null) {
                System.out.println("jogador não existe\n");//falta criar exeption
            } else e.adiciona_jogador(j);
        }
    }

    public double calculaStats() {
        return this.jogadores_suplentes.values().stream().mapToDouble(Jogador::calculaCapacidade).sum();
    }

    public int contra(Equipa e) {

        int prob1, prob2, random;
        int result;
        double stats1 = this.calculaStats();//jogadores_suplentes.values().stream().mapToDouble(Jogador.Jogador::calculaCapacidade).sum();
        double stats2 = e.calculaStats();//jogadores_suplentes.values().stream().mapToDouble(Jogador.Jogador::calculaCapacidade).sum();
        random = (int) (Math.random() * 100);//pode ser alterado para double
        //double bomdia1 = (stats1/(stats1+stats2))*100;
        //double bomdia2 = (stats2/(stats1+stats2))*100;
        //System.out.print(random + " | ");
        //System.out.print(bomdia1+ " | " + bomdia2 + " | ");
        prob1 = (int) Math.round(((stats1 / (stats1 + stats2)) * 100));//pode ser alterado para double
        prob2 = (int) Math.round(((stats2 / (stats1 + stats2)) * 100));//pode ser alterado para double
        System.out.print(random + " | ");
        System.out.print(prob1 + " | " + prob2 + " | ");
        if (prob1 > prob2) {
            //System.out.print("  Entrou 1"+ stats1 + stats2 + "|");
            if (random < prob1) {
                result = 1;
            } else if (random > prob1) {
                result = 2;
            } else result = 0;//solução provisório para o empate com 1% de chance, quando prob1==random
        } else if (prob1 < prob2) {
            //System.out.print("  Entrou 2 "+ stats1+ "  "+ stats2 + " | ");
            if (random < prob2) {
                result = 2;
            } else if (random > prob2) {
                result = 1;
            } else result = 0;//solução provisório para o empate com 1% de chance, quando prob2==random
        } else if (random < 70) result = 0;
        else if (random < 85) result = 1;
        else result = 2;

        return result;

    }
}