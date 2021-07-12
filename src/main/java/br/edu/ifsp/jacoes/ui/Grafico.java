package br.edu.ifsp.jacoes.ui;

import java.io.IOException;
import java.sql.Date;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultOHLCDataset;
import org.jfree.data.xy.OHLCDataItem;

import br.edu.ifsp.jacoes.data.LeitorCSV;
import br.edu.ifsp.jacoes.core.Acao;
import br.edu.ifsp.jacoes.core.Candle;
import java.time.ZoneId;
import org.jfree.chart.axis.DateAxis;

public class Grafico {
    public static void main(String[] args) throws IOException {
        LeitorCSV leitor = new LeitorCSV("/home/bruno/Downloads/csvs/BBDC4.SA.csv");
        
        System.out.println("Caminho do arquivo: "+leitor.getCaminhoArquivo());
        
        Acao acao = new Acao("BBDC4");
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

        ChartFrame frame = new ChartFrame("Cotações diárias", chart);
        frame.pack();
        frame.setVisible(true);
    }
}
