package model;

public class Fornecedor {
    private int idFornecedor;
    private String email;
    private String nome;
    private String senha;
    private String telefone;
    private String cnpj;
    private String estado;
    private String cidade;
    private String cep;
    private String bairro;
    private String rua;
    private int nEmpresa;

    public Fornecedor() {
    }

    public Fornecedor(int idFornecedor, String email, String nome, String senha, String telefone, String cnpj,
            String estado, String cidade, String cep, String bairro, String rua, int nEmpresa) {
        this.idFornecedor = idFornecedor;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.bairro = bairro;
        this.rua = rua;
        this.nEmpresa = nEmpresa;
    }

    public Fornecedor(int idFornecedor, String nome, String cnpj) {
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNEmpresa() {
        return nEmpresa;
    }

    public void setNEmpresa(int nEmpresa) {
        this.nEmpresa = nEmpresa;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "idFornecedor=" + idFornecedor +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'' +
                ", cep='" + cep + '\'' +
                ", bairro='" + bairro + '\'' +
                ", rua='" + rua + '\'' +
                ", nEmpresa=" + nEmpresa +
                '}';
    }
}
