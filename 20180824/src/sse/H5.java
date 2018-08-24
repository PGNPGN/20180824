package sse;

import java.util.Scanner;

public class H5 {
Scanner scan = new Scanner(System.in);
int testcase;
int sand_kind, sand_num;
int[] array;
int sol;
int[]check;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		H5 obj = new H5();
		obj.getInput();
	}

	public void getInput() {
		testcase = scan.nextInt();
		for(int i=0; i<testcase; i++) {
			sol=0;
			sand_kind = scan.nextInt(); sand_num = scan.nextInt();
			array = new int[sand_kind];
			check = new int[sand_num];
			for(int j=0; j<sand_kind; j++) {
				array[j] = scan.nextInt();
			}
			sort(array);
			process(0,0);
			System.out.println(sol);
		}
	}

	private void process(int index, int cnt) {

		if(cnt == sand_num) {
			if(index == sand_kind) {
				check[cnt-1] = 0;
			}
			System.out.println("back");
			sol++;
			return;
		}
		
		
		for(int i=index; i<sand_kind; i++) {
			if(check[cnt] == array[i]) continue;
			System.out.println("pick "+array[i]+"cnt is "+cnt);
			check[cnt] = array[i];
			process(i+1, cnt+1);
			
		}
		
		
		
	}

	private void sort(int[] array2) {
		for(int i=0; i<sand_kind-1; i++) {
			for(int j=i+1; j<sand_kind; j++) {
				if(array2[i]>array2[j]) {
					int temp = array2[i];
					array2[i] = array2[j];
					array2[j] = temp;
				}
			}
		}
		
		for(int i=0; i<sand_kind; i++) {
				System.out.print(array[i]);
		}
		
	}
}
