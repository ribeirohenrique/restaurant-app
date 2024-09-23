package com.restaurant.restaurantapp.resources;

import com.restaurant.restaurantapp.entities.Cliente;
import com.restaurant.restaurantapp.entities.Pagamento;
import com.restaurant.restaurantapp.entities.dtos.ClienteDto;
import com.restaurant.restaurantapp.entities.dtos.PagamentoDto;
import com.restaurant.restaurantapp.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    //Criar
    @PostMapping
    public ResponseEntity<PagamentoDto> insert(@RequestBody Pagamento pagamento) {
        pagamento = pagamentoService.insert(pagamento);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pagamento.getId()).toUri();
        return ResponseEntity.created(uri).body(new PagamentoDto(pagamento));
    }
}
