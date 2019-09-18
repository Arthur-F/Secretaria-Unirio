package controller;

import java.util.List;
import model.entity.Aluno;
import model.entity.Professor;
import model.entity.Tecnico;

public class Autenticacao {
	
	private Autenticacao() {
		
	}
// método para reconhecimento do aluno e realizar a sua autenticação
	public static boolean reconhecerAluno(String tipoUsuario, String cpfTela, String senhaTela) {

		List<Aluno> lista = Gerenciador.acessarXML(tipoUsuario);
		for (int i = 0; i < lista.size(); i++) {
			// se a senha for correspondente ao cpf informado, validar 
			if ((lista.get(i).getCpf().equals(cpfTela)) && lista.get(i).getSenha().equals(senhaTela)) {
				return true;
			}
		}
		// se a senha NÃO for correspondente ao cpf informado, NÃO validar
		return false;

	}
// método para reconhecimento do professor e realizar a sua autenticação
	public static boolean reconhecerProfessor(String tipoUsuario, String cpfTela, String senhaTela) {

		List<Professor> lista = Gerenciador.acessarXML(tipoUsuario);
		for (int i = 0; i < lista.size(); i++) {
			// se a senha for correspondente ao cpf informado, validar
			if ((lista.get(i).getCpf().equals(cpfTela)) && lista.get(i).getSenha().equals(senhaTela)) {
				return true;
			}
		}
		// se a senha NÃO for correspondente ao cpf informado, NÃO validar
		return false;

	}

// método para reconhecimento do professor e realizar a sua autenticação
	public static boolean reconhecerTecnico(String tipoUsuario, String cpfTela, String senhaTela) {

		List<Tecnico> lista = Gerenciador.acessarXML(tipoUsuario);
		for (int i = 0; i < lista.size(); i++) {
			// se a senha for correspondente ao cpf informado, validar
			if ((lista.get(i).getCpf().equals(cpfTela)) && lista.get(i).getSenha().equals(senhaTela)) {
				return true;
			}
		}
		// se a senha NÃO for correspondente ao cpf informado, NÃO validar
		return false;

	}

//método para reconhecer o tipo de usuário	
	public static boolean reconhecerUsuario(String tipoUsuario, String cpfTela, String senhaTela) {

		switch (tipoUsuario) {
		//caso o cpf informado seja de um aluno, reconhecer como tipo de usuário aluno
		case "Aluno": return reconhecerAluno(tipoUsuario, cpfTela, senhaTela);
		//caso o cpf informado seja de um professor, reconhecer como tipo de usuário professor
		case "Professor": return reconhecerProfessor(tipoUsuario, cpfTela, senhaTela);
		//caso o cpf informado não seja de um aluno ou professor, reconhecer como tipo de usuário técnico
		default: return reconhecerTecnico(tipoUsuario, cpfTela, senhaTela);
		}
	}

}
