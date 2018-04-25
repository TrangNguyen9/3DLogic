import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Puzzle {
	
	static int n_puzzle;
	static int n_color;
	static String fileName;
	static TableauBloc puzzle;
	int n_tmp = 3;
	
	public static void readFile(Scanner sc) {
		//read input file		
		int puzzle_value [][];
		
		String fileName = sc.nextLine();
		System.out.println(fileName);
		
		n_puzzle = sc.nextInt();
		n_color = sc.nextInt();
		
		puzzle_value = new int [n_puzzle * 2 + 2][n_puzzle * 2 + 2];
		
		for (int i = 0; i<= n_puzzle * 2 + 1; i++) {
			for (int j = 0; j<=n_puzzle * 2 + 1; j++) {
				puzzle_value[i][j] = -1;
			}
		}
		
		for (int i = 1; i <= n_puzzle * 2; i++) {
			for (int j = 1; j <= n_puzzle * 2; j++) {
				if (i > n_puzzle && j>n_puzzle) {
					break;
				}
				puzzle_value[i][j] = sc.nextInt();
			}
		}
		
		puzzle = new TableauBloc(n_puzzle*2, n_color, puzzle_value);
	}
	
	public static void main(String [] args) throws IOException {
		long startTime = System.nanoTime(); //commencer à calculer le temps
		
		Scanner sc = new Scanner(new File(args[0]));
		readFile(sc);
		puzzle.print();
		puzzle.color(1, 1);
		
		long endTime = System.nanoTime(); //finir à calculer le temps
		long duree = (endTime - startTime) / 1000000 ;
		System.out.println("Durée du calcul: " + (long) duree + " ms.");
	}
}
