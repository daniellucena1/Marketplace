package com.ecommerce.models;

public class Entrega {
    private final int numeroRastreio;
    private String idCliente;
    private double valorFrete;
    private String status;
    private int idPedido;

    public Entrega(int numeroRastreio, String idCliente, double valorFrete, String status, int idPedido) {
        this.numeroRastreio = numeroRastreio;
        this.idCliente = idCliente;
        this.valorFrete = valorFrete;
        this.status = status;
        this.idPedido = idPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumeroRastreio() {
        return numeroRastreio;
    }

    public String getIdCliente() {
        return this.idCliente;
    }

    public int getIdPedido() {
        return this.idPedido;
    }

    public double getValorFrete() {
        return this.valorFrete;
    }

    @Override
    public String toString() {
        return "\n Numero de Rastreio: " + numeroRastreio + "\n Valor Frete: " + valorFrete
                + "\n Status: " + status;
    }
}
