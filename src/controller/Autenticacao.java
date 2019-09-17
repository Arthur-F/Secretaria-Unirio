package controller;

import java.util.ArrayList;
import model.entity.Aluno;
import model.entity.Professor;
import model.entity.Tecnico;

public class Autenticacao {
	
	private Autenticacao() {
		
	}

	public static boolean reconhecerAluno(String tipoUsuario, String cpfTela, String senhaTela) {

		ArrayList<Aluno> lista = Gerenciador.acessarXML(tipoUsuario);
		for (int i = 0; i < lista.size(); i++) {
			if ((lista.get(i).getCpf().equals(cpfTela)) && lista.get(i).getSenha().equals(senhaTela)) {
				return true;
			}
		}
		return false;

	}

	public static boolean reconhecerProfessor(String tipoUsuario, String cpfTela, String senhaTela) {

		ArrayList<Professor> lista = Gerenciador.acessarXML(tipoUsuario);
		for (int i = 0; i < lista.size(); i++) {
			if ((lista.get(i).getCpf().equals(cpfTela)) && lista.get(i).getSenha().equals(senhaTela)) {
				return true;
			}
		}
		return false;

	}

	public static boolean reconhecerTecnico(String tipoUsuario, String cpfTela, String senhaTela) {

		ArrayList<Tecnico> lista = Gerenciador.acessarXML(tipoUsuario);
		for (int i = 0; i < lista.size(); i++) {
			if ((lista.get(i).getCpf().equals(cpfTela)) && lista.get(i).getSenha().equals(senhaTela)) {
				return true;
			}
		}
		return false;

	}

	
	public static boolean reconhecerUsuario(String tipoUsuario, String cpfTela, String senhaTela) {

		switch (tipoUsuario) {
		case "Aluno": return reconhecerAluno(tipoUsuario, cpfTela, senhaTela);			
		case "Professor": return reconhecerProfessor(tipoUsuario, cpfTela, senhaTela);
		default: return reconhecerTecnico(tipoUsuario, cpfTela, senhaTela);
		}
	}

}
