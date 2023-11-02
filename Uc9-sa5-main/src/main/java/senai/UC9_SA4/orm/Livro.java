package senai.UC9_SA4.orm;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "livros")

public class Livro
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	private String titulo;
	private String autor;
	private String isbn;
	private String editora;
	
	public Integer getId()
	{
		return id;
	}
	public String getTitulo()
	{
		return titulo;
	}
	public String getAutor()
	{
		return autor;
	}
	public String getIsbn()
	{
		return isbn;
	}
	public String getEditora()
	{
		return editora;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}
	public void setAutor(String autor)
	{
		this.autor = autor;
	}
	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}
	public void setEditora(String editora)
	{
		this.editora = editora;
	}
}
