package com.restaurant.restaurantapp.controller;

import com.restaurant.restaurantapp.entities.Cliente;
import com.restaurant.restaurantapp.entities.dtos.ClienteDto;
import com.restaurant.restaurantapp.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Listar todos os clientes
    @GetMapping
    public String listarTodos(Model model) {
        model.addAttribute("clientes", clienteService.findAll());
        return "clientes/lista";
    }

    // Encontrar cliente por ID
    @GetMapping("/{id}")
    public String encontrarPorId(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.findById(id);
        model.addAttribute("cliente", new ClienteDto(cliente));
        return "clientes/detalhes";
    }

    // Mostrar formulário para criar um novo cliente
    @GetMapping("/novo")
    public String mostrarFormularioCriacao(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/formulario";
    }

    // Criar um novo cliente
    @PostMapping
    public String criar(@ModelAttribute Cliente cliente) {
        clienteService.insert(cliente);
        return "redirect:/clientes";
    }

    // Mostrar formulário para editar um cliente existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.findById(id);
        model.addAttribute("cliente", cliente);
        return "clientes/formulario";
    }

    // Atualizar um cliente existente
    @PostMapping("/editar/{id}")
    public String atualizar(@PathVariable Long id, @ModelAttribute Cliente cliente) {
        cliente.setId(id);
        clienteService.update(id, cliente);
        return "redirect:/clientes";
    }

    // Deletar um cliente
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        clienteService.delete(id);
        return "redirect:/clientes";
    }
}
