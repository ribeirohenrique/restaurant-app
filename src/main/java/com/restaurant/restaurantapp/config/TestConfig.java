package com.restaurant.restaurantapp.config;

import com.restaurant.restaurantapp.entities.*;
import com.restaurant.restaurantapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private RestauranteRepository restauranteRepository;
    @Autowired
    private ItemCardapioRepository itemCardapioRepository;
    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private CardapioRepository cardapioRepository;

    @Override
    @Transactional
    public void run(String... args) {
        // Criando instâncias de Cliente
        Cliente cliente1 = new Cliente(null, "João Silva", "12345678901", "joao@gmail.com", "11987654321");
        Cliente cliente2 = new Cliente(null, "Maria Oliveira", "98765432109", "maria@gmail.com", "21987654322");
        clienteRepository.saveAllAndFlush(Arrays.asList(cliente1, cliente2));

        // Criando instâncias de Restaurante
        Restaurante restaurante1 = new Restaurante(null, "Restaurante Saboroso", "Rua 123, Centro", "1145678910", new ArrayList<>(), new ArrayList<>());
        Restaurante restaurante2 = new Restaurante(null, "Restaurante Delícia", "Av. Principal, 456", "2145678920", new ArrayList<>(), new ArrayList<>());
        //restauranteRepository.saveAllAndFlush(Arrays.asList(restaurante1, restaurante2));

        // Criando instâncias de Cardápio
        Cardapio cardapio1 = new Cardapio(null, "Cardápio Restaurante Saboroso", true, restaurante1, new ArrayList<>());
        Cardapio cardapio2 = new Cardapio(null, "Cardápio Restaurante Delícia", true, restaurante2, new ArrayList<>());
        //cardapioRepository.saveAllAndFlush(Arrays.asList(cardapio1, cardapio2));

        // Criando instâncias de ItemCardapio
        ItemCardapio item1 = new ItemCardapio(null, "Pizza", "Pizza de queijo", 25.00, cardapio1);
        ItemCardapio item2 = new ItemCardapio(null, "Hambúrguer", "Hambúrguer artesanal", 15.00, cardapio1);
        ItemCardapio item3 = new ItemCardapio(null, "Suco", "Suco de laranja", 5.00, cardapio1);
        ItemCardapio item4 = new ItemCardapio(null, "Sopa", "Sopa de legumes", 10.00, cardapio2);
        ItemCardapio item5 = new ItemCardapio(null, "Salada", "Salada verde", 8.00, cardapio2);
        //itemCardapioRepository.saveAllAndFlush(Arrays.asList(item1, item2, item3, item4, item5));

        // Criando listas de itens do pedido, garantindo que não haja duplicatas
        List<ItemCardapio> itensPedido1 = new ArrayList<>(Arrays.asList(item1, item3));
        List<ItemCardapio> itensPedido2 = new ArrayList<>(Arrays.asList(item4));
        List<ItemCardapio> itensPedido3 = new ArrayList<>(Arrays.asList(item2));
        List<ItemCardapio> itensPedido4 = new ArrayList<>(Arrays.asList(item5));
        List<ItemCardapio> itensPedido5 = new ArrayList<>(Arrays.asList(item1));

        // Criando instâncias de Pagamento
        Pagamento pagamento1 = new Pagamento(null, new Date(), "Cartão de Crédito", 40.00, null);
        Pagamento pagamento2 = new Pagamento(null, new Date(), "Dinheiro", 5.00, null);
        Pagamento pagamento3 = new Pagamento(null, new Date(), "Pix", 18.00, null);
        Pagamento pagamento4 = new Pagamento(null, new Date(), "Cartão de Débito", 30.00, null);
        Pagamento pagamento5 = new Pagamento(null, new Date(), "Dinheiro", 23.00, null);
        //pagamentoRepository.saveAllAndFlush(Arrays.asList(pagamento1, pagamento2, pagamento3, pagamento4, pagamento5));

        // Criando instâncias de Pedido
        Pedido pedido1 = new Pedido(null, new Date(), "concluido", 40.00, cliente1, new ArrayList<>(itensPedido1), pagamento1, restaurante1);
        Pedido pedido2 = new Pedido(null, new Date(), "pendente", 5.00, cliente2, new ArrayList<>(itensPedido2), pagamento2, restaurante2);
        Pedido pedido3 = new Pedido(null, new Date(), "concluido", 18.00, cliente1, new ArrayList<>(itensPedido3), pagamento3, restaurante1);
        Pedido pedido4 = new Pedido(null, new Date(), "cancelado", 30.00, cliente2, new ArrayList<>(itensPedido4), pagamento4, restaurante2);
        Pedido pedido5 = new Pedido(null, new Date(), "em andamento", 23.00, cliente1, new ArrayList<>(itensPedido5), pagamento5, restaurante1);
        //pedidoRepository.saveAllAndFlush(Arrays.asList(pedido1, pedido2, pedido3, pedido4, pedido5));
    }

}
