import java.util.Date;

public class Metrica {
    private double cintura;
    private double altura;
    private double peito;
    private double perna;
    private double biceps;
    private double peso;
    private String data;
   
    public Metrica(){
        
    }

    public void setAltura(double altura){
        this.altura = altura;
    }
    
    public double getAltura(){
        return altura;
    }
    
    public void setBiceps(double biceps){
        this.biceps = biceps;
    }
    
    public double getBiceps(){
        return biceps;
    }
    
    public void setPeso(double peso){
        this.peso = peso;
    }
    
    public double getPeso(){
        return peso;
    }
    
    public void setPeito(double peito){
        this.peito = peito;
    }
    
    public double getPeito(){
        return peito;
    }
    
    public void setCintura(double cintura){
        this.cintura = cintura;
    }
    
    public double getCintura(){
        return cintura;
    }
    
    public void setPerna(double perna){
        this.perna = perna;
    }
    
    public double getPerna(){
        return perna;
    }
    
    public void setData(String data){
        this.data = data;
    }
    
    public String getData(){
        return data;
    }
    
    public String dataNow(String data){ 
        Date dataNow = new Date();
        return dataNow + "";
    }
    
    public double imc(){
        double resultado = peso / (altura*altura);
        return resultado;
    }
}
