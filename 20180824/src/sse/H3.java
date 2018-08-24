package sse;

import java.util.Scanner;

public class H3 {
	Scanner scan = new Scanner(System.in);
	int num;
	Curve[] curve;
	int curve_index;
	int[][] direction = {{1,0},{0,-1},{-1,0},{0,1}};
	int[][] map = new int[100][100];
	int sol;
	
	public class Curve{
		int x, y, direction, generation;
		
		public Curve(int x, int y, int direction, int generation) {
			this.x = x;
			this.y = y;
			this.direction = direction;
			this.generation = generation;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		H3 obj = new H3();
		obj.getInput();

//		for(int i=0; i<9; i++) {
//			System.out.println(obj.curve[i].x+" "+obj.curve[i].y);
//
//		}
		
//		obj.print();
		obj.check();
			
		
	}
	private void check() {
		for(int i=0; i<99; i++) {
			for(int j=0; j<99; j++) {
				if(map[i][j]==1 && map[i+1][j]==1 && map[i][j+1]==1 && map[i+1][j+1]==1) {
					sol++;
				}
			}
		}
		System.out.println(sol);
		
	}
	private void print() {
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
	private void rotation(int start_x, int start_y, int what_x, int what_y, int index, int generation) {
		int a = start_x - what_x;
		int b = start_y - what_y;
		
		curve[2*(int)(Math.pow(2, generation))-index] = new Curve(start_x+b,start_y-a,0,generation+1);
		
	}
	
	private void make_curve(int generation) {
		
		if(generation == curve[0].generation) {
			point(generation);
			return;
		}
		
		for(int i=(int)Math.pow(2, generation)-1; i>=0; i--) {
			rotation(curve[(int)Math.pow(2, generation)].x,curve[(int)Math.pow(2, generation)].y,curve[i].x,curve[i].y, i, generation);
		}
		make_curve(generation+1);
		
	}
	

	private void point(int generation) {
		
		for(int i=0; i<Math.pow(2,generation)+1;i++) {
			try {
				map[curve[i].x][curve[i].y] = 1;
			}catch (ArrayIndexOutOfBoundsException e) {
				
			}
			
		}
		
	}
	public void getInput() {
		num = scan.nextInt();
		curve = new Curve[(int)Math.pow(2,20)];
		
		for(int i=0; i<num; i++) {
			curve_index = 0;
			curve[0] = new Curve(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt());
			curve[1] = new Curve(curve[0].x + direction[curve[0].direction][0], curve[0].y + direction[curve[0].direction][1], curve[0].direction, curve[0].generation);
			make_curve(0);
		}
		
		
	}

	
}
