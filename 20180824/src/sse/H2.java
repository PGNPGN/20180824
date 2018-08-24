package sse;

import java.util.Scanner;

public class H2 {
	Scanner scan = new Scanner(System.in);
	int a, b;
	int max_length;
	int[][] map;
	int index;
	int[][] d1 = {{-1,0},{0,1},{1,0},{0,-1}};//»ó¿ìÇÏÁÂ
	Camera[] queue;
	int min = Integer.MAX_VALUE, count;

	public class Camera{
		int x, y, kind;

		public Camera(int x, int y, int kind) {
			this.x = x;
			this.y = y;
			this.kind = kind;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		H2 obj = new H2();
		obj.getInput();
//		obj.print();
//		obj.mark_area(2, 3, 5, 0);
//		obj.print();
//		obj.unmark_area(2,3,5,0);
//		obj.print();
//		
		obj.dfs(0);
		System.out.println(obj.min);

	}

	public void dfs(int cnt) {


		if(cnt == index) {
			calculate();
			if(count<min) {
				min = count;
				return;
			}
			return;
		}

			for(int i=0; i<4; i++) {
//				System.out.println("i = "+i+" cnt = "+cnt);
				mark_area(queue[cnt].x, queue[cnt].y, queue[cnt].kind, i);
				dfs(cnt+1);
				unmark_area(queue[cnt].x, queue[cnt].y, queue[cnt].kind, i);
			}
		

	}
	private void calculate() {
		count=0;
		for(int i=0; i<a; i++) {
			for(int j=0; j<b; j++) {
				if(map[i][j] == 0) {
					count++;
				}
			}
		}
		
	}

	private void check(int x, int y, int i) {
		try{
			for(int j=1; j<max_length; j++) {
				if(map[x+j*d1[i][0]][y+j*d1[i][1]] == 6) break;
				if(map[x+j*d1[i][0]][y+j*d1[i][1]]<6 && map[x+j*d1[i][0]][y+j*d1[i][1]]>0) continue;
				map[x+j*d1[i][0]][y+j*d1[i][1]] += 10;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			
		}
	}
	private void uncheck(int x, int y, int i) {
		try{
			for(int j=1; j<max_length; j++) {
				if(map[x+j*d1[i][0]][y+j*d1[i][1]] == 6) break;
				if(map[x+j*d1[i][0]][y+j*d1[i][1]]<6 && map[x+j*d1[i][0]][y+j*d1[i][1]]>0) continue;
				map[x+j*d1[i][0]][y+j*d1[i][1]] -= 10;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			
		}
	}
	
	
	private void mark_area(int x, int y, int kind, int i) {
//		System.out.println("mark_area, x = "+x+" y = "+y+" kind = "+kind+" i = "+i);
		if(kind == 1) {
			check(x,y,i);
		}
		
		if(kind == 2 ) {
			check(x,y,i%4);
			check(x,y,(i+2)%4);
		}
		
		if(kind == 3) {
			check(x,y,i%4);
			check(x,y,(i+1)%4);
		}
		if(kind == 4) {
			check(x,y,i%4);
			check(x,y,(i+1)%4);
			check(x,y,(i+3)%4);
		}
		if(kind == 5) {
			check(x,y,i%4);
			check(x,y,(i+1)%4);
			check(x,y,(i+2)%4);
			check(x,y,(i+3)%4);
		}
		
		
	}
	private void unmark_area(int x, int y, int kind, int i) {
//		System.out.println("unmark_area, x = "+x+" y = "+y+" kind = "+kind+" i = "+i);
		if(kind == 1) {
			uncheck(x,y,i);
		}
		
		if(kind == 2 ) {
			uncheck(x,y,i%4);
			uncheck(x,y,(i+2)%4);
		}
		
		if(kind == 3) {
			uncheck(x,y,i%4);
			uncheck(x,y,(i+1)%4);
		}
		if(kind == 4) {
			uncheck(x,y,i%4);
			uncheck(x,y,(i+1)%4);
			uncheck(x,y,(i+3)%4);
		}
		if(kind == 5) {
			uncheck(x,y,i%4);
			uncheck(x,y,(i+1)%4);
			uncheck(x,y,(i+2)%4);
			uncheck(x,y,(i+3)%4);
		}
		
		
	}
	public void getInput() {
		a = scan.nextInt();
		b = scan.nextInt();
		map = new int[a][b];
		queue = new Camera[a*b];
		max_length=Math.max(a, b);

		for(int i=0; i<a; i++) {
			for(int j=0; j<b; j++) {
				map[i][j] = scan.nextInt();
				if(map[i][j]!=0 && map[i][j]!=6) {
					queue[index++] = new Camera(i,j,map[i][j]);
				}
			}
		}

		

		for(int i=0; i<index; i++) {
//			System.out.println(queue[i].x+" "+queue[i].y+" "+queue[i].kind);
		}
	}
	
	public void print() {
		for(int i=0; i<a; i++) {
			for(int j=0; j<b; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
