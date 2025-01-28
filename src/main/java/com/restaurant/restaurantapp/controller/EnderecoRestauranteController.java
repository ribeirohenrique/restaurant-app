package com.restaurant.restaurantapp.controller;

import com.restaurant.restaurantapp.entities.EnderecoRestaurante;
import com.restaurant.restaurantapp.entities.dtos.EnderecoRestauranteDto;
import com.restaurant.restaurantapp.service.EnderecoRestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/enderecos-restaurantes")
public class EnderecoRestauranteController {

    @Autowired
    private EnderecoRestauranteService enderecoRestauranteService;

    // Listar todos os endereços
    @GetMapping
    public String listarTodos(Model model) {
        model.addAttribute("enderecos", enderecoRestauranteService.findAll());
        return "enderecos-restaurantes/lista";
    }

    // Encontrar endereço por ID
    @GetMapping("/{id}")
    public String encontrarPorId(@PathVariable Long id, Model model) {
        EnderecoRestaurante enderecoRestaurante = enderecoRestauranteService.findById(id);
        model.addAttribute("endereco", new EnderecoRestauranteDto(enderecoRestaurante));
        return "enderecos-restaurantes/detalhes";
    }

    // Mostrar formulário para criar um novo endereço
    @GetMapping("/novo")
    public String mostrarFormularioCriacao(Model model) {
        model.addAttribute("endereco", new EnderecoRestaurante());
        return "enderecos-restaurantes/formulario";
    }

    // Criar um novo endereço
    @PostMapping
    public String criar(@ModelAttribute EnderecoRestaurante enderecoRestaurante) {
        enderecoRestauranteService.insert(enderecoRestaurante);
        return "redirect:/enderecos-restaurantes";
    }

    // Mostrar formulário para editar um endereço existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        EnderecoRestaurante enderecoRestaurante = enderecoRestauranteService.findById(id);
        model.addAttribute("endereco", enderecoRestaurante);
        return "enderecos-restaurantes/formulario";
    }

    // Atualizar um endereço existente
    @PostMapping("/editar/{id}")
    public String atualizar(@PathVariable Long id, @ModelAttribute EnderecoRestaurante enderecoRestaurante) {
        enderecoRestaurante.setId(id);
        enderecoRestauranteService.update(id, enderecoRestaurante);
        return "redirect:/enderecos-restaurantes";
    }

    // Deletar um endereço
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        enderecoRestauranteService.delete(id);
        return "redirect:/enderecos-restaurantes";
    }
}
