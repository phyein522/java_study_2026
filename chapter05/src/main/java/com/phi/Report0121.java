package com.phi;

public class Report0121 {
	public void booleanArray() {
		/*
		- 1번 : 10개의 boolean 값이 원소인 1차원 배열의 짝수번째 인덱스가 true 이고 다른 인덱스는 false 로 만들어서 출력하세요
		입력 =>
		boolean[] boolArray = new boolean[10];
		한줄에 출력 =>
		true, false, true, false, ..., true, false
		*/
		boolean[] boolArray = new boolean[10];	//new boolean[]: false 초기화
		for(int i = 0; i < boolArray.length; i += 2) {	//짝수 index에만 true 대입
			boolArray[i] = true;
		}

		for(int i = 0; i < boolArray.length; i++) {
			System.out.print((i != 0 ? ", " : "") + boolArray[i]);
		}
		System.out.println();
	}

	public void countZeroAndOne() {
		/*
		- 2번 : 0,1 로 이루어진 2차원 직사각형 배열이 있습니다. 0의 갯수와 1의 갯수를 출력하세요
		입력 =>
		int[][] intDemention2 = {
				{0, 0, 1, 1, 0, 0}, {1, 0, 0, 1, 0, 0}
				, {0, 1, 0, 1, 0, 0}, {0, 0, 1, 1, 0, 1}
				, {1, 0, 0, 0, 1, 0}
			};
		한줄에 출력 =>
		0의 갯수는 ?개, 1의 갯수는 ?개.
		*/
		int[][] intDemention2 = {
				{0, 0, 1, 1, 0, 0},
				{1, 0, 0, 1, 0, 0},
				{0, 1, 0, 1, 0, 0},
				{0, 0, 1, 1, 0, 1},
				{1, 0, 0, 0, 1, 0}
		};

		int[] countZeroAndOne = new int[2];	//index: 0, 1

		for(int[] intDemention1 : intDemention2) {
			for(int intDemention : intDemention1) {
				countZeroAndOne[intDemention]++;
			}
		}

		System.out.printf("0의 갯수는 %d개, 1의 갯수는 %d개.\n", countZeroAndOne[0], countZeroAndOne[1]);
	}

	public void reverseRowCol() {
		/*
		- 3번 : 입력이 아래와 같을때 출력을 아래와 같이 만드세요
		입력 =>
		char[][] chInput = {
			{'*', '*', '*', '*', ' '},
			{'*', '*', ' ', ' ', ' '},
			{'*', ' ', '*', '*', '*'}
		};
		****
		**
		* ***
		처리 => 반복문 사용하세요
		출력 배열 =>
		char[][] chOutput = {
			{'*', '*', '*'},
			{'*', '*', ' '},
			{'*', ' ', '*'},
			{'*', ' ', '*'},
			{' ', ' ', '*'},
		};
		***
		**
		* *
		* *
		  *
		*/
		char[][] chInput = {
				{'*', '*', '*', '*', ' '},
				{'*', '*', ' ', ' ', ' '},
				{'*', ' ', '*', '*', '*'}
		};
		int chInputRow = chInput.length;
		int chInputCol = chInput[0].length;
		char[][] chOutput = new char[chInputCol][chInputRow];
		for(int col = 0; col < chInputCol; col++) {
			for(int row = 0; row < chInputRow; row++) {
				chOutput[col][row] = chInput[row][col];
			}
		}

		for(char[] row : chOutput) {
			for(char col : row) {
				System.out.print(col);
			}
			System.out.println();
		}
	}

	public void exercise1() {
		int[] intArray = new int[30];
		for(int i = 0; i < intArray.length; i++) {
			intArray[i] = i;
		}

		char[] charArray = new char[20];

		boolean[][] booleanArray = new boolean[3][4];
		for(int i = 0; i < booleanArray.length; i++) {
			for(int j = 0; j < booleanArray[i].length; j++) {
				booleanArray[i][j] = true;
			}
		}

		String[] stringArray = new String[50];
		for(int i = 0; i < stringArray.length; i++) {
			stringArray[i] = "empty";
		}
	}

	public void exercise2() {
		int[][] intDemention2 = {
				{1, 0, 1, 0, 0, 1}
				, {1, 0, 1, 1, 0, 1}
				, {0, 1, 0, 1, 0, 0}
				, {1, 0, 0, 1, 0, 1}
				, {1, 0, 1, 0, 0, 1}
		};
		int[] count = new int[2];
		for(int[] intDemention1 : intDemention2) {
			for(int intDemention : intDemention1) {
				count[intDemention]++;
			}
		}
		System.out.printf("0의 갯수는 %d개, 1의 갯수는 %d개.\n", count[0], count[1]);
	}

	public void exercise3() {
		char[][] chInput = {
				{'*', ' ', '*', '*', ' '},
				{'*', '*', ' ', ' ', ' '},
				{'*', ' ', '*', ' ', '*'},
				{' ', '*', '*', ' ', '*'},
				{'*', ' ', '*', ' ', '*'},
				{' ', ' ', '*', '*', '*'}
		};
		int chInputRow = chInput.length;
		int chInputCol = chInput[0].length;
		char[][] chOutput = new char[chInputCol][chInputRow];
		for(int col = 0; col < chInputCol; col++) {
			for(int row = 0; row < chInputRow; row++) {
				chOutput[col][row] = chInput[row][col];
			}
		}

		for(char[] row : chOutput) {
			for(char col : row) {
				System.out.print(col);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		System.out.println();

		Report0121 r = new Report0121();
		r.booleanArray();
		r.countZeroAndOne();
		r.reverseRowCol();

		System.out.println();

		r.exercise1();
		r.exercise2();
		r.exercise3();

		System.out.println();
	}
}
