package model;

public class Carrinho {
    private int idCarrinho;
    private int idUsuario;
    private int idProduto;
    private int quantidadeProduto;
    private double precoProduto;

    public Carrinho() {}

    public Carrinho(int idCarrinho, int idUsuario, int idProduto, int quantidadeProduto, double precoProduto) {
        this.idCarrinho = idCarrinho;
        this.idUsuario = idUsuario;
        this.idProduto = idProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.precoProduto = precoProduto;
    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "idCarrinho=" + idCarrinho +
                ", idUsuario=" + idUsuario +
                ", idProduto=" + idProduto +
                ", quantidadeProduto=" + quantidadeProduto +
                ", precoProduto=" + precoProduto +
                '}';
    }
}

