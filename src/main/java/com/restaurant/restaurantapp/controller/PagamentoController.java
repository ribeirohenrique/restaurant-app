package com.restaurant.restaurantapp.controller;

import com.restaurant.restaurantapp.entities.Pagamento;
import com.restaurant.restaurantapp.entities.dtos.PagamentoDto;
import com.restaurant.restaurantapp.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    // Listar todos os pagamentos
    @GetMapping
    public String listarTodos(Model model) {
        model.addAttribute("pagamentos", pagamentoService.findAll());
        return "pagamentos/lista";
    }

    // Encontrar pagamento por ID
    @GetMapping("/{id}")
    public String encontrarPorId(@PathVariable Long id, Model model) {
        Pagamento pagamento = pagamentoService.findById(id);
        model.addAttribute("pagamento", new PagamentoDto(pagamento));
        return "pagamentos/detalhes";
    }

    // Mostrar formulário para criar um novo pagamento
    @GetMapping("/novo")
    public String mostrarFormularioCriacao(Model model) {
        model.addAttribute("pagamento", new Pagamento());
        return "pagamentos/formulario";
    }

    // Criar um novo pagamento
    @PostMapping
    public String criar(@ModelAttribute Pagamento pagamento) {
        pagamentoService.insert(pagamento);
        return "redirect:/pagamentos";
    }

    // Mostrar formulário para editar um pagamento existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        Pagamento pagamento = pagamentoService.findById(id);
        model.addAttribute("pagamento", pagamento);
        return "pagamentos/formulario";
    }

    // Atualizar um pagamento existente
    @PostMapping("/editar/{id}")
    public String atualizar(@PathVariable Long id, @ModelAttribute Pagamento pagamento) {
        pagamento.setId(id);
        pagamentoService.update(id, pagamento);
        return "redirect:/pagamentos";
    }

    // Deletar um pagamento
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        pagamentoService.delete(id);
        return "redirect:/pagamentos";
    }
}
