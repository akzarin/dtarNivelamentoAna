package app;

import Enums.Destinos;
import dto.Acompanhante;
import dto.Viagem;
import dto.ViagemInternacional;
import dto.ViagemNacional;
import sun.security.krb5.internal.crypto.Des;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) { //Void significa que não tem retorno
        Viagem viagem = new Viagem(Destinos.GOIAS);

        viagem.setDestino(Destinos.MANAUS);

        Acompanhante acompanhante1 = new Acompanhante();
        acompanhante1.setNome("Kleber");
        acompanhante1.setConfirmouCadastro(true);

        Acompanhante acompanhante2 = new Acompanhante();
        acompanhante2.setNome("Geiso");
        acompanhante2.setConfirmouCadastro(false);

        List<Acompanhante> acompanhantes = new ArrayList<Acompanhante>();
        acompanhantes.add(acompanhante1);
        acompanhantes.add(acompanhante2);

        try { // serve para mostrar uma mensagem tratada ao usuario se houver um erro
            viagem.setAcompanhantes(acompanhantes);
        } catch (Exception excecao) {
            System.out.println("Ocorreu um erro:");
            System.out.println(excecao.getMessage());
        }

        System.out.println(viagem.getDestino().getCidade());
        System.out.println(viagem.getAcompanhantes().size());
        System.out.println(viagem.getAcompanhantes().get(0).getNome());
        //Se não usar o .getCidade, vai retornar só o enum, ou seja, retorna só "MANAUS", mas se usar .getCidade, vai estar pegando o atributo do .getDestino

        for (Acompanhante acompanhante : viagem.getAcompanhantes()) {
            System.out.println(acompanhante.getNome());
            System.out.println(acompanhante.isConfirmouCadastro());
        }

        ViagemNacional viagemNacional1 = new ViagemNacional(Destinos.RECIFE);
        try {
            viagemNacional1.setAcompanhantes(acompanhantes);
        } catch (Exception excecao) {
            System.out.println("Ocorreu um erro:");
            System.out.println(excecao.getMessage());
        }
        viagemNacional1.setCpf("12345678910");

        ViagemInternacional viagemInternacional1 = new ViagemInternacional(Destinos.NYC);
        try {
            viagemInternacional1.setAcompanhantes(acompanhantes);
        } catch (Exception excecao) {
            System.out.println("Ocorreu um erro:");
            System.out.println(excecao.getMessage());
        }
        viagemInternacional1.setPassaporte("1234-5");

        System.out.println(viagemNacional1.calcularPrevisaoDeDiasParaRetorno());
    }
}




