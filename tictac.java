import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 public class tictac implements ActionListener {
 private JFrame frame;
 private JPanel panel;
 private JButton button[] =new JButton[9];
 private boolean xTurn;
 public tictac()
 {
     frame =new JFrame("tic_tac_toe");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     panel=new JPanel();
     panel.setLayout(new GridLayout(3,3));
     panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
     
     for(int i=0;i<9;i++)
     {
        button[i]=new JButton();
        button[i].setFont(new Font("Arial",Font.PLAIN,40));
        button[i].setBackground(Color.BLACK);
        button[i].addActionListener(this);
        panel.add(button[i]);
        
     }
     frame.add(panel,BorderLayout.CENTER);
     frame.setSize(400,400);
      
      
     
     frame.setVisible(true);
     
 }
  @Override
    public void actionPerformed(ActionEvent e) {
      JButton button =(JButton)e.getSource();
      if(xTurn)
      {
          button.setText("X");
      }else
      {
          button.setText("O");
      }
      button.setEnabled(false);
      xTurn=!xTurn;
      checkForWinner();
    }
    public void checkForWinner()
    {
        for(int i=0;i<9;i+=3)
        {
            if(button[i].getText().equals(button[i+1].getText())&&button[i].getText().equals(button[i+2].getText())&&!button[i].isEnabled())
            {
                JOptionPane.showMessageDialog(frame,button[i].getText()+ "!WIns");
                resetGame();
                return;
            }
        }
        //check columns
        for(int i=0;i<3;i++)
        {
            if(button[i].getText().equals(button[i+3].getText())&&button[i].getText().equals(button[i+6].getText())&&!button[i].isEnabled())
            {
                JOptionPane.showMessageDialog(frame,button[i].getText()+"Wins!");
                resetGame();
                return;
            }
        }
        //check diagonals 
        if(button[0].getText().equals(button[4].getText())&&button[0].getText().equals(button[8].getText())&&!button[0].isEnabled())
        {
            JOptionPane.showMessageDialog(frame,button[0].getText());
            return;
            
        }
        if(button[2].getText().equals(button[4].getText())&&button[2].getText().equals(button[6].getText())&&!button[2].isEnabled())
        {
            JOptionPane.showMessageDialog(frame,button[2].getText()+"Wins");
            resetGame();
            return;
            
        }
        //check for tie
        boolean tie=true;
        for(int i=0;i<9;i++)
        {
            if(button[i].isEnabled())
            {
                tie=false;
                break;
            }
        }if(tie)
                {
                    JOptionPane.showMessageDialog(frame,"Tie game!");
                    resetGame();
                    
                }
    }
 public void resetGame()
 {
     for(int i=0;i<9;i++)
     {
         button[i].setText(" ");
         button[i].setEnabled(true);
     }
     xTurn=true;
 }
     
public static void main(String[] args) {
        // TODO code application logic here
        new tictac();
     
    }

    
    
}

