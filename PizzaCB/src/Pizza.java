
public class Pizza {
	
	private String nome;
	private double tamanho;
	private double preco;
	private double mediaPizza;

	//-> Método construtor
	public Pizza(String nome, double tamanho, double preco) {
		setNome(nome);
		setTamanho(tamanho);
		setPreco(preco);
	}

	//-> Média das pizzas
	public double getMediaPizza() {
		return mediaPizza;
	}

	public void setMediaPizza(double mediaPizza) {
		this.mediaPizza = mediaPizza;
	}

	//-> Nome das pizzas
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	//-> Tamanho das pizzas
	public double getTamanho() {
		return tamanho;
	}

	public void setTamanho(double tamanho) {        
		this.tamanho = tamanho;
	}

	//-> Preço das pizzas
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
