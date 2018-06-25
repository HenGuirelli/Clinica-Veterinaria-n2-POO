package br.com.fatec.controller;

import br.com.fatec.excecoes.DataInvalidaException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Data extends Date{
    private Date data;
    
    //construtores
    public Data(String data){
        this.data = toDate(data);
    }    
    
    public Data(Date data){
        this.data = data;
    }
    
    
    //metodos de conversão    
    public Date toDate(){
        return data;
    }
    
    public java.sql.Date toSqlDate(){
        if (data != null)
            return new java.sql.Date(data.getTime());
        return null;
    }
    
    public Timestamp toTimestamp(){
        if (data != null)
            return new Timestamp(data.getTime());
        return null;
    }
    
    @Override
    public String toString(){
        if (data != null){
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            return df.format(data);
        }
        return null;
    }
    
    /**
     * Recebe uma data dd/MM/yyy de parametro
     * returna dia da semana ex:
     *  Segunda, Terça, Quarta...
     * 
     */
    public static String getDiaDaSemana(String data){
        Calendar cal = Calendar.getInstance();
        //seta a data passada atual
        cal.setTime(new Data(data).toDate());
        //inteiro referente ao dia da semana
        int diaDaSemana = cal.get(Calendar.DAY_OF_WEEK);
        
        switch(diaDaSemana){
            case 1:
                return "Domingo";
            case 2:
                return "Segunda";
            case 3:
                return "Terça";
            case 4:
                return "Quarta";
            case 5:
                return "Quinta";
            case 6:
                return "Sexta";
            case 7:
                return "Sabado";
        }
        return null;
    }
    //getters uteis
    public int getDia(){
        return Integer.parseInt(new Data(this.data).toString().split("/")[0]);
    }
    
    public int getMes(){
        return Integer.parseInt(new Data(this.data).toString().split("/")[1]);
    }
    
    public int getAno(){
        return Integer.parseInt(new Data(this.data).toString().split("/")[2]);
    }
    
    //metodos privados
    private Date toDate(String data){
        try{
             if (data.equals(""))
                 return null;
            //converte a data de String para Date
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = (java.util.Date)formatter.parse(data);
            return date;
        }catch(ParseException e){
            throw new DataInvalidaException("valor recebido:" + data);
        }
    }
}
