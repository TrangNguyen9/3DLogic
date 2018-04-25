import java.util.Scanner;

public class TableauBloc {
	int nbTableau;
	Bloc tableau[][];
	int nbColor;
	Scanner sc = new Scanner(System.in);
	boolean trouve;

	public TableauBloc(int n){
		nbTableau = n;
		nbColor = 0;
		tableau = new Bloc [nbTableau + 2][nbTableau + 2];
		trouve = false;
		
		for (int i = 0; i<=nbTableau; i++) {
			for (int j = 0; j<=nbTableau; j++) {
				tableau[i][j] = new Bloc(i,j);
			}
		}
	}
	
	public TableauBloc(int n, int m, int value[][]){
		nbTableau = n;
		nbColor = m;
		tableau = new Bloc [nbTableau + 2][nbTableau + 2];
		trouve = false;
		
		for (int i = 0; i<=nbTableau + 1; i++) {
			for (int j = 0; j<=nbTableau + 1; j++) {
				tableau[i][j] = new Bloc(i,j, value[i][j]);
			}
		}
	}
	
	public boolean checkColor() { //verifier bon color
		//considere si tableau[i][j] != -1, 
		//if tableau[i][j] ne peuvent pas changer, coutSameColor doivent =1
		//sinon coutSameColor doivent =2
		
		int count;
		for (int i = 1; i<=nbTableau; i++) {
			for (int j = 1; j<=nbTableau; j++) {
				
				if (tableau[i][j].color != -1) {
					count = tableau[i][j].coutSameColor(tableau, nbTableau);	
				
					if (tableau[i][j].change && count !=2) {
						return false;
					}
					if (!tableau[i][j].change && count !=1) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public void color(int i, int j) {
		if (! trouve) {
			if (tableau[i][j].change ) {
				for (int l = 1; l<=nbColor; l++) {
					tableau[i][j].setColor(l);
					if (j == nbTableau) {
						if (i == nbTableau) {
							if (checkColor()) {
								print();
							}
						} else {
							color(i+1, 1);
						}
					} else {
						color(i, j + 1);
					}				
				}
			} else {
				if (j == nbTableau) {
					if (i == nbTableau) {
						if (checkColor()) {
							trouve = true;
							print();
						}
					} else {
						color(i+1, 1);
					}
				} else {
					color(i, j + 1);
				}
			}
		} else {
			return;
		}
	}
	
	public void print() {
		for (int i = 1; i<= nbTableau; i++) {
			for (int j = 1; j<= nbTableau; j++) {
				if (tableau[i][j].color != -1) {
					System.out.print(tableau[i][j].color + " ");
				} else {
					System.out.print("-" + " ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
