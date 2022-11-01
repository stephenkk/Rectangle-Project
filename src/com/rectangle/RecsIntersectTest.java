package com.rectangle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecsIntersectTest {
	
	RecsIntersect recsProj = new RecsIntersect();

	@Test
	void testIsContained() {
		Diagonal upwardDiagOfRecA = new Diagonal(3,2,8,6); 
		Diagonal upwardDiagOfRecB = new Diagonal(4,3,7,5);
		assertTrue(recsProj.isContained(upwardDiagOfRecA, upwardDiagOfRecB));
		
		
	}
	
	@Test
	void testIsContainedFalse() {
		Diagonal upwardDiagOfRecA = new Diagonal(3,2,8,6); 
		Diagonal upwardDiagOfRecB = new Diagonal(4,3,9,5);
		assertFalse(recsProj.isContained(upwardDiagOfRecA, upwardDiagOfRecB));
	}
	
	
//	@Test
//	void testIsACorner() {
//		Diagonal upwardDiagOfRecA = new Diagonal(3,2,8,6);
//		Diagonal downwardDiagOfRecB = new Diagonal(5,3,9,8);
//		assertTrue(recsProj.isACorner(upwardDiagOfRecA, downwardDiagOfRecB, 5, 3));
//	}

}
