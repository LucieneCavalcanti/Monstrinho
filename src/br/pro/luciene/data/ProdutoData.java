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
        String sql="delete from produtos where codigo=?";
        PreparedStatement ps = getConexao().prepareStatement((sql));
        ps.setInt(1,2);
        int registros = ps.executeUpdate();
        if(registros > 0) return true;
        else return false;
    }

    @Override
    public boolean editar(Object o) throws Exception {
        String sql="update produtos set descricao=?, quantidade=? where codigo=?";
        PreparedStatement ps = getConexao().prepareStatement((sql));
        ps.setString(1, "Energetico Monster");
        ps.setFloat(2, 3600);
        ps.setInt(3,2);
        int registros = ps.executeUpdate();
        if(registros > 0) return true;
        else return false;
    }

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

    @Override
    public Object obter(int id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obter'");
    }
    
}
