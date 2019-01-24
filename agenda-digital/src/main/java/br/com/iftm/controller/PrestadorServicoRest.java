package br.com.iftm.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.PrestadorServicoBusiness;
import br.com.iftm.entily.Cidade;
import br.com.iftm.entily.PrestadorServico;

@RestController // habilita Classe como um servico rest.
@RequestMapping(value = "/prestadorservico") // Nome do Serviço.
public class PrestadorServicoRest {

	@Autowired // procura pela classe, evita de instanciar
	private PrestadorServicoBusiness psBusiness; // acessando a classe

	// CREATE
	@PostMapping
	public ResponseEntity<?> create(@RequestBody PrestadorServico prestadorServ) {

		try {
			prestadorServ = psBusiness.create(prestadorServ);

			return ResponseEntity.ok(prestadorServ);
		} catch (BusinessException e) {

			e.printStackTrace();

			// mensagem de erro
			return ResponseEntity.badRequest().body(e);
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////

	// READ
	@GetMapping
	public ResponseEntity<?> read() {

		try {
			List<PrestadorServico> retornaLista = psBusiness.read();

			if (retornaLista.isEmpty()) {
				return ResponseEntity.notFound().build();
			} else {
				// devolve a lista
				return ResponseEntity.ok(retornaLista);
			}

		} catch (BusinessException e) {

			e.printStackTrace();
			return ResponseEntity.badRequest().body(e); // retorna um codigo de badRequest
		}
	}

	// READ BY NAME
	@GetMapping("/filtro/nome") // rota que será retornada algum dado)
	public ResponseEntity<?> readByName(@PathParam("nome") String nome) {

		try {
			List<PrestadorServico> retornaLista = psBusiness.readByName(nome);

			if (retornaLista.isEmpty()) {
				return ResponseEntity.notFound().build();
			} else {
				// devolve a lista
				return ResponseEntity.ok(retornaLista);
			}

		} catch (BusinessException e) {

			e.printStackTrace();
			return ResponseEntity.badRequest().body(e); // retorna um codigo de badRequest
		}
	}

	// READ BY CIDADE (buscar por cidade)
	@GetMapping("/filtro/cidade") // rota que será retornada algum dado
	public ResponseEntity<?> readByCidade(@PathParam("cidade") Cidade cidade) {

		try {
			List<PrestadorServico> retornaCidade = psBusiness.readByCidade(cidade);

			if (retornaCidade == null || retornaCidade.isEmpty()) {
				return ResponseEntity.notFound().build();
			} else {
				// devolve a lista
				return ResponseEntity.ok(retornaCidade);
			}

		} catch (BusinessException e) {
			// mensagem de erro
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e); // retorna um codigo de badRequest
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////////////

	// UPDATE
	@PutMapping
	public ResponseEntity<?> update(@RequestBody PrestadorServico prestadorServ) {

		try {
			prestadorServ = psBusiness.update(prestadorServ);

			// devolve o objeto criado
			return ResponseEntity.ok(prestadorServ);
		} catch (BusinessException e) {

			e.printStackTrace();
			// mensagem de erro
			return ResponseEntity.badRequest().body(e);
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////

	// DELETE
	@DeleteMapping(value = "/{id}") // deletando pelo código, no caso ID
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {

		try {
			psBusiness.delete(id);
			return ResponseEntity.ok().build();

		} catch (BusinessException e) {

			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}
	}

}
