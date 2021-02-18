package PT2019.assignment1.Assignment_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class Scadere implements ActionListener{

	private JTextField text1;
	private JTextField text2;
	private JTextField text3;

	public Scadere(JTextField text1, JTextField text2, JTextField text3) {
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
	}

	public void actionPerformed(ActionEvent e) {
		String polinomul1;
		String polinomul2;
		polinomul1 = text1.getText();
		polinomul2 = text2.getText();

		Tokenizer p1 = new Tokenizer(polinomul1);
		Tokenizer p2 = new Tokenizer(polinomul2);

		p1.tokenize();
		p2.tokenize();

		Polinom rezultat = new Polinom();
		Operatie o = new Operatie();

		rezultat = o.scaderePolinoame(p1.getP(), p2.getP());

		text3.setText(rezultat.toString());

	}

}
