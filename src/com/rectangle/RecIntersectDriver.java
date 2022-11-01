package com.rectangle;

import java.util.Scanner;

public class RecIntersectDriver {
	public static void main(String[] args) {

		int x1,y1,x2,y2;
		Scanner scanner = new Scanner(System.in);
		//Take input for rectangle A upper diagonal coordinates
		System.out.println("Please enter rectangleA upper diagonal cordinates in format : x1,y1,x2,y2");
		System.out.println("Also to enter valid rectangle diagonals. Please take care of condition x2>x1 && y2>y1");
		String input = scanner.nextLine();
		String[] arr = input.split(",");
		do {
			if (arr.length == 4) {
				try {
					x1 = Integer.parseInt(arr[0]);
					y1 = Integer.parseInt(arr[1]);
					x2 = Integer.parseInt(arr[2]);
					y2 = Integer.parseInt(arr[3]);
					if (x2 > x1 && y2 > y1)
						break;
					else
						System.out.println("Coordinates condition not satisfied. Please try again");
				} catch (Exception e) {
					System.out.println("Please enter only numbers. Please try again");
				}
			} else
				System.out.println("Wrong format entered. Please try again");

			input = scanner.nextLine();
			arr = input.split(",");

		}while(true);
		Diagonal UpwardDiagOfRectangleA = new Diagonal(x1,y1,x2,y2);
		
		//Take input for rectangle B upper diagonal coordinates
		System.out.println("Please enter rectangleB upper diagonal cordinates in format : x1,y1,x2,y2");
		System.out.println("Also to enter valid rectangle diagonals. Please take care of condition x2>x1 && y2>y1");
		input = scanner.nextLine();
		arr = input.split(",");
		do {
			if (arr.length == 4) {
				try {
					x1 = Integer.parseInt(arr[0]);
					y1 = Integer.parseInt(arr[1]);
					x2 = Integer.parseInt(arr[2]);
					y2 = Integer.parseInt(arr[3]);
					if (x2 > x1 && y2 > y1)
						break;
					else
						System.out.println("Coordinates condition not satisfied. Please try again");
				} catch (Exception e) {
					System.out.println("Please enter only numbers. Please try again");
				}
			} else
				System.out.println("Wrong format entered. Please try again");

			input = scanner.nextLine();
			arr = input.split(",");

		}while(true);
		
		
		Diagonal UpwardDiagOfRectangleB = new Diagonal(x1,y1,x2,y2);

		RecsIntersect intersectFinder = new RecsIntersect();
		intersectFinder.findIntersectPoints(UpwardDiagOfRectangleA, UpwardDiagOfRectangleB);
		
		//TEST CASES:
		// Rectangle B on left side
		// proper adjacent
		// 6,2,8,6
		// adjacent(sub-line)
		// 8,3,10,5
		// adjacent(partial)
		// 6,3,8,8
		// not adjacent
		// 7,3,10,5

		// Containment cases:
		// 2,1,9,7
		// 4,3,7,5

		// Intersection cases:
		// 4,3,9,5 faces right
		// 4,3,7,8 faces up
		// 1,3,5,5 faces left
		// 5,1,7,5 faces down
		// 5,3,9,8 NE edge
		// 2,4,5,8 NW edge
		// 2,1,5,4 SW edge
		// 4,1,9,5 SE edge
		// 4,1,7,7 protrudes above and below
		// 2,3,9,5 protrudes left and right
		// 2,1,9,5 hangover l,r,b
		// 2,5,9,7 hangover l,t,r
		// 1,1,5,7 hangover t,l,b
		// No Intersection cases:

		// -4,1,2,4 out to the left
		// -5,2,1,5 under
		// 9,2,10,6 out to the right
		// 5,8,9,9 above
	}

	
	
}
//public static void main(String[] args) {
//
//	Diagonal UpwardDiagOfRectangleA = new Diagonal (5,1,8,5);
//	Diagonal UpwardDiagOfRectangleB = new Diagonal (2,2,5,4);
//	
//	RecsIntersect intersectFinder = new RecsIntersect();
//	
//	intersectFinder.findIntersectPoints(UpwardDiagOfRectangleA, UpwardDiagOfRectangleB);
//
//
//	
////Containment cases:
////2,1,9,7
////4,3,7,5	
//	
////Intersection cases:
////4,3,9,5 faces right
////4,3,7,8 faces up
////1,3,5,5 faces left
////5,1,7,5 faces down	
////5,3,9,8 NE edge	
////2,4,5,8 NW edge
////2,1,5,4 SW edge
////4,1,9,5 SE edge
////4,1,7,7 protrudes above and below	
////2,3,9,5 protrudes left and right
////2,1,9,5 hangover l,r,b
////2,5,9,7 hangover l,t,r
////1,1,5,7 hangover t,l,b
////No Intersection cases:
//	
////-4,1,2,4 out to the left
////-5,2,1,5 under
////9,2,10,6 out to the right
////5,8,9,9 above
//	
//	//proper adjacent
//	//6,2,8,6
//		
//	//adjacent(sub-line)
//	//6,3,8,5
//	
//	//adjacent(partial)
//	//6,3,8,8	
//	
//	//not adjacent
//	//7,3,10,5
//}
