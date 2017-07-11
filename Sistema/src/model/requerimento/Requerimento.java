package model.requerimento;

import java.io.File;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import model.entity.Usuario;

public class Requerimento {

    @Getter
    @Setter
    private String numeroProtocolo;
    @Getter
    @Setter
    public Usuario requerente;
    @Getter
    @Setter
    private Usuario areaResponsavel;
    @Getter
    @Setter
    private String status;
    @Getter
    @Setter
    private String descricao;
    @Getter
    @Setter
    private String dataCriacao;
    @Getter
    @Setter
    private String dataSolucao;
    @Getter
    @Setter
    private String resposta;
    @Getter
    @Setter
    private String tipoRequerimento;
    @Getter
    @Setter
    private File anexo;
    @Getter
    @Setter
    private String disciplina;

    public Requerimento(Usuario requerente,
            Usuario areaResponsavel, String status,
            String descricao, String dataCriacao,
            String dataSolucao, String resposta,
            String tipoRequerimento) {
        this.numeroProtocolo = gerarNumeroProtocolo();
        this.requerente = requerente;
        this.areaResponsavel = areaResponsavel;
        this.status = status;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dataSolucao = dataSolucao;
        this.resposta = resposta;
        this.tipoRequerimento = tipoRequerimento;
    }

    public Requerimento(Usuario requerente,
            Usuario areaResponsavel, String status,
            String descricao, String dataCriacao,
            String dataSolucao, String resposta,
            String tipoRequerimento, File anexo, String disciplina) {
        this.numeroProtocolo = gerarNumeroProtocolo();
        this.requerente = requerente;
        this.areaResponsavel = areaResponsavel;
        this.status = status;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dataSolucao = dataSolucao;
        this.resposta = resposta;
        this.tipoRequerimento = tipoRequerimento;
        this.anexo = anexo;
        this.disciplina = disciplina;
    }

    public Requerimento() {
        this.numeroProtocolo = gerarNumeroProtocolo();

    }

    private String gerarNumeroProtocolo() {
        return String.valueOf(System.currentTimeMillis());
    }
}