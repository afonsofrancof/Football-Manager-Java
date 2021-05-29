import java.util.List;

public class Jogo {

    private String resultadoFinal;
    private List<Jogador> marcadores;
    private double posse_de_bola;
    private int passes;
    private int remates;
    private double accuracy;

    public void simulaJogo(Equipa e1,Equipa e2){

        double stats1 = e1.calculaStats();
        double stats2 = e2.calculaStats();
        int moeda_ao_ar = (int) (Math.random() * 2) == 0 ? 1 : 2;//Math.random() * ( max - min ) returns a value in the range [0, max – min] where max is excluded
        float timer;




    }



}
