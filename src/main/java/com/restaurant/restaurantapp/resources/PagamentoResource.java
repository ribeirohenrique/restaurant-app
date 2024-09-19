package com.restaurant.restaurantapp.resources;

import com.restaurant.restaurantapp.entities.Pagamento;
import com.restaurant.restaurantapp.entities.dtos.PagamentoDto;
import com.restaurant.restaurantapp.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pagamentos", produces = "application/json", consumes = "application/json")
public class PagamentoResource {

    @Autowired
    private PagamentoService pagamentoService;

    //Encontrar conta por Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<PagamentoDto> findById(@PathVariable Long id) {
        Pagamento pagamento = pagamentoService.findById(id);
        return ResponseEntity.ok().body(new PagamentoDto(pagamento));
    }
}
