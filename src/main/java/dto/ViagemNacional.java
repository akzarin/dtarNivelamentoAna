package dto;

import Enums.Destinos;
import Interfaces.CalculadoraDePrevisao;
import utils.ArquivosUtils;

import java.util.List;


public class ViagemNacional extends Viagem implements CalculadoraDePrevisao { //o extends serve para pegar todos os atributos de Viagem

    private String cpf;

    public ViagemNacional(Destinos lugarDeDestino) {
        super(lugarDeDestino);
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public void setAcompanhantes(List<Acompanhante> acompanhantes) throws Exception {

        int limiteDeAcompanhantes = Integer.parseInt(ArquivosUtils.getPropriedade("viagem.nacional.acompanhantes.limite"));

        if (acompanhantes.size() <= limiteDeAcompanhantes) {
        super.setAcompanhantes(acompanhantes);
    } else {
            throw new Exception("Viagens nacionais não podem ter mais de " + limiteDeAcompanhantes + " acompanhantes");
        }
    }

    public int calcularPrevisaoDeDiasParaRetorno() {
        int quantidadeDeDias = 0;

        switch (getDestino()) {
            case MARINGA: quantidadeDeDias = 0; break;
            case GOIAS: quantidadeDeDias = 2; break;
            case MANAUS: quantidadeDeDias = 4; break;
            case OSASCO: quantidadeDeDias = 2; break;
            case RECIFE: quantidadeDeDias = 5; break;
        } return quantidadeDeDias;
    }

}
