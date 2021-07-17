package br.edu.ifsp.jacoes.tools;

import java.util.Calendar;
import java.util.Date;
import org.jfree.data.xy.OHLCDataItem;


public class Matematica {
    public double calculaValorMin(OHLCDataItem [] dados, int diasExibicao){
        double min = (double) dados[dados.length - 1].getLow();
        for(int i = dados.length - 1; i >= (dados.length - 1 - diasExibicao); i--){
            if((double) dados[i].getLow() < min){
                min = (double) dados[i].getLow();
            }
        }
        return min - (min * 0.005);
    }
    public double calculaValorMax(OHLCDataItem [] dados, int diasExibicao){
        double max = (double) dados[dados.length - 1].getHigh();
        for(int i = dados.length - 1; i >= (dados.length - 1 - diasExibicao); i--){
            if((double) dados[i].getHigh() > max){
                max = (double) dados[i].getHigh();
            }
        }
        return max + (max * 0.005);
    }
    public Date calculaDataMin(OHLCDataItem [] dados, int diasExibicao){
        return dados[dados.length - 1 - diasExibicao].getDate();
    }
    public Date calculaDataMax(OHLCDataItem [] dados, int diasExibicao){
        Calendar c = Calendar.getInstance(); 
        c.setTime(dados[dados.length - 1].getDate());
        c.add(Calendar.DATE, 1);
        Date dataMax = c.getTime();
        return dataMax;
    }
}
