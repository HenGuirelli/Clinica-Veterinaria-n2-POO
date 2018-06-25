package br.com.fatec.Enum;

public enum EnumTipoConta {
    adm,
    veterinario,
    secretaria;
    
    public static EnumTipoConta toEnum(String val){
        for (EnumTipoConta tipo : EnumTipoConta.values())
            if (tipo.toString().toLowerCase().equals(val.toLowerCase()))
                return tipo;
        
        return null;
    }
    
    
}
