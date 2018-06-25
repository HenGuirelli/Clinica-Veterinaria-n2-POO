package br.com.fatec.Enum;

public enum EnumEspecializacao {
    GATO,
    CACHORRO,
    GERAL;
    
    public static EnumEspecializacao toEnum(String val){
         for (EnumEspecializacao tipo : EnumEspecializacao.values())
            if (tipo.toString().toLowerCase().equals(val.toLowerCase()))
                return tipo;        
        return null;
    }
}
