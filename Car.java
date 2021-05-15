
public class Car
{
  
  
  private String name;
  
  private int startingPos;
  
  public Car(String name, int pos) {
    this.name = name;
    this.startingPos = pos;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int getPos()
  {
    return startingPos;
  }

  public void setPos(int pos)
  {
    this.startingPos = pos;
  }
  
  

}
