package contateste;

public class ContaEspecial extends Conta{
    private float limiteNegativo;
    
    public ContaEspecial(String nome, int numero, float saldo, float limiteNegativo){
        super(nome, numero, saldo);
        this.limiteNegativo = limiteNegativo;        
    }
    
    public ContaEspecial(){
        super();       
    }

    public float getLimiteNegativo() {
        return limiteNegativo;
    }

    public void setLimiteNegativo(float limiteNegativo) {
        this.limiteNegativo = limiteNegativo;
    }
    
    public int saque(float valor){
        
        if((saldo - valor) >= limiteNegativo){
            saldo = saldo - valor;   
            return 0;
        }
        else{
            //System.out.println("\nErro ao sacar!!!\n");
            return -1;
        }
    }
    
}
