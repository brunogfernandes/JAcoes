package br.edu.ifsp.jacoes.data;

import java.io.File;
import br.edu.ifsp.jacoes.core.Candle;
import br.edu.ifsp.jacoes.core.Intervalo;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeitorCSV{
    private String caminhoArquivo;
    private File arquivo;
    
    public LeitorCSV(String caminhoArquivo){
        this.setArquivo(caminhoArquivo);
    }
    
    public LeitorCSV(){
    }
    
    public void setArquivo(String caminho){
        this.caminhoArquivo = caminho;
        arquivo = new File(this.caminhoArquivo);
    }
    
    public String getCaminhoArquivo(){
        return caminhoArquivo;
    }
    
    public File getArquivo(){
        return arquivo;
    }
    
    public LocalDate gerarData(String input){
        String [] strData = input.split("-");
        
        int ano = Integer.parseInt(strData[0]);
        int mes = Integer.parseInt(strData[1]);
        int dia = Integer.parseInt(strData[2]);
        
        LocalDate data = LocalDate.of(ano, mes, dia);
        
        return data;
    }
    
    public Candle gerarCandle(String linha) throws NumberFormatException{
        String[] dados = linha.split(",");
        LocalDate data = gerarData(dados[0]);
        double abertura;
        double maxima;
        double minima;
        double fechamento;
        double volume;
        
        try{
            abertura = Double.parseDouble(dados[1]);
            maxima = Double.parseDouble(dados[2]);
            minima = Double.parseDouble(dados[3]);
            fechamento = Double.parseDouble(dados[4]);
            volume = Double.parseDouble(dados[6]);
            return new Candle(abertura, maxima, minima, fechamento, volume, Intervalo.DIARIO, data);
        }catch(NumberFormatException ex){
            System.err.println("Seu arquivo CSV contem linhas nulas!");
            System.err.println(ex);
        } 
        return new Candle();
    }
    
    public List<Candle> gerarListaCandles() throws FileNotFoundException{
        List<Candle> lista = new ArrayList<>();
        try{
            Scanner input = new Scanner(arquivo);
            input.nextLine();
            while(input.hasNext()){
                lista.add(gerarCandle(input.nextLine()));
            }
        }catch(FileNotFoundException ex){
            System.err.println("Erro! Arquivo não encontrado!");
            System.err.println(ex);
        }
        return lista;
    }
}