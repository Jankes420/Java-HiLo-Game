import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Zgadywanka extends JFrame {
	private JButton btnPlayAgain;
	private JButton btnZgadnij;
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	public int numberOfTries = 1;
	public void checkGuess(){
		String guessText = txtGuess.getText();
		String message = "";
		try {
			int guess = Integer.parseInt(guessText);
			if (guess < theNumber) {
				message = guess + " Za ma³o. Spróbuj jeszcze raz";
				numberOfTries = numberOfTries + 1;
			}
			else if (guess > theNumber) {
				message = guess + " Za du¿o. Sprónuj jeszcze raz";
				numberOfTries = numberOfTries + 1;
			}
			else {
				message = guess + " Jest poprawne. Wygrywasz za "+ numberOfTries + ". razem! Zagrajmy jeszcze raz!";
				btnPlayAgain.setVisible(true);
				btnZgadnij.setVisible(false);
			}
		}catch(Exception e) {
			message = "Podaj liczbê naturaln¹ od 1 do 100.";
		}
		finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.setText("");
		}
	}
	public void newGame() {
		theNumber = (int)(Math.random()*100+1);
		numberOfTries = 1;
	}
	public Zgadywanka() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Moja zgadywanka");
		getContentPane().setLayout(null);

		JLabel lblIntro = new JLabel("Moja gra w zgadwanie");
		lblIntro.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIntro.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntro.setBounds(10, 38, 414, 20);
		getContentPane().add(lblIntro);

		JLabel lblZgadnij = new JLabel("Zgadnij liczbe od 1 do 100:");
		lblZgadnij.setHorizontalAlignment(SwingConstants.RIGHT);
		lblZgadnij.setBounds(23, 96, 234, 14);
		getContentPane().add(lblZgadnij);

		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setBounds(267, 93, 33, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);

		btnZgadnij = new JButton("Zgadnij!");
		btnZgadnij.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnZgadnij.setBounds(172, 148, 89, 23);
		getContentPane().add(btnZgadnij);

		lblOutput = new JLabel("Podaj liczbe i wcisnij guzik!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(10, 209, 414, 14);
		getContentPane().add(lblOutput);
		
		btnPlayAgain = new JButton("Nowa Gra");
		btnPlayAgain.setVisible(false);
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame();
				btnPlayAgain.setVisible(false);
				btnZgadnij.setVisible(true);
				lblOutput.setText("Zgadnij liczbe od 1 do 100:");
			}
		});
		btnPlayAgain.setBounds(172, 175, 89, 23);
		getContentPane().add(btnPlayAgain);
	}

	public static void main(String[] args) {
		Zgadywanka theGame = new Zgadywanka();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);
	}
}
