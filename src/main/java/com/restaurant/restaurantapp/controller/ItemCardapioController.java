package com.restaurant.restaurantapp.controller;

import com.restaurant.restaurantapp.entities.ItemCardapio;
import com.restaurant.restaurantapp.service.ItemCardapioService;
import com.restaurant.restaurantapp.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/itens-cardapios")
public class ItemCardapioController {

    private final ItemCardapioService itemCardapioService;

    @Autowired
    public ItemCardapioController(ItemCardapioService itemCardapioService) {
        this.itemCardapioService = itemCardapioService;
    }

    @GetMapping
    public String listarTodos(Model model) {
        model.addAttribute("itens", itemCardapioService.findAll());
        return "itens-cardapios/lista";
    }

    @GetMapping("/novo")
    public String mostrarFormularioCriacao(Model model) {
        model.addAttribute("itemCardapio", new ItemCardapio());
        return "itens-cardapios/formulario";
    }

    @PostMapping
    public String criar(@ModelAttribute ItemCardapio itemCardapio) {
        itemCardapioService.insert(itemCardapio);
        return "redirect:/itens-cardapios";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        try {
            ItemCardapio itemCardapio = itemCardapioService.findById(id);
            model.addAttribute("itemCardapio", itemCardapio);
            return "itens-cardapios/formulario";
        } catch (ResourceNotFoundException e) {
            return "redirect:/itens-cardapios";
        }
    }

    @PostMapping("/{id}")
    public String atualizar(@PathVariable Long id, @ModelAttribute ItemCardapio itemCardapio) {
        itemCardapio.setId(id);
        itemCardapioService.insert(itemCardapio);  // Aqui usamos o serviço para salvar
        return "redirect:/itens-cardapios";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        try {
            itemCardapioService.delete(id);  // Aqui usamos o serviço para deletar
            return "redirect:/itens-cardapios";
        } catch (ResourceNotFoundException e) {
            return "redirect:/itens-cardapios";
        }
    }
}
