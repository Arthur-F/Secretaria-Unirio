package controller;

import java.util.ArrayList;
import model.entity.Aluno;
import model.entity.Professor;
import model.entity.Tecnico;

public class Autenticacao {

    public static boolean reconhecerUsuario(String tipoUsuario, String cpfTela, String senhaTela) {

        switch (tipoUsuario) {
            case "Aluno":
            {
                ArrayList<Aluno> lista = Gerenciador.acessarXML(tipoUsuario);
                for (int i = 0; i < lista.size(); i++) {
                    if ((lista.get(i).getCpf().equals(cpfTela)) && lista.get(i).getSenha().equals(senhaTela)) {
                        return true;
                    }
                }
                return false;
                
            }
            case "Professor":
            {
                ArrayList<Professor> lista = Gerenciador.acessarXML(tipoUsuario);
                for (int i = 0; i < lista.size(); i++) {
                    if ((lista.get(i).getCpf().equals(cpfTela)) && lista.get(i).getSenha().equals(senhaTela)) {
                        return true;
                    }
                }
                return false;
            }
            default:
            {
                ArrayList<Tecnico> lista = Gerenciador.acessarXML(tipoUsuario);
                for (int i = 0; i < lista.size(); i++) {
                    if ((lista.get(i).getCpf().equals(cpfTela)) && lista.get(i).getSenha().equals(senhaTela)) {
                        return true;
                    }
                }
                return false;
            }
        }
    }
}
