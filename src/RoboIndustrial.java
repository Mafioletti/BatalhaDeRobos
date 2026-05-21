public class RoboIndustrial {
    private String nome;
    private int energia;
    private int ataque;
    private int defesa;

    //construtor
    public RoboIndustrial(String nome, int energia, int ataque, int defesa) {
        this.nome = nome;
        this.energia = energia;
        this.ataque = ataque;
        this.defesa = defesa;
    }
    //métodos

    public int atacar(){
        if(ataque == 0){
            return 0;
        } else {
            return ataque;
        }
    }
    public void exibirStatus(){
        System.out.format("\nNome: %S \nEnergia: %S \nAtaque: %d \nDefesa: %d", 
            nome, energia, ataque, defesa
        );
    }
    public String estaFuncionando(){
            return energia > 0 ? "Está funcionando" : "Parou de funcionar";
    }
    //get e set

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
}