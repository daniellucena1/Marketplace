package com.ecommerce.controllers;

import java.util.Scanner;
import com.ecommerce.interfaces.IDonoController;
import com.ecommerce.interfaces.IDonoRepository;
import com.ecommerce.repositories.DonoRepository;
import com.ecommerce.models.Dono;

public class DonoController implements IDonoController {
    public IDonoRepository repository;

    public DonoController(DonoRepository repository) {
        this.repository = repository;
    }

    public Dono buscarDono() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(">> Digite a id do dono a ser procurado: ");
        String idDono = scanner.nextLine();

        return this.repository.buscarDono(idDono);
    }

    public Dono create() {
        Scanner scanner = new Scanner(System.in);

        System.out.print(">> Nome: ");
        String nome = scanner.nextLine();

        System.out.println(">> Senha: ");
        String senha = scanner.nextLine();

        System.out.print(">> CPF: ");
        String cpf = scanner.nextLine();

        boolean permissao = true;

        Dono dono = new Dono(cpf, senha, nome, permissao);

        System.out.println(this.repository.create(dono));
        return dono;
    }

    public boolean login() {
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
