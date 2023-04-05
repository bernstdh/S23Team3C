import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
// import java.util.ArrayList;

/**
 * Creates and reads both .rcp and .mel objects.
 * @author beaumueller
 *
 */
public class Serializer
{
  private static final String RECIPE = ".rcp";
  private static final String MEAL = ".mel";
//  *EXAMPLE DRIVER*
//  public static void main(String[] args) {
//    Recipes r = new Recipes("example", 99990, new ArrayList<Ingredient>(),
//        new ArrayList<Utensils>());
//    Recipes r2 = null;
//    System.out.println(r.getName());
//    System.out.println(r.numPpl());
//    try {
//      serializeRecipe(r);
//    } catch (IOException ioe) {
//      
//    }
//    try
//    {
//      r2 = deserializeRecipe("example.rcp");
//    }
//    catch (ClassNotFoundException | IOException e)
//    {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }
//    System.out.println("Now printing deserialized Recipes object");
//    System.out.println(r2.getName());
//    System.out.println(r2.numPpl());
//  }
  /**
   * Creates a new .rcp file.
   * @param r The object to make the file from
   * @throws IOException  If there is Input/Output trouble
   */
  public static void serializeRecipe(final Recipes r) throws IOException 
  {
    FileOutputStream fileOut = new FileOutputStream(r.getName() + RECIPE);
    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    out.writeObject(r);
    fileOut.close();
  }
  
  /**
   * Creates a new .rcp file with a custom directory.
   * @param dir the directory
   * @param r the recipe to save
   * @throws IOException If there's input/output trouble
   */
  public static void serializeRecipe(final String dir, final Recipes r) throws IOException
  {
    FileOutputStream fileOut = new FileOutputStream(dir + r.getName() + RECIPE);
    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    out.writeObject(r);
    fileOut.close();
  }
  
  /**
   * Creates a new .mel file.
   * @param m The object to make the file from
   * @throws IOException  If there is Input/Output trouble
   */
  public static void serializeMeal(final Meals m) throws IOException
  {
    FileOutputStream fileOut = new FileOutputStream(m.getName() + MEAL);
    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    out.writeObject(m);
    fileOut.close();
  }
  
  /**
   * Creates a new .mel file with custom directory.
   * @param dir the directory
   * @param m the meals object to be made into a file
   * @throws IOException  if there's a problem with Input/output
   */
  public static void serializeMeal(final String dir, final Meals m) throws IOException
  {
    FileOutputStream fileOut = new FileOutputStream(dir + "\\" + m.getName() + MEAL);
    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    out.writeObject(m);
    fileOut.close();
  }
  
  /**
   * Creates a new Recipes object from the given file name.
   * @param fileName The file name of the recipe
   * @return The new Recipes object
   * @throws IOException If there is input/output trouble
   * @throws ClassNotFoundException If the Recipes class can't be found from the given file.
   */
  public static Recipes deserializeRecipe(final String fileName) throws IOException,
      ClassNotFoundException
  {
    FileInputStream fileIn = new FileInputStream(fileName);
    ObjectInputStream in = new ObjectInputStream(fileIn);
    Recipes r = (Recipes) in.readObject();
    in.close();
    return r;
  }
  
  /**
   * Creates a new Meals object from the given file name.
   * @param fileName The file name of the meal
   * @return The new Meals object
   * @throws IOException If there is input/output trouble
   * @throws ClassNotFoundException if the Meals class can't be found from the given file.
   */
  public static Meals deserializeMeal(final String fileName) throws IOException,
      ClassNotFoundException
  {
    FileInputStream fileIn = new FileInputStream(fileName);
    ObjectInputStream in = new ObjectInputStream(fileIn);
    Meals m = (Meals) in.readObject();
    in.close();
    return m;
  }

}
