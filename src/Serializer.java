import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Creates and reads both .rcp and .mel objects.
 * @author beaumueller
 *
 */
public class Serializer
{
  private static final String RECIPE = ".rcp";
  private static final String MEAL = ".mel";
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
   * Creates a new .mel file.
   * @param m The object to make the file from
   * @throws IOException  If ther is Input/Output trouble
   */
  public static void serializeMeal(final Meals m) throws IOException
  {
    FileOutputStream fileOut = new FileOutputStream(m.getName() + MEAL);
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
