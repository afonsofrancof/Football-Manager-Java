import Jogador.*;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Equipa {

    public String nome;
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
            System.out.println("jogador já existe\n");
        }

    }


    public Jogador remove_jogador(String nome) {

        Jogador j = this.getJogadores_suplentes().remove(nome);
        if (j == null) {
            j = this.jogadores_titulares.remove(nome);
            if (j == null) {
                System.out.println("jogador não existe\n");
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
                System.out.println("jogador não existe\n");
            } else e.adiciona_jogador(j);
        }
    }

    public double calculaStats() {
        return this.jogadores_titulares.values().stream().mapToDouble(Jogador::calculaCapacidade).sum();
    }






    public void constroiEquipa(int defesa,int meio,int ataque){//assumimos que ele tem jogadores suficientes e adequados para jogar

        if(ataque+meio+defesa!=10) return;//exception aqui
        Guarda_Redes g = this.jogadores_suplentes.values()
                .stream()
                .map(Jogador::clone)
                .filter(e->e instanceof Guarda_Redes)
                .map(Guarda_Redes.class::cast)
                .max(new Jogador.comparaJogadores())
                .orElse(null);
        this.jogadores_suplentes.remove(g.getNome());
        this.jogadores_titulares.put(g.getNome(),g);


        List<Avancado> a = this.jogadores_suplentes.values()
                .stream()
                .map(Jogador::clone)
                .filter(e->e instanceof Avancado)
                .map(Avancado.class::cast)
                .sorted(new Jogador.comparaJogadores())
                .collect(Collectors.toList());


        List<Lateral> l = this.jogadores_suplentes.values()
                .stream()
                .map(Jogador::clone)
                .filter(e->e instanceof Lateral)
                .map(Lateral.class::cast)
                .sorted(new Jogador.comparaJogadores())
                .collect(Collectors.toList());

        List<Defesa> d = this.jogadores_suplentes.values()
                .stream()
                .map(Jogador::clone)
                .filter(e->e instanceof Defesa)
                .map(Defesa.class::cast)
                .sorted(new Jogador.comparaJogadores())
                .collect(Collectors.toList());

        List<Medio> m = this.jogadores_suplentes.values()
                .stream()
                .map(Jogador::clone)
                .filter(e->e instanceof Medio)
                .map(Medio.class::cast)
                .sorted(new Jogador.comparaJogadores())
                .collect(Collectors.toList());


        if(ataque==3){//4-3-3 (4 defesas,3 médios, 1 avançado , 2 laterais)
            Avancado av = a.remove(a.size()-1);
            this.jogadores_titulares.put(av.getNome(),av);
            this.jogadores_suplentes.remove(av.getNome());
            for(int i=0;i<3;i++){
                Medio med = m.remove(m.size()-1);
                this.jogadores_suplentes.remove(med.getNome());
                this.jogadores_titulares.put(med.getNome(),med);
            }

        }
        else{//4-4-2 (4 defesas,2 médios, 2 laterais, 2 avançados)
            for(int i=0;i<2;i++){
                Avancado av = a.remove(a.size()-1);
                this.jogadores_suplentes.remove(av.getNome());
                this.jogadores_titulares.put(av.getNome(),av);
            }
            for(int i=0;i<2;i++){
                Medio med = m.remove(m.size()-1);
                this.jogadores_suplentes.remove(med.getNome());
                this.jogadores_titulares.put(med.getNome(),med);
            }
        }

        for(int i=0;i<2;i++){
            Lateral lat = l.remove(l.size()-1);
            this.jogadores_suplentes.remove(lat.getNome());
            this.jogadores_titulares.put(lat.getNome(),lat);
        }

        for(int i=0;i<4;i++){
            Defesa def = d.remove(d.size()-1);
            this.jogadores_suplentes.remove(def.getNome());
            this.jogadores_titulares.put(def.getNome(),def);
        }

    }

    public void desconstroiEquipa(){

       this.jogadores_suplentes.putAll(this.jogadores_titulares.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,e -> e.getValue().clone())));
       this.jogadores_titulares.clear();

    }



    public int contra(Equipa e) {

        this.constroiEquipa(4, 3, 3);
        e.constroiEquipa(4, 3, 3);
        int prob1, prob2, random;
        int result;
        double stats1 = this.calculaStats();
        double stats2 = e.calculaStats();
        random = (int) (Math.random() * 100);
        prob1 = (int) Math.round(((stats1 / (stats1 + stats2)) * 100));
        prob2 = (int) Math.round(((stats2 / (stats1 + stats2)) * 100));
        System.out.print(random + " | ");
        System.out.print(prob1 + " | " + prob2 + " | ");
        if (prob1 > prob2) {
            if (random < prob1) {
                result = 1;
            } else if (random > prob1) {
                result = 2;
            } else result = 0;
        } else if (prob1 < prob2) {

            if (random < prob2) {
                result = 2;
            } else if (random > prob2) {
                result = 1;
            } else result = 0;
        } else if (random < 70) result = 0;
        else if (random < 85) result = 1;
        else result = 2;

        this.desconstroiEquipa();
        e.desconstroiEquipa();

        return result;

    }
}