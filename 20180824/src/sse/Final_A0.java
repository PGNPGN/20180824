package sse;

import java.util.Scanner;

public class Final_A0 {
	Scanner scan = new Scanner(System.in);
	int size;
	int range;
	int[][] map;
	int max, sol;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Final_A0 obj = new Final_A0();
		obj.getInput();
		obj.dfs(0);
		System.out.println(obj.max);
	}
	
	public void dfs(int cnt) {
		
		if(cnt == 2) {
			count();
			if(sol>max) {
				max = sol;
				return;
			}
			return;
		}
		
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(map[i][j]<2) {
					paint(i,j);
					dfs(cnt+1);
					unpaint(i,j);
				}
				
			}
		}
	}
	
	
	private void count() {
		sol=0;
		for(int a=0; a<size; a++) {
			for(int b=0; b<size; b++) {
				if(map[a][b]==2) {
					sol++;
				}
			}
		}
//		System.out.println(sol);
		
	}

	private void unpaint(int i, int j) {
		for(int a=0; a<size; a++) {
			for(int b=0; b<size; b++) {
				if(abs(a-i)+abs(b-j)<=range && map[a][b]>1) {
					map[a][b] -=2;
				}
			}
		}
		
	}

	private void paint(int i, int j) {
		for(int a=0; a<size; a++) {
			for(int b=0; b<size; b++) {
				if(abs(a-i)+abs(b-j)<=range) {
					map[a][b] += 2;
				}
			}
		}
		
	}
	
	public int abs(int a) {
		if(a>=0) return a;
		if(a<0) return -a;
		return 0;
	}

	public void getInput() {
		size = scan.nextInt();
		range = scan.nextInt();
		map = new int[size][size];
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				map[i][j] = scan.nextInt();
			}
		}
	}
}
