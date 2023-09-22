package com.ecommerce.models;

public class Pedido {
    private static int idCounter = 0;
    private final int id;
    private String idCliente;
    private String produtos;
    private int entregaId;

    public Pedido(String idCliente, String produtos) {
        this.id = idCounter++;
        this.idCliente = idCliente;
        this.produtos = produtos;
    }

    public String imprimePedido() {
        return "Produto(s): " + produtos + "Entrega: " + entregaId;
    }

    public int getId() {
        return this.id;
    }

    public String getClienteId() {
        return this.idCliente;
    }

    public void setEntrega(int entregaId) {
        this.entregaId = entregaId;
    }

    public int getEntrega() {
        return this.entregaId;
    }

    public String getProdutos() {
        return this.produtos;
    }

    @Override
    public String toString() {
        return "Pedido: \n ID:" + id + "\nCliente:" + idCliente;
    }
}