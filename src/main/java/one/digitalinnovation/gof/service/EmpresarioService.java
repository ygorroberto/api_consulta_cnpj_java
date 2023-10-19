package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Empresario;

public interface EmpresarioService {

	Iterable<Empresario> buscarTodos();

	Empresario buscarPorId(Long id);

	void inserir(Empresario empresario);

	void atualizar(Long id, Empresario empresario);

	void deletar(Long id);

}
