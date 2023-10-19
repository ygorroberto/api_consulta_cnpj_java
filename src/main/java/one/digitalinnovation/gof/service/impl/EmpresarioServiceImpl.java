package one.digitalinnovation.gof.service.impl;

import java.util.Optional;

import one.digitalinnovation.gof.model.CnpjRepository;
import one.digitalinnovation.gof.model.EmpresarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.model.Empresario;
import one.digitalinnovation.gof.model.Cnpj;
import one.digitalinnovation.gof.service.EmpresarioService;
import one.digitalinnovation.gof.service.ApiCnpjService;

@Service
public class EmpresarioServiceImpl implements EmpresarioService {

	// Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private EmpresarioRepository empresarioRepository;
	@Autowired
	private CnpjRepository cnpjRepository;
	@Autowired
	private ApiCnpjService apiCnpjService;
	
	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<Empresario> buscarTodos() {
		return empresarioRepository.findAll();
	}

	@Override
	public Empresario buscarPorId(Long id) {
		Optional<Empresario> empresario = empresarioRepository.findById(id);
		return empresario.get();
	}

	@Override
	public void inserir(Empresario empresario) {
		salvarEmpresarioComCnpj(empresario);
	}

	@Override
	public void atualizar(Long id, Empresario empresario) {
		Optional<Empresario> empresarioBd = empresarioRepository.findById(id);
		if (empresarioBd.isPresent()) {
			salvarEmpresarioComCnpj(empresario);
		}
	}

	@Override
	public void deletar(Long id) {
		empresarioRepository.deleteById(id);
	}

	private void salvarEmpresarioComCnpj(Empresario empresario) {
		// Verificar se o CNPJ do Empresário já existe (pelo CNPJ).
		String numeroCnpj = empresario.getCnpj().getCnpj();
		Cnpj cnpj = cnpjRepository.findById(numeroCnpj).orElseGet(() -> {
			// Caso não exista, integrar com o Brasil CNPJ e persistir o retorno.
			Cnpj novoCnpj = apiCnpjService.consultarCnpj(numeroCnpj);

			cnpjRepository.save(novoCnpj);
			return novoCnpj;
		});
		empresario.setCnpj(cnpj);
		// Inserir Empresário, vinculando o CNPJ (novo ou existente).
		empresarioRepository.save(empresario);
	}

}
