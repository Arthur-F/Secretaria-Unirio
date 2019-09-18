/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author RafaelSalazarStavale
 */
public class Usuario {

    @Getter
    @Setter
    private String cpf; // cpf do usuário. É utilizado para fazer o login no sistema. 
    @Getter
    @Setter
    private String senha; // senha do usuário
    @Getter
    @Setter
    private String nome; // nome do usuário
    @Getter
    @Setter
    private String dataNascimeto; // data de nascimento do usuário
    @Getter
    @Setter
    private String nacionalidade; // nacionalidade do usuário
    @Getter
    @Setter
    private String email; // e-mail do usuário
    @Getter
    @Setter
    private String estadoCivil; // estado civil do usuário
    @Getter
    @Setter
    private String sexo; // sexo do usuário (feminino ou masculino)
    @Getter
    @Setter
    private String nomeDaMae; // nome da mãe do usuário
    @Getter
    @Setter
    private String nomeDoPai; // nome do pai do usuário
    @Getter
    @Setter
    private String deficiencia; 
    @Getter
    @Setter
    private String tipoDeEndereco; // tipod e endereço do usuário
    @Getter
    @Setter
    private String tipoLogradouro; // tipo de logradouro do usuário
    @Getter
    @Setter
    private String logradouro; // logradouro do usuário
    @Getter
    @Setter
    private String complemento; // complemento do logradouro do usuário
    @Getter
    @Setter
    private String estado; // estado onde o usuário reside
    @Getter
    @Setter
    private String telefoneResidencial; // telefone residencial do usuário
    @Getter
    @Setter
    private String bairro; // bairro onde o usuário reside
    @Getter
    @Setter
    private String cidade; // cidade onde o usuário reside
    @Getter
    @Setter
    private String telefoneCelular; // telefone celular do usuário
    @Getter
    @Setter
    private String numero;
    @Getter
    @Setter
    private String cep; // cep do endereço do usuário
    @Getter
    @Setter
    private String pais; // país onde o usuário reside

    public Usuario() {
    }

    public Usuario(String cpf, String senha, String nome, String dataNascimeto, String nacionalidade, String email, String estadoCivil, String sexo, String nomeDaMae, String nomeDoPai, String deficiencia, String tipoDeEndereco, String tipoLogradouro, String logradouro, String complemento, String estado, String telefoneResidencial, String bairro, String cidade, String telefoneCelular, String numero, String cep, String pais) {
        this.cpf = cpf;
        this.senha = senha;
        this.nome = nome;
        this.dataNascimeto = dataNascimeto;
        this.nacionalidade = nacionalidade;
        this.email = email;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
        this.nomeDaMae = nomeDaMae;
        this.nomeDoPai = nomeDoPai;
        this.deficiencia = deficiencia;
        this.tipoDeEndereco = tipoDeEndereco;
        this.tipoLogradouro = tipoLogradouro;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.estado = estado;
        this.telefoneResidencial = telefoneResidencial;
        this.bairro = bairro;
        this.cidade = cidade;
        this.telefoneCelular = telefoneCelular;
        this.numero = numero;
        this.cep = cep;
        this.pais = pais;
    }

}
