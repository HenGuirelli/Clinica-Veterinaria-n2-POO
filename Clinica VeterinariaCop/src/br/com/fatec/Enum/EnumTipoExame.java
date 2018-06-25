package br.com.fatec.Enum;


public enum EnumTipoExame {
    Hemograma, 
    Urina, 
    Fezes, 
    Ultrassonografia, 
    Endoscopia, 
    Oftalmologico;
    
    public static EnumTipoExame toEnum(String val){
        for (EnumTipoExame tipo : EnumTipoExame.values())
            if (tipo.toString().toLowerCase().equals(val.toLowerCase()))
                return tipo;
        
        return null;
    }
}
