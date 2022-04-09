package problema2;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class MegaDoIFS {

	public static void main(String[] args) throws IOException {

		/*
		 * ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ##
		 * ## ## ## ## ## ## # ## Autor: <Herisson> ## ## Concluído em: <14/02/2022> ##
		 * ## Declaro que este código foi elaborado por mim de forma individual e nao
		 * contem nenhum ## ## trecho de codigo de outro colega ou de outro autor, tais
		 * como provindos de livros e ## ## apostilas, e paginas ou documentos
		 * eletronicos da Internet. Qualquer trecho de codigo ## ## de outra autoria que
		 * nao a minha esta destacado com uma citacao para o autor e a fonte ## ## do
		 * codigo, e estou ciente que estes trechos nao serao considerados para fins de
		 * avaliacao. ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ##
		 * ## ## ## ## ## ## ## ## ## ## ## #
		 */

		Scanner dados;
		dados = new Scanner(Paths.get("client.txt"), "UTF-8");

		int qtdApostas = dados.nextInt();
		int[][] apostas = new int[qtdApostas][6];

		System.out.println("Apostas");

		for (int i = 0; i < qtdApostas; i++) {
			for (int a = 0; a < 6; a++) {
				apostas[i][a] = dados.nextInt();
				System.out.printf("%d ", apostas[i][a]);
			}
			System.out.println();
		}

		Random aleat = new Random();

		int[] sorteio = new int[6]; // declaração do vetor
		int count = 0;

		// gera os números aleatórios
		for (int i = 0; i < 6; i++) {
			sorteio[i] = aleat.nextInt(61);
		}

		System.out.println("\nSorteio\n ");

		// exibe os números sorteados
		for (int i = 0; i < 6; i++) {
			System.out.println(sorteio[i]);
			System.out.println(" ");
		}

		// compara os numeros sorteados e apostados para definir seus ganhadores
		for (int linha = 0; linha < qtdApostas; linha++) {

			int posSorteio = 0;

			while (posSorteio < 6) {
				for (int coluna = 0; coluna < 6; coluna++) {
					if (sorteio[posSorteio] == apostas[linha][coluna]) {
						count++;
					}
				}
				posSorteio = posSorteio + 1;
			}

			// exibe a aposta vencedora
			if (count == 6) {
				System.out.println("A aposta é a vencedora da Mega Sena!");
			}
			if (count == 5) {
				System.out.println("A aposta é a vencedora da quina!");
			}
			if (count == 4) {
				System.out.println("A aposta é a vencedora da quadra!");
			} else {

				System.out.println("Não houve ganhador");
				break;
			}
		}

	}
}