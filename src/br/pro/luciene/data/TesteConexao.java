package br.pro.luciene.data;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.pro.luciene.model.Produto;

//import java.sql.PreparedStatement;
//import java.util.Scanner;

public class TesteConexao {

    public static void main(String[] args) {
        try {
            ProdutoData DAO = new ProdutoData();
            Produto obj = new Produto();
            String opcao = "";
            do {
                try {
                    opcao = JOptionPane
                            .showInputDialog(
                                    "Digite uma opção:\n[incluir] Produto\n[Pesquisar] Produto\n[listar] Produtos \n[Sair] Terminar");
                    switch (opcao) {
                        case "incluir":
                            obj.setDescrição(JOptionPane.showInputDialog("Digite a descrição"));
                            obj.setQuantidade(Float.parseFloat(JOptionPane.showInputDialog("Digite a quantidade")));
                            if (DAO.incluir(obj)) {
                                JOptionPane.showMessageDialog(null, "Salvo com sucesso");
                            } else {
                                JOptionPane.showMessageDialog(null, "Erro ao salvar");
                            }
                            break;
                        case "pesquisar":
                            ArrayList pesquisa = DAO.pesquisar(JOptionPane.showInputDialog("Digite a pesquisa"));
                            JOptionPane.showMessageDialog(null, pesquisa);
                            break;
                        case "listar": // listar todos select * from produtos order by codigo
                            // codigo - descricao
                            ArrayList lista = DAO.pesquisar("%");
                            JOptionPane.showMessageDialog(null, lista);
                            break;
                        case "sair":
                            System.exit(0);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida");
                    }
                } catch (Exception erro) {
                    JOptionPane.showMessageDialog(null, erro.getMessage());
                }
            } while (!opcao.equalsIgnoreCase("Sair"));

            /*
             * if (DAO.incluir(new Object()))
             * 
             * System.out.println("Salvo com sucesso!");
             * else{
             * System.out.println("Erro");
             * }
             * 
             * if (DAO.editar(new Object()))
             * 
             * System.out.println("Salvo com sucesso!");
             * else{
             * System.out.println("Erro");
             * }
             * 
             * if (DAO.excluir(2))
             * 
             * System.out.println("Salvo com sucesso!");
             * else{
             * System.out.println("Erro");
             * }
             */

        } catch (Exception e) {
            System.out.println("ERRO:" + e.getMessage());
        }
    }

}
