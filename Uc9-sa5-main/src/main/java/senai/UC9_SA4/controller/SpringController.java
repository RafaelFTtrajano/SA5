package senai.UC9_SA4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import senai.UC9_SA4.orm.Livro;
import senai.UC9_SA4.services.LivroServico;

@Controller
public class SpringController
{
	@Autowired
	private LivroServico servico;

	@GetMapping({ "/" })
	public String path()
	{
		return "index";
	}

	@GetMapping({ "/livros" })
	public String listarLivros(Model modelo)
	{
		modelo.addAttribute("livro", servico.listarLivros());
		return "livros";
	}

	@GetMapping("/livros/adicionar")
	public String adicionarLivro(Model modelo)
	{
		Livro livro = new Livro();
		modelo.addAttribute("livro", livro);
		return "livroform";
	}

	@PostMapping("/livro")
	public String salvarLivro(@ModelAttribute("livro") Livro livro)
	{
		servico.salvarLivro(livro);
		return "redirect:/livros";
	}
	
	@GetMapping({"/livro/{id}"})
	public String apagarLivro(@PathVariable Integer id)
	{
		servico.apagarLivro(id);
		return "redirect:/livros";
	}
	
	@GetMapping("/livro/editar/{id}")
	public String editarLivro(@PathVariable Integer id, Model modelo)
	{
		modelo.addAttribute("livro", servico.consultarLivroID(id));
		return "editarLivro";
	}
	
	@PostMapping("/livro/{id}")
	public String atualizarLivro(@PathVariable Integer id, @ModelAttribute("livro")Livro livro, Model modelo)
	{
		Livro liv = servico.consultarLivroID(id);
		liv.setId(id);
		liv.setTitulo(livro.getTitulo());
		liv.setAutor(livro.getAutor());
		liv.setIsbn(livro.getIsbn());
		liv.setEditora(livro.getEditora());
		
		servico.atualizarLivro(livro);
		return "redirect:/livros";
	}
}
