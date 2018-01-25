package br.com.saude.prontuario.model.repository.interfaces;

import java.util.List;
import java.util.Map;

public interface GenericRepository<T> {

	List<T> buscarPorNome(String nome);

	List<T> buscar(Map<String, Object> params);

	List<T> autocompletar(String valor);
}
