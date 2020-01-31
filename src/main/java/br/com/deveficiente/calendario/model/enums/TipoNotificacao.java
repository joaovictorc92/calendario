package br.com.deveficiente.calendario.model.enums;

public enum TipoNotificacao {
    EMAIL;

    public static boolean contains(String value){
        for(TipoNotificacao t : values()){
            if(t.name().equals(value)){
                return true;
            }
        }
        return false;
    }
}
