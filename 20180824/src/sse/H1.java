package sse;

import java.util.Scanner;

public class H1 {
	Scanner scan = new Scanner(System.in);
	int var1, var2, var3;
	int[][] map;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void getInput() {
		var1 = scan.nextInt();
		var2 = scan.nextInt();
		var3 = scan.nextInt();
		map = new int[var3][var1];
		for(int i=0; i<var2; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			
			map[a][b] = 1;
			map[a][b+1] = 2;
		}
		
	}
}
