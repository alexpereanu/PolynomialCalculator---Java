package PT2019.assignment1.Assignment_1;

import java.util.Collections;

public class Operatie {

	public Operatie() {

	}

	public Polinom adunarePolinoame(Polinom p1, Polinom p2) {

		Polinom result = new Polinom();

		int i = 0;
		while (i < p1.getLungimePolinom()) {
			int added = 0;
			for (int j = 0; j < p2.getLungimePolinom(); j++) {
				if (p1.getPolinom().get(i).getGrad() == p2.getPolinom().get(j).getGrad()) {
					result.addMonom(
							new Monom(p1.getPolinom().get(i).getCoeficient() + p2.getPolinom().get(j).getCoeficient(),
									p1.getPolinom().get(i).getGrad()));
					added++;
					break;
				}
			}
			if (added == 0) {
				result.addMonom(p1.getMonom(i));
			}
			i++;
		}

		int j = 0;
		while (j < p2.getLungimePolinom()) {
			int x = 0;
			for (int k = 0; k < result.getLungimePolinom(); k++) {
				if (p2.getPolinom().get(j).getGrad() == result.getPolinom().get(k).getGrad()) {
					x++;
				}
			}
			if (x == 0) {
				result.addMonom(p2.getPolinom().get(j));
			}
			j++;
		}
		Collections.sort(result.getPolinom());
		return result;

	}

	// scaderea este operatia inversa adunarii
	// daca negam al doilea polinom si-l adunam cu primul obtinem de altfel p1-p2
	public Polinom scaderePolinoame(Polinom p1, Polinom p2) {

		Polinom result = new Polinom();
		p2.negarePolinom(p2);
		result = adunarePolinoame(p1, p2);
		Collections.sort(result.getPolinom());
		return result;
	}

	public Polinom derivarePolinom(Polinom p1) {
		Polinom rezultat = new Polinom();
		int gradPolinom = 0;
		int g2 = p1.getLungimePolinom() - 1;
		while (gradPolinom <= g2) {
			if (p1.getPolinom().get(gradPolinom).getGrad() == 0)
				rezultat.addMonom(new Monom(0, 0));
			else
				rezultat.addMonom(new Monom(
						p1.getPolinom().get(gradPolinom).getCoeficient() * p1.getPolinom().get(gradPolinom).getGrad(),
						(p1.getPolinom().get(gradPolinom).getGrad() - 1)));
			gradPolinom++;
		}
		rezultat.setGrad(g2);
		Collections.sort(rezultat.getPolinom());
		return rezultat;
	}

	public Polinom integrarePolinom(Polinom p1) {

		Polinom rezultat = new Polinom();
		int gradPolinom = 0;
		int g2 = p1.getLungimePolinom() - 1;
		while (gradPolinom <= g2) {
			if (p1.getPolinom().get(gradPolinom).getGrad() > -1) {
				rezultat.addMonom(new Monom(
						(p1.getPolinom().get(gradPolinom).getCoeficient()
								/ (p1.getPolinom().get(gradPolinom).getGrad() + 1)),
						p1.getPolinom().get(gradPolinom).getGrad() + 1));
			}
			gradPolinom++;
		}
		rezultat.setGrad(g2);
		Collections.sort(rezultat.getPolinom());
		return rezultat;
	}

	public Polinom inmultirePolinoame(Polinom p1, Polinom p2) {
		Polinom result = new Polinom();
		for (int i = 0; i < p1.getLungimePolinom(); i++) {
			for (int j = 0; j < p2.getLungimePolinom(); j++) {
				result.addMonom(
						new Monom(p1.getPolinom().get(i).getCoeficient() * p2.getPolinom().get(j).getCoeficient(),
								p1.getPolinom().get(i).getGrad() + p2.getPolinom().get(j).getGrad()));
			}
		}
		Collections.sort(result.getPolinom());
		
		return result;
	}

	public Polinom impartirePolinoame(Polinom deimpartitul, Polinom impartitorul) {
		Polinom catul = new Polinom();
		Polinom restul = new Polinom();
		Collections.sort(deimpartitul.getPolinom());
		Collections.sort(impartitorul.getPolinom());
		int lungimeDeImpartit = 0;
		int lungimeImpartitor = 0;
		Operatie o = new Operatie();
		int times = deimpartitul.getGrad() - impartitorul.getGrad();

		for (int i = 0; i < times; i++) {
			Monom deimp = new Monom(0, 0);
			deimp = deimpartitul.getPolinom().get(lungimeDeImpartit);
			Monom imp = new Monom(0, 0);
			imp = impartitorul.getPolinom().get(0);
			Monom result = new Monom(0, 0);
			result = deimp.impartireMonoame(imp);
			Polinom conversie = new Polinom();
			conversie.addMonom(result);
			catul.addMonom(result);

			Polinom adunareCuMinus = new Polinom();
			adunareCuMinus = o.inmultirePolinoame(impartitorul, conversie);
			deimpartitul = o.scaderePolinoame(deimpartitul, adunareCuMinus);

			restul = deimpartitul;

			if (deimpartitul.getPolinom().get(lungimeDeImpartit).getCoeficient() == 0) {
				lungimeDeImpartit++;
			}
			// lungimeImpartitor --;

		}

		return catul;

	}

}
