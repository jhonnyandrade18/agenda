package br.com.iftm.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.PrestadorServicoBusiness;
import br.com.iftm.dao.PrestadorServicoDAO;
import br.com.iftm.entily.Cidade;
import br.com.iftm.entily.PrestadorServico;
import br.com.iftm.entily.Telefone;
import br.com.iftm.entily.TipoServico;

@Service
public class PrestadorServicoBusinessImpl implements PrestadorServicoBusiness {

	@Autowired // procura pela classe, evita de instanciar
	private PrestadorServicoDAO prestadorDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PrestadorServico create(PrestadorServico prestadorServ) throws BusinessException {

		// validação se está preenchido ou não, dado obrigatório (objeto é string)
		if (StringUtils.isEmpty(prestadorServ.getNome())) {
			throw new BusinessException("Nome Requerido!"); // excessão disparada pela camada Business
		}

		// dado obrigatório, (objeto se compara com NULL)
		if (prestadorServ.getCidade().getCodigo() == null) {
			throw new BusinessException("Cidade Requerido!"); // possui chave estrangeira
		}

		// dado obrigatório, (objeto é string)
		if (StringUtils.isEmpty(prestadorServ.getBairro())) {
			throw new BusinessException("Bairro Requerido!"); // excessão disparada pela camada Business
		}

		// dado obrigatório, (objeto é string)
		if (StringUtils.isEmpty(prestadorServ.getLogradouro())) {
			throw new BusinessException("Logradouro Requerido!"); // excessão disparada pela camada Business
		}

		// dado obrigatório, (objeto se compara com NULL)
		if (prestadorServ.getTipoLogradouro() == null) {
			throw new BusinessException("TipoLogradouro Requerido!"); // excessão disparada pela camada Business
		}

		// dado obrigatório, (objeto é string)
		if (prestadorServ.getNumero() == null) {
			throw new BusinessException("Numero Casa Requerido!"); // excessão disparada pela camada Business
		}

		// dado obrigatório, (objeto se compara com NULL)
		if (prestadorServ.getTelefones() == null || prestadorServ.getTelefones().isEmpty()) {
			throw new BusinessException("Pelo menos um telefone Requerido!"); // possui chave estrangeira
		}

		for (Telefone telefone : prestadorServ.getTelefones()) {

			if (telefone.getDdd() == null) {
				throw new BusinessException("DDD Requerido!");
			}

			if (telefone.getNumero() == null) {
				throw new BusinessException("Número Telefone Requerido!");
			}

			telefone.setPrestadorServico(prestadorServ);
		}

		if (prestadorServ.getTipoServicos() == null || prestadorServ.getTipoServicos().isEmpty()) {
			throw new BusinessException("Pelo menos um tipo de serviço é Requerido");
		}

		for (TipoServico tipoServico : prestadorServ.getTipoServicos()) {

			if (tipoServico.getCodigo() == null) {
				throw new BusinessException("Código Tipo Serviço Requerido!");
			}
		}

		return prestadorDao.create(prestadorServ); // trata a parte de persistência (via interface)
	}

	////////////////////////////////////////////////////////////////////////////////////

	@Override
	@Transactional(readOnly = true)
	public List<PrestadorServico> read() throws BusinessException {
		// chama a camada DAO (dados)
		return prestadorDao.read();
	}

	@Override
	public List<PrestadorServico> readByName(String nome) throws BusinessException {

		// validação
		if (StringUtils.isEmpty(nome)) {
			throw new BusinessException("Nome Requerido!"); // excessão disparada pela camada Business
		}
		return prestadorDao.readByName(nome); // trata a parte de persistência (via interface)
	}

	@Override
	public List<PrestadorServico> readByCidade(Cidade cidade) throws BusinessException { // CORRIGIR

		// validação
		if (StringUtils.isEmpty(cidade)) {
			throw new BusinessException("Cidade Requerido!"); // excessão disparada pela camada Business
		}
		return prestadorDao.readByCidade(cidade); // trata a parte de persistência (via interface)
	}

	////////////////////////////////////////////////////////////////////////////////////

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PrestadorServico update(PrestadorServico prestadorServ) throws BusinessException {

		if (prestadorServ.getCodigo() == null) {
			throw new BusinessException("Nome Requerido!"); // excessão disparada pela camada Business
		}

		// validação se está preenchido ou não, dado obrigatório (objeto é string)
		if (StringUtils.isEmpty(prestadorServ.getNome())) {
			throw new BusinessException("Nome Requerido!"); // excessão disparada pela camada Business
		}

		// dado obrigatório, (objeto se compara com NULL)
		if (prestadorServ.getCidade().getCodigo() == null) {
			throw new BusinessException("Cidade Requerido!"); // possui chave estrangeira
		}

		// dado obrigatório, (objeto é string)
		if (StringUtils.isEmpty(prestadorServ.getBairro())) {
			throw new BusinessException("Bairro Requerido!"); // excessão disparada pela camada Business
		}

		// dado obrigatório, (objeto é string)
		if (StringUtils.isEmpty(prestadorServ.getLogradouro())) {
			throw new BusinessException("Logradouro Requerido!"); // excessão disparada pela camada Business
		}

		// dado obrigatório, (objeto se compara com NULL)
		if (prestadorServ.getTipoLogradouro() == null) {
			throw new BusinessException("TipoLogradouro Requerido!"); // excessão disparada pela camada Business
		}

		// dado obrigatório, (objeto é string)
		if (prestadorServ.getNumero() == null) {
			throw new BusinessException("Numero Casa Requerido!"); // excessão disparada pela camada Business
		}

		// dado obrigatório, (objeto se compara com NULL)
		if (prestadorServ.getTelefones() == null || prestadorServ.getTelefones().isEmpty()) {
			throw new BusinessException("Pelo menos um telefone Requerido!"); // possui chave estrangeira
		}

		for (Telefone telefone : prestadorServ.getTelefones()) {

			if (telefone.getDdd() == null) {
				throw new BusinessException("DDD Requerido!");
			}

			if (telefone.getNumero() == null) {
				throw new BusinessException("Número Telefone Requerido!");
			}

			telefone.setPrestadorServico(prestadorServ);
		}

		if (prestadorServ.getTipoServicos() == null || prestadorServ.getTipoServicos().isEmpty()) {
			throw new BusinessException("Pelo menos um tipo de serviço é Requerido");
		}

		for (TipoServico tipoServico : prestadorServ.getTipoServicos()) {

			if (tipoServico.getCodigo() == null) {
				throw new BusinessException("Código Tipo Serviço Requerido!");
			}
		}

		return prestadorDao.update(prestadorServ); // trata a parte de persistência (via interface)
	}

	////////////////////////////////////////////////////////////////////////////////////

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Integer id) throws BusinessException {

		if (id == null) {

			throw new BusinessException("Nome Requerido!"); // excessão disparada pela camada Business
		}
		prestadorDao.delete(id); // trata a parte de persistência (via interface)
	}

}
