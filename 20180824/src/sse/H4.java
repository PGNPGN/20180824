package sse;

import java.util.Scanner;

public class H4 {
	Scanner scan = new Scanner(System.in);
	int testcase;
	char[][] map;
	int Rx, Ry, Bx, By;
	int[][] dr = {{-1,0},{1,0},{0,-1},{0,1}};
	int min = Integer.MAX_VALUE;
	int[][] check;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		H4 obj = new H4();
		obj.getInput();
	}

	public void getInput() {
		testcase = scan.nextInt();

		for(int i=0; i<testcase; i++) {
			min = Integer.MAX_VALUE;
			int R=scan.nextInt(), C=scan.nextInt();
			map = new char[R][C];
			check = new int[R][C];
			scan.nextLine();

			for(int j=0; j<R; j++) {
				String dummy = scan.nextLine();
				for(int k=0; k<C; k++) {
					map[j][k] = dummy.charAt(k);
					if(map[j][k] == 'R') {
						Rx = j; Ry = k;
					}
					if(map[j][k] == 'B') {
						Bx = j; By = k;
					}
				}
			}
			check[Rx][Ry] = 1;
			process(Rx, Ry, Bx, By,0);
			if(min>10) {
				System.out.println(-1);
			}else {
				System.out.println(min);
			}

		}

	}

	private void process(int Rx_, int Ry_, int Bx_, int By_, int cnt) {
		int Rnx, Rny, Bnx, Bny;

//		System.out.println("Rx_ = "+Rx_+" Ry_ = "+Ry_+" Bx_ = "+Bx_+" By_ = "+By+" cnt = "+cnt);
		if(cnt>10) return;
		if(Rx_ == Bx_ && Ry_ == By_) return;
		if(map[Bx_][By_] == 'H') return;
		if(map[Rx_][Ry_] == 'H') {
			if(cnt<min) {
				min = cnt;
//				System.out.println(min);
				return;
			}
			return;
		}


		for(int i=0; i<4; i++) {
			Rnx = Rx_ + dr[i][0];
			Rny = Ry_ + dr[i][1];
			Bnx = Bx_ + dr[i][0];
			Bny = By_ + dr[i][1];

//			System.out.println("Rnx = "+Rnx+" Rny = "+Rny);
			
			
			if(map[Rnx][Rny] == '#' || check[Rnx][Rny] == 1) {
				if(map[Bnx][Bny] =='#') {
					process(Rx_,Ry_,Bx_,By_,cnt+1);
				}else {
					process(Rx_,Ry_,Bnx,Bny,cnt+1);
				}
				
			}else {
				if(map[Bnx][Bny] =='#') {
					process(Rnx,Rny,Bx_,By_,cnt+1);
				}else {
					process(Rnx,Rny,Bnx,Bny,cnt+1);
				}
			}
		}
	}

}
