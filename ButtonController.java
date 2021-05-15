import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ButtonController implements ActionListener
{

  //JOptionPane lapCount, carCount, carCreator;
  
  //private JButton button1, button2;
  
  String carCount, lapCount, curCarName;
  
  private String lapQuestion = "How many laps do you want the race to be?";
  
  private String carQuestion = "How many cars do you want in the race?";
  
  private String carNameQuestion = "What is the name of this car?";
  
  private GuiController instance;
  
  
  
  
  public ButtonController()
  {
  }




  @Override
  public void actionPerformed(ActionEvent e)
  {
    
    String event = e.getActionCommand();
    
    if (event.equals("Start Race")) 
    {
      try
      {
        raceStart();
      }
      catch (Exception e1)
      {
        instance.throwErrorMessage(e1.getMessage());
      }
    } 
    else if (event.equals("Stop Race")) 
    {
      
    }
  }
    
    
    
    
    private void raceStart() {
      
      instance = GuiController.createInstance();
      instance.getTextArea().setText("");
      Race race = new Race(); 
      
      
      
    
      try
      {
        carCount = JOptionPane.showInputDialog(carQuestion);
        
      }
      catch (NumberFormatException e)
      {
        throw new IllegalArgumentException("Please enter a valid number");
      }

      if (carCount == null) {
        return;
      }
      try
      {
        lapCount = JOptionPane.showInputDialog(lapQuestion);
      }
      catch (NumberFormatException e)
      {
        throw new IllegalArgumentException("Please enter a valid number");
      }
      if (lapCount == null) {
        return;
      }
      
      int intCarCount = 0;
      int intLapCount = 0;
      try
      {
        intCarCount = Integer.parseInt(carCount);
      }
      catch (NumberFormatException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      
      try
      {
        intLapCount = Integer.parseInt(lapCount);
      }
      catch (NumberFormatException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      for (int i = 0; i < intCarCount; i++) {
        curCarName = JOptionPane.showInputDialog(carNameQuestion + " (Car Number " + (i + 1) + " )");
        if (curCarName == null) {
          return;
        }
        Car newCar = new Car(curCarName, i);
        race.addCar(newCar);
      }
      
      String startingLineUp = "";
      for (Car car : race.getRacers()) {
        startingLineUp += car.getName() + " starts in " + (car.getPos() + 1) + "! \n";
      }

      instance.getTextArea().append(startingLineUp);
      for (int i = 0; i < intLapCount; i++) {
        instance.getTextArea().append("Starting lap " + (i + 1) + "! \n");
        if (i == (intLapCount / 2)) 
        {
          instance.getTextArea().append("Halfway through the standings are: \n");
          int count = 0;
          for (Car car : race.getRacers()) {
            instance.getTextArea().append(car.getName() + " sits in " + (count + 1) + "! \n");
            count++;
          }
        }
        race.update();
      }
      
      String finalLineUp = "";
      int counter  = 1;
      finalLineUp += "*********************\n In Conclusion.....";
      for (Car car : race.getRacers()) {
        finalLineUp += car.getName() + " finishes in " + counter + "! \n";
        counter++;
      }
      finalLineUp += "That's all folks!";
      
      instance.getTextArea().append(finalLineUp);
    }
    
   
    
  }
  
  


