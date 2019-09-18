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

    public static void analisaRequerimento(Requerimento requerimento) {
        if (requerimento.getStatus().equals("TRIAGEM") ||
        		requerimento.getStatus().equals(DESIGNADO) ||
        		requerimento.getStatus().equals(CONCLUIDO) ||
        		requerimento.getStatus().equals(REJEITADO) ||
        		requerimento.getStatus().equals("PENDENTE"))
            montaXML(requerimento);       
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

    public static List<Requerimento> buscarTriagem() {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        List<Requerimento> lista = xml.getLista();
        List<Requerimento> listaRetorno = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getStatus().equals("TRIAGEM")) {
                listaRetorno.add(lista.get(i));
            }
        }
        return listaRetorno;
    }

    public static List<Requerimento> buscarRequerimentoProtocolo(String numeroProtocolo) {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        List<Requerimento> lista = xml.getLista();
        List<Requerimento> listaRetorno = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNumeroProtocolo().equals(numeroProtocolo)) {
                listaRetorno.add(lista.get(i));
            }
        }
        return listaRetorno;
    }

    public static List<Requerimento> buscarRequerimentoCPF(String cpf) {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        List<Requerimento> lista = xml.getLista();
        List<Requerimento> listaRetorno = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getRequerente().getCpf().equals(cpf)) {
                listaRetorno.add(lista.get(i));
            }
        }
        return listaRetorno;
    }

    public static List<Requerimento> buscarRequerimentoRequerenteAluno() {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        List<Requerimento> lista = xml.getLista();
        List<Requerimento> listaRetorno = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getRequerente() instanceof model.entity.Aluno) {
                listaRetorno.add(lista.get(i));
            }
        }
        return listaRetorno;
    }

    public static List<Requerimento> buscarRequerimentoRequerenteProfessor() {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        List<Requerimento> lista = xml.getLista();
        List<Requerimento> listaRetorno = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getRequerente() instanceof model.entity.Professor) {
                listaRetorno.add(lista.get(i));
            }
        }
        return listaRetorno;
    }

    public static List<Requerimento> buscarRequerimentoAreaResponsavelProfessor() {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        List<Requerimento> lista = xml.getLista();
        List<Requerimento> listaRetorno = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getAreaResponsavel() instanceof model.entity.Professor) {
                listaRetorno.add(lista.get(i));
            }
        }
        return listaRetorno;
    }

    public static List<Requerimento> buscarRequerimentoAreaResponsavelTecnico() {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        List<Requerimento> lista = xml.getLista();
        List<Requerimento> listaRetorno = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getAreaResponsavel() instanceof model.entity.Tecnico && lista.get(i).getStatus().equals(DESIGNADO)) {
                listaRetorno.add(lista.get(i));
            }
        }
        return listaRetorno;
    }

    public static List<Requerimento> buscarRequerimentoFinalizado() {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        List<Requerimento> lista = xml.getLista();
        List<Requerimento> listaRetorno = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getStatus().equals(REJEITADO) ||  lista.get(i).getStatus().equals(CONCLUIDO) ) {
                
                    listaRetorno.add(lista.get(i));
                
            }
        }
        return listaRetorno;
    }
    
    
    public static List<Requerimento> buscarRequerimentoAreaResponsavelProfessorDesignado(String cpf) {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        List<Requerimento> lista = xml.getLista();
        List<Requerimento> listaRetorno = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {

            if ((lista.get(i).getStatus().equals(DESIGNADO)) && lista.get(i).getAreaResponsavel().getCpf().equals(cpf)) {
                        
                listaRetorno.add(lista.get(i));
                
            }
        }
        return listaRetorno;
    }
public static List<Requerimento> buscarRequerimentoAreaResponsavelProfessorDesignadoPendente(String cpf) {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        List<Requerimento> lista = xml.getLista();
        List<Requerimento> listaRetorno = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getStatus().equals("PENDENTE") && (lista.get(i).getAreaResponsavel().getCpf().equals(cpf))) {       
                    listaRetorno.add(lista.get(i));
            }  
        }
        return listaRetorno;
    }
    public static List<Requerimento> buscarRequerimentoAreaResponsavelProfessorFinalizado(String cpf) {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        List<Requerimento> lista = xml.getLista();
        List<Requerimento> listaRetorno = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {

            if ((lista.get(i).getStatus().equals(CONCLUIDO) )|| (lista.get(i).getStatus().equals(REJEITADO)) && (lista.get(i).getAreaResponsavel().getCpf().equals(cpf))) {
                        
            	listaRetorno.add(lista.get(i));
                
            }
        }
        return listaRetorno;
    }
    public static List acessarXML(String tipoUsuario) {
        ManipuladorXML manipulador = new ManipuladorXML(String.valueOf(tipoUsuario) + "s.xml");
        manipulador.leXML();
        return manipulador.getLista();
    }
}
