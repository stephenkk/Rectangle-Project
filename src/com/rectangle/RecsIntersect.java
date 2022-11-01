package com.rectangle;

public class RecsIntersect {
	//isContained method compares coords of the two entered diags to determine
	//if the one of the two rectangles is contained within the other
	boolean isContained(Diagonal upwardDiagOfRecA, Diagonal upwardDiagOfRecB) {
		if (upwardDiagOfRecA.x1 < upwardDiagOfRecB.x1 && upwardDiagOfRecA.x2 > upwardDiagOfRecB.x2
				&& upwardDiagOfRecA.y1 < upwardDiagOfRecB.y1 && upwardDiagOfRecA.y2 > upwardDiagOfRecB.y2) {
			System.out.println("Rectangle B is contained within Rectangle A");
			return true;
		} else if (upwardDiagOfRecA.x1 > upwardDiagOfRecB.x1 && upwardDiagOfRecA.x2 < upwardDiagOfRecB.x2
				&& upwardDiagOfRecA.y1 > upwardDiagOfRecB.y1 && upwardDiagOfRecA.y2 < upwardDiagOfRecB.y2) {
			System.out.println("Rectangle A is contained within Rectangle B");
			return true;
		} else
			return false;
	}
	//doIntersect evaluates the coords of the two entered diags to determine
	//if the rectangles intersect at all
	boolean doIntersect(Diagonal upwardDiagOfRecA, Diagonal upwardDiagOfRecB) {
		if (upwardDiagOfRecA.x1 > upwardDiagOfRecB.x2 || upwardDiagOfRecA.x2 < upwardDiagOfRecB.x1
				|| upwardDiagOfRecA.y1 > upwardDiagOfRecB.y2 || upwardDiagOfRecA.y2 < upwardDiagOfRecB.y1)
			return false;
		else
			return true;
	}
	//If two rectangles intersect they will create a new smaller rectangle
	//findUpwardNewDiagonal discovers the upward sloping diag of the new rectangle
	Diagonal findUpwardNewDiagonal(Diagonal UpwardDiagOfRecA, Diagonal UpwardDiagOfRecB) {

		int x5 = Math.max(UpwardDiagOfRecA.x1, UpwardDiagOfRecB.x1);
		int y5 = Math.max(UpwardDiagOfRecA.y1, UpwardDiagOfRecB.y1);// (x5, y5) are bottom left of new rec
		int x6 = Math.min(UpwardDiagOfRecA.x2, UpwardDiagOfRecB.x2);
		int y6 = Math.min(UpwardDiagOfRecA.y2, UpwardDiagOfRecB.y2);// (x6, y6) is top right of new rec

		Diagonal upwardNewRecDiag = new Diagonal(x5, y5, x6, y6);
		System.out.println("First new diag is: (" + upwardNewRecDiag.x1 + "," + upwardNewRecDiag.y1 + ")" + " " + "("
				+ upwardNewRecDiag.x2 + "," + upwardNewRecDiag.y2 + ")");

		return upwardNewRecDiag;

	}
	//Finds adjacencies or intersection points if they exist and prints to console
	void findIntersectPoints(Diagonal upwardDiagOfRecA, Diagonal upwardDiagOfRecB) {
		//first check for containment and non-intersection
		if (isContained(upwardDiagOfRecA, upwardDiagOfRecB))
			return;
		if (!doIntersect(upwardDiagOfRecA, upwardDiagOfRecB)) {
			System.out.println("The rectangles do not intersect");
			System.out.println("The rectangles hase no containment");
			System.out.println("The rectangles are not adjacent");
			
			return;
		}
		//get new upwardsloping diagonal of rectangle created by intersection
		Diagonal upwardNewRecDiag = findUpwardNewDiagonal(upwardDiagOfRecA, upwardDiagOfRecB);
		//get downward sloping diag of rectangle A
		Diagonal downwardDiagOfRecA = new Diagonal(upwardDiagOfRecA.x1, upwardDiagOfRecA.y2, upwardDiagOfRecA.x2,
				upwardDiagOfRecA.y1);
		//get new downward sloping diagonal of rectangle created by intersection
		Diagonal downwardNewRecDiag = new Diagonal(upwardNewRecDiag.x1, upwardNewRecDiag.y2, upwardNewRecDiag.x2,
				upwardNewRecDiag.y1);
		//print the coords of the newly formed rectangle's diags to console
		System.out.println("Second new diag is: (" + downwardNewRecDiag.x1 + "," +
		 downwardNewRecDiag.y1 + ")" + " " +"(" + downwardNewRecDiag.x2 + "," +
		 downwardNewRecDiag.y2 + ")");
		
		//Check for adjacency on four sides of rectangle A
		
		//Where rectangle B is on right side of rectangle A
		if (upwardDiagOfRecA.x2 == upwardDiagOfRecB.x1) {
			if (upwardDiagOfRecA.y2 == upwardDiagOfRecB.y2) {
				System.out.println("Rectangle A is proper adjacent to rectangle B");
				return;
			} else if (upwardDiagOfRecA.y2 > upwardDiagOfRecB.y2) {
				System.out.println("Rectangle A is adjacent(sub-line) to rectangle B");
				return;
			} else if (upwardDiagOfRecA.y2 < upwardDiagOfRecB.y2) {
				System.out.println("Rectangle A is adjacent(partial) to rectangle B");
				return;
			}
		}
		
		//Where rectangle B is on top of rectangle A
		if (upwardDiagOfRecA.y2 == upwardDiagOfRecB.y1) {
			if (downwardDiagOfRecA.x1 == upwardDiagOfRecB.x1) {
				System.out.println("Rectangle A is proper adjacent to rectangle B");
				return;
			} else if (downwardDiagOfRecA.x1 < upwardDiagOfRecB.x1) {
				System.out.println("Rectangle is A adjacent(sub-line) to rectangle B");
				return;
			} else if (downwardDiagOfRecA.x1 > upwardDiagOfRecB.x1) {
				System.out.println("Rectangle A is adjacent(partial) to rectangle B");
				return;
			}
		}
		
		// Where rectangle B is on left side of rectangle A
		if (upwardDiagOfRecA.x1 == upwardDiagOfRecB.x2) {
			if (upwardDiagOfRecA.y1 == upwardDiagOfRecB.y1) {
				System.out.println("Rectangle B is proper adjacent to rectangle A");
				return;
			} else if (upwardDiagOfRecA.y1 < upwardDiagOfRecB.y1) {
				System.out.println("Rectangle B is adjacent(sub-line) to rectangle A");
				return;
			} else if (upwardDiagOfRecA.y1 > upwardDiagOfRecB.y1) {
				System.out.println("Rectangle B is adjacent(partial) to rectangle A");
				return;
			}
		}
		
		// Where rectangle B is on bottom of rectangle A
		if (upwardDiagOfRecA.y1 == upwardDiagOfRecB.y2) {
			if (downwardDiagOfRecA.x2 == upwardDiagOfRecB.x2) {
				System.out.println("The rectangle B is  proper adjacent to rectangle A");
				return;
			} else if (downwardDiagOfRecA.x2 > upwardDiagOfRecB.x2) {
				System.out.println("The rectangle B adjacent(sub-line) to rectangle A");
				return;
			} else if (downwardDiagOfRecA.x2 < upwardDiagOfRecB.x2) {
				System.out.println("The rectangle B adjacent(partial) to rectangle A");
				return;
			}
		}
		//If there is intersection that is not an adjacency, then there must be
		//either two or four points of intersection which are end points of the new 
		//diagonals. A separate for loop inspects each end point.
		//There are four "edge" cases in which a corner of rectangle A could be
		//incorrectly identified as a point of intersection. !isACorner eliminates
		// those possibilities and then the points of intersection are discovered by 
		//remainder of the for loop.
		if (!isACorner(upwardDiagOfRecA, downwardDiagOfRecA, upwardNewRecDiag.x1, upwardNewRecDiag.y1)
				& (upwardNewRecDiag.x1 == upwardDiagOfRecA.x1 || upwardNewRecDiag.x1 == upwardDiagOfRecA.x2
						|| upwardNewRecDiag.y1 == upwardDiagOfRecA.y1 || upwardNewRecDiag.y1 == upwardDiagOfRecA.y2))
			System.out.println("Intersection points are :(" +  upwardNewRecDiag.x1 + "," + upwardNewRecDiag.y1 +")");

		if (!isACorner(upwardDiagOfRecA, downwardDiagOfRecA, upwardNewRecDiag.x2, upwardNewRecDiag.y2)
				& (upwardNewRecDiag.x2 == upwardDiagOfRecA.x1 || upwardNewRecDiag.x2 == upwardDiagOfRecA.x2
						|| upwardNewRecDiag.y2 == upwardDiagOfRecA.y1 || upwardNewRecDiag.y2 == upwardDiagOfRecA.y2))
			System.out.println("Intersection points are :(" +upwardNewRecDiag.x2 + "," + upwardNewRecDiag.y2+")");

		if (!isACorner(upwardDiagOfRecA, downwardDiagOfRecA, downwardNewRecDiag.x1, downwardNewRecDiag.y1)
				& (downwardNewRecDiag.x1 == upwardDiagOfRecA.x1 || downwardNewRecDiag.x1 == upwardDiagOfRecA.x2
						|| downwardNewRecDiag.y1 == upwardDiagOfRecA.y1
						|| downwardNewRecDiag.y1 == upwardDiagOfRecA.y2))
			System.out.println("Intersection points are :(" + downwardNewRecDiag.x1 + "," + downwardNewRecDiag.y1+")");

		if (!isACorner(upwardDiagOfRecA, downwardDiagOfRecA, downwardNewRecDiag.x2, downwardNewRecDiag.y2)
				& (downwardNewRecDiag.x2 == upwardDiagOfRecA.x1 || downwardNewRecDiag.x2 == upwardDiagOfRecA.x2
						|| downwardNewRecDiag.y2 == upwardDiagOfRecA.y1
						|| downwardNewRecDiag.y2 == upwardDiagOfRecA.y2))
			System.out.println("Intersection points are :(" +downwardNewRecDiag.x2 + "," + downwardNewRecDiag.y2+")");
	}

	boolean isACorner(Diagonal upwardDiagOfRecA, Diagonal downwardDiagOfRecA, int x, int y) {

		if (x == upwardDiagOfRecA.x1 && y == upwardDiagOfRecA.y1 || x == upwardDiagOfRecA.x2 && y == upwardDiagOfRecA.y2
				|| x == downwardDiagOfRecA.x1 && y == downwardDiagOfRecA.y1
				|| x == downwardDiagOfRecA.x2 && y == downwardDiagOfRecA.y2)
			return true;
		else
			return false;
	}
	

}

