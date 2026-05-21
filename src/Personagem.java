public class Personagem {
    private String nome;
    private String classe;
    private int forca;
    private int dano;
    private int vida;

    
    //construtor
    
    public Personagem(String nome, String classe, int forca) {
        this.nome = nome;
        this.classe = classe;
        this.forca = forca;

        if(classe.equalsIgnoreCase("MAGO")){
            vida = forca * 1000;
        } else if(classe.equalsIgnoreCase("GUERREIRO")){
            vida = forca * 2000;
        } else if(classe.equalsIgnoreCase("DRUIDA")){
            vida = forca * 500;
        } else {
            vida = forca * 10;
        }
        System.out.println("\n\nPersonagem cadastrado");
        mostrarPersonagem();
    }
    
    //metodos personalizados
    
    private void mostrarPersonagem(){
        System.out.format("Nome: %S \nClasse: %S \nForça: %d \nVida: %d",
            nome, classe, forca, vida
        ); 
    }
    
    
    //getters setters
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}
