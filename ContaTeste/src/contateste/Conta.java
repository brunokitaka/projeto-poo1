package contateste;

public abstract class Conta {
    protected String nome;
    protected int numero;
    protected float saldo;
    static private int numeroDeContas;

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    public Conta(String nome, int numero, float saldo){
        this.nome = nome;
        this.numero = numero;
        this.saldo = saldo;
    }

    static public int getNumeroDeContas() {
        return numeroDeContas;
    }

    static public void setNumeroDeContas(int numeroDeContas) {
        Conta.numeroDeContas = numeroDeContas;
    }
    
    public Conta(){
        nome = "Sem nome";
        numero = 0;
        saldo = 0.0f;
    }
    
    public int saque(float valor){
        
        /*if(0 <= (this.getSaldo() - valor))
        {
            this.setSaldo(this.getSaldo() - valor);
            System.out.println("\n\nSaque feito com sucesso!!!\n\n");
        }
        else
        {
            System.out.println("Saldo insuficiente");
        }*/
        
        try{
            if((saldo - valor) >= 0){
                this.setSaldo(this.getSaldo() - valor);
                //System.out.println("\n\nSaque feito com sucesso!!!\n\n");
                return 0;
            }
            else{
                throw new ExceptionNumero("");
            }
        }
        catch(ExceptionNumero exceptionNumero){
            //System.out.println("\nValor muito alto!!!\n");
            return -1;
        }
    }
    
    public void deposito(float valor){
        this.saldo = this.saldo + valor;
    }
    
}
