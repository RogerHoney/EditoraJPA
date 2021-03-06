package utd.classes.jpa;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery (name ="Autor.findAll", query="select a from Autor a")
public class Autor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="nome_autor")
	private String nome;
	@ManyToMany
	private Collection <Livro> livros = new ArrayList <Livro>();
	
	//getters and setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Collection<Livro> getLivros() {
		return livros;
	}
	public void setLivros(Collection<Livro> livros) {
		this.livros = livros;
	}
	

}
