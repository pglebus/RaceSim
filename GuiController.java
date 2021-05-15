import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class GuiController extends JFrame
{
  
  /**
   * 
   */
  private static final long serialVersionUID = -5200564328159758197L;

  private static boolean exists = false;
  
  private static JFrame instance;
  
  private JFrame bottomFrame;
  
  private JPanel buttonPanel;
  
  private JLabel titleLabel;
  
  private JTextArea raceDisplay;
  
  private JTextField inputField;
  
  private JButton startRace, stopRace;
  
  private JScrollPane jSP;
  
  
  private GuiController() 
  {
    
    GuiController.instance = new JFrame();
    
    exists = true;
    instance.setSize(670, 550);
    instance.setTitle("Racing Simulator");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
 
    
    Container contentPane = instance.getContentPane();
    contentPane.setLayout(new BorderLayout());
    
    
    
    raceDisplay = new JTextArea();
    raceDisplay.setBackground(Color.white);
    raceDisplay.setForeground(Color.black);
    raceDisplay.setFont(new Font("Copperplate", Font.PLAIN, 16));
    raceDisplay.setEditable(false);
    raceDisplay.setBorder(BorderFactory.createLineBorder(Color.red, 3));
    jSP = new JScrollPane(raceDisplay);
    jSP.setVisible(true);
    
    contentPane.add(jSP, BorderLayout.CENTER);
    
    bottomFrame = new JFrame();
    Container bFCP = bottomFrame.getContentPane();
    bFCP.setLayout(new BorderLayout());
  
    startRace = new JButton("Start Race");
    //stopRace = new JButton("Stop Race");
    startRace.setBackground(Color.black);
    startRace.setForeground(Color.WHITE);
    startRace.setFont(new Font("Copperplate", Font.ITALIC, 20));
    
    
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(1,1));
    
    ButtonController bController = new ButtonController();
    startRace.addActionListener(bController);
    //stopRace.addActionListener(bController);
    
    buttonPanel.add(startRace);
    //buttonPanel.add(stopRace);
    
    bFCP.add(buttonPanel, BorderLayout.SOUTH);

    contentPane.add(bFCP, BorderLayout.SOUTH);
    
    
    titleLabel = new JLabel();
    titleLabel.setOpaque(true);
    titleLabel.setBackground(Color.black);
    titleLabel.setForeground(Color.white);
    titleLabel.setFont(new Font("Copperplate", Font.PLAIN, 12));
    titleLabel.setText("Racing Simulator 2021");
    
    
    contentPane.add(titleLabel, BorderLayout.NORTH);
    
    instance.setVisible(true);
    
    
  }
  
  
  public static GuiController createInstance() 
  {
    if (!exists) instance = new GuiController();
    
    return (GuiController) instance;
  }
  
  public JTextArea getTextArea() {
    return raceDisplay;
  }
  
  public void throwErrorMessage(String errorMessage) 
  {
    JOptionPane.showMessageDialog(null, errorMessage, errorMessage, JOptionPane.ERROR_MESSAGE);
  }
  

}
