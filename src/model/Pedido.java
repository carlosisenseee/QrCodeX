package model;

import java.time.LocalDate;

public class Pedido {
    private int idPedido;
    private int idCarrinho;
    private LocalDate dataPedidoFeito;
    private LocalDate dataPedidoEntregue;
    private double precoTotal;
    private String statusPagamento; // PAGO, ABERTO, CANCELADO

    public Pedido() {}

    public Pedido(int idPedido, int idCarrinho, LocalDate dataPedidoFeito, LocalDate dataPedidoEntregue,
                  double precoTotal, String statusPagamento) {
        this.idPedido = idPedido;
        this.idCarrinho = idCarrinho;
        this.dataPedidoFeito = dataPedidoFeito;
        this.dataPedidoEntregue = dataPedidoEntregue;
        this.precoTotal = precoTotal;
        this.statusPagamento = statusPagamento;
    }

    // Getters e Setters
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public LocalDate getDataPedidoFeito() {
        return dataPedidoFeito;
    }

    public void setDataPedidoFeito(LocalDate dataPedidoFeito) {
        this.dataPedidoFeito = dataPedidoFeito;
    }

    public LocalDate getDataPedidoEntregue() {
        return dataPedidoEntregue;
    }

    public void setDataPedidoEntregue(LocalDate dataPedidoEntregue) {
        this.dataPedidoEntregue = dataPedidoEntregue;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", idCarrinho=" + idCarrinho +
                ", dataPedidoFeito=" + dataPedidoFeito +
                ", dataPedidoEntregue=" + dataPedidoEntregue +
                ", precoTotal=" + precoTotal +
                ", statusPagamento='" + statusPagamento + '\'' +
                '}';
    }
}
