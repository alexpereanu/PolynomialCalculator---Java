package PT2019.assignment1.Assignment_1;

public class Monom implements Comparable {

	private double coeficient;
	private int grad;

	public Monom(double coeficient, int grad) {
		super();
		this.coeficient = coeficient;
		this.grad = grad;
	}

	public double getCoeficient() {
		return coeficient;
	}

	public void setCoeficient(double coeficient) {
		this.coeficient = coeficient;
	}

	public int getGrad() {
		return grad;
	}

	public void setGrad(int grad) {
		this.grad = grad;
	}
	
	public int compareTo(Object monom) {
		
		Monom m =(Monom)monom;
		if(this == m)
			return 0;
		if(this.grad < m.grad)
			return 1;
		if(this.grad == m.grad)
			return 0;
		else return -1;
	}
	
	public Monom impartireMonoame(Monom m1) {
		Monom result = new Monom(0,0);
		result.setCoeficient(this.coeficient/m1.coeficient);
		if(this.grad >= m1.getGrad())
			result.grad = this.grad - m1.grad;
		
		return result;
	}


}
