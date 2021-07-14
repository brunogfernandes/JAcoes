package br.edu.ifsp.jacoes.ui;

import java.sql.Date;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultOHLCDataset;
import org.jfree.data.xy.OHLCDataItem;

import br.edu.ifsp.jacoes.data.LeitorCSV;
import br.edu.ifsp.jacoes.core.Acao;
import br.edu.ifsp.jacoes.core.Candle;
import java.io.FileNotFoundException;
import java.time.ZoneId;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.data.time.MovingAverage;
import org.jfree.data.xy.XYDataset;

public class Grafico {
    public ChartPanel plotarGrafico(String ticker, String caminhoArquivo) throws FileNotFoundException{
        LeitorCSV leitor = new LeitorCSV(caminhoArquivo);
        
        Acao acao = new Acao(ticker);
        acao.setListaCandles(leitor.gerarListaCandles());  
        
        OHLCDataItem [] dados = new OHLCDataItem[acao.getListaCandles().size()];
        
        for(int i = 0; i < acao.getListaCandles().size(); i++){
            Candle candle = acao.getListaCandles().get(i);
            dados[i] = new OHLCDataItem(Date.from(candle.getData().atStartOfDay(ZoneId.systemDefault()).toInstant()), candle.getAbertura(), candle.getMaxima(), candle.getMinima(), candle.getFechamento(), 0.0);
        }
        
        DefaultOHLCDataset dataset;
        dataset = new DefaultOHLCDataset(dados[0], dados);

        JFreeChart chart = ChartFactory.createCandlestickChart(
                acao.getTicker(), "Dias", "Preço", dataset, false);

        XYPlot plot = (XYPlot) chart.getPlot();
        NumberAxis range = (NumberAxis) plot.getRangeAxis();
        DateAxis domain = (DateAxis) plot.getDomainAxis();
        range.setRange(22.50, 29.00);
        domain.setRange(Date.valueOf("2021-04-10"), Date.valueOf("2021-07-10"));
        
        XYDataset dataset2 = MovingAverage.createMovingAverage(dataset, "teste", 1209600000, 0);
        plot.setDataset(1, dataset2);
        plot.setRenderer(1, new StandardXYItemRenderer());
        
        ChartPanel cp = new ChartPanel(chart);
        cp.setMouseWheelEnabled(true);
        
        return cp;
    }
}
