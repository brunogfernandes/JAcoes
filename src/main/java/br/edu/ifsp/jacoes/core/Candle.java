package br.edu.ifsp.jacoes.core;

import java.time.LocalDate;

public class Candle {
    private final double abertura;
    private final double maxima;
    private final double minima;
    private final double fechamento;
    private final double volume;
    private final Intervalo intervalo;
    private final LocalDate data;
    
    public Candle(){
        this(0.0, 0.0, 0.0, 0.0, 0.0, Intervalo.DIARIO, LocalDate.now());
    }
    
    public Candle(double abertura, double maxima, double minima, double fechamento, double volume, Intervalo intervalo, LocalDate data){
        this.abertura = abertura;
        this.maxima = maxima;
        this.minima = minima;
        this.fechamento = fechamento;
        this.volume = volume;
        this.intervalo = intervalo;
        this.data = data;
    }

    public double getAbertura() {
        return abertura;
    }

    public double getMaxima() {
        return maxima;
    }

    public double getMinima() {
        return minima;
    }

    public double getFechamento() {
        return fechamento;
    }

    public double getVolume() {
        return volume;
    }

    public Intervalo getIntervalo() {
        return intervalo;
    }

    public LocalDate getData() {
        return data;
    }
}
