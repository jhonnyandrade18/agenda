package br.com.iftm.entily;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.iftm.entily.enums.Estado;

@Entity // persistencia
@Table(name = "CIDADE", schema = "EVERIS", uniqueConstraints = {
		/* @UniqueConstraint para nao repetir atributos */
		@UniqueConstraint(name = "UNQ_CIDADE", columnNames = { "NOME_CIDADE", "NOME_ESTADO" }) })
@SequenceGenerator(name = "SQ_CIDADE", sequenceName = "SQ_CIDADE", initialValue = 1, allocationSize = 1, schema = "EVERIS")
public class Cidade {

	@Id

	@GeneratedValue(generator = "SQ_CIDADE", strategy = GenerationType.SEQUENCE)

	@Column(name = "CODIGO_CIDADE")
	private Integer codigo;
	@Column(name = "NOME_CIDADE", nullable = false, length = 100)
	private String nome;
	@Column(name = "NOME_ESTADO", nullable = false, length = 2)
	@Enumerated(EnumType.STRING)
	private Estado estado;

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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
