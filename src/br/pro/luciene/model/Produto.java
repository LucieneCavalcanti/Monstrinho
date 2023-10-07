package br.pro.luciene.model;
public class Produto {
    private int codigo;
    private String descrição;
    private float quantidade;

    



    public Produto() {
        codigo=0;
        descrição = new String();
        quantidade = 0;
    }
    public Produto(int codigo, String descrição, float quantidade) {
        this.codigo = codigo;
        this.descrição = descrição;
        this.quantidade = quantidade;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getDescrição() {
        return descrição;
    }
    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }
    public float getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    
}
