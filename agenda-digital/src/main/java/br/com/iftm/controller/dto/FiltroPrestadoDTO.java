package br.com.iftm.controller.dto;

import java.util.Set;

import br.com.iftm.entily.Cidade;
import br.com.iftm.entily.TipoServico;
import br.com.iftm.entily.enums.Estado;

public class FiltroPrestadoDTO {

	private String nome;
	private Estado estado;
	private Cidade cidade;
	private Set<TipoServico> tiposServicos;

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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Set<TipoServico> getTiposServicos() {
		return tiposServicos;
	}

	public void setTiposServicos(Set<TipoServico> tiposServicos) {
		this.tiposServicos = tiposServicos;
	}

}
