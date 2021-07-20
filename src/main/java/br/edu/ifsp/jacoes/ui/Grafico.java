package br.edu.ifsp.jacoes.ui;

import java.util.Date;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultOHLCDataset;
import org.jfree.data.xy.OHLCDataItem;
import br.edu.ifsp.jacoes.data.LeitorCSV;
import br.edu.ifsp.jacoes.core.Acao;
import br.edu.ifsp.jacoes.core.Candle;
import br.edu.ifsp.jacoes.tools.Matematica;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.time.ZoneId;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.ui.RectangleAnchor;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.time.MovingAverage;
import org.jfree.data.xy.XYDataset;

public class Grafico {
    public ChartPanel plotarGrafico(String ticker, String caminhoArquivo, int intExibicao, int intMMA, int intCandle) throws FileNotFoundException{
        // inicializa leitor
        LeitorCSV leitor = new LeitorCSV(caminhoArquivo, intCandle);
        
        Matematica matematica = new Matematica();
        
        // inicializa acao com ticker passado pela jacoes
        Acao acao = new Acao(ticker);
        acao.setListaCandles(leitor.gerarListaCandles());  
        
        // incializa array de itens OHLC
        OHLCDataItem [] dados;
        
        if(intCandle == 0){
            dados = new OHLCDataItem[acao.getListaCandles().size()];
            for(int i = 0; i < acao.getListaCandles().size(); i++){
                Candle candle = acao.getListaCandles().get(i);
                if(candle.getAbertura() == 0.0){
                    Date data = Date.from(candle.getData().atStartOfDay(ZoneId.systemDefault()).toInstant());
                    dados[i] = new OHLCDataItem(data, (double) dados[i-1].getOpen(), (double) dados[i-1].getHigh(), (double) dados[i-1].getLow(), (double) dados[i-1].getClose(), 0.0);
                }else{
                    Date data = Date.from(candle.getData().atStartOfDay(ZoneId.systemDefault()).toInstant());
                    dados[i] = new OHLCDataItem(data, candle.getAbertura(), candle.getMaxima(), candle.getMinima(), candle.getFechamento(), 0.0);
                }
            }
        }else{
            int tamArraySem = 0;
            for(int i = 0, j = 0; i < acao.getListaCandles().size(); i+=5, j++) tamArraySem = j;
            
            dados = new OHLCDataItem[tamArraySem];
            
            for(int i = 0, j = 0; i < acao.getListaCandles().size(); i+=5, j++){
                if(i+5 < acao.getListaCandles().size()){
                    if(acao.getListaCandles().get(i).getMaxima() == 0) break;
                    
                    double maxHigh = acao.getListaCandles().get(i).getMaxima();
                    double minLow = acao.getListaCandles().get(i).getMinima();
                    
                    Candle candle = acao.getListaCandles().get(i);
                    
                    for(int k = i; k < i+5; k++){
                        if(maxHigh < acao.getListaCandles().get(i).getMaxima())
                            maxHigh = acao.getListaCandles().get(i).getMaxima();
                        
                        if(minLow > acao.getListaCandles().get(i).getMinima())
                            minLow = acao.getListaCandles().get(i).getMinima();
                    }
                    
                    Date data = Date.from(candle.getData().atStartOfDay(ZoneId.systemDefault()).toInstant());
                    double fec = acao.getListaCandles().get(i+5).getFechamento();
                    dados[j] = new OHLCDataItem(data, candle.getAbertura(), maxHigh, minLow, fec, 0.0);
                }
            }
        }
        
        // inicializa dataset OHLC
        DefaultOHLCDataset dataset;
        dataset = new DefaultOHLCDataset(dados[0], dados);

        // constroi grafico candlestick usando o dataset inicializado acima
        JFreeChart chart = ChartFactory.createCandlestickChart(
                acao.getTicker(), "Data", "Valor das Ações (R$)", dataset, false);

        // retorna plot do grafico candlestick
        XYPlot plot = (XYPlot) chart.getPlot();
        
        // deixa o candle grossao 
        CandlestickRenderer renderer = (CandlestickRenderer) plot.getRenderer();
        renderer.setAutoWidthMethod(CandlestickRenderer.WIDTHMETHOD_SMALLEST);

        // retorna variaveis de range dos eixos
        NumberAxis range = (NumberAxis) plot.getRangeAxis();
        DateAxis domain = (DateAxis) plot.getDomainAxis();
        
        // seta o range dos eixos
        range.setRange(matematica.calculaValorMin(dados, intExibicao), matematica.calculaValorMax(dados, intExibicao));
        domain.setRange(matematica.calculaDataMin(dados, intExibicao), matematica.calculaDataMax(dados, intExibicao));
        
        final Marker marca = new ValueMarker((matematica.calculaValorMax(dados, intExibicao) + matematica.calculaValorMin(dados, intExibicao))/2); 
        marca.setLabel(ticker);
        marca.setLabelAnchor(RectangleAnchor.CENTER);
        marca.setLabelTextAnchor(TextAnchor.CENTER);
        marca.setLabelFont(new Font("Arial", Font.BOLD, 36));
        marca.setAlpha(0.1f);
        plot.addRangeMarker(marca);
        
        XYDataset dataset2 = MovingAverage.createMovingAverage(dataset, "teste", 86400000*intMMA, 0);
        plot.setDataset(1, dataset2);
        plot.setRenderer(1, new StandardXYItemRenderer());
        
        ChartPanel painelGrafico = new ChartPanel(chart);
        painelGrafico.setMouseWheelEnabled(true);
        
        return painelGrafico;
    }
}
