package com.ecommerce;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.ecommerce.controllers.*;
import com.ecommerce.database.DatabaseConnection;
import com.ecommerce.models.*;
import com.ecommerce.repositories.*;
import com.ecommerce.interfaces.*;

public class App {
    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.connection();
        int opcao = -1;
        Scanner scan = new Scanner(System.in);

        ICategoriaController categoriaController = new CategoriaController(new CategoriaRepository(connection));
        IProdutoController produtoController = new ProdutoController(new ProdutoRepository(connection));
        IEntregaController entregaController = new EntregaController(new EntregaRepository(connection));
        IPedidoController pedidoController = new PedidoController(new PedidoRepository(connection));
        IClienteController clienteController = new ClienteController(new ClienteRepository(connection));
        IDonoController donoController = new DonoController(new DonoRepository(connection));

        while(opcao != 0) {
            System.out.println("--------- Login ---------");
            System.out.println(">> 1 - Cliente\n>> 2 - Dono\n>> 0 - Encerrar");

            opcao = Integer.parseInt(scan.nextLine());

            switch(opcao) {
                case 1:
                    if(clienteController.login(false)) {
                        Cliente cliente = clienteController.findClienteById();
                        menuCliente(cliente, clienteController, categoriaController, produtoController, entregaController, pedidoController);
                    }
                    break;
                case 2:
                    if(donoController.login()) {
                        menuDono(clienteController, categoriaController, produtoController, entregaController, pedidoController);
                    }
                    break;
                case 0:
                    scan.close();
                    break;
            }
        }
    }

    public static void menuDono(IClienteController clienteController, ICategoriaController categoriaController,
            IProdutoController produtoController, IEntregaController entregaController,
            IPedidoController pedidoController) {
        int opcao = -1;
        boolean user = true;
        Scanner sc = new Scanner(System.in);

        while (opcao != 0 && user == true) {
            System.out.println("Digite umas das opções:\n");
            System.out.println(">> 1 - Criar Cliente");
            System.out.println(">> 2 - Remover cliente");
            System.out.println(">> 3 - Buscar cliente");
            System.out.println(">> 4 - Mostrar prdoutos");
            System.out.println(">> 5 - Adicionar produtos");
            System.out.println(">> 6 - Remover produtos");
            System.out.println(">> 7 - Atualizar Produtos");
            System.out.println(">> 8 - Imprimir relatório dos pedidos");
            System.out.println(">> 9 - Alterar status de entrega");
            System.out.println(">> 10 - Criar categoria");
            System.out.println(">> 11 - Mostrar categorias");            
            System.out.println(">> 12 - Sair");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    clienteController.create();
                    break;
                case 2:
                    clienteController.remove();
                    break;
                case 3:
                    System.out.println(clienteController.findClienteById().getCPF() + " " + clienteController.findClienteById().getNome()); 
                    break;
                case 4:
                    produtoController.getAll();
                    break;
                case 5:
                    int pos = categoriaController.getPos();
                    if (pos != -1) {
                        produtoController.create(categoriaController.getCategoria(pos));
                        break;
                    }
                    produtoController.create(categoriaController.create());
                    break;
                case 6:
                    produtoController.remove();
                    break;
                case 7:
                    produtoController.update();
                    break;
                case 8:
                    pedidoController.getPedidos();
                    break;
                case 9:
                    entregaController.update();
                    break;
                case 10:
                    categoriaController.create();
                    break;
                case 11:
                    categoriaController.getAll();
                    break;
                case 12:
                    user = clienteController.login(true);
                    break;
                case 0:
                    sc.close();
                    break;
            }
        }
    }

    public static void menuCliente(Cliente cliente, IClienteController clienteController, ICategoriaController categoriaController,
            IProdutoController produtoController, IEntregaController entregaController,
            IPedidoController pedidoController) {
        List<Produto> carrinho = new ArrayList<Produto>();

        int opcao = -1;
        boolean userV = true;
        Scanner sc = new Scanner(System.in);

        while (opcao != 0 && userV) {
            produtoController.getAll();

            System.out.println("-----------------------------------------------");
            System.out.println("Digite umas das opções:\n");
            System.out.println(">> 1 - Adicionar produto carrinho");
            System.out.println(">> 2 - Mostrar carrinho");
            System.out.println(">> 3 - Alterar meus dados");
            System.out.println(">> 4 - Listar produtos a partir da categoria");
            System.out.println(">> 5 - Finalizar pedido");
            System.out.println(">> 6 - Listar meus pedidos");
            System.out.println(">> 7 - Listar entrega");
            System.out.println(">> 8 - Encerrar programa");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    Produto produto = produtoController.findById();
                    carrinho.add(produto);
                    break;
                case 2:
                    for (Produto produtoDoCarrinho : carrinho) {
                        System.out.println(produtoDoCarrinho);
                    }
                    break;
                case 3:
                    clienteController.update(cliente);
                    break;
                case 4:
                    Categoria categoria = categoriaController.getCategoria(categoriaController.getPos());
                    produtoController.getByCategoria(categoria);
                    break;
                case 5:
                    String produtos = "";

                    for (int i = 0; i < carrinho.size(); i++) {
                        produtos += carrinho.get(i).getNome() + ", ";
                    }

                    Pedido pedido = new Pedido(cliente.getCPF(), produtos);
                    pedidoController.create(pedido);
                    Entrega entrega = new Entrega(1, cliente.getCPF(), new Random().nextInt(100), "Aguarde", pedido.getId());
                    entregaController.create(entrega);
                    break;
                case 6:
                    pedidoController.getPedidoByUserId(cliente.getCPF());
                    break;
                case 7:
                    userV = clienteController.login(true);
                case 0:
                    sc.close();
                    break;
            }
        }
    }
}