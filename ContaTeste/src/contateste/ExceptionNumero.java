package contateste;

public class ExceptionNumero extends Exception{
      
    public ExceptionNumero(String msg)
    {
        super(msg); 
    } 
    public ExceptionNumero(String msg, Throwable cause)
    { 
        super(msg, cause); 
    }     
}
