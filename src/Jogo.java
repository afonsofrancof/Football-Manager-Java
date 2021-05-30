import Jogador.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Jogo {

    private String resultadoFinal;
    private List<Jogador> marcadores;
    private double posse_de_bola;
    private int passes;
    private int remates;
    private double accuracy;

    public Jogo() {
        this.resultadoFinal ="0-0";
        this.marcadores = new ArrayList<>();
        this.posse_de_bola =0.0;
        this.passes = 0;
        this.remates = 0;
        this.accuracy = 0.0;
    }

    public Jogo(String resultadoFinal, List<Jogador> marcadores, double posse_de_bola, int passes, int remates, double accuracy) {
        this.resultadoFinal = resultadoFinal;
        this.marcadores = marcadores;
        this.posse_de_bola = posse_de_bola;
        this.passes = passes;
        this.remates = remates;
        this.accuracy = accuracy;
    }

    public void simulaJogo(Equipa e1, Equipa e2) throws InterruptedException {

        int equipa_bola =0;
        int zona_do_campo=1;
        int golo1=0, golo2=0;
        equipa_bola = (int) (Math.random() * 2) == 0 ? 1 : 2;//Math.random() * ( max - min ) returns a value in the range [0, max – min] where max is excluded
        float timer=0;

        while(golo2<10){
            TimeUnit.SECONDS.sleep(1);
            switch (zona_do_campo) {
                case 0 -> {
                    if(calcula_defesa_ataque(e1, e2)==2) {
                        if(calcula_ataque_guardaRedes(e2,e1)==1) {
                            golo2++;
                            System.out.println("GOLO EQUIPA 2\n");
                        }else{
                            System.out.println("Guarda Redes defendeu!");
                        }
                    }else{
                        System.out.println("Equipa 1 defendeu o ataque\n");
                        System.out.println("Equipa 1 avança para o meio campo\n");
                    }
                    zona_do_campo=1;
                    equipa_bola=1;
                }
                case 1 -> {
                    if (calcula_medio_medio(e1, e2) == 1) {
                        if(equipa_bola==1) System.out.println("Equipa 1 manteve a bola no meio campo\n");else System.out.println("Equipa 1 roubou a bola no meio campo\n");
                        equipa_bola = 1;
                        zona_do_campo = 2;
                        System.out.println("Equipa 1 ataca\n");
                    } else {
                        if(equipa_bola==2) System.out.println("Equipa 2 manteve a bola no meio campo\n");else System.out.println("Equipa 2 roubou a bola no meio campo\n");
                        equipa_bola = 2;
                        zona_do_campo = 0;
                        System.out.println("Equipa 2 ataca\n");
                    }
                }

                case 2 -> {
                    if(calcula_defesa_ataque(e2, e1)==1) {
                        if(calcula_ataque_guardaRedes(e1,e2)==1) {
                            golo1++;
                            System.out.println("GOLO EQUIPA 1\n");
                        }else{
                            System.out.println("Guarda Redes defendeu!");
                        }
                    }else{
                        System.out.println("Equipa 2 defendeu o ataque\n");
                        System.out.println("Equipa 2 avança para o meio campo \n");
                    }
                    zona_do_campo=1;
                    equipa_bola=2;
                }
            }
        }



    }

    public int calcula_defesa_ataque(Equipa e1,Equipa e2){
        double defe1 = e1.jogadores_suplentes.values().stream().map(Jogador::clone).filter(e -> e instanceof Defesa).mapToDouble(Jogador::calculaCapacidade).sum();
        double atae2 = e2.jogadores_suplentes.values().stream().map(Jogador::clone).filter(e -> e instanceof Avancado || e instanceof Lateral).mapToDouble(Jogador::calculaCapacidade).sum();
        double mede2 = e2.jogadores_suplentes.values().stream().map(Jogador::clone).filter(e -> e instanceof Medio).mapToDouble(Jogador::calculaCapacidade).sum();
        double total2 = 0.70*atae2 + 0.30*mede2;
        return ((int) (Math.random() * (defe1+total2+1)))<= (int)defe1? 1:2 ;
    }

    public int calcula_medio_medio(Equipa e1,Equipa e2){

        double mede1 = e1.jogadores_suplentes.values().stream().map(Jogador::clone).filter(e -> e instanceof Medio || e instanceof Lateral).mapToDouble(Jogador::calculaCapacidade).sum();
        double mede2 = e2.jogadores_suplentes.values().stream().map(Jogador::clone).filter(e -> e instanceof Medio || e instanceof Lateral).mapToDouble(Jogador::calculaCapacidade).sum();
        return ((int) (Math.random() * (mede1+mede2+1)))<= (int)mede1? 1:2 ;

    }

    public int calcula_ataque_guardaRedes(Equipa e1,Equipa e2){

        ArrayList<Avancado> avae1 = e1.jogadores_suplentes.values().stream().map(Jogador::clone).filter(e -> e instanceof Avancado).map(Avancado.class::cast).collect(Collectors.toCollection(ArrayList::new));
        int sizeAva = avae1.size();
        int randomAva = (int) (Math.random() *(sizeAva));
        ArrayList<Medio> mede1 = e1.jogadores_suplentes.values().stream().map(Jogador::clone).filter(e -> e instanceof Medio).map(Medio.class::cast).collect(Collectors.toCollection(ArrayList::new));
        int sizeMed = mede1.size();
        int randomMed = (int) (Math.random() *(sizeMed));
        ArrayList<Lateral> late1 = e1.jogadores_suplentes.values().stream().map(Jogador::clone).filter(e -> e instanceof Lateral).map(Lateral.class::cast).collect(Collectors.toCollection(ArrayList::new));
        int sizeLat = late1.size();
        int randomLat = (int) (Math.random() *(sizeLat));

        double remate;
        Jogador j;
        int remate_chance = (int) (Math.random() * 100);
        if(remate_chance<=49) {j = avae1.get(randomAva);}else
        if(remate_chance <=84) {j = mede1.get(randomMed);}else
        {j = late1.get(randomLat);}
        remate = j.getRemate();
        System.out.println(j.getNome() + " rematou!");


        Guarda_Redes g  = e2.jogadores_suplentes.values().stream().map(Jogador::clone).filter(e->e instanceof Guarda_Redes).map(Guarda_Redes.class::cast).collect(Collectors.toCollection(ArrayList::new)).get(0);

        int decisao = (int)(Math.random() * (remate+g.getElasticidade()+1));
        return (decisao <= remate) ? 1:2;



    }


}
