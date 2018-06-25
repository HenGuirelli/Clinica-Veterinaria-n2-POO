package br.com.fatec.Enum;

public enum EnumTurno {
    MANHA,
    TARDE,
    NOITE;
    
    public static EnumTurno toEnum(String val){
        for (EnumTurno turno : EnumTurno.values())
           if (turno.toString().toLowerCase().equals(val.toLowerCase()))
               return turno;        
       return null;
    }
}
