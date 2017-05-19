package utd.classes.jpa;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Autor {
	
	@Id
	@GeneratedValue
	
	private Long id;
	@Column(name="nome_autor")
	private String nome;
	public String getNome() {
		return nome;
	}
	
	@Transient // ignora a inclusão no banco
	private String idade;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getId() {
		return id;
	}
	
	
	
	

}
