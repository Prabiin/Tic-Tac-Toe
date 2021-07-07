import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

class TicTacToe implements ActionListener {

	JFrame frame = new JFrame();
	JLabel title_field = new JLabel();
	JLabel player_update = new JLabel();
	JPanel title_panel = new JPanel();
	JPanel board_panel = new JPanel();
	JButton[] button = new JButton[9];
	boolean player1_turn;
	Random random = new Random();
	
	TicTacToe() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.getContentPane().setBackground(new Color(150, 150, 150));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		title_field.setBackground(Color.BLACK);
		title_field.setForeground(new Color(25, 255, 0));
		title_field.setFont(new Font("Ink Free", Font.BOLD, 70));
		title_field.setHorizontalAlignment(JLabel.CENTER);
		title_field.setText("tic-tac-toe");
		title_field.setOpaque(true);
		
		player_update.setBackground(Color.BLACK);
		player_update.setForeground(new Color(25, 255, 0));
		player_update.setFont(new Font("Ink Free", Font.BOLD, 20));
		player_update.setHorizontalAlignment(JLabel.CENTER);
		player_update.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0, 0, 600, 10);
		
		board_panel.setLayout(new GridLayout(3, 3));
		board_panel.setBackground(new Color(25, 25, 25));
		
		for(int i = 0; i < 9; i++) {
			button[i] = new JButton();
			board_panel.add(button[i]);
			button[i].setFont(new Font("MV Boli", Font.BOLD, 100));
			button[i].setFocusable(false);
			button[i].addActionListener(this);
		}
		
		title_panel.add(title_field);
		title_panel.add(player_update, BorderLayout.SOUTH);
		frame.add(title_panel, BorderLayout.NORTH);
		frame.add(board_panel);
		
		if(random.nextInt(2) == 0) {
			player1_turn = true;
			player_update.setText("Player O's turn");
		} else {
			player1_turn = false;
			player_update.setText("Player X's turn");
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 9; i++) {
			if(e.getSource() == button[i]) {
				if(player1_turn) {
					if(button[i].getText() == "") {
						button[i].setText("O");
						button[i].setForeground(new Color(0, 0, 255));
						player_update.setText("Player X's turn");
						player1_turn = false;
						check();
					} 
				} else {
					if(button[i].getText() == "") {
						button[i].setText("X");
						button[i].setForeground(new Color(255, 0, 0));
						player_update.setText("Player O's turn");
						player1_turn = true;
						check();
					} 
				}
			}
		}
	}
	
	public void check() {
		if(button[0].getText() == "O" && button[1].getText() == "O" && button[2].getText() == "O") {
			xWin(0, 1, 2);
		}
		if(button[3].getText() == "O" && button[4].getText() == "O" && button[5].getText() == "O") {
			xWin(3, 4, 5);
		}
		if(button[6].getText() == "O" && button[7].getText() == "O" && button[8].getText() == "O") {
			xWin(6, 7, 8);
		}
		if(button[0].getText() == "O" && button[3].getText() == "O" && button[6].getText() == "O") {
			xWin(0, 3, 6);
		}
		if(button[1].getText() == "O" && button[4].getText() == "O" && button[7].getText() == "O") {
			xWin(1, 4, 7);
		}
		if(button[2].getText() == "O" && button[5].getText() == "O" && button[8].getText() == "O") {
			xWin(2, 5, 8);
		}
		if(button[0].getText() == "O" && button[4].getText() == "O" && button[8].getText() == "O") {
			xWin(0, 4, 8);
		}
		if(button[2].getText() == "O" && button[4].getText() == "O" && button[6].getText() == "O") {
			xWin(2, 4, 6);
		}
		
		
		if(button[0].getText() == "X" && button[1].getText() == "X" && button[2].getText() == "X") {
			oWin(0, 1, 2);
		}
		if(button[3].getText() == "X" && button[4].getText() == "X" && button[5].getText() == "X") {
			oWin(3, 4, 5);
		}
		if(button[6].getText() == "X" && button[7].getText() == "X" && button[8].getText() == "X") {
			oWin(6, 7, 8);
		}
		if(button[0].getText() == "X" && button[3].getText() == "X" && button[6].getText() == "X") {
			oWin(0, 3, 6);
		}
		if(button[1].getText() == "X" && button[4].getText() == "X" && button[7].getText() == "X") {
			oWin(1, 4, 7);
		}
		if(button[2].getText() == "X" && button[5].getText() == "X" && button[8].getText() == "X") {
			oWin(2, 5, 8);
		}
		if(button[0].getText() == "X" && button[4].getText() == "X" && button[8].getText() == "X") {
			oWin(0, 4, 8);
		}
		if(button[2].getText() == "X" && button[4].getText() == "X" && button[6].getText() == "X") {
			oWin(2, 4, 6);
		}
	}
	
	public void xWin(int a, int b, int c) {
		player_update.setForeground(Color.WHITE);
		player_update.setText("Player O Wins");
		button[a].setBackground(Color.GREEN);
		button[b].setBackground(Color.GREEN);
		button[c].setBackground(Color.GREEN);
		for(int i=0; i< 9; i++) {
			button[i].setEnabled(false);
		}
	}
	
	public void oWin(int a, int b, int c) {
		player_update.setForeground(Color.WHITE);
		player_update.setText("Player X Wins");
		button[a].setBackground(Color.GREEN);
		button[b].setBackground(Color.GREEN);
		button[c].setBackground(Color.GREEN);
		for(int i=0; i< 9; i++) {
			button[i].setEnabled(false);
		}
	}

	public static void main(String[] args) {
		new TicTacToe();
	}
}
