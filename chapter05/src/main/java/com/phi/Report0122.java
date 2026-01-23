package com.phi;

public class Report0122 {
	public String[] monthString() {
		//1-1. String 12개를 보관하는 1차원 배열을 선언하고 각 원소를 달(12개월)을 나타내는 단어를 저장하세요.
		String[] monthString = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
		return monthString;
	}
	public String[] dayOfWeekString() {
		//1-2. String 7개를 보관하는 1차원 배열을 선언하고 각 원소를 요일을 나타내는 단어를 저장하세요.
		String[] dayOfWeekString = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
		return dayOfWeekString;
	}
	public void printString(String[] strArray) {
		//1-3. 1-1, 1-2 2개의 배열을 모두 출력 하세요 for(;;)문장, for(:) 문장 사용 2번씩 출력
		System.out.println("\nfor(;;)");
		for(int i = 0; i < strArray.length; i++) {
			System.out.println(i + ": " + strArray[i]);
		}
		System.out.println("\nfor(:)");
		for(String str : strArray) {
			System.out.println(str);
		}
	}

	public void randomShort() {
		System.out.println("\n\nRandomShort");
		short[][] randomShort = new short[(int)(Math.random() * 7) + 3][];
		for(int row = 0; row < randomShort.length; row++) {
			randomShort[row] = new short[(int)(Math.random() * 7) + 3];
			for(int col = 0; col < randomShort[row].length; col++) {
				randomShort[row][col] = (short)((Math.random() * 7) + 3);
				System.out.print((col == 0 ? "" : ", ") + randomShort[row][col]);
			}
			System.out.println();
		}
	}

	public void hexahedronArray() {
		System.out.println("\n\nHexahedronArray");

		int[][][] hexahedronArray = new int[4][5][7];
		hexahedronArray[0][0][0] = (int)(Math.random() * 201) - 100;
		int[] min = new int[3];
		int[] max = new int[3];
		int[] count = new int[201];
		for(int side = 0; side < hexahedronArray.length; side++) {
			for(int row = 0; row < hexahedronArray[side].length; row++) {
				for(int col = 0; col < hexahedronArray[side][row].length; col++) {
					if(side + row + col == 0) {
						System.out.print(hexahedronArray[side][row][col]);
						continue;
					}
					hexahedronArray[side][row][col] = (int)(Math.random() * 201) - 100;
					if(hexahedronArray[min[0]][min[1]][min[2]] > hexahedronArray[side][row][col]) {
						min[0] = side;
						min[1] = row;
						min[2] = col;
					}
					if(hexahedronArray[max[0]][max[1]][max[2]] < hexahedronArray[side][row][col]) {
						max[0] = side;
						max[1] = row;
						max[2] = col;
					}
					if(hexahedronArray[side][row][col] < 0) {
						int index = hexahedronArray[side][row][col] * -1 + 100;
						count[index]++;
					} else {
						count[hexahedronArray[side][row][col]]++;
					}
					System.out.print((col == 0 ? "" : ", ") + hexahedronArray[side][row][col]);
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.printf("max: hexahedronArray[%d][%d][%d] = %d\n", max[0], max[1], max[2], hexahedronArray[max[0]][max[1]][max[2]]);
		System.out.printf("min: hexahedronArray[%d][%d][%d] = %d\n", min[0], min[1], min[2], hexahedronArray[min[0]][min[1]][min[2]]);
		int line = 0;
		for(int i = 0; i < count.length; i++) {
			/*
			if(i % 10 == 0) {
				System.out.println();
			}
			System.out.print(i % 10 == 0 ? "" : " \t");
			if(i < 101) {
				System.out.printf("%-3d: %-3d", i, count[i]);
			} else {
				System.out.printf("%-3d: %-3d", ((i - 100) * -1), count[i]);
			}
			*/
			if(count[i] != 0) {
				if(line % 10 == 0) {
					System.out.println();
					line = 0;
				} else {
					System.out.print(" \t");
				}
				line++;
				if(i < 101) {
					System.out.printf("%-3d: %-3d", i, count[i]);
				} else {
					System.out.printf("%-3d: %-3d", ((i - 100) * -1), count[i]);
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Report0122 report = new Report0122();
		report.printString(report.monthString());
		report.printString(report.dayOfWeekString());
		report.randomShort();
		report.hexahedronArray();
	}
}
