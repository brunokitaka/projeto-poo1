package contateste;

public class ContaPoupanca extends Conta{
    float rendimento;
    
    public ContaPoupanca(String nome, int numero, float saldo, float rendimento){
        super(nome, numero, saldo);
        this.rendimento = rendimento; 
    }
    
    public ContaPoupanca(){
        super();
    }

    public float getRendimento() {
        return rendimento;
    }

    public void setRendimento(float rendimento){
        this.rendimento = rendimento;
    }
    
    public void incremento(){
        float valor;
        
        valor = this.getSaldo() + (this.getSaldo() * (this.getRendimento()/100)); 
        
        this.setSaldo(valor);
    }
    
}
