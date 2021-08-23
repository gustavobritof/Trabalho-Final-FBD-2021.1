package control;

import java.util.List;

import model.Model;

public interface IControl <T extends Model, V extends Object>{
	public boolean inserir (T model);
	public boolean excluir(T model);
	public boolean alterar(T model);
	public List<T> obterTodos();
	public T obterPorId(V id);
}