import java.util.ArrayList;


public abstract class Jogador{
    
    protected String nome;
    protected float velocidade;
    protected float resistencia;
    protected float destreza;
    protected float impulsao;
    protected float jogo_de_cabeca;
    protected float remate;
    protected float capacidade_de_passe;
    protected ArrayList<String> historico_eq;

    public Jogador(){

        this.nome="";
        this.velocidade=0;
        this.resistencia=0;
        this.destreza=0;
        this.impulsao=0;
        this.jogo_de_cabeca=0;
        this.remate=0;
        this.capacidade_de_passe = 0;
        this.historico_eq=new ArrayList<String>();
        

    }

    public Jogador(String nome,float velocidade,float resistencia,float destreza,float impulsao,float jogo_de_cabeca,float remate,float capacidade_de_passe, ArrayList<String> historico_eq){

        this.nome=nome;
        this.velocidade=velocidade;
        this.resistencia=resistencia;
        this.destreza=destreza;
        this.impulsao=impulsao;
        this.jogo_de_cabeca=jogo_de_cabeca;
        this.remate=remate;
        this.capacidade_de_passe=capacidade_de_passe;
        this.setHistorico_eq(historico_eq);

    }

    public Jogador(Jogador j){
        
        this.nome=j.getNome();
        this.velocidade = j.getVelocidade();
        this.resistencia=j.getResistencia();
        this.destreza=j.getDestreza();
        this.impulsao=j.getImpulsao();
        this.jogo_de_cabeca=j.getJogo_de_cabeca();
        this.remate=j.getRemate();
        this.capacidade_de_passe=j.getCapacidade_de_passe();
        this.setHistorico_eq(j.getHistorico_eq());



    }
    

    public float getVelocidade(){

        return this.velocidade;

    }

    public float getDestreza(){

        return this.destreza;

    }

    public float getResistencia(){

        return this.resistencia;

    }



    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }


    public void setResistencia(float resistencia) {
        this.resistencia = resistencia;
    }


    public void setDestreza(float destreza) {
        this.destreza = destreza;
    }


    public float getImpulsao() {
        return this.impulsao;
    }


    public void setImpulsao(float impulsao) {
        this.impulsao = impulsao;
    }


    public float getJogo_de_cabeca() {
        return this.jogo_de_cabeca;
    }


    public void setJogo_de_cabeca(float jogo_de_cabeca) {
        this.jogo_de_cabeca = jogo_de_cabeca;
    }


    public float getRemate() {
        return this.remate;
    }


    public void setRemate(float remate) {
        this.remate = remate;
    }


    public float getCapacidade_de_passe() {
        return this.capacidade_de_passe;
    }

    public void setCapacidade_de_passe(float capacidade_de_passe) {
        this.capacidade_de_passe = capacidade_de_passe;
    }

    public ArrayList<String> getHistorico_eq(){
        return this.historico_eq;
    }
    
    public void setHistorico_eq (ArrayList<String> lista){        
        this.historico_eq = new ArrayList<>();
        //this.historico_eq.addAll(lista);
        for(String j:lista){
            this.historico_eq.add(j);
        }
    }
    
    public String toString(){
        String str = getNome() + ":" 
        + "\nVelocidade ->"           + getVelocidade() 
        + "\nDestreza ->"             + getDestreza() 
        + "\nImpulsao ->"             + getImpulsao() 
        + "\nJogo de cabeca ->"       + getJogo_de_cabeca() 
        + "\nRemate ->"               + getRemate() 
        + "\nCapacidade de passe ->"  + getCapacidade_de_passe()
        + "\nHistorico de clubes ->" + getHistorico_eq() + '\n';
        return str;
    }


    public String getNome(){

        return this.nome;
    }


    public abstract double calculaCapacidade();

    public abstract Jogador clone();

}



//_______________________________________________________________________________________________________________________________________________________



class Defesa extends Jogador{

    private float cap_defesa; 
    
    public Defesa(){
        super();
        this.cap_defesa = 0;
    } 

    public Defesa(String nome,float velocidade,float resistencia,float destreza,float impulsao,float jogo_de_cabeca,float remate,float capacidade_de_passe, ArrayList<String> historico_eq,float cap_defesa){

        super(nome,velocidade,resistencia,destreza,impulsao,jogo_de_cabeca,remate,capacidade_de_passe,historico_eq);
        this.cap_defesa = cap_defesa;

    }

    public Defesa(Defesa d){
        super(d);
        this.cap_defesa = d.getCap_defesa();
    }

    public float getCap_defesa() {
        return this.cap_defesa;
    }

    public void setCap_defesa(float cap_defesa) {
        this.cap_defesa = cap_defesa;
    }
    
    
    public String toString(){
        String str = getNome() + ":" 
        + "\nVelocidade ->"           + getVelocidade() 
        + "\nDestreza ->"             + getDestreza() 
        + "\nImpulsao ->"             + getImpulsao() 
        + "\nJogo de cabeca ->"       + getJogo_de_cabeca() 
        + "\nRemate ->"               + getRemate() 
        + "\nCapacidade de passe ->"  + getCapacidade_de_passe()
        + "\n Historico de clubes ->" + getHistorico_eq()
        + "\nCapacidade de defesa ->" + getCap_defesa()+'\n';
        return str;
    }



    public double calculaCapacidade(){
        return (this.velocidade+this.resistencia+this.destreza+this.capacidade_de_passe)*0.8
                +(this.impulsao+this.remate+this.jogo_de_cabeca)*0.6
                +this.cap_defesa;

    }

    public Defesa clone(){
        return new Defesa(this);
    }



}


//_______________________________________________________________________________________________________________________________________________________



class Lateral extends Jogador{

    private float cap_cruzar;
    
    public Lateral(){
        super();
        this.cap_cruzar = 0;
    } 

    public Lateral(String nome,float velocidade,float resistencia,float destreza,float impulsao,float jogo_de_cabeca,float remate,float capacidade_de_passe,ArrayList<String> historico_eq,float cap_cruzar){

        super(nome,velocidade,resistencia,destreza,impulsao,jogo_de_cabeca,remate,capacidade_de_passe,historico_eq);
        this.cap_cruzar = cap_cruzar;
    }

    public Lateral(Lateral l){
        super(l);
        this.cap_cruzar = l.getCap_cruzar();
    }
    
    public float getCap_cruzar() {
        return this.cap_cruzar;
    }

    public void setCap_cruzar(float cap_cruzar) {
        this.cap_cruzar = cap_cruzar;
    }

    public String toString(){
        String str = getNome() + ":" 
        + "\nVelocidade ->"           + getVelocidade() 
        + "\nDestreza ->"             + getDestreza() 
        + "\nImpulsao ->"             + getImpulsao() 
        + "\nJogo de cabeca ->"       + getJogo_de_cabeca() 
        + "\nRemate ->"               + getRemate() 
        + "\nCapacidade de passe ->"  + getCapacidade_de_passe()
        + "\n Historico de clubes ->" + getHistorico_eq()
        + "\nCapacidade de cruzar ->" + getCap_cruzar() +'\n'; 
        return str;
    }

    public double calculaCapacidade(){

        return (this.getResistencia()+this.getDestreza())*0.8
                +(this.getImpulsao()+this.getRemate()+this.getJogo_de_cabeca())*0.6
                +this.getCap_cruzar()+this.getVelocidade()+this.getCapacidade_de_passe();

    }

    public Lateral clone(){
        return new Lateral(this);
    }


}


//_______________________________________________________________________________________________________________________________________________________



class Avancado extends Jogador{

    private float cap_marcar;
    
    public Avancado(){
        super();
        this.cap_marcar = 0;
    } 

    public Avancado(String nome,float velocidade,float resistencia,float destreza,float impulsao,float jogo_de_cabeca,float remate,float capacidade_de_passe,ArrayList<String> historico_eq,float cap_marcar){

        super(nome,velocidade,resistencia,destreza,impulsao,jogo_de_cabeca,remate,capacidade_de_passe,historico_eq);
        this.cap_marcar = cap_marcar;
    }

    public Avancado(Avancado a){
        super(a);
        this.cap_marcar=a.getCap_marcar();
        
    }

    public float getCap_marcar() {
        return this.cap_marcar;
    }

    public void setCap_marcar(float cap_marcar) {
        this.cap_marcar = cap_marcar;
    }
    
    public String toString(){
        String str = getNome() + ":" 
        + "\nVelocidade ->"           + getVelocidade() 
        + "\nDestreza ->"             + getDestreza() 
        + "\nImpulsao ->"             + getImpulsao() 
        + "\nJogo de cabeca ->"       + getJogo_de_cabeca() 
        + "\nRemate ->"               + getRemate() 
        + "\nCapacidade de passe ->"  + getCapacidade_de_passe()
        + "\n Historico de clubes ->" + getHistorico_eq()
        + "\nCapacidade de marcar ->" + getCap_marcar() +'\n';
        return str;
    }

    public double calculaCapacidade(){

        return (this.getResistencia()+this.getCapacidade_de_passe())*0.8
                +this.getVelocidade()+this.getImpulsao()+this.getRemate()+this.getJogo_de_cabeca()+this.getDestreza()+this.getCap_marcar();

    }

    public Avancado clone(){
        return new Avancado(this);
    }

}




//_______________________________________________________________________________________________________________________________________________________





class Medio extends Jogador{

    private float cap_medio;
    
    public Medio(){
        super();
        this.cap_medio = 0;
    } 

    public Medio(String nome,float velocidade,float resistencia,float destreza,float impulsao,float jogo_de_cabeca,float remate,float capacidade_de_passe,ArrayList<String> historico_eq, float cap_medio){

        super(nome,velocidade,resistencia,destreza,impulsao,jogo_de_cabeca,remate,capacidade_de_passe,historico_eq);
        this.cap_medio = cap_medio;
    }

    public Medio(Medio m){
        super(m);
        this.cap_medio=m.getCap_medio();
    }
    
    public float getCap_medio() {
        return this.cap_medio;
    }

    public void setCap_medio(float cap_medio) {
        this.cap_medio = cap_medio;
    }

    public String toString(){
        String str = getNome() + ":" 
        + "\nVelocidade ->"           + getVelocidade() 
        + "\nDestreza ->"             + getDestreza() 
        + "\nImpulsao ->"             + getImpulsao() 
        + "\nJogo de cabeca ->"       + getJogo_de_cabeca() 
        + "\nRemate ->"               + getRemate() 
        + "\nCapacidade de passe ->"  + getCapacidade_de_passe()
        + "\n Historico de clubes ->" + getHistorico_eq()
        + "\nCapacidade de Medio ->"  + getCap_medio() +'\n';
        return str;
    }

    public double calculaCapacidade(){

        return (this.getResistencia()+this.getVelocidade())*0.8
                +(this.getImpulsao()+this.getRemate()+this.getJogo_de_cabeca())*0.6
                +this.getDestreza()+this.getCapacidade_de_passe();

    }

    public Medio clone(){
        return new Medio(this);
    }


}



//_______________________________________________________________________________________________________________________________________________________



class Guarda_Redes extends Jogador{

    private float elasticidade;

    public Guarda_Redes(){
        super();
        this.elasticidade=0;
    } 

    public Guarda_Redes(String nome,float velocidade,float resistencia,float destreza,float impulsao,float jogo_de_cabeca,float remate,float capacidade_de_passe,ArrayList<String> historico_eq,float elasticidade){

        super(nome,velocidade,resistencia,destreza,impulsao,jogo_de_cabeca,remate,capacidade_de_passe,historico_eq);
        this.elasticidade=elasticidade;

    }

    public Guarda_Redes(Guarda_Redes g){
        super(g);
        this.elasticidade=g.getElasticidade();
    }


    public float getElasticidade() {
        return this.elasticidade;
    }

    public void setElasticidade(float elasticidade) {
        this.elasticidade = elasticidade;
    }


    public String toString(){
        String str = getNome() + ":" 
        + "\nVelocidade ->"           + getVelocidade() 
        + "\nDestreza ->"             + getDestreza() 
        + "\nImpulsao ->"             + getImpulsao() 
        + "\nJogo de cabeca ->"       + getJogo_de_cabeca() 
        + "\nRemate ->"               + getRemate() 
        + "\nCapacidade de passe ->"  + getCapacidade_de_passe()
        + "\nElasticidade ->"         + getElasticidade()
        + "\n Historico de clubes ->" + getHistorico_eq() + '\n';
        return str;
    }

    public double calculaCapacidade(){

        return (this.getResistencia()+this.getVelocidade()+this.getRemate()+this.getJogo_de_cabeca())*0.4
                +(this.getDestreza())*0.6
                +this.getElasticidade()+this.getImpulsao();

    }
    public Guarda_Redes clone(){
        return new Guarda_Redes(this);
    }


}
