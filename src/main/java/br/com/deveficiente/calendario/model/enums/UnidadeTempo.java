package br.com.deveficiente.calendario.model.enums;

public enum UnidadeTempo {
    MINUTOS,
    HORAS,
    DIAS,
    SEMANAS;

    public static boolean contains(String value){
        for(UnidadeTempo u : values()){
            if(u.name().equals(value)){
                return true;
            }
        }
        return false;
    }
}
