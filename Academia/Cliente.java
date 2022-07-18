import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cliente {
    private String name;
    private String cpf;
    private String genero;
    private ArrayList<Metrica> metricas;
    private String dataNasc;
    
    /*
    public Cliente(String nome, String cpf, String dataNasc, String genero){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.genero = genero;
    }*/
    
    public Cliente(){
        metricas = new ArrayList<>();
    }
    
    public void setNome(String nome){
        this.name = nome;
    }
    
    public String getNome(){
        return name;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public String getCpf(){
        return cpf;
    }
    
    public String getDataNasc(){
        return dataNasc;
    }
    
        public void setDataNasc(String dataNasc){
        this.dataNasc = dataNasc;
    }
    
    public void setGenero(String genero){
        this.genero = genero;
    }
    
    public String getGenero(){
        return genero;
    }
    
    public ArrayList<Metrica> getMetricas(){
        return this.metricas;
    }
    
        public void setMetricas(ArrayList<Metrica> metricas){
        this.metricas = metricas;
    }
    
    public double mediaPeso(){
        int cont = 0;
        double soma = 0;
        for (Metrica m:metricas){
            soma += m.getPeso();
            cont++;
        }
        return soma/cont;
    }
    
        public Metrica pesquisarMetrica(String data) {
        return metricas.stream().filter(m->m.getData().equals(data)).findFirst().orElse(null);
    }
    
    public List<Metrica> ordenarMetricas(){
        this.metricas = new ArrayList<Metrica>(metricas.stream().sorted((d1, d2)->d1.getData().compareTo(d2.getData())).collect(Collectors.toList()));
        return metricas.stream().sorted((d1, d2)->d1.getData().compareTo(d2.getData())).collect(Collectors.toList());
    }
    
    public boolean adicionarMetrica(double altura, double peso, double cintura, double biceps, double peito, String data){
        if(pesquisarMetrica(data)==null){
            Metrica m = new Metrica();
            m.setAltura(altura); 
            m.setPeso(peso); 
            m.setCintura(cintura); 
            m.setBiceps(biceps); 
            m.setPeito(peito); 
            m.setData(data); 
            metricas.add(m);
            
            return true;
        }
        return false;
    }   
        
    public boolean removerMetrica(String data){
        Metrica m = pesquisarMetrica(data);
        if(m!=null){
            metricas.remove(m);
            return true;    
        }
        return false;
    }
    
    public double imcAtual(){
        return metricas.get(metricas.size() -1).imc();
    }
    
    public double bicepsAtual()
    {
        return metricaAtual().getBiceps();
    }
    
    public double pesoInicial()
    {
        return metricaInicial().getPeso();
    }
    
        public double pesoAtual()
    {
        return metricaAtual().getPeso();
    }
    
    public double alturaAtual()
    {
        return metricaAtual().getAltura();
    }

    public double alturaInicial()
    {
        return metricaInicial().getAltura();
    
    }
    
    public double bicepsInicial()
    {
        return metricaInicial().getBiceps();
    }
    
        public double peitoralAtual()
    {
        return metricaAtual().getPeito();
    }
    
    public double peitoralInicial()
    {
        return metricaInicial().getPeito();
    }
    
    public double pesoVariacao()
    {
        return pesoAtual() - pesoInicial();
    }
    
    public double alturaVariacao()
    {
        return alturaAtual() - alturaInicial();
    }
    
    public double bicepsVariacao()
    {
        return bicepsAtual() - bicepsInicial();
    }
    
    public double peitoralVariacao()
    {
        return peitoralAtual() - peitoralInicial();
    }
    
    public Metrica metricaAtual()
    {
        ordenarMetricas();
        return metricas.get(metricas.size()-1);
    }
    
    public Metrica metricaInicial()
    {
        ordenarMetricas();
        return metricas.get(0);
    }
    
                 
    public String adequacao(){
        if(imcAtual() < 18.5){
            return "IMC abaixo do peso";
        } else if(imcAtual() > 19.5 && imcAtual() < 26.9){
            return "IMC adequado";
        } else if(imcAtual() > 28 && imcAtual() < 36.9){
            return "Obesidade Grau I";
        } else if(imcAtual() > 24 && imcAtual() < 29.9){
            return "Sobrepeso";    
        } if(imcAtual() > 35 && imcAtual() < 39.9){
            return "Obesidade Grau II";
        } else {
            return "Obesidade Grau III ou Morbida";
        }
    }
    
    
    
    
    public double desvioPadrao(){
        int cont = 0;
        double desvioPadrao = 0;
        for (Metrica m:metricas){
            desvioPadrao += Math.pow(m.getPeso() - mediaPeso(), 2);
            cont++;
        }
        return Math.sqrt(desvioPadrao / (cont - 1));
    }
}
