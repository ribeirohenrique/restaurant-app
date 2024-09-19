package com.restaurant.restaurantapp.config;

import com.restaurant.restaurantapp.entities.*;
import com.restaurant.restaurantapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Date;

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
    @Autowired
    private EnderecoRestauranteRepository enderecoRestauranteRepository;

    @Override
    public void run(String... args) {
        // Criando instâncias de Cliente
        Cliente cliente1 = new Cliente(null, "João Silva", "12345678901", "joao@gmail.com");
        Cliente cliente2 = new Cliente(null, "Maria Oliveira", "98765432109", "maria@gmail.com");
        clienteRepository.saveAllAndFlush(Arrays.asList(cliente1, cliente2));

        // Criando instâncias de endereco
        EnderecoRestaurante enderecoRestaurante1 = new EnderecoRestaurante(null, "Rua Adalberto da Silva", 342, "13190-012", "Canela", "Sumaré", null);
        EnderecoRestaurante enderecoRestaurante2 = new EnderecoRestaurante(null, "Rua Pepe Moreno", 111, "05145-0123", "Faria Lima", "Vinhedo", null);
        enderecoRestauranteRepository.saveAll(Arrays.asList(enderecoRestaurante1, enderecoRestaurante2));

        // Criando instâncias de Restaurante
        Restaurante restaurante1 = new Restaurante(null, "Restaurante Saboroso", "1145678910", null, null, enderecoRestaurante1);
        Restaurante restaurante2 = new Restaurante(null, "Restaurante Delícia", "2145678920", null, null, enderecoRestaurante2);
        restauranteRepository.saveAllAndFlush(Arrays.asList(restaurante1, restaurante2));

        // Criando instâncias de Cardápio
        Cardapio cardapio1 = new Cardapio(null, "Cardápio Restaurante Saboroso", restaurante1, null);
        Cardapio cardapio2 = new Cardapio(null, "Cardápio Restaurante Delícia", restaurante2, null);
        cardapioRepository.saveAllAndFlush(Arrays.asList(cardapio1, cardapio2));

        // Criando instâncias de ItemCardapio
        ItemCardapio item1 = new ItemCardapio(null, "Pizza", "Pizza de queijo", 25.00, cardapio1);
        ItemCardapio item2 = new ItemCardapio(null, "Hambúrguer", "Hambúrguer artesanal", 15.00, cardapio2);
        itemCardapioRepository.saveAllAndFlush(Arrays.asList(item1, item2));

        // Criando instâncias de Pagamento
        Pagamento pagamento1 = new Pagamento(null, new Date(), "Cartão de Crédito", 40.00, null);
        Pagamento pagamento2 = new Pagamento(null, new Date(), "Dinheiro", 5.00, null);
        pagamentoRepository.saveAllAndFlush(Arrays.asList(pagamento1, pagamento2));

        // Criando instâncias de Pedido
        Pedido pedido1 = new Pedido(null, new Date(), "concluido", 40.00, cliente1, null, pagamento1, restaurante1);
        Pedido pedido2 = new Pedido(null, new Date(), "pendente", 5.00, cliente2, null, pagamento2, restaurante2);
        Pedido pedido3 = new Pedido(null, new Date(), "concluido", 18.00, cliente1, null, pagamento1, restaurante1);
        pedidoRepository.saveAllAndFlush(Arrays.asList(pedido1, pedido2, pedido3));
    }

}
