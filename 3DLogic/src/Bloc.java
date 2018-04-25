
public class Bloc {
	int i;
	int j;
	int color;
	boolean change;
	
	public Bloc() {
		this.i = -1; 
		this.j = -1;
		this.color = -1;
		this.change = false;
	}
	
	public Bloc(int i, int j) {
		this.i = i; 
		this.j = j;
		this.color = -1;
		this.change = false;
	}
	
	public Bloc(int i, int j, int value) {
		this.i = i; 
		this.j = j;
		this.color = value;
		this.change = (value == 0);
	}
	
	public Bloc top(Bloc tableau[][]) {
		return tableau[i-1][j];
	}
	
	public Bloc bot(Bloc tableau[][], int nbTableau) {		
		if ((i==(nbTableau / 2)) && (j > (nbTableau /2))) {
			return tableau[j][i];
		} else {
			return tableau[i+1][j];
		}
	}
	
	public Bloc right(Bloc tableau[][], int nbTableau) {
		if ((j==(nbTableau / 2)) && (i > (nbTableau /2))) {
			return tableau[j][i];
		} else {
			return tableau[i][j+1];
		}
	}
	
	public Bloc left(Bloc tableau[][]) {
		return tableau[i][j-1];
	}
	
	public int coutSameColor(Bloc tableau[][], int nbTableau) {
		int count = 0; 
		
		if (this.top(tableau).color == color ) {
			count++;
		}
		if (this.bot(tableau, nbTableau).color == color ) {
			count++;
		}
		if (this.left(tableau).color == color ) {
			count++;
		}
		if (this.right(tableau, nbTableau).color == color ) {
			count++;
		}
		
		return count;
	}
	
	public boolean setColor(int c) {
		if (this.change) {
			this.color = c;
		}
		
		return this.change;
	}
	
}
