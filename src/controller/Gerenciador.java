package controller;

import dao.ManipuladorXML;

import java.util.ArrayList;
import java.util.List;
import model.entity.Aluno;

import model.entity.Professor;
import model.entity.Tecnico;

import model.requerimento.Requerimento;

public class Gerenciador {

    private static final String REQUERIMENTO = "Requerimentos.xml";
    private static final String PROFESSOR = "Professors.xml";
    private static final String TECNICO = "Tecnicos.xml";
    private static final String ALUNO = "Alunos.xml";
    private static final String CONCLUIDO = "CONCLUIDO";
    private static final String DESIGNADO = "DESIGNADO";    
    private static final String REJEITADO = "REJEITADO";
 
    private Gerenciador()
    {
    	throw new IllegalStateException("Classe Utilitaria");
    }
    
    public static void montaXML (Requerimento requerimento) {
    	ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        List<Requerimento> listaInicial = xml.getLista();
        List<Requerimento> listaVazia = new ArrayList<>();

        xml.setLista(listaVazia);
        xml.escreveXML();

        for (int i = 0; i < listaInicial.size(); i++) {
            if (listaInicial.get(i).getNumeroProtocolo().equals(requerimento.getNumeroProtocolo())) {
                listaInicial.remove(i);
            }
        }

        xml.setLista(listaInicial);
        xml.adiciona(requerimento);
        xml.escreveXML();
    }

    public static boolean checaRequerimento(Requerimento requerimento) {
    	/*Triagem é o primeiro estado do requerimento. 
    	 * Assim que o ticket é aberto ele aparece para a secretaria como triagem */
    	if (requerimento.getStatus().equals("TRIAGEM") ||
    			/*Assim que a secretaria identifica para quem o requerimento deve 
    			 * ser DESIGNADO e valida que todas as informações necessárias estão 
    			 * preenchidas, ela envia o requerimento para o responsável e o 
    			 * requerimento ganha o estado DESIGNADO*/
    			requerimento.getStatus().equals(DESIGNADO) ||
    			/*Quando o requerimento termina de ser processado pelo responsável
    			 * ele solicita o encerramento do requerimento, alterando o seu status para 
    			 * CONCLUIDO*/
    			requerimento.getStatus().equals(CONCLUIDO) ||
    			/*Caso a recretaria identifique que o requerimento aberto pelo requerente 
    			 * é improcedente por algum motivo, ele pode rejeitar o requerimento, 
    			 * alterando seu status para REJEITADO*/
    			requerimento.getStatus().equals(REJEITADO) ||
    			/*Caso a secretaria identique que falta alguma informação para o 
    			 * encaminhar o requerimento para o responsável, ela pode solicitar 
    			 * do requerente mais informações através do estado PENDENTE*/
    			requerimento.getStatus().equals("PENDENTE"))
    		return true;
    	else
    		return false;
    	
    }
    public static void analisaRequerimento(Requerimento requerimento) {
    	if(checaRequerimento(requerimento)) {
    		montaXML(requerimento);
    	}
    }

    public static Aluno obterAluno(String cpf, String senha) {
        List<Aluno> lista;
        Aluno alunoObtido;
        alunoObtido = null;
        ManipuladorXML manipulador = new ManipuladorXML(ALUNO);
        manipulador.leXML();
        lista = manipulador.getLista();
        for (int i = 0; i < lista.size(); i++) {
            if ((lista.get(i).getCpf().equals(cpf)) && lista.get(i).getSenha().equals(senha)) {
                alunoObtido = lista.get(i);
                return alunoObtido;
            }
        }
        return alunoObtido;
    }

    public static Tecnico obterTecnico(String cpf, String senha) {
        List<Tecnico> lista;
        Tecnico tecnicoObtido;
        tecnicoObtido = null;
        ManipuladorXML manipulador = new ManipuladorXML(TECNICO);
        manipulador.leXML();
        lista = manipulador.getLista();
        for (int i = 0; i < lista.size(); i++) {
            if ((lista.get(i).getCpf().equals(cpf)) && lista.get(i).getSenha().equals(senha)) {
                tecnicoObtido = lista.get(i);
                return tecnicoObtido;
            }
        }
        return tecnicoObtido;
    }

    public static Professor obterProfessorDisciplina(String disciplina) {
        List<Professor> lista;
        Professor professorObtido;
        professorObtido = null;
        ManipuladorXML manipulador = new ManipuladorXML(PROFESSOR);
        manipulador.leXML();
        lista = manipulador.getLista();
        for (int i = 0; i < lista.size(); i++) {
            if ((lista.get(i).getGrade().contains(disciplina))) {
                
                professorObtido = lista.get(i);
                return professorObtido;
            }
        }
        return professorObtido;
    }

    public static Professor obterProfessorCargo(String cargo) {

        List<Professor> lista;
        Professor professorObtido;
        professorObtido = null;
        ManipuladorXML manipulador = new ManipuladorXML(PROFESSOR);
        manipulador.leXML();
        lista = manipulador.getLista();
        for (int i = 0; i < lista.size(); i++) {
            if ((lista.get(i).getCargo().equals(cargo))) {
                professorObtido = lista.get(i);
                return professorObtido;
            }
        }
        return professorObtido;
    }

    public static Tecnico criarTecnicoGenerico() {
        Tecnico tecnico = new Tecnico();
        tecnico.setNome("Tecnico Generico");
        tecnico.setCpf("0000");
        return tecnico;
    }

    public static Professor obterProfessorCPF(String cpf, String senha) {
        List<Professor> lista;
        Professor professorObtido;
        professorObtido = null;
        ManipuladorXML manipulador = new ManipuladorXML(PROFESSOR);
        manipulador.leXML();
        lista = manipulador.getLista();
        for (int i = 0; i < lista.size(); i++) {
            if ((lista.get(i).getCpf().equals(cpf)) && lista.get(i).getSenha().equals(senha)) {
                professorObtido = lista.get(i);
                return professorObtido;
            }
        }
        return professorObtido;
    }

    /*Método para buscar os requerimentos que estão no estado de TRIAGEM*/
    public static List<Requerimento> buscarTriagem() {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        List<Requerimento> lista = xml.getLista();
        List<Requerimento> listaRetorno = new ArrayList<>();
        // para cada requerimento da lista de requerimentos fazer:
        for (int i = 0; i < lista.size(); i++) {
        	//se o estado do requerimento for triagem
            if (lista.get(i).getStatus().equals("TRIAGEM")) {
            	//adiciona esse requerimento com estado de TRIAGEM à lista de retorno 
                listaRetorno.add(lista.get(i));
            }
        }
        //trazer a lista de retorno contendo os requerimentos que estão no estado TRIAGEM
        return listaRetorno;
    }
// método usado para procurar um requerimento a partir do seu número de protocolo
    public static List<Requerimento> buscarRequerimentoProtocolo(String numeroProtocolo) {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        List<Requerimento> lista = xml.getLista();
        List<Requerimento> listaRetorno = new ArrayList<>();
        //para cada item da lista de requerimento
        for (int i = 0; i < lista.size(); i++) {
        	//se o número do protocolo inserido foi igual ao número de protocolo de um item da lista
            if (lista.get(i).getNumeroProtocolo().equals(numeroProtocolo)) {
            	//adicionar à lista de retorno o requerimento que foi buscado
                listaRetorno.add(lista.get(i));
            }
        }
      /*trazer a lista de retorno contendo os requerimentos que possuem o mesmo número 
       * de protocolo inserido na busca*/
        return listaRetorno;
    }
//método para buscar requerimentos associados ao cpf de um usuário requerente
    public static List<Requerimento> buscarRequerimentoCPF(String cpf) {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        List<Requerimento> lista = xml.getLista();
        List<Requerimento> listaRetorno = new ArrayList<>();
        //para cada item da lista de requerimento
        for (int i = 0; i < lista.size(); i++) {
        	//se o número do cpf inserido for igual ao número de cpf de um requerente
            if (lista.get(i).getRequerente().getCpf().equals(cpf)) {
            	//adicionar à lista de retorno o requerimento que foi encontrado
                listaRetorno.add(lista.get(i));
            }
        }
        /*trazer a lista de retorno contendo os requerimentos que possuem o mesmo número 
         * de cpf do requerente inserido na busca*/
        return listaRetorno;
    }
  //método para buscar requerimentos associados à entidade de um usuário requerente
    public static List<Requerimento> buscarRequerimentoRequerenteAluno() {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        List<Requerimento> lista = xml.getLista();
        List<Requerimento> listaRetorno = new ArrayList<>();
        //para cada item da lista de requerimento
        for (int i = 0; i < lista.size(); i++) {
        	//se o requerente pesquisado for igual ao requerente de um requerimento
            if (lista.get(i).getRequerente() instanceof model.entity.Aluno) {
            	//adicionar à lista de retorno o requerimento que foi encontrado
                listaRetorno.add(lista.get(i));
            }
        }
        /*trazer a lista de retorno contendo os requerimentos que possuem o mesmo requerente 
         * inserido na busca*/
        return listaRetorno;
    }
  //método para buscar requerimentos associados à entidade de um usuário requerente
    public static List<Requerimento> buscarRequerimentoRequerenteProfessor() {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        List<Requerimento> lista = xml.getLista();
        List<Requerimento> listaRetorno = new ArrayList<>();
        //para cada item da lista de requerimento
        for (int i = 0; i < lista.size(); i++) {
        	//se o requerente pesquisado for igual ao requerente de um requerimento
            if (lista.get(i).getRequerente() instanceof model.entity.Professor) {
            	//adicionar à lista de retorno o requerimento que foi encontrado
                listaRetorno.add(lista.get(i));
            }
        }
        /*trazer a lista de retorno contendo os requerimentos que possuem o mesmo requerente 
         * inserido na busca*/
        return listaRetorno;
    }
  //método para buscar requerimentos associados à entidade de uma área responsável
    public static List<Requerimento> buscarRequerimentoAreaResponsavelProfessor() {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        List<Requerimento> lista = xml.getLista();
        List<Requerimento> listaRetorno = new ArrayList<>();
        //para cada item da lista de requerimento
        for (int i = 0; i < lista.size(); i++) {
        	//se á área responsável pesquisada for igual à área responsável de um requerimento
            if (lista.get(i).getAreaResponsavel() instanceof model.entity.Professor) {
            	//adicionar à lista de retorno o requerimento que foi encontrado
            	listaRetorno.add(lista.get(i));
            }
        }
        /*trazer a lista de retorno contendo os requerimentos que possuem a mesma área 
         * responsável inserido na busca*/
        return listaRetorno;
    }
  //método para buscar requerimentos associados à entidade de uma área responsável
    public static List<Requerimento> buscarRequerimentoAreaResponsavelTecnico() {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        List<Requerimento> lista = xml.getLista();
        List<Requerimento> listaRetorno = new ArrayList<>();
        //para cada item da lista de requerimento
        for (int i = 0; i < lista.size(); i++) {
        	//se á área responsável pesquisada for igual à área responsável de um requerimento
            if (lista.get(i).getAreaResponsavel() instanceof model.entity.Tecnico && lista.get(i).getStatus().equals(DESIGNADO)) {
            	//adicionar à lista de retorno o requerimento que foi encontrado
                listaRetorno.add(lista.get(i));
            }
        }
        /*trazer a lista de retorno contendo os requerimentos que possuem a mesma área 
         * responsável inserido na busca*/
        return listaRetorno;
    }
/*busca requerimentos que estão finalizados. Requerimentos finalizados são os que possuem 
 * os estados CONLUIDO ou REJEITADO */
    public static List<Requerimento> buscarRequerimentoFinalizado() {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        List<Requerimento> lista = xml.getLista();
        List<Requerimento> listaRetorno = new ArrayList<>();
        //para cada item da lista de requerimento
        for (int i = 0; i < lista.size(); i++) {
        	// se o requerimento possui os estados REJEITADO ou CONCLUIDO
            if (lista.get(i).getStatus().equals(REJEITADO) ||  lista.get(i).getStatus().equals(CONCLUIDO) ) {
            		//trazer esse requerimento na lista de retorno de requerimentos
                    listaRetorno.add(lista.get(i));
                
            }
        }
        /*trazer a lista de retorno contendo os requerimentos que possuem os mesmos estados
         * inseridos na busca*/
        return listaRetorno;
    }
    
// métodos para buscar requerimentos que já estejam designados para algum professor    
    public static List<Requerimento> buscarRequerimentoAreaResponsavelProfessorDesignado(String cpf) {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        List<Requerimento> lista = xml.getLista();
        List<Requerimento> listaRetorno = new ArrayList<>();
        //para toda a lsita de requerimentos
        for (int i = 0; i < lista.size(); i++) {
        	// se existir um requerimento com o estado DESIGNADO e com a área responsável sendo um professor
            if ((lista.get(i).getStatus().equals(DESIGNADO)) && lista.get(i).getAreaResponsavel().getCpf().equals(cpf)) {
                //adicionar esse requerimento à lista de retorno        
                listaRetorno.add(lista.get(i));
                
            }
        }
        //exibir a lista de retorno gerada
        return listaRetorno;
    }
    
// métodos para buscar requerimentos que já estejam pendentes para algum professor    
public static List<Requerimento> buscarRequerimentoAreaResponsavelProfessorDesignadoPendente(String cpf) {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        List<Requerimento> lista = xml.getLista();
        List<Requerimento> listaRetorno = new ArrayList<>();
        //para toda a lsita de requerimentos
        for (int i = 0; i < lista.size(); i++) {
        	// se existir um requerimento com o estado PENDENTE e com a área responsável sendo um professor
            if (lista.get(i).getStatus().equals("PENDENTE") && (lista.get(i).getAreaResponsavel().getCpf().equals(cpf))) {       
            	//adicionar esse requerimento à lista de retorno    
            	listaRetorno.add(lista.get(i));
            }  
        }
        //exibir a lista de retorno gerada
        return listaRetorno;
    }

/*métodos para buscar requerimentos que já estejam finalizados para algum professor. 
 * Finalizado são os estados CONCLUÍDO ou REJEITADO. */
    public static List<Requerimento> buscarRequerimentoAreaResponsavelProfessorFinalizado(String cpf) {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        List<Requerimento> lista = xml.getLista();
        List<Requerimento> listaRetorno = new ArrayList<>();
        //para toda a lsita de requerimentos
        for (int i = 0; i < lista.size(); i++) {
        	// se existir um requerimento com o estado CONCLUIDO ou REJEITADO e com a área responsável sendo um professor
            if ((lista.get(i).getStatus().equals(CONCLUIDO) )|| (lista.get(i).getStatus().equals(REJEITADO)) && (lista.get(i).getAreaResponsavel().getCpf().equals(cpf))) {
            	//adicionar esse requerimento à lista de retorno 
            	listaRetorno.add(lista.get(i));
                
            }
        }
        //exibir a lista de retorno gerada
        return listaRetorno;
    }
    public static List acessarXML(String tipoUsuario) {
        ManipuladorXML manipulador = new ManipuladorXML(String.valueOf(tipoUsuario) + "s.xml");
        manipulador.leXML();
        return manipulador.getLista();
    }
}
