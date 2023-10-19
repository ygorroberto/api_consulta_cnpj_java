package one.digitalinnovation.gof.controller;

import one.digitalinnovation.gof.model.Empresario;
import one.digitalinnovation.gof.service.EmpresarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("empresarios")
public class EmpresarioRestController {

	@Autowired
	private EmpresarioService empresarioService;

	@GetMapping
	public ResponseEntity<Iterable<Empresario>> buscarTodos() {
		return ResponseEntity.ok(empresarioService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Empresario> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(empresarioService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Empresario> inserir(@RequestBody Empresario empresario) {
		empresarioService.inserir(empresario);
		return ResponseEntity.ok(empresario);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Empresario> atualizar(@PathVariable Long id, @RequestBody Empresario empresario) {
		empresarioService.atualizar(id, empresario);
		return ResponseEntity.ok(empresario);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		empresarioService.deletar(id);
		return ResponseEntity.ok().build();
	}
}
