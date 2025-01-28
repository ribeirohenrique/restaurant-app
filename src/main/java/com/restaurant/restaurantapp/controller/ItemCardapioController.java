package com.restaurant.restaurantapp.controller;

import com.restaurant.restaurantapp.entities.ItemCardapio;
import com.restaurant.restaurantapp.repository.ItemCardapioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item-cardapio")
public class ItemCardapioController {

    private final ItemCardapioRepository itemCardapioRepository;

    public ItemCardapioController(ItemCardapioRepository itemCardapioRepository) {
        this.itemCardapioRepository = itemCardapioRepository;
    }

    @GetMapping("/cadastrar")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("itemCardapio", new ItemCardapio());
        return "formulario-cadastro";
    }

    @PostMapping
    public String salvarItemCardapio(@ModelAttribute ItemCardapio itemCardapio) {
        itemCardapioRepository.save(itemCardapio);
        return "redirect:/item-cardapio/listar";
    }

    @GetMapping("/listar")
    public String listarItensCardapio(Model model) {
        model.addAttribute("itens", itemCardapioRepository.findAll());
        return "lista-itens";
    }
}
