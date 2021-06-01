import Jogador.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Jogo {

    private Equipa e1;
    private Equipa e2;
    private LocalDate data;


    private String resultadoFinal;
    private List<Golo> marcadores;
    private List<String> cartoes;
    private List<String> expulsoes;
    private List<String> substituidos;
    private int posse_de_bola1;
    private int posse_de_bola2;
    private double remates1;
    private double remates2;
    private double accuracy1;
    private double accuracy2;
    private int faltas;
    private int foras;
    private int defesas1;
    private int defesas2;
    private int substituicao1;
    private int substituicao2;



    public Jogo(Equipa equipa1, Equipa equipa2, LocalDate data) {
        this.e1 = equipa1;
        this.e2 = equipa2;
        this.data = data;
        this.resultadoFinal = "";
        this.marcadores = new ArrayList<>();
        this.cartoes = new ArrayList<>();
        this.expulsoes = new ArrayList<>();
        this.substituidos = new ArrayList<>();
        this.posse_de_bola1 = 0;
        this.posse_de_bola2 = 0;
        this.remates1 = 0;
        this.remates2 = 0;
        this.accuracy1 = 0.0;
        this.accuracy2 = 0.0;
        this.faltas=0;
        this.defesas1=0;
        this.defesas2=0;
        this.foras=0;
        this.substituicao1=0;
        this.substituicao2=0;

    }

    public void simulaJogo() throws InterruptedException {

        int equipa_bola;
        int subs_prob;
        double posse_bola1 = 0;
        int subs_valida;
        int fora;
        int subs;
        int zona_do_campo = 1;
        int golo1 = 0, golo2 = 0;
        equipa_bola = (int) (Math.random() * 2) == 0 ? 1 : 2;//Math.random() * ( max - min ) returns a value in the range [0, max – min] where max is excluded
        float timer = 0;
        this.e1.constroiEquipa(4, 3, 3);
        this.e2.constroiEquipa(4, 3, 3);


        while(timer<90){
            TimeUnit.SECONDS.sleep(1);
            System.out.print(timer+": ");
            int a = calculaFaltas(zona_do_campo,equipa_bola,e1,e2);
            if(a==1) {
                equipa_bola = equipa_bola==1?0:1;

            }else
            switch (zona_do_campo) {
                case 0 :
                    if (calcula_defesa_ataque(e1, e2) == 2) {

                        if (calcula_ataque_guardaRedes(e2, e1,timer) == 1) {
                            golo2++;

                            System.out.println(e1.getNome()+ "  " + golo1 + " - " + golo2 + "  "  +e2.getNome() + '\n');
                        }else{
                            this.defesas1++;
                        }
                        this.remates2++;
                    } else {
                        System.out.println(e1.getNome() + " defendeu o ataque e passa para o contra-ataque\n");
                        posse_bola1++;//added
                    }
                    zona_do_campo = 1;
                    equipa_bola = 1;

                    break;

                case 1 :
                    if (calcula_medio_medio(e1, e2) == 1) {
                        if(equipa_bola==1) System.out.println(e1.getNome() + " manteve a bola no meio campo e começa a ganhar terreno\n");else System.out.println(e1.getNome() + " roubou a bola no meio campo e inicia o contra-ataque\n");
                        equipa_bola = 1;
                        posse_bola1++;//added
                        zona_do_campo = 2;
                    } else {
                        if(equipa_bola==2) System.out.println(e2.getNome() + " manteve a bola no meio campo e começa a ganhar terreno\n");else System.out.println(e2.getNome() + " roubou a bola no meio campo e inicia o contra-ataque\n");
                        equipa_bola = 2;
                        zona_do_campo = 0;
                    }
                    fora = (int) (Math.random() * 10) < 4 ? 1 : 0;
                    equipa_bola = (equipa_bola == 1) ? 2 : 1;
                    if(fora==1){//houve uma fora
                        System.out.println("FORA!\n");
                        this.foras++;
                        subs = (int) (Math.random() * 2) == 0 ? 1 : 2;
                        subs_prob = (int) (Math.random() * 100) < 10 ? 1 : 0;
                        if (subs == 1 && this.substituicao1<3 && subs_prob==1) {

                            subs_valida=substituicao(e1);
                            if(subs_valida==1) this.substituicao1++;
                        }
                        if(subs == 2&&this.substituicao2<3&&subs_prob==1){

                            subs_valida=substituicao(e2);
                            if(subs_valida==1) this.substituicao2++;

                        }
                    }


                    break;

                case 2 :
                    if(calcula_defesa_ataque(e2, e1)==1) {
                        posse_bola1++;

                        if(calcula_ataque_guardaRedes(e1,e2,timer)==1) {
                            golo1++;
                            System.out.println(e1.getNome()+ "  " + golo1 + " - " + golo2 + "  "  +e2.getNome() + '\n');
                        }else{
                            this.defesas2++;
                        }
                        this.remates1++;
                    }else{
                        System.out.println(e2.getNome() + " defendeu o ataque e passa para o contra-ataque\n");

                    }
                    zona_do_campo=1;
                    equipa_bola=2;
                    break;
            }



            timer++;
            if (timer == 45) {//pode ser feita aqui uma tabela;
                System.out.println("\n\n--------------FINAL  DA  PRIMEIRA PARTE--------------\n\n");

                /*Cálculo dos stats*/
                this.posse_de_bola1 = (int) ((posse_bola1 / 45) * 100);
                this.posse_de_bola2 = 100 - this.posse_de_bola1;
                this.accuracy1 = (golo1 / this.remates1) * 100;
                this.accuracy2 = (golo2 / this.remates2) * 100;
                this.resultadoFinal = e1.getNome() + "  " + golo1 + " - " + golo2 + "  " + e2.getNome();
                /*Cálculo dos stats*/

                TimeUnit.SECONDS.sleep(2);
                System.out.println("              " + e1.getNome() + "  VS  " + e2.getNome());
                System.out.println("Resultado:             " + golo1 + "  VS  " + golo2 + "  ");
                System.out.println("Posse de Bola:       " + String.format("%02d", this.posse_de_bola1) + "%" + "  VS  " + String.format("%02d", this.posse_de_bola2) + "%");
                System.out.println("Remates:              " + String.format("%02.0f", this.remates1) + "  VS  " + String.format("%02.0f", this.remates2));
                System.out.println("Accuracy:           " + String.format("%02.0f", this.accuracy1) + "%" + "  VS  " + String.format("%02.0f", this.accuracy2) + "%");
                System.out.println("Defesas:             " + String.format("%02d", this.defesas1) + "  VS  " + String.format("%02d", this.defesas2));
                System.out.println("Substituições:         " + String.format("%d", this.substituicao1) + " VS " + String.format("%d", this.substituicao2));
                System.out.println("Foras: " + this.foras);
                System.out.println("Faltas: " + this.faltas);
                TimeUnit.SECONDS.sleep(5);
                System.out.println("\n\n--------------INICIO DA SEGUNDA PARTE--------------\n\n");

            }

            if (timer == 90) {
                System.out.println("Apito Final");

                /*Cálculo dos stats*/
                this.posse_de_bola1 = (int) ((posse_bola1 / 90) * 100);
                this.posse_de_bola2 = 100 - this.posse_de_bola1;
                this.accuracy1 = (golo1 / this.remates1) * 100;
                this.accuracy2 = (golo2 / this.remates2) * 100;
                this.resultadoFinal = e1.getNome() + "  " + golo1 + " - " + golo2 + "  " + e2.getNome();
                /*Cálculo dos stats*/


                TimeUnit.SECONDS.sleep(2);
                System.out.println("              " + e1.getNome() + "  VS  " + e2.getNome());
                System.out.println("Resultado:             " + golo1 + "  VS  " + golo2 + "  ");
                System.out.println("Posse de Bola:       " + String.format("%02d", this.posse_de_bola1) + "%" + "  VS  " + String.format("%02d", this.posse_de_bola2) + "%");
                System.out.println("Remates:              " + String.format("%02.0f", this.remates1) + "  VS  " + String.format("%02.0f", this.remates2));
                System.out.println("Accuracy:           " + String.format("%02.0f", this.accuracy1) + "%" + "  VS  " + String.format("%02.0f", this.accuracy2) + "%");
                System.out.println("Defesas:             " + String.format("%02d", this.defesas1) + "  VS  " + String.format("%02d", this.defesas2));
                System.out.println("Substituições:         " + String.format("%d", this.substituicao1) + " VS " + String.format("%d", this.substituicao2));
                System.out.println("Foras: " + this.foras);
                System.out.println("Faltas: " + this.faltas);
                System.out.println("Golos: " + this.marcadores.toString());//este print pode ficar melhor
                this.resultadoFinal = e1.getNome() + "  " + golo1 + " - " + golo2 + "  " + e2.getNome();
            }

        }


        e1.desconstroiEquipa();
        e2.desconstroiEquipa();

    }



    public int substituicao(Equipa e){

        Jogador out = e.jogadores_titulares.values().stream().max(new Jogador.comparaCansacos()).orElse(null);
        Class c = out.getClass();

        Jogador in=e.jogadores_suplentes.values().stream().map(Jogador::clone).filter(a -> c.equals(a.getClass())&& !this.substituidos.contains(a.getNome())).max(new Jogador.comparaJogadores()).orElse(null);
        if(in==null) return 0;
        e.jogadores_titulares.remove(out.getNome());
        e.jogadores_suplentes.put(out.getNome(),out);
        e.jogadores_titulares.put(in.getNome(),in);
        e.jogadores_suplentes.remove(in.getNome());
        this.substituidos.add(out.getNome());
        System.out.print("Substituicao: ");
        System.out.println("Entra " + in.getNome() + ", Sai " + out.getNome() + '\n');
        return 1;

    }


    public int calculaFaltas(int zona_do_campo,int equipa_bola,Equipa e1,Equipa e2) throws InterruptedException {

        int falta = (int) (Math.random() * 100)<12?1:0;
        if (falta==0) return 0;
        else {
            this.faltas++;
            System.out.println("FALTA!");
            TimeUnit.SECONDS.sleep(3);
        }
        int equipa_falta;
        int cartao = (int) (Math.random() * 100);
        Equipa x = null;
        if(cartao<80){
            if(equipa_bola==2) {x = e1; equipa_falta = 1;}
            else {x = e2; equipa_falta = 2;}
        }
        else{
            if(equipa_bola==2) { x = e2; equipa_falta = 2;
            }
            else {x = e1; equipa_falta = 1;}
        }
        ArrayList<Jogador> jog = new ArrayList<>();
        Jogador j = null;

        switch (zona_do_campo){
            case 0:
                if(equipa_falta==1)
                jog = x.jogadores_titulares.values()
                        .stream()
                        .map(Jogador::clone)
                        .filter(e -> e instanceof Defesa || e instanceof Medio)
                        .collect(Collectors.toCollection(ArrayList::new));
                else {
                    jog = x.jogadores_titulares.values()
                            .stream()
                            .map(Jogador::clone)
                            .filter(e -> e instanceof Avancado || e instanceof Lateral|| e instanceof Medio)
                            .collect(Collectors.toCollection(ArrayList::new));
                }

                int randomzona0 = (int) (Math.random() *(jog.size()));
                j = jog.get(randomzona0);
                break;

            case 1:

                jog = x.jogadores_titulares.values()
                        .stream()
                        .map(Jogador::clone)
                        .filter(e -> e instanceof Medio || e instanceof Lateral)
                        .collect(Collectors.toCollection(ArrayList::new));

                int randomzona1 = (int) (Math.random() * (jog.size()));
                j = jog.get(randomzona1);
                break;
            case 2:

                if(equipa_falta==2)
                    jog = x.jogadores_titulares.values()
                            .stream()
                            .map(Jogador::clone)
                            .filter(e -> e instanceof Defesa || e instanceof Medio)
                            .collect(Collectors.toCollection(ArrayList::new));
                else {
                    jog = x.jogadores_titulares.values()
                            .stream()
                            .map(Jogador::clone)
                            .filter(e -> e instanceof Avancado || e instanceof Lateral|| e instanceof Medio)
                            .collect(Collectors.toCollection(ArrayList::new));
                }

                int randomDef = (int) (Math.random() *(jog.size()));
                j = jog.get(randomDef);
                break;
        }

        if(cartao<4) {
            x.adiciona_jogador(j);//expulsão
            x.jogadores_titulares.remove(j.getNome());//expulsão
            this.expulsoes.add(j.getNome());
            System.out.println(j.getNome() + " levou cartão vermelho e foi expulso"+'\n');

        }
        else if(cartao<50) {
            if(this.cartoes.contains(j)) {

                x.adiciona_jogador(j);//expulsão
                x.jogadores_titulares.remove(j.getNome());//expulsão
                this.expulsoes.add(j.getNome());
                System.out.println(j.getNome() + " levou o segundo cartão amanerlo e foi expulso"+'\n');
            }
            else {
                this.cartoes.add(j.getNome());
                System.out.println(j.getNome() + " levou cartão amarelo\n");
            }
        }else{
            System.out.println("Não houve cartão"+'\n');
        }



        return 1;
    }


    public int calcula_defesa_ataque(Equipa e1,Equipa e2){

        double defe1=0;
        double mede1=0;

        for(Jogador j:e1.jogadores_titulares.values()){
            if(j instanceof Defesa) {
                j.incrementaCansaco();
                defe1 += j.calculaCapacidade();
            }else
                if(j instanceof Medio){
                    j.incrementaCansaco();
                    mede1 += j.calculaCapacidade();
            }
        }

        double atae2=0;
        double mede2=0;

        for(Jogador j:e2.jogadores_titulares.values()){
            if(j instanceof Avancado || j instanceof Lateral) {
                j.incrementaCansaco();
                atae2 += j.calculaCapacidade();
            }else
            if(j instanceof Medio){
                j.incrementaCansaco();
                mede2 += j.calculaCapacidade();
            }
        }
        //double defe1 = e1.jogadores_titulares.values().stream().map(Jogador::clone).filter(e -> e instanceof Defesa).mapToDouble(Jogador::calculaCapacidade).sum();
        //double mede1 = e1.jogadores_titulares.values().stream().map(Jogador::clone).filter(e -> e instanceof Medio).mapToDouble(Jogador::calculaCapacidade).sum();
        //double atae2 = e2.jogadores_titulares.values().stream().map(Jogador::clone).filter(e -> e instanceof Avancado || e instanceof Lateral).mapToDouble(Jogador::calculaCapacidade).sum();
        //double mede2 = e2.jogadores_titulares.values().stream().map(Jogador::clone).filter(e -> e instanceof Medio).mapToDouble(Jogador::calculaCapacidade).sum();
        double totalata = 0.70*atae2 + 0.30*mede2;
        double totaldef = 0.70*defe1 + 0.30*mede1;
        return ((int) (Math.random() * (totaldef+totalata+1)))<= (int)totaldef? 1:2 ;
    }

    public int calcula_medio_medio(Equipa e1,Equipa e2){

        //double mede1 = e1.jogadores_titulares.values().stream().map(Jogador::clone).filter(e -> e instanceof Medio || e instanceof Lateral).mapToDouble(Jogador::calculaCapacidade).sum();
        //double mede2 = e2.jogadores_titulares.values().stream().map(Jogador::clone).filter(e -> e instanceof Medio || e instanceof Lateral).mapToDouble(Jogador::calculaCapacidade).sum();
        double mede1=0;
        double mede2=0;

        for(Jogador j:e1.jogadores_titulares.values()){
            if(j instanceof Medio || j instanceof Lateral) {
                j.incrementaCansaco();
                mede1 += j.calculaCapacidade();
            }
        }
        for(Jogador j:e2.jogadores_titulares.values()){
            if(j instanceof Medio || j instanceof Lateral) {
                j.incrementaCansaco();
                mede2 += j.calculaCapacidade();
            }
        }
        return ((int) (Math.random() * (mede1+mede2+1)))<= (int)mede1? 1:2 ;

    }

    public int calcula_ataque_guardaRedes(Equipa e1,Equipa e2,float timer) throws InterruptedException{


        ArrayList<Avancado> avae1 = e1.jogadores_titulares.values()
                .stream()
                .map(Jogador::clone)
                .filter(e -> e instanceof Avancado)
                .map(Avancado.class::cast)
                .collect(Collectors.toCollection(ArrayList::new));
        int sizeAva = avae1.size();
        int randomAva = (int) (Math.random() *(sizeAva));

        ArrayList<Medio> mede1 = e1.jogadores_titulares.values()
                .stream()
                .map(Jogador::clone)
                .filter(e -> e instanceof Medio)
                .map(Medio.class::cast)
                .collect(Collectors.toCollection(ArrayList::new));
        int sizeMed = mede1.size();
        int randomMed = (int) (Math.random() *(sizeMed));

        ArrayList<Lateral> late1 = e1.jogadores_titulares.values()
                .stream()
                .map(Jogador::clone)
                .filter(e -> e instanceof Lateral)
                .map(Lateral.class::cast)
                .collect(Collectors.toCollection(ArrayList::new));
        int sizeLat = late1.size();
        int randomLat = (int) (Math.random() *(sizeLat));

        double remate;
        Jogador j;
        int remate_chance = (int) (Math.random() * 100);
        if(remate_chance<=49) {j = avae1.get(randomAva);}else
        if(remate_chance <=84) {j = mede1.get(randomMed);}else
        {j = late1.get(randomLat);}
        remate = j.getRemate();


        Guarda_Redes g  = e2.jogadores_titulares.values()
                .stream()
                .map(Jogador::clone)
                .filter(e->e instanceof Guarda_Redes)
                .map(Guarda_Redes.class::cast)
                .collect(Collectors.toCollection(ArrayList::new)).get(0);

        System.out.println(j.getNome() + " rematou!\n");
        TimeUnit.SECONDS.sleep(1);

        int remate_baliza = (int) (Math.random() * 100);

        if(remate_baliza < 64){

            System.out.println(j.getNome() + " falhou o remate!\n");
            return 2;
        }
        int decisao = (int)(Math.random() * (remate+g.getElasticidade()+1));

        int result = (decisao <= remate) ? 1:2;


        if(result==1) {

            System.out.println("GOLOOOOOOOOO!!!\n");
            this.marcadores.add(new Golo(j.getNome(), timer,e1.nome));
        }else{
            System.out.println(g.getNome() + " defendeu!\n");
        }

        return result;

    }

    private class Golo{

        private String jogador;
        private float minuto;
        private String equipa;

        public Golo(String jogador, float minuto,String equipa) {
            this.jogador = jogador;
            this.minuto = minuto;
            this.equipa = equipa;
        }

        public String toString(){
            return equipa + ": " + jogador + "  " + (int) minuto;
        }


    }


}
