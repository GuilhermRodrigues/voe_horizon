package br.com.voehorizon.enumeration;

public enum TipoClasseVooEnum {

    ECONOMICA(0,"ECONOMICA"),
    ECONOMICA_PREMIUM(1, "ECONOMICA_PREMIUM"),
    EXECUTIVA(2,"EXECUTIVA"),
    PRIMEIRA_CLASSE(3,"PRIMEIRA_CLASSE");

    private Integer id;
    private String tipo;


    private TipoClasseVooEnum(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }
}
