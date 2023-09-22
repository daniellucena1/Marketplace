package com.ecommerce.controllers;

import java.util.Scanner;

import com.ecommerce.interfaces.*;
import com.ecommerce.models.*;
import com.ecommerce.repositories.ClienteRepository;

public class ClienteController implements IClienteController {
    public IClienteRepository repository;

    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente create() {
        Scanner scanner = new Scanner(System.in);

        System.out.print(">> Nome: ");
        String nome = scanner.nextLine();

        System.out.println(">> Senha: ");
        String senha = scanner.nextLine();

        System.out.print(">> CPF: ");
        String cpf = scanner.nextLine();

        System.out.print(">> Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print(">> CEP: ");
        String cep = scanner.nextLine();

        boolean permissao = false;

        Cliente cliente = new Cliente(cpf, senha, nome, permissao, endereco, cep);

        System.out.println(this.repository.create(cliente));
        return cliente;
    }

    public void remove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(">> Digite a id do cliente a ser removido: ");
        String idCliente = scanner.nextLine();

        System.out.println(this.repository.remove(idCliente));
    }

    public Cliente findClienteById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(">> Digite a id do cliente a ser procurado");
        String idCliente = scanner.nextLine();

        return this.repository.findClienteById(idCliente);
    }

    public void update(Cliente cliente) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(">> Digite o novo nome a ser atualizado: ");
        String nome = scanner.nextLine();
        System.out.print(">> Digite a nova senha a ser atualizada: ");
        String senha = scanner.nextLine();
        System.out.print(">> Digite o novo endereco a ser atualizado:");
        String endereco = scanner.nextLine();
        System.out.print(">> Digite o novo CEP a ser atualizado: ");
        String cep = scanner.nextLine();

        boolean permissao = false;
        if (cliente.isPermissao()) {
            System.out.println("Digite a nova permissão: ");
            permissao = Boolean.valueOf(scanner.nextLine());
        }

        Cliente usuarioAtualizado = new Cliente(cliente.getCPF(), senha, nome, permissao, endereco, cep);
        this.repository.update(usuarioAtualizado);
    }

    public boolean login(boolean end) {
        if (end == true) {
            return false;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println(">> Digite seu cpf: ");
        String cpf = scanner.nextLine();
        System.out.println(">> Digite sua senha: ");
        String senha = scanner.nextLine();

        if (this.repository.login(cpf, senha) == true) {
            System.out.println(">> Entrando...");
            return true;
        }

        System.out.println(">> CPF ou senha incorretos");
        return false;
    }
}