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
                                    "Digite uma opção:\n[incluir] Produto\n[Pesquisar] Produto\n[listar] Produtos \n[excluir] Produtos\n[editar] Produto\n[Sair] Terminar");
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
                            ArrayList<Produto> lista = DAO.listar();
                            //JOptionPane.showMessageDialog(null, lista);//.toString()
                            String mensagem="Produtos Cadastrados:";
                            for (Produto p : lista) {
                                mensagem+= "\nID: " + p.getCodigo() + " - " + p.getDescrição();
                            }
                            JOptionPane.showMessageDialog(null, mensagem);
                            break;
                        case "excluir":
                            ArrayList<Produto> lista2 = DAO.listar();
                            //JOptionPane.showMessageDialog(null, lista);//.toString()
                            String mensagem2="Produtos Cadastrados:";
                            for (Produto p : lista2) 
                                mensagem2+= "\nID: " + p.getCodigo() + " - " + p.getDescrição();
                            int id = Integer.parseInt(JOptionPane.showInputDialog(null, mensagem2 
                            + "\n\nDigite o código do produto para excluir:"));
                            if(id>0)
                                if(DAO.excluir(id))
                                    JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
                                else
                                    JOptionPane.showMessageDialog(null, "Erro ao excluir");
                            else 
                                JOptionPane.showMessageDialog(null, "Erro ao selecionar registro");
                            break;
                        case "editar":
                            ArrayList<Produto> lista3 = DAO.listar();
                            //JOptionPane.showMessageDialog(null, lista);//.toString()
                            String mensagem3="Produtos Cadastrados:";
                            for (Produto p : lista3) 
                                mensagem3+= "\nID: " + p.getCodigo() + " - " + p.getDescrição();
                            int id3 = Integer.parseInt(JOptionPane.showInputDialog(null, mensagem3 
                            + "\n\nDigite o código do produto para editar:"));
                            if(id3>0)
                                obj = (Produto)DAO.obter(id3);
                                if(obj!=null){
                                    obj.setDescrição(JOptionPane.showInputDialog(null, 
                                    "Digite a descrição", obj.getDescrição()));
                                    obj.setQuantidade(Float.parseFloat(JOptionPane.showInputDialog(null, 
                                    "Digite a quantidade", obj.getQuantidade())));
                                    if(DAO.editar(obj)){
                                        JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
                                    }else 
                                        JOptionPane.showMessageDialog(null, "Não foi possível atualizar");
                                    
                                }
                            else 
                                JOptionPane.showMessageDialog(null, "Erro ao selecionar registro");
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
