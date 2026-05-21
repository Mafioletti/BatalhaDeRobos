import java.util.Random;
import java.util.Scanner;

public class BatalhaRobosMain {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        RoboIndustrial r1 = new RoboIndustrial("Atom", 130, 10, 0);
        RoboIndustrial r2 = new RoboIndustrial("Zeus", 110, 10, 0);

        int energiaR1 = r1.getEnergia();
        int defesaR1 = r1.getDefesa();
        int valorAtaqueR1 = r1.atacar();
        int energiaR2 = r2.getEnergia();
        int defesaR2 = r2.getDefesa();
        int valorAtaqueR2 = r2.atacar();
        int startR1 = energiaR1;
        int startR2 = energiaR2;
        int qtdVezesR1 = 1;
        int qtdVezesR2 = 1;

        System.out.println("==BATALHA DE ROBÔS==");
        r1.exibirStatus();
        System.out.println("\n\n== X ==");
        r2.exibirStatus();

        do { 
            System.out.println("\n\nTURNO DE " + r1.getNome());
            r1.exibirStatus();
            System.out.println("\n\nAção que deseja executar: ");
            System.out.println("1. Atacar");
            System.out.println("2. Curar");
            System.out.println("3.Ataque especial");
            int opcao1 = sc.nextInt();
            
            switch (opcao1) {
                case 1:
                    Random ataqueCriticRandomR1 = new Random();
                    int fatorCriticoR1 = ataqueCriticRandomR1.nextInt(6) + 1;
                    if(fatorCriticoR1 == 6){
                        System.out.println("Ataque Crítico !!!");
                        valorAtaqueR1 *= 2;
                        valorAtaqueR1 -= defesaR2;
                        if(valorAtaqueR1 < 0){
                            valorAtaqueR1 = 0;
                        }
                        energiaR2 -= valorAtaqueR1;
                        r2.setEnergia(energiaR2);
                    }
                    valorAtaqueR1 -= defesaR2;
                    if(valorAtaqueR1 < 0){
                        valorAtaqueR1 = 0;
                    }
                    energiaR2 -= valorAtaqueR1;
                    r2.setEnergia(energiaR2);
                    break;
                case 2:
                    int energiaAtualR1 = r1.getEnergia();
                    Random cura = new Random();
                    int fatorCuraR1 = cura.nextInt(20) + 1;
                    if(energiaAtualR1 < startR1){
                        energiaAtualR1 += fatorCuraR1;
                        r1.setEnergia(energiaAtualR1);
                    } else {
                        System.out.println("Robô não pode curar, turno perdido");
                    }
                    break;
                    case 3:
                        if(qtdVezesR1 == 1){
                        System.out.println(r1.getNome() + " usou o ataque especial");
                        int fatorR1 = 3;
                        int valorAtaqueEspecialR1 = valorAtaqueR1 * fatorR1;
                        valorAtaqueEspecialR1 -= defesaR2;
                        if(valorAtaqueR1 < 0){
                            valorAtaqueR1 = 0;
                        }
                        energiaR2 -= valorAtaqueEspecialR1;
                        r2.setEnergia(energiaR2);
                        qtdVezesR1 -= 1;
                    } else {
                        System.out.println("Ataque especial já foi usado, turno perdido seu bobão :(");
                    }
                    break;
                    default:
                        System.out.println("Opção Indisponível");
            }
            r2.exibirStatus();
            System.out.println("\n\nAção que deseja executar: ");
            System.out.println("1. Atacar");
            System.out.println("2. Curar");
            System.out.println("3. Ataque Especial");
            int opcao2 = sc.nextInt();
            
            switch (opcao2) {
                case 1:
                    Random ataqueCriticRandom = new Random();
                    int fatorCriticoR2 = ataqueCriticRandom.nextInt(6) + 1;
                    if(fatorCriticoR2 == 6){
                        System.out.println("Ataque Crítico !!!");
                        valorAtaqueR2 *= 2;
                        valorAtaqueR2 -= defesaR1;
                        if(valorAtaqueR2 < 0){
                            valorAtaqueR2 = 0;
                        }
                        energiaR1 -= valorAtaqueR2;
                        r1.setEnergia(energiaR1);
                    } else {
                        valorAtaqueR2 -= defesaR1;
                        if(valorAtaqueR2 < 0){
                            valorAtaqueR2 = 0;
                        }
                        energiaR1 -= valorAtaqueR2;
                        r1.setEnergia(energiaR1);
                    }
                    break;
                    case 2:
                        int energiaAtualR2 = r2.getEnergia();
                        Random curaR2 = new Random();
                        int fatorCuraR2 = curaR2.nextInt(20) + 1;
                        if(energiaAtualR2 < startR2){
                            energiaAtualR2 += fatorCuraR2;
                            r1.setEnergia(energiaAtualR2);
                        } else {
                            System.out.println("Robô não pode curar, turno perdido");
                        }
                        break;
                        case 3:
                            if(qtdVezesR2 == 1){
                                System.out.println(r2.getNome() + " usou o ataque especial");
                                int fatorR2 = 3;
                                int valorAtaqueEspecialR2 = valorAtaqueR2 * fatorR2;
                                valorAtaqueEspecialR2 -= defesaR2;
                                if(valorAtaqueR2 < 0){
                                    valorAtaqueR2 = 0;
                                }
                                energiaR1 -= valorAtaqueEspecialR2;
                                r1.setEnergia(energiaR1);
                                qtdVezesR2 -= 1;
                        } else {
                            System.out.println("Ataque especial já foi usado, turno perdido seu bobão :(");
                        }
                    break;
                default:
                    System.out.println("Opção indisponível");
                    }
        } while (energiaR1 > 0 && energiaR2 > 0);
        System.out.println("==RESULTADOS DA BATALHA==\n");

        if(energiaR1 <= 0){
            System.out.println("\nRobô " + r1.getNome() + " foi derrotado.");
            System.out.println("Robô " + r2.getNome() + " venceu !");
        } else if(energiaR2 <= 0){
            System.out.println("Robô " + r2.getNome() + " foi derrotado");
            System.out.println("Robô " + r1.getNome() + " venceu !");
        }
    }
}