package com.restaurant.restaurantapp.controller;

import com.restaurant.restaurantapp.entities.Pedido;
import com.restaurant.restaurantapp.entities.dtos.PedidoDto;
import com.restaurant.restaurantapp.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    // Listar todos os pedidos
    @GetMapping
    public String listarTodos(Model model) {
        model.addAttribute("pedidos", pedidoService.findAll());
        return "pedidos/lista";
    }

    // Encontrar pedido por ID
    @GetMapping("/{id}")
    public String encontrarPorId(@PathVariable Long id, Model model) {
        Pedido pedido = pedidoService.findById(id);
        model.addAttribute("pedido", new PedidoDto(pedido));
        return "pedidos/detalhes";
    }

    // Mostrar formulário para criar um novo pedido
    @GetMapping("/novo")
    public String mostrarFormularioCriacao(Model model) {
        model.addAttribute("pedido", new Pedido());
        return "pedidos/formulario";
    }

    // Criar um novo pedido
    @PostMapping
    public String criar(@ModelAttribute Pedido pedido) {
        pedidoService.insert(pedido);
        return "redirect:/pedidos";
    }

    // Mostrar formulário para editar um pedido existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        Pedido pedido = pedidoService.findById(id);
        model.addAttribute("pedido", pedido);
        return "pedidos/formulario";
    }

    // Atualizar um pedido existente
    @PostMapping("/editar/{id}")
    public String atualizar(@PathVariable Long id, @ModelAttribute Pedido pedido) {
        pedido.setId(id);
        pedidoService.update(id, pedido);
        return "redirect:/pedidos";
    }

    // Deletar um pedido
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        pedidoService.delete(id);
        return "redirect:/pedidos";
    }
}
