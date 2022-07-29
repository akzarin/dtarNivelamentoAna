package Enums;

public enum Destinos {
    OSASCO("Osasquinho"),
    MARINGA("Maringuinha"),
    GOIAS("Goiaszin"),
    RECIFE("Recifinho"),
    MANAUS("Manauszin"),
    MIAMI("Miamizinha"),
    NYC("Nova Iorquinha");

    private String cidade;

   Destinos(String cidade) {

       this.cidade = cidade;
    }

    public String getCidade() {

       return this.cidade;
    }
}
