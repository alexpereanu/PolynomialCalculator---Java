package PT2019.assignment1.Assignment_1;

import junit.framework.TestCase;


public class TestJUnit extends TestCase {

	public Polinom p1;
	public Polinom p2;
	public Operatie o;
	
	/*public void setUp() {
		p1.addMonom(new Monom(4,4));
		p2.addMonom(new Monom(2,4));
		System.out.println(p1.toString());
	}*/
	
	public void setUp() {
		
	}
	
	public void tearDown() {
		
	}
	
	public TestJUnit() {
		Polinom polinom1 = new Polinom();
		polinom1.addMonom(new Monom(4,4));
		this.p1 = polinom1;
		
		Polinom polinom2 = new Polinom();
		polinom2.addMonom(new Monom(2,4));
		this.p2 = polinom2;
	}
	
	public void testAdd() {
		Polinom adunare = new Polinom();
		Operatie o = new Operatie();
		adunare = o.adunarePolinoame(this.p1, this.p2);
		//assertEquals(result,adunare);
		assertTrue(adunare.toString().equals("6.0*X^4"));
		
	}
}
