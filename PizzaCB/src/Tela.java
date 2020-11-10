import java.text.DecimalFormat;
import java.util.Scanner;


public class Tela {
	
	private static Pizza[] pizzas = new Pizza[1];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		CalculoPizza calculo = new CalculoPizza();
		int opcao = 0;
		
		System.out.println("____________________");
		System.out.println("|                  |");
		System.out.println("| PIZZARIA BEM BOM |");
		System.out.println("|__________________|" + "\r");
		

		while (opcao != 3) {

			System.out.println("----------------- Sistema Pizza -----------------");
			System.out.println(" Adicionar pizza ------------- [1]");
			System.out.println(" Pizzas ---------------------- [2]");
			System.out.println(" Sair ------------------------ [3]");
			System.out.println("-------------------------------------------------");
			opcao = sc.nextInt();

			switch (opcao) {

			//--> Caso escolha 'Adicionar pizza'
			case 1:
				System.out.println("Nome da pizza");
				String nome = sc.next();

				System.out.println("Tamanho da pizza {em cm}");
				double tamanho = sc.nextDouble();

				System.out.println("Preço da pizza {em R$}");
				double preco = sc.nextDouble();
				
				adicionarPizza(nome, tamanho, preco);
				System.out.println("Pizza adicionada");
				break;

			//--> Caso escolha 'Pizzas'
			case 2:
				calculo.organizaMedias(pizzas);
				mostraPizzas(calculo.diferencaPercentual(pizzas));
				break;

			//--> Caso escolha 'Sair'
			case 3:
				System.out.println("Finalizando...");
				break;

			//--> Caso escolha uma opção que não existe
			default:
				System.out.println("Opção Inválida!");
				break;
			}
		}
	}

	
	//---> Adiciona uma nova Pizza
	public static void adicionarPizza(String nome, double tamanho, double preco) {

		pizzas = novoArray(pizzas);
		Pizza pizza = new Pizza(nome, tamanho, preco);  

		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] == null) {
				pizzas[i] = pizza;                    
				break;
			}
		}
	}

	//---> Expande o Array
	public static Pizza[] novoArray(Pizza[] pizzas) {
		Pizza[] novoArray = new Pizza[pizzas.length + 1];
		for (int i = 0; i < pizzas.length; i++) {        
			novoArray[i] = pizzas[i];
		}
		return novoArray;
	}
	
	//--> Mostra o caso 2 [Pizzas]
	public static void mostraPizzas(double[] percentual) {
		for(int i = 0;i<pizzas.length-1;i++) {
			System.out.println("--------------------------------");
			System.out.println("Pizza ["+(i+1)+"]");
			System.out.println("Nome ["+pizzas[i].getNome()+"]");
			System.out.println("Tamanho ["+pizzas[i].getTamanho()+"]");
			System.out.println("Preço [R$ "+pizzas[i].getPreco()+"]");
			
			DecimalFormat decimal = new DecimalFormat();
			
			System.out.println("R$ {p/cm²}  [R$ "+decimal.format(pizzas[i].getMediaPizza())+"]");
			if(i == 0) {
				System.out.println("[Melhor Custo Beneficio]");
			}else {
				System.out.println("Diferença percentual ["+decimal.format(percentual[i])+"%]");
			}
			System.out.println("--------------------------------");
		}
	}

}
