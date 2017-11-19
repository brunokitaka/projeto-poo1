package contateste;

import java.util.*;

public class Banco {

    private static Banco instance = new Banco();
    Collection<Conta> contas = new ArrayList();
    int sucedido;
    ReadTextFile leitura = new ReadTextFile();
    CriaFile write = new CriaFile();

    private Banco() {
        leitura.openFile();
        leitura.readRecords(contas);
        leitura.closeFile();
    }

    public static Banco getInstance() {
        return instance;
    }

    public void criaContaSimples(String nome, int numero, float saldo) {
        contas.add(new ContaSimples(nome, numero, saldo));
    }

    public void criaContaEspecial(String nome, int numero, float saldo, float limiteSaldo) {
        contas.add(new ContaEspecial(nome, numero, saldo, limiteSaldo));
    }

    public void criaContaPoupanca(String nome, int numero, float saldo, float rendimento) {
        contas.add(new ContaPoupanca(nome, numero, saldo, rendimento));
    }

    public float consulta(int n) {
        for (Conta c : contas) {
            if (c.getNumero() == n) {
                return c.getSaldo();
            }
        }
        return -1;
    }

    public int realizaSaque(int numero, float valor) {
        for (Conta c : contas) {
            if (c.getNumero() == numero) {
                sucedido = c.saque(valor);
                if (sucedido == 0) {
                    return 0;
                }
                if (sucedido == -1) {
                    return -2;
                }
            }
        }
        return -1;
    }

    public int realizaDeposito(int numero, float valor) {
        for (Conta c : contas) {
            if (c.getNumero() == numero) {
                c.deposito(valor);
                return 0;
            }
        }
        return -1;
    }

    public void rendimento() {
        for (Conta c : contas) {
            if (c instanceof ContaPoupanca) {
                ((ContaPoupanca) c).incremento();
            }
        }
    }
    
    public void gravar(){
        write.openFile();
        write.addRecords(contas);
        write.closeFile();
    }
}
