package br.udemy.andre.bookservice.proxy;


import br.udemy.andre.bookservice.response.Cambio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "cambio-service")
public interface CambioProxy {

    @GetMapping(value = "/cambio/{amount}/{from}/{to}")
    public Cambio getCambio(
            @PathVariable("amount") Double amount,
            @PathVariable("from") String from,
            @PathVariable("to") String to);
}
