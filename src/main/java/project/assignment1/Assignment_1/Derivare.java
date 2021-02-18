package PT2019.assignment1.Assignment_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class Derivare implements ActionListener {

	private JTextField text1;
	private JTextField text2;

	public Derivare(JTextField text1, JTextField text2) {
		this.text1 = text1;
		this.text2 = text2;

	}

	public void actionPerformed(ActionEvent e) {
		String polinomul1;
		polinomul1 = text1.getText();

		Tokenizer p1 = new Tokenizer(polinomul1);
		p1.tokenize();
		Polinom rezultat = new Polinom();
		Operatie o = new Operatie();

		rezultat = o.derivarePolinom(p1.getP());
		text2.setText(rezultat.toString());

	}
}
