package br.pro.luciene.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.pro.luciene.model.Produto;

public class ProdutoData extends Conexao implements CRUD{
    public ProdutoData() throws Exception{}

    @Override
    public boolean incluir(Object o) throws Exception {
        Produto objProduto = (Produto)o;
        String sql="insert into Produtos (descricao, quantidade) values(?,?)";
        PreparedStatement ps = getConexao().prepareStatement((sql));
        ps.setString(1, objProduto.getDescrição());
        ps.setFloat(2, objProduto.getQuantidade());
        int registros = ps.executeUpdate();
        if(registros > 0) return true;
        else return false;

    }

    @Override
    public boolean excluir(int id) throws Exception {
        String sql="delete from produtos where id=?";
        PreparedStatement ps = getConexao().prepareStatement((sql));
        ps.setInt(1,id);
        int registros = ps.executeUpdate();
        if(registros > 0) return true;
        else return false;
    }

    @Override
    public boolean editar(Object o) throws Exception {
        Produto obj = (Produto)o;
        String sql="update produtos set descricao=?, quantidade=? where id=?";
        PreparedStatement ps = getConexao().prepareStatement((sql));
        ps.setString(1, obj.getDescrição());
        ps.setFloat(2, obj.getQuantidade());
        ps.setInt(3,obj.getCodigo());
        int registros = ps.executeUpdate();
        if(registros > 0) return true;
        else return false;
    }
// domain1 - root - sa Glassfish
    @Override
    public ArrayList pesquisar(String pesquisa) throws Exception {
        String sql = "select * from produtos where descricao like '%"+pesquisa+"%'";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList dados = new ArrayList<>();
        while(rs.next()){
            dados.add(rs.getString("descricao"));
        }
        return dados;
    }

    public ArrayList<Produto> listar() throws Exception {
        String sql = "select * from produtos order by descricao";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Produto> dados = new ArrayList<>();
        while(rs.next()){
            Produto objProduto = new Produto(rs.getInt("id"), 
            rs.getString("descricao") , 
            rs.getInt("quantidade"));
            dados.add(objProduto);
        }
        return dados;
    }

    @Override
    public Object obter(int id) throws Exception {
        String sql = "select * from produtos where id=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        Produto objProduto = null;
        if(rs.next()){
            objProduto = new Produto(rs.getInt("id"), 
            rs.getString("descricao") , 
            rs.getInt("quantidade"));
        }
        return objProduto;
    }
    
}
