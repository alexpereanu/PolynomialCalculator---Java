package PT2019.assignment1.Assignment_1;

import java.util.*;

public class Polinom {

	private int grad;
	private ArrayList<Monom> polinom;
	private int lungimePolinom = 0;

	public Polinom() {
		super();
		this.grad = -1;
		polinom = new ArrayList<Monom>();
	}

	public int getGrad() {
		return grad;
	}

	public void setGrad(int grad) {
		this.grad = grad;
	}

	public ArrayList<Monom> getPolinom() {
		return this.polinom;
	}

	public void setPolinom(ArrayList<Monom> polinom) {
		this.polinom = polinom;
	}

	// returnam un monom aflat la indexul i
	public Monom getMonom(int i) {
		return polinom.get(i);
	}

	public void addMonom(Monom m) {
		if (m.getGrad() > this.getGrad())
			this.setGrad(m.getGrad());
		polinom.add(m);
		this.lungimePolinom++;
	}

	public Polinom negarePolinom(Polinom p) {
		Polinom result = new Polinom();
		int i = 0;
		while (i < p.lungimePolinom) {
			int inc = 0;
			if (p.getPolinom().get(i).getCoeficient() > 0) {
				p.getPolinom().get(i).setCoeficient(-p.getPolinom().get(i).getCoeficient());
				inc++;
			}
			if (p.getPolinom().get(i).getCoeficient() < 0 && inc == 0)
				p.getPolinom().get(i).setCoeficient(Math.abs(p.getPolinom().get(i).getCoeficient()));
			i++;
		}
		result = p;
		return result;

	}

	public int getLungimePolinom() {
		return lungimePolinom;
	}

	public void setLungimePolinom(int lungimePolinom) {
		this.lungimePolinom = lungimePolinom;
	}


	// Suprascriem metoda de afisare pentru polinom
	public String toString() {

		String s = "";
		int len = 0;
		if ((polinom.get(len).getCoeficient() == 1.0) && (polinom.get(len).getGrad() == 1))
			s += "X";
		if ((polinom.get(len).getCoeficient() == 1.0) && (polinom.get(len).getGrad() > 1))
			s += "X^";
		if ((polinom.get(len).getCoeficient() == -1.0) && (polinom.get(len).getGrad() == 1))
			s += "-X";
		if ((polinom.get(len).getCoeficient() == -1.0) && (polinom.get(len).getGrad() > 1))
			s += "-X^" + polinom.get(len).getGrad();
		if ((polinom.get(len).getCoeficient() == -1.0) && (polinom.get(len).getGrad() > 1))
			s += "-X^";
		if ((polinom.get(len).getCoeficient() != 0) && (polinom.get(len).getGrad() > 1))
			s += polinom.get(len).getCoeficient() + "*X^" + polinom.get(len).getGrad();
		if ((polinom.get(len).getCoeficient() != 0) && (polinom.get(len).getGrad() == 0))
			s += polinom.get(len).getCoeficient();

		for (int i = 1; i < polinom.size(); i++) {
			int ss = 0;
			if (polinom.get(i).getCoeficient() > 0)
				s += " + ";
			if ((polinom.get(i).getCoeficient() == 1.0) && (polinom.get(i).getGrad() == 1))
				s += "X";
			if ((polinom.get(i).getCoeficient() == 1.0) && (polinom.get(i).getGrad() > 1))
				s += "X^";
			if ((polinom.get(i).getCoeficient() == -1.0) && (polinom.get(i).getGrad() == 1))
				s += " -X ";
			if ((polinom.get(i).getCoeficient() == -1.0) && (polinom.get(i).getGrad() > 1))
				s += "-X^";
			if ((polinom.get(i).getCoeficient() != 0) && (polinom.get(i).getGrad() > 1))
				s += polinom.get(i).getCoeficient() + "*X^" + polinom.get(i).getGrad();
			if ((polinom.get(i).getCoeficient() == -1.0) && (polinom.get(i).getGrad() > 1))
				s += "-X^" + polinom.get(i).getGrad();
			if ((polinom.get(i).getCoeficient() != 0) && (polinom.get(i).getGrad() == 1))
				s += " " + polinom.get(i).getCoeficient() + "X";
			if ((polinom.get(i).getCoeficient() != 0) && (polinom.get(i).getGrad() == 0)) {
				s += polinom.get(i).getCoeficient();
				ss++;
			}
			if ((polinom.get(i).getCoeficient() < 0) && (polinom.get(i).getGrad() > 0) && (ss != 0))
				s += " -X^" + polinom.get(i).getGrad();
		}

		System.out.println(s);
		return s;

	}

}
