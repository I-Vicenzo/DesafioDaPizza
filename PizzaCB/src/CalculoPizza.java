
public class CalculoPizza {

	//---> Calculo da média de preço por cm²
	public double mediaPreco(Pizza pizza) {
		double raio = pizza.getTamanho() / 2;
		double area = Math.PI * Math.pow(raio, 2);    
		return pizza.getPreco() / area;
	}


	//---> Adiciona todas as médias de pizzas feitas
	public Pizza[] organizaMedias(Pizza[] pizzas) {

		for(int i = 0;i<pizzas.length-1;i++) {
			pizzas[i].setMediaPizza(mediaPreco(pizzas[i]));  
		}

		boolean entrou = true;
		//-> Organiza as médias de pizzas adicionadas
		for (int i = 0; i < pizzas.length-1; i++) {     

			int indice = i;
			entrou = true;

			while (entrou) {
				entrou = false;

				if (indice > 0) {
					if (pizzas[indice].getMediaPizza() < pizzas[indice - 1].getMediaPizza()) {
						Pizza Temporaria = pizzas[indice];
						pizzas[indice] = pizzas[indice - 1];
						pizzas[indice-1] = Temporaria;
						entrou = true;
					}
				}
				indice--;
			}
		}
		return pizzas;
	}

	//---> Calulo da difetença percentuas das pizzas
	public double[] diferencaPercentual(Pizza[] pizzas) {

		double[] porcentagem = new double[pizzas.length];    

		for(int i = 1;i<pizzas.length-1;i++) {
			porcentagem[i] = ((100*pizzas[i].getMediaPizza())/pizzas[1].getMediaPizza());  
		}

		boolean entrou = true;
		//-> Organiza o vetor dos percentuais
		for (int i = 0; i < porcentagem.length-1; i++) {      
			int indice = i;
			entrou = true;

			while (entrou) {
				entrou = false;

				if (indice > 0) {
					if (porcentagem[indice] < porcentagem[indice - 1]) {
						double numTemp = porcentagem[indice];
						porcentagem[indice] = porcentagem[indice - 1];
						porcentagem[indice-1] = numTemp;
						entrou = true;
					}
				}
				indice--;
			}
		}
		return porcentagem;
	}

}
