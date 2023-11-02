package senai.UC9_SA4.services;

import java.util.List;

import senai.UC9_SA4.orm.Livro;	

public interface LivroServico
{
	public List<Livro> listarLivros();

	public Livro salvarLivro(Livro livro);
	
	public void apagarLivro(Integer id);
	
	public Livro consultarLivroID(Integer id);
	
	public Livro atualizarLivro(Livro livro);
}
