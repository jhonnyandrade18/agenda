package br.com.iftm.entily;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity // persistencia
@Table(name = "TIPOSERVICO", schema = "EVERIS", uniqueConstraints = {
		@UniqueConstraint(name = "UNQ_TIPOSERVICO", columnNames = { "NOME_TIPOSERVICO" }) })
@SequenceGenerator(name = "SQ_TIPOSERVICO", sequenceName = "SQ_TIPOSERVICO", initialValue = 1, allocationSize = 1, schema = "EVERIS")

public class TipoServico {

	@Id

	@GeneratedValue(generator = "SQ_TIPOSERVICO", strategy = GenerationType.SEQUENCE)

	@Column(name = "CODIGO_TIPOSERVICO")

	private Integer codigo;

	@Column(name = "NOME_TIPOSERVICO", nullable = false, length = 100)

	private String nome;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
