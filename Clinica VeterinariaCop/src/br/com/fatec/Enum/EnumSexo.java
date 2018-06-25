package br.com.fatec.Enum;

public enum EnumSexo {
    M, F;
    public static EnumSexo toEnum(char sexo){
        if (sexo == 'M' || sexo == 'm')
            return EnumSexo.M;
        if (sexo == 'F' || sexo == 'f')
            return EnumSexo.F;
        return null;
    }
}
