package contateste;

import java.util.Scanner;
import javax.swing.JFrame;

public class ContaTeste {

    public static void main(String[] args) {
        /*int sair = 0;
        int o = 0, i, valor, achei = 0;
        Conta c[] = new Conta[10];
        String nome;
        int numero;
        float saldo;
        float limiteNegativo;
        float rendimento;
        CriaFile app = new CriaFile();
        ReadTextFile leitura = new ReadTextFile();*/
        
        
        /*i = Conta.getNumeroDeContas();
        System.out.printf("%d\n", i);
        Scanner input = new Scanner(System.in);*/
        
        FramePrincipal telaInicial = new FramePrincipal();
        telaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaInicial.setSize(500, 250);
        telaInicial.setLocationRelativeTo(null);
        telaInicial.setVisible(true);
        
        
        
        /*while(sair != 1){
            System.out.println("1- Criar uma conta simples");
            System.out.println("2- Criar uma conta especial");
            System.out.println("3- Criar uma conta poupanca");
            System.out.println("4- Consultar saldo");
            System.out.println("5- Deposito");
            System.out.println("6- Saque");
            System.out.println("7- Incremento de rendimento");
            System.out.println("0- Sair");
            o = input.nextInt();
            
               switch(o){
                   case 1:
                    System.out.printf("Insira o nome do titular: ");
                    nome = input.next();
                    System.out.printf("Insira o numero da conta: ");
                    numero = input.nextInt();
                    System.out.printf("Insira o saldo da conta: ");
                    saldo = input.nextFloat();

                    for(int j = 0; j < i; j++){
                         if(c[j].getNumero() == numero){
                            achei = 1;
                         }
                     }
                     if(achei == 1){
                         System.out.println("Conta ja existe!!!");
                     }
                     else{
                         c[i] = new ContaSimples(nome, numero, saldo);
                         i++;
                         System.out.println("Conta criada com sucesso!!!\n");
                    }
                    achei = 0;
                    break;

                    case 2:
                       System.out.printf("Insira o nome do titular: ");
                       nome = input.next();
                       System.out.printf("Insira o numero da conta: ");
                       numero = input.nextInt();
                       System.out.printf("Insira o saldo da conta: ");
                       saldo = input.nextFloat();
                       System.out.printf("Insira o limite dos saques negativos: ");
                       limiteNegativo = input.nextFloat();
                       
                        for(int j = 0; j < i; j++){
                            if(c[j].getNumero() == numero){
                               achei = 1;
                            }
                        }
                        if(achei == 1){
                            System.out.println("Conta ja existe!!!");
                        }
                        else{
                            c[i] = new ContaEspecial(nome, numero, saldo, limiteNegativo);
                            i++;
                            System.out.println("Conta criada com sucesso!!!\n");
                        }
                        achei = 0;
                       break;
                       
                    case 3:
                       System.out.printf("Insira o nome do titular: ");
                       nome = input.next();
                       System.out.printf("Insira o numero da conta: ");
                       numero = input.nextInt();
                       System.out.printf("Insira o saldo da conta: ");
                       saldo = input.nextFloat();
                       System.out.printf("Insira a taxa de rendimento: ");
                       rendimento = input.nextFloat();
                       
                       for(int j = 0; j < i; j++){
                            if(c[j].getNumero() == numero){
                               achei = 1;
                            }
                        }
                        if(achei == 1){
                            System.out.println("Conta ja existe!!!");
                        }
                        else{
                            c[i] = new ContaPoupanca(nome, numero, saldo, rendimento);
                            i++;
                            System.out.println("Conta criada com sucesso!!!\n");
                        }
                        achei = 0;
                        break;
                       
                    case 4:
                       System.out.printf("Insira o numero da conta: ");
                       numero = input.nextInt();
                                              
                        for(int j = 0; j < i; j++){
                            if(c[j].getNumero() == numero){
                               achei = 1;
                               System.out.printf("\nSaldo = %.2f\n\n", c[j].getSaldo());
                            }
                        }
                        if(achei == 0){
                            System.out.println("Conta não encontrada!!!\n");
                        }
                        achei = 0;
                       
                       break;
                       
                    case 5:
                       System.out.printf("Insira o numero da conta: ");
                       numero = input.nextInt();
                       
                       for(int j = 0; j < i; j++){
                            if(c[j].getNumero() == numero){
                              achei = 1;
                              System.out.println("Insira o valor do deposito");
                              valor = input.nextInt();
                              
                              c[j].deposito(valor);
                              System.out.println("\nDeposito feito com sucesso!!!\n");
                            }
                       }
                       if(achei == 0){
                            System.out.println("Conta não encontrada!!!\n");
                        }
                       achei = 0;
                       
                       break;
                       
                    case 6:
                        System.out.printf("Insira o numero da conta: ");
                        numero = input.nextInt();
                       
                        for(int j = 0; j < i; j++){
                            if(c[j].getNumero() == numero){
                              achei = 1;
                              System.out.printf("Insira o valor do saque: ");
                              valor = input.nextInt();
                              c[j].saque(valor);
                            }
                        }
                        
                        if(achei == 0){
                            System.out.println("Conta não encontrada!!!\n");
                        }
                        achei = 0;
                       
                        break;
                  
                    case 7:
                        for(int j = 0; j < i; j++){
                            if(c[j] instanceof ContaPoupanca){
                            ContaPoupanca aux = (ContaPoupanca)c[j];
                            aux.incremento();
                            }
                        }
                        break;
		
                   case 0:
                            app.openFile();
                            app.addRecords(c, 10);
                            app.closeFile();
                        sair = 1;
                        break;
                        
                   default:
                        System.out.println("Entrada invalida!");
               }
        }*/
    }
    
}
