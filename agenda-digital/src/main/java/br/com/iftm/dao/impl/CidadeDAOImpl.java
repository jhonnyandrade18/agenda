package br.com.iftm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.iftm.dao.CidadeDAO;
import br.com.iftm.entily.Cidade;
import br.com.iftm.entily.enums.Estado;

//CAMADA DE DADOS

@Repository
public class CidadeDAOImpl implements CidadeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private List<Cidade> listaCidade = new ArrayList<>();
	private int indice = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.iftm.dao.CidadeDAO#create(br.com.iftm.entily.Cidade)
	 */

	@Override
	public Cidade create(Cidade cidade) {
		/*
		 * // numero do codigo em sequencia cidade.setCodigo(indice++);
		 * 
		 * // envia para a lista listaCidade.add(cidade);
		 */

		sessionFactory.getCurrentSession().save(cidade);
		sessionFactory.getCurrentSession().flush();

		return cidade;
	}

	@Override
	public List<Cidade> read() {
		/*
		 * // retorna List com o nome das cidades return listaCidade;
		 */
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Cidade.class);
		return criteria.list();
	}

	@Override
	public List<Cidade> readByEstado(Estado estado) {

		/*
		 * List<Cidade> listaRetorno = new ArrayList<>(); // verifica na lista for
		 * (Cidade cidade : listaCidade) {
		 * 
		 * if (cidade.getEstado().equals(estado)) { listaRetorno.add(cidade); } }
		 * 
		 * return listaRetorno;
		 * 
		 */

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Cidade.class);
		criteria.add(Restrictions.eq("estado", estado));
		return criteria.list();
	}// verificar

	@Override
	public Cidade update(Cidade cidade) {

		/*
		 * for (Cidade cidade2 : listaCidade) {
		 * 
		 * if (cidade2.getCodigo().equals(cidade.getCodigo())) {
		 * cidade2.setNome(cidade.getNome()); cidade2.setEstado(cidade.getEstado()); } }
		 * return cidade;
		 * 
		 */

		sessionFactory.getCurrentSession().update(cidade);
		sessionFactory.getCurrentSession().flush();

		return cidade;

	}

	@Override
	public void delete(Integer id) {

		/*
		 * for (Cidade cidade2 : listaCidade) {
		 * 
		 * if (cidade2.getCodigo().equals(id)) { // remove da lista
		 * listaCidade.remove(cidade2); break; } }
		 */

		Cidade cidade = new Cidade();
		cidade.setCodigo(id);
		sessionFactory.getCurrentSession().delete(cidade);
		sessionFactory.getCurrentSession().flush();
	}

}
