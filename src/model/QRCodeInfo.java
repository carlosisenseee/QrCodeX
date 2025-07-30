package model;

public class QRCodeInfo {
    private int idProduto;
    private String descricao;
    private int idPedido;
    private int idFornecedor;
    private String fornecedor;
    private String usuario;
    private String rua;
    private String bairro;
    private String cidade;
    private String cep;

    public QRCodeInfo() {
    }

    public QRCodeInfo(int idProduto, String descricao, int idPedido, int idFornecedor, String fornecedor,
            String usuario) {
        this.idProduto = idProduto;
        this.descricao = descricao;
        this.idPedido = idPedido;
        this.idFornecedor = idFornecedor;
        this.fornecedor = fornecedor;
        this.usuario = usuario;
    }

    public QRCodeInfo(int idProduto, String descricao, int idPedido, int idFornecedor,
            String fornecedor, String usuario, String rua, String bairro,
            String cidade, String cep) {
        this.idProduto = idProduto;
        this.descricao = descricao;
        this.idPedido = idPedido;
        this.idFornecedor = idFornecedor;
        this.fornecedor = fornecedor;
        this.usuario = usuario;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "QRCodeInfo{" +
                "idProduto=" + idProduto +
                ", descricao='" + descricao + '\'' +
                ", idPedido=" + idPedido +
                ", idFornecedor=" + idFornecedor +
                ", fornecedor='" + fornecedor + '\'' +
                ", usuario='" + usuario + '\'' +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }

}
