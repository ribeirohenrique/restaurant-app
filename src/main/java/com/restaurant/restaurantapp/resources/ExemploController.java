package com.restaurant.restaurantapp.resources;

import com.restaurant.restaurantapp.entities.Cliente;
import com.restaurant.restaurantapp.service.CardapioService;
import com.restaurant.restaurantapp.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ExemploController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/bemvindo")
    public String bemVindo(Model model) {
        model.addAttribute("nome", "Henrique");
        return "bemvindo"; // Nome do arquivo "bemvindo.html" na pasta templates
    }

    @GetMapping("/produtos")
    public String listarProdutos(Model model) {
        Cliente cliente = clienteService.findById(1L);
        model.addAttribute("cliente", cliente);
        return "produtos"; // Mapeia para "produtos.html"
    }

}