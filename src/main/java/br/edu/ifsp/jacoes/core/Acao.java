package br.edu.ifsp.jacoes.core;

import java.util.ArrayList;
import java.util.List;

public class Acao {
    private final String ticker;
    private List<Candle> listaCandles;
    
    public Acao(){
        this("VOID0");
    }
    
    public Acao(String ticker){
        this.ticker = ticker;
        this.listaCandles = new ArrayList<>();
    }
    
    public String getTicker(){
        return this.ticker;
    }
    
    public List<Candle> getListaCandles(){
        return this.listaCandles;
    }
    
    public void adicionarCandle(Candle candle){
        listaCandles.add(candle);
    }
    
    public void removerCandle(Candle candle){
        listaCandles.remove(candle);
    }
    
    public void setListaCandles(List<Candle> lista){
        listaCandles.clear();
        listaCandles.addAll(lista);
    }
}
