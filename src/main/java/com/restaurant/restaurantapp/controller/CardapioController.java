package com.restaurant.restaurantapp.controller;

import com.restaurant.restaurantapp.entities.Cardapio;
import com.restaurant.restaurantapp.entities.dtos.CardapioDto;
import com.restaurant.restaurantapp.service.CardapioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/cardapios")
public class CardapioController {

    @Autowired
    private CardapioService cardapioService;

    // Listar todos os cardápios
    @GetMapping
    public String listarTodos(Model model) {
        model.addAttribute("cardapios", cardapioService.findAll());
        return "cardapios/lista";
    }

    // Encontrar por ID
    @GetMapping("/{id}")
    public String encontrarPorId(@PathVariable Long id, Model model) {
        Cardapio cardapio = cardapioService.findById(id);
        model.addAttribute("cardapio", new CardapioDto(cardapio));
        return "cardapios/detalhes";
    }

    // Mostrar formulário para criar um novo cardápio
    @GetMapping("/novo")
    public String mostrarFormularioCriacao(Model model) {
        model.addAttribute("cardapio", new Cardapio());
        return "cardapios/formulario";
    }

    // Criar um novo cardápio
    @PostMapping
    public String criar(@ModelAttribute Cardapio cardapio) {
        cardapioService.insert(cardapio);
        return "redirect:/cardapios";
    }

    // Mostrar formulário para editar um cardápio
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        Cardapio cardapio = cardapioService.findById(id);
        model.addAttribute("cardapio", cardapio);
        return "cardapios/formulario";
    }

    // Atualizar um cardápio existente
    @PostMapping("/editar/{id}")
    public String atualizar(@PathVariable Long id, @ModelAttribute Cardapio cardapio) {
        cardapio.setId(id); // Garantir que o ID seja mantido
        cardapioService.update(id, cardapio);
        return "redirect:/cardapios";
    }

    // Deletar um cardápio
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        cardapioService.delete(id);
        return "redirect:/cardapios";
    }
}
