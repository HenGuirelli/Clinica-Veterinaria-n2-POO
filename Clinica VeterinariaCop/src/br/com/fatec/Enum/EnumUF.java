package br.com.fatec.Enum;

public enum EnumUF {
    AC,
    AL,
    AM,
    AP,
    BA,
    CE,
    DF,
    ES,
    GO,
    MA,
    MT,
    MS,
    MG,
    PA,
    PB,
    PR,
    PE,
    PI,
    RJ,
    RN,
    RS,
    RO,
    RR,
    SC,
    SP,
    SE,
    TO;
    
    public static EnumUF toEnum(String uf){
        for (EnumUF enumUF : EnumUF.values())
            if (enumUF.toString().toLowerCase().equals(uf.toLowerCase()))
                return enumUF;
        return null;
    }
}
