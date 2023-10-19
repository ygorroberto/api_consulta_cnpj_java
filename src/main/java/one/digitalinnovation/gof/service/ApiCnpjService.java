package one.digitalinnovation.gof.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import one.digitalinnovation.gof.model.Cnpj;

@FeignClient(name = "consultaCnpj", url = "https://brasilapi.com.br/api/cnpj/v1")
public interface ApiCnpjService {

	@GetMapping("/{cnpj}")
    Cnpj consultarCnpj(@PathVariable("cnpj") String cnpj);
}
