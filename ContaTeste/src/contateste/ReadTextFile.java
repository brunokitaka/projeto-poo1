package contateste;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadTextFile {

    private Scanner input;

    public void openFile() {
        try {
            input = new Scanner(new File("clientes.txt"));

        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Erro abrindo o arquivo");
            System.exit(1);
        }
    }

    public void readRecords(Collection c) {
        Conta recordSimples = new ContaSimples();
        ContaEspecial recordEspecial = new ContaEspecial();
        ContaPoupanca recordPoupanca = new ContaPoupanca();
        int count = 0, teste ;
        
        try {
            while (input.hasNext()) {
                teste = input.nextInt();
                if (teste == 1) 
                {
                    recordSimples.setNumero(input.nextInt());
                    recordSimples.setNome(input.next());
                    recordSimples.setSaldo(input.nextFloat());
                    c.add(recordSimples);
                    //System.out.printf("%d %s %f\n", c[count].getNumero(), c[count].getNome(), c[count].getSaldo()); //teste
                    //count++;
                }
                else
                {
                    if(teste == 2)
                    {
                        recordEspecial.setNumero(input.nextInt());
                        recordEspecial.setNome(input.next());
                        recordEspecial.setSaldo(input.nextFloat());
                        recordEspecial.setLimiteNegativo(input.nextFloat());
                        c.add(recordEspecial);
                        //count++;
                        //System.out.printf("%d %s %f %f\n", recordEspecial.getNumero(), recordEspecial.getNome(), recordEspecial.getSaldo(), recordEspecial.getLimiteNegativo());
                    }
                    if(teste == 3)
                    {
                        recordPoupanca.setNumero(input.nextInt());
                        recordPoupanca.setNome(input.next());
                        recordPoupanca.setSaldo(input.nextFloat());
                        recordPoupanca.setRendimento(input.nextFloat());
                        c.add(recordPoupanca);
                        //count++;
                        //System.out.printf("%d %s %f %f\n", recordPoupanca.getNumero(), recordPoupanca.getNome(), recordPoupanca.getSaldo(), recordPoupanca.getRendimento());
                    }
                }
            }
            //Conta.setNumeroDeContas(count);
        } catch (NoSuchElementException elementException) {
            System.err.println("Arquivo fora de formatacao");
            input.close();
            System.exit(1);
        } catch (IllegalStateException stateException) {
            System.err.println("Erro: Nao foi possivel ler o arquivo");
            System.exit(1);
        }
    }

    public void closeFile() {
        if (input != null) {
            input.close();
        }
    }
}
