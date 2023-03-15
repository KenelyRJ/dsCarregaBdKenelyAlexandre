package carregabanco.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "idPessoa")
@Table(name = "aluno")
public class AlunoModel extends PessoaModel implements Serializable {
	private static final long serialVersionUID = 1L;
	//campus,polo,coordenacao,curso,nome_estudante,situacao,idade,sexo,email_institucional,periodo_entrada

	private String nome_estudante;
	private String coordenacao;
	private String curso;
	private String situacao;
	private String periodo_entrada;

	public String getCoordenacao() {
		return coordenacao;
	}

	public void setCoordenacao(String coordenacao) {
		this.coordenacao = coordenacao;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getNome_estudante() {
		return nome_estudante;
	}

	public void setNome_estudante(String nome_estudante) {
		this.nome_estudante = nome_estudante;
	}

	public String getPeriodo_entrada() {
		return periodo_entrada;
	}

	public void setPeriodo_entrada(String periodo_entrada) {
		this.periodo_entrada = periodo_entrada;
	}

}
