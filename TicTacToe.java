import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TicTacToe implements ActionListener {

Random random = new Random();
JFrame frame = new JFrame();
JPanel title_panel = new JPanel();
JPanel buttm_panel = new JPanel();
JLabel textfield = new JLabel();
JButton[] buttons = new JButton[9];
boolean player1_turn;


   
    public void actionPerformed(ActionEvent e) {

      for (int i = 0; i < buttons.length; i++) {
          if (e.getSource() == buttons[i]) {
              if (player1_turn) {
                if (buttons[i].getText().equals("")) {
                    buttons[i].setForeground(new Color(255, 0, 0));
                    buttons[i].setText("X");
                    player1_turn = false;
                    textfield.setText("O turn");
                    check();
                }
              } else {
                      if (buttons[i].getText().equals("")) {
                           buttons[i].setForeground(new Color(0, 0, 255));
                           buttons[i].setText("O");
                           player1_turn = true;
                            textfield.setText("X turn"); 
                            check();
                            }
                   }

              }
      }

     }
    
   
    TicTacToe(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);   
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.add(textfield);

        buttm_panel.setLayout(new GridLayout(3,3));
        buttm_panel.setBackground(new Color(150,150,150));
        for(int i = 0; i < 9; i++){
            buttons[i] = new JButton();
            buttons[i].setBackground(new Color(150,150,150));
            buttons[i].setForeground(new Color(25,25,25));
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].setOpaque(true);
            buttons[i].addActionListener(this);
            buttm_panel.add(buttons[i]);
        }

        title_panel.setBounds(0, 0, 800, 100);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(buttm_panel);

        firstturn();

    }

      public void firstturn(){

        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        if(random.nextInt(2) == 0){
            player1_turn = true;
            textfield.setText("X Turn");
        }
        else{
            player1_turn = false;
            textfield.setText("O Turn");
        }

      }
        public void check(){ 
          //check for X win
          if (
            (buttons[0].getText() == "X") && 
            (buttons[1].getText() == "X") &&
            (buttons[2].getText() == "X")
           ) {
            Xwin(0, 1, 2);
          }

          if ((buttons[3].getText() == "X") &&
              (buttons[4].getText() == "X") &&
              (buttons[5].getText() == "X")) {
            Xwin(3, 4, 5);
          }
          if ((buttons[6].getText() == "X") &&
              (buttons[7].getText() == "X") &&
              (buttons[8].getText() == "X")) {
            Xwin(6, 7, 8);
          }
          if ((buttons[0].getText() == "X") &&
              (buttons[3].getText() == "X") &&
              (buttons[6].getText() == "X")) {
            Xwin(0, 3, 6);
          }
          if ((buttons[1].getText() == "X") &&
              (buttons[4].getText() == "X") &&
              (buttons[7].getText() == "X")) {
            Xwin(1, 4, 7);
          }
          if ((buttons[2].getText() == "X") &&
              (buttons[5].getText() == "X") &&
              (buttons[8].getText() == "X")) {
            Xwin(2, 5, 8);
          }
          if ((buttons[0].getText() == "X") &&
              (buttons[4].getText() == "X") &&
              (buttons[8].getText() == "X")) {
            Xwin(0, 4, 8);
          }
          if ((buttons[2].getText() == "X") &&
              (buttons[4].getText() == "X") &&
              (buttons[6].getText() == "X")) {
            Xwin(2, 4, 6);
          }

          //check for O win
          if ((buttons[0].getText() == "O") &&
              (buttons[1].getText() == "O") &&
              (buttons[2].getText() == "O")) {
            Owin(0, 1, 2);
          }

          if ((buttons[3].getText() == "O") &&
              (buttons[4].getText() == "O") &&
              (buttons[5].getText() == "O")) {
            Owin(3, 4, 5);
          }
          if ((buttons[6].getText() == "O") &&
              (buttons[7].getText() == "O") &&
              (buttons[8].getText() == "O")) {
            Owin(6, 7, 8);
          }
          if ((buttons[0].getText() == "O") &&
              (buttons[3].getText() == "O") &&
              (buttons[6].getText() == "O")) {
            Owin(0, 3, 6);
          }
          if ((buttons[1].getText() == "O") &&
              (buttons[4].getText() == "O") &&
              (buttons[7].getText() == "O")) {
            Owin(1, 4, 7);
          }
          if ((buttons[2].getText() == "O") &&
              (buttons[5].getText() == "O") &&
              (buttons[8].getText() == "O")) {
            Owin(2, 5, 8);
          }
          if ((buttons[0].getText() == "O") &&
              (buttons[4].getText() == "O") &&
              (buttons[8].getText() == "O")) {
            Owin(0, 4, 8);
          }
          if ((buttons[2].getText() == "O") &&
              (buttons[4].getText() == "O") &&
              (buttons[6].getText() == "O")) {
            Owin(2, 4, 6);
          }


        }
        public void Xwin(int a, int b, int c){
          buttons[a].setBackground(new Color(0,255,0));
          buttons[b].setBackground(new Color(0,255,0));
          buttons[c].setBackground(new Color(0,255,0));
          textfield.setText("X Wins!");
          for(int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
          }
         }
         
        
        public void Owin(int a , int b, int c){
          buttons[a].setBackground(new Color(255,0,0));
          buttons[b].setBackground(new Color(255,0,0));
          buttons[c].setBackground(new Color(255,0,0));
          textfield.setText("O Wins!");
          for(int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
          }
          
        }
    }

