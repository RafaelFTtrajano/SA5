package senai.UC9_SA4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import senai.UC9_SA4.orm.Livro;
import senai.UC9_SA4.repository.LivroRepository;

@Service
public class LivroServicoCRUD implements LivroServico
{
	@Autowired
	private LivroRepository repositorio;
	
	public List<Livro> listarLivros()
	{
		return (List<Livro>)repositorio.findAll();
	}
	
	public Livro salvarLivro(Livro livro)
	{
		return repositorio.save(livro);
	}
	
	public void apagarLivro(Integer id)
	{ 
		repositorio.deleteById(id);
	}
	
	public Livro consultarLivroID(Integer id)
	{
		return repositorio.findById(id).get();
	}
	
	public Livro atualizarLivro(Livro livro)
	{
		return repositorio.save(livro);
	}
}
