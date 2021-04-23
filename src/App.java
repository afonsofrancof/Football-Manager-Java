public class App {
    public static void main(String[] args){
        
        Jogador j1= new Lateral("Mona Grossa",9f,9f,9f,9f,9f,9f,9f);
        Jogador j2= new Guarda_Redes("Pipi",1f,1f,1f,1f,1f,1f,1f,1f);
        Jogador j3= new Avancado("Gambi",5f,5f,5f,5f,5f,5f,5f);
        Jogador j4= new Medio("Gatinho Gordo",2f,2f,2f,2f,2f,2f,2f);
        Jogador j5= new Defesa("Garanito",10f,10f,5f,1f,1f,10f,1f);
        //t.add(j);
        Equipa e= new Equipa("FC Cabouco");
        Equipa a= new Equipa("FC Santana");

        e.adiciona_jogador(j1);
        e.adiciona_jogador(j2);
        e.adiciona_jogador(j3);
        e.adiciona_jogador(j4);
        e.adiciona_jogador(j5);

        System.out.println("Old team:");
        System.out.println(e.getJogadores_suplentes());

        e.mudaParaEquipa(a, j2);
        
        System.out.println("New team:");
        System.out.println(a.getJogadores_suplentes());
        System.out.println("Old team:");
        System.out.println(e.getJogadores_suplentes());

        e.remove_jogador(j1);
        e.remove_jogador(j2);
        e.remove_jogador(j3);
        e.remove_jogador(j4);
        e.remove_jogador(j5);

        
        System.out.println(e.getJogadores_suplentes());




    }

}
