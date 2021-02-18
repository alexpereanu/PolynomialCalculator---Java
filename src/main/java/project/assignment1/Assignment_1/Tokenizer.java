package PT2019.assignment1.Assignment_1;
import java.util.StringTokenizer;

public class Tokenizer {

	private Polinom p = new Polinom();
	private String s;
	
	public Tokenizer(String s) {
		this.s = s;
	}

	public Polinom getP() {
		return p;
	}

	public void setP(Polinom p) {
		this.p = p;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
	
	public void tokenize() {
		StringTokenizer stringTokenizat = new StringTokenizer(s,"x^ ");
		while(stringTokenizat.hasMoreElements()) {
			double coeficient = Double.parseDouble(stringTokenizat.nextElement().toString());
			int grad = Integer.parseInt(stringTokenizat.nextElement().toString());
			
			Monom m = new Monom(coeficient,grad);
			p.addMonom(m);
		}
	}
}
