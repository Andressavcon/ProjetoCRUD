package repository;

import model.Banco;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Repository<T extends Banco> {

    Map<Integer, T> bancoDeDados;

    public Repository(){
        this.bancoDeDados = new TreeMap<>();
    }

    public void salvar(T t){
        this.bancoDeDados.put(t.getId(), t);
    }

    public List<T> buscarTodos(){
        return this.bancoDeDados.values().stream().collect(Collectors.toList());
    }

    public T buscar(Integer id) {
        return this.bancoDeDados.get(id);
    }

    public void remover(Integer id){
        this.bancoDeDados.remove(id);
    }
}
