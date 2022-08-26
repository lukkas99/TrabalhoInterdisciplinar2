package maven.project;

public class Cliente {
	private int id;
	private String nome;
	private String endereco;
	private int idade;
	private char sexo;
	
	public Cliente() {
		this.id = -1;
		this.nome = "";
		this.endereco = "";
		this.idade = -1;
		this.sexo = '*';
		
	}
	
	public Cliente(int id, String nome, String endereco, int idade, char sexo) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.idade = idade;
		this.sexo = sexo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Usuario [id = " + id + ", nome = " + nome + ", endereco = " + endereco +", idade = " + idade + ", sexo = " + sexo + "]";
	}	
}
