package br.com.iftm.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.CidadeBusiness;
import br.com.iftm.dao.CidadeDAO;
import br.com.iftm.entily.Cidade;
import br.com.iftm.entily.enums.Estado;

//CAMADA DE NEGÓCIO (com cada função)

@Service
public class CidadeBusinessImpl implements CidadeBusiness {

	@Autowired // procura pela classe, evita de instanciar
	private CidadeDAO cidadeDao;

	@Override
	public Cidade create(Cidade cidade) throws BusinessException {
		// validação se está preenchido ou não
		if (StringUtils.isEmpty(cidade.getNome())) {
			throw new BusinessException("Nome Requerido!"); // excessão disparada pela camada Business
		}

		// dado obrigatório, (objeto se compara com NULL)
		if (cidade.getEstado() == null) {
			throw new BusinessException("Estado Requerido!"); // excessão disparada pela camada Business
		}
		return cidadeDao.create(cidade); // trata a parte de persistência (via interface)
	}

	////////////////////////////////////////////////////////////////////////////////////

	@Override
	public List<Cidade> read() {
		// chama a camada DAO (dados)
		return cidadeDao.read(); // trata a parte de persistência (via interface)
	}

	////////////////////////////////////////////////////////////////////////////////////

	@Override
	public Cidade update(Cidade cidade) throws BusinessException {

		if (cidade.getCodigo() == null) {
			throw new BusinessException("Código Requerido!"); // excessão disparada pela camada Business
		}
		// validação se está preenchido ou não
		if (StringUtils.isEmpty(cidade.getNome())) {
			throw new BusinessException("Nome Requerido!"); // excessão disparada pela camada Business
		}

		if (cidade.getEstado() == null) {
			throw new BusinessException("Estado Requerido!"); // excessão disparada pela camada Business
		}

		return cidadeDao.update(cidade); // trata a parte de persistência (via interface)
	}

	////////////////////////////////////////////////////////////////////////////////////

	@Override
	public void delete(Integer id) throws BusinessException {

		if (id == null) {

			throw new BusinessException("Nome Requerido!"); // excessão disparada pela camada Business
		}
		cidadeDao.delete(id); // trata a parte de persistência (via interface)
	}

	////////////////////////////////////////////////////////////////////////////////////

	@Override
	public List<Cidade> readByEstado(Estado estado) throws BusinessException {

		// validação
		if (estado == null) {
			throw new BusinessException("Estado Requerido!"); // excessão disparada pela camada Business
		}
		return cidadeDao.readByEstado(estado); // trata a parte de persistência (via interface)

	}

}
