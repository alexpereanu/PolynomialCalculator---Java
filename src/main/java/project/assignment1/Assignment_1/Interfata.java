package PT2019.assignment1.Assignment_1;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Interfata extends JFrame implements ActionListener{

	private JPanel panel = new JPanel();

	private JLabel label1 = new JLabel("Primul polinom");
	private JLabel label2 = new JLabel("Al doilea polinom");
	private JLabel label3 = new JLabel("Rezultatul");
	private JLabel label4 = new JLabel("Derivarea primului polinom");
	private JLabel label5 = new JLabel("Integrarea celui de-al doilea polinom");

	private JButton button1 = new JButton("Adunare");
	private JButton button2 = new JButton("Scadere");
	private JButton button3 = new JButton("Inmultire");
	private JButton button4 = new JButton("Impartire");
	private JButton button5 = new JButton("Derivare");
	private JButton button6 = new JButton("Integrare");

	private JTextField text1 = new JTextField(50);
	private JTextField text2 = new JTextField(50);
	private JTextField text3 = new JTextField(50);
	private JTextField text4 = new JTextField(50);
	private JTextField text5 = new JTextField(50);


	public Interfata() {
		Dimension size = new Dimension(600, 320);
		this.setSize(size);
		getContentPane().add(panel);
		
		panel.add(button1);
		button1.addActionListener(new Adunare(text1,text2,text3));
		
		panel.add(button2);
		button2.addActionListener(new Scadere(text1,text2,text3));
		
		panel.add(button3);
		button3.addActionListener(new Inmultire(text1,text2,text3));
		
		panel.add(button4);
		button4.addActionListener(new Impartire(text1,text2,text3));
		
		panel.add(button5);
		button5.addActionListener(new Derivare(text1,text4));
		
		panel.add(button6);
		button6.addActionListener(new Integrare(text2,text5));
		
		panel.add(label1);
		panel.add(text1);
		
		panel.add(label2);
		panel.add(text2);
		
		panel.add(label3);
		panel.add(text3);
		
		panel.add(label4);
		panel.add(text4);
		
		panel.add(label5);
		panel.add(text5);
		
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}