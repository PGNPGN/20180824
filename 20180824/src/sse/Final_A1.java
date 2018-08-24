package sse;

import java.util.Scanner;

public class Final_A1 {
	
	Scanner scan = new Scanner(System.in);
	int testcase;
	char[][] map;
	String dummy;
	int[][] dr = {{-1,-1},{-1,0},{-1,1}};
	int max = -Integer.MAX_VALUE;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Final_A1 obj = new Final_A1();
		obj.getInput();
//		obj.use_bomb(12);
//		obj.print();
//		obj.unuse_bomb(12);
//		obj.print();
	}

	public void getInput() {
		testcase = scan.nextInt();
		map = new char[13][5];
		scan.nextLine();
		
		for(int i=0; i<testcase; i++) {
			max = -Integer.MAX_VALUE;
			for(int k=0; k<13; k++) {
				dummy = scan.nextLine();
				for(int j=0; j<5; j++) {
					map[k][j] = dummy.charAt(j);
				}
			}
			
			process(12, 2, 1, 1, 0);
			System.out.println(max);
		}
	}

	private void process(int x, int y, int bomb, int stage, int score) {
		int nx, ny;

		if(bomb<0) return;
		if(stage == 13) {
			if(score > max) {
//				System.out.println(score);
				max = score;
				return;
			}
			return;
		}
		
		
		
		
		for(int i=0; i<3; i++) {
			nx = x + dr[i][0];
			ny = y + dr[i][1];
			
			if(nx>=0&&nx<13&&ny>=0&&ny<5) {
//				System.out.println("next = "+nx+" "+ny);
				
				if(map[nx][ny] == 'X') {
					use_bomb(x);
//					System.out.println("Stage = "+stage+" bomb = "+bomb+" used bomb");
					process(nx,ny,bomb-1,stage+1,score); //폭탄사용 후 진행
					unuse_bomb(x);
//					System.out.println("Stage = "+stage+" unused bomb");
					process(nx,ny,bomb,stage+1,score-7); //또는 미사용 후 진행
					
				}else if(map[nx][ny] == '0' || map[nx][ny] == '9') {
//					System.out.println("Stage = "+stage+" pass");
					process(nx,ny,bomb,stage+1,score);	// 장애물없이 통과
				}else if(map[nx][ny] == '*') {
//					System.out.println("Stage = "+stage+" get coin"+" score = "+(score+10));
					process(nx,ny,bomb,stage+1,score+10); // 동전먹음
				}
			}
			
		}
		
		
	}

	private void unuse_bomb(int x) {
		// TODO Auto-generated method stub
		try {
			for(int i=1; i<=5; i++) {
				for(int j=0; j<5; j++) {
					if(map[x-i][j] == '9') {
						map[x-i][j] = 'X';
					}
				}
			}
		}catch (ArrayIndexOutOfBoundsException e) {
			
		}
	}

	private void use_bomb(int x) {
		// TODO Auto-generated method stub
		try {
			for(int i=1; i<=5; i++) {
				for(int j=0; j<5; j++) {
					if(map[x-i][j] == 'X') {
						map[x-i][j] = '9';
					}
				}
			}
		}catch (ArrayIndexOutOfBoundsException e) {
			
		}
	}
	
	public void print() {
		for(int i=0; i<13; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
