import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Race
{

  private int laps;
  
  private LinkedList<Car> racers;
  
  private GuiController instance = GuiController.createInstance();
  
  public Race() {
    this.laps = 0;
    this.racers = new LinkedList<Car>();
  }
  
  
  public void addCar(Car car) {
    racers.add(car);
  }
  
  public Car getCar(int pos) {
    return racers.get(pos);
  }
  
  public void setLaps(int laps) {
    this.laps = laps;
  }
  
  public int getLaps() {
    return this.laps;
  }
  
  public LinkedList<Car> getRacers() {
    return this.racers;
  }
  
  
  public void update() {
    Random rand = new Random();
    int carsThatMove = rand.nextInt(3);
    ArrayList<Integer> usedCarPos = new ArrayList<Integer>();
    usedCarPos.add(0);
    for (int i = 0; i < carsThatMove; i++) {
      int carPosToMove = rand.nextInt(racers.size());
      if (!usedCarPos.contains(carPosToMove)) {
        usedCarPos.add(carPosToMove);
        Car curCar = racers.get(carPosToMove);
        Car aheadCar = racers.get(carPosToMove - 1);
        racers.set(carPosToMove, aheadCar);
        racers.set(carPosToMove - 1, curCar);
        instance.getTextArea().append((curCar.getName() + " has overtaken " 
            + aheadCar.getName() + "\n"));
      }
    }
  }
  
  
}
