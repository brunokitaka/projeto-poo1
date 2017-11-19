package contateste;
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.*;

public class CriaFile {
    private Formatter output; 
    
    public void openFile()
    {
        try{
            output = new Formatter("clientes.txt");
        }
        catch(SecurityException securityException)
        {
            System.err.println("Voce nao tem acesso a esse arquivo!!!");
            System.exit(1);
        }
        catch(FileNotFoundException fileNotFoundException)
        {
            System.err.println("Erro ao abrir ou criar arquivo!!!");
            System.exit(1);
        }
    }
    
    public void addRecords(Collection c)
    {
        Conta recordSimples = new ContaSimples();
        ContaEspecial recordEspecial = new ContaEspecial();
        ContaPoupanca recordPoupanca = new ContaPoupanca();
        ContaEspecial auxE;
        ContaPoupanca auxP;
        int codigo;
        
        try
        {
            for(Object conta : c)
            {
                if(conta != null)
                    if(conta instanceof ContaSimples)
                    {
                        recordSimples.setNumero(((ContaSimples) conta).getNumero());
                        recordSimples.setNome(((ContaSimples) conta).getNome());
                        recordSimples.setSaldo(((ContaSimples) conta).getSaldo());  
                        codigo = 1;
                        output.format("%d %d %s %.2f\n", codigo, recordSimples.getNumero(), recordSimples.getNome(), recordSimples.getSaldo());
                    }
                    else if(conta instanceof ContaEspecial)
                    {
                        auxE = (ContaEspecial)conta;
                        recordEspecial.setNumero(((ContaEspecial) conta).getNumero());
                        recordEspecial.setNome(((ContaEspecial) conta).getNome());
                        recordEspecial.setSaldo(((ContaEspecial) conta).getSaldo());
                        recordEspecial.setLimiteNegativo(auxE.getLimiteNegativo());
                        codigo = 2;
                        output.format("%d %d %s %.2f %.2f\n", codigo, recordEspecial.getNumero(), recordEspecial.getNome(), recordEspecial.getSaldo(), recordEspecial.getLimiteNegativo());
                    }
                    else if(conta instanceof ContaPoupanca)
                    {
                        auxP = (ContaPoupanca)conta;
                        recordPoupanca.setNumero(((ContaPoupanca) conta).getNumero());
                        recordPoupanca.setNome(((ContaPoupanca) conta).getNome());
                        recordPoupanca.setSaldo(((ContaPoupanca) conta).getSaldo());
                        recordPoupanca.setRendimento(auxP.getRendimento());
                        codigo = 3;
                        output.format("%d %d %s %.2f %.2f\n", codigo, recordPoupanca.getNumero(), recordPoupanca.getNome(), recordPoupanca.getSaldo(), recordPoupanca.getRendimento());
                    }
            }
        }
        catch(FormatterClosedException formatterClosedException)
        {
            System.err.println("\n\nErro na escrita de arquivo!!!\n\n");
        }
        /*catch(NoSuchElementException elementException)
        {
            System.err.println("\n\nEntrada invalida. Please try again.\n\n");
        }*/
    }
    
    public void closeFile()
    {
        if(output != null)
        {
            output.close();
        }
    }
}

