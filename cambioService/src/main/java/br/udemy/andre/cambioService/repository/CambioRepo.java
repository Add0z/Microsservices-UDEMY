package br.udemy.andre.cambioService.repository;

import br.udemy.andre.cambioService.model.Cambio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CambioRepo extends JpaRepository<Cambio, Long> {

    Cambio findByFromAndTo(String from, String to);


}
