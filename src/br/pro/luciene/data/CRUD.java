package br.pro.luciene.data;

import java.util.ArrayList;

public interface CRUD {
    public boolean incluir (Object o) throws Exception;
    public boolean excluir (int id) throws Exception;
    public boolean editar (Object o) throws Exception;
    public ArrayList pesquisar (String pesquisa) throws Exception;
    public Object obter(int id) throws Exception;
}
