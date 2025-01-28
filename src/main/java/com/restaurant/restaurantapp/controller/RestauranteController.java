package com.restaurant.restaurantapp.controller;

import com.restaurant.restaurantapp.entities.Restaurante;
import com.restaurant.restaurantapp.entities.dtos.RestauranteDto;
import com.restaurant.restaurantapp.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    // Listar todos os restaurantes
    @GetMapping
    public String listarTodos(Model model) {
        model.addAttribute("restaurantes", restauranteService.findAll());
        return "restaurantes/lista";
    }

    // Encontrar restaurante por ID
    @GetMapping("/{id}")
    public String encontrarPorId(@PathVariable Long id, Model model) {
        Restaurante restaurante = restauranteService.findById(id);
        model.addAttribute("restaurante", new RestauranteDto(restaurante));
        return "restaurantes/detalhes";
    }

    // Mostrar formulário para criar um novo restaurante
    @GetMapping("/novo")
    public String mostrarFormularioCriacao(Model model) {
        model.addAttribute("restaurante", new Restaurante());
        return "restaurantes/formulario";
    }

    // Criar um novo restaurante
    @PostMapping
    public String criar(@ModelAttribute Restaurante restaurante) {
        restauranteService.insert(restaurante);
        return "redirect:/restaurantes";
    }

    // Mostrar formulário para editar um restaurante existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        Restaurante restaurante = restauranteService.findById(id);
        model.addAttribute("restaurante", restaurante);
        return "restaurantes/formulario";
    }

    // Atualizar um restaurante existente
    @PostMapping("/editar/{id}")
    public String atualizar(@PathVariable Long id, @ModelAttribute Restaurante restaurante) {
        restaurante.setId(id);
        restauranteService.update(id, restaurante);
        return "redirect:/restaurantes";
    }

    // Deletar um restaurante
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        restauranteService.delete(id);
        return "redirect:/restaurantes";
    }
}
