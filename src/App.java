import java.util.ArrayList;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        ArrayList<Jogador> t=new ArrayList<>();
        ArrayList<Jogador> s=new ArrayList<>();
        Jogador j= new Jogador(1f,2f,3f,4f,5f,6f,7f);
        t.add(j);
        Equipa e= new Equipa("Bomdia\n",t,s);
        e.adiciona_jogador(j);
        e.jogadores_suplentes.add(j);
        System.out.println(s.size());
        //System.out.println(t.toString());
        //System.out.println(t.get(0).velocidade);
        //System.out.println(t.get(0).resistencia);
        //System.out.println(t.get(0).destreza);
        //System.out.println(t.get(0).impulsao);
        //System.out.println(t.get(0).jogo_de_cabeca);
        //System.out.println(t.get(0).remate);
        //System.out.println(t.get(0).capacidade_de_passe);
//
        System.out.println(t.size());


    }

}
