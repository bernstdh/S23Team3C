package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import items.Ingredients;
import items.Meals;
import items.Recipes;

/**
 * Creates and reads both .rcp and .mel objects.
 * 
 * @author Beau Mueller
 *
 */
public class Serializer
{
  private static final String RECIPE = ".rcp";
  private static final String MEAL = ".mel";
  private static final String SLASH = "/";
  private static final String INGREDIENTS = "UserIngredients.dat";

  /**
   * main method.
   * 
   * @param args
   */
  // public static void main(final String[] args)
  // {
  // Recipes r = new Recipes("example", 99990, new ArrayList<Ingredient>(),
  // new ArrayList<Utensils>(), new ArrayList<Steps>());
  // Recipes r2 = null;
  // System.out.println(r.getName());
  // System.out.println(r.numPpl());
  // try {
  // serializeRecipe(r);
  // } catch (IOException ioe) {
  //
  // }
  // try
  // {
  // r2 = deserializeRecipe("example.rcp");
  // }
  // catch (ClassNotFoundException | IOException e)
  // {
  // // TODO Auto-generated catch block
  // e.printStackTrace();
  // }
  // System.out.println("Now printing deserialized Recipes object");
  // System.out.println(r2.getName());
  // System.out.println(r2.numPpl());
  // }
  /**
   * Creates a new .rcp file.
   * 
   * @param r
   *          The object to make the file from
   * @throws IOException
   *           If there is Input/Output trouble
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
   * 
   * @param dir
   *          the directory
   * @param r
   *          the recipe to save
   * @throws IOException
   *           If there's input/output trouble
   */
  public static void serializeRecipe(final String dir, final Recipes r) throws IOException
  {
    FileOutputStream fileOut = new FileOutputStream(dir + SLASH + r.getName() + RECIPE);
    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    out.writeObject(r);
    fileOut.close();
  }

  /**
   * Creates a new .mel file.
   * 
   * @param m
   *          The object to make the file from
   * @throws IOException
   *           If there is Input/Output trouble
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
   * 
   * @param dir
   *          the directory
   * @param m
   *          the meals object to be made into a file
   * @throws IOException
   *           if there's a problem with Input/output
   */
  public static void serializeMeal(final String dir, final Meals m) throws IOException
  {
    FileOutputStream fileOut = new FileOutputStream(dir + SLASH + m.getName() + MEAL);
    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    out.writeObject(m);
    fileOut.close();
  }

  /**
   * Creates a new Recipes object from the given file name.
   * 
   * @param fileName
   *          The file name of the recipe
   * @return The new Recipes object
   * @throws IOException
   *           If there is input/output trouble
   * @throws ClassNotFoundException
   *           If the Recipes class can't be found from the given file.
   */
  public static Recipes deserializeRecipe(final String fileName)
      throws IOException, ClassNotFoundException
  {
    FileInputStream fileIn = new FileInputStream(fileName);
    ObjectInputStream in = new ObjectInputStream(fileIn);
    Recipes r = (Recipes) in.readObject();
    in.close();
    return r;
  }

  /**
   * Creates a new Meals object from the given file name.
   * 
   * @param fileName
   *          The file name of the meal
   * @return The new Meals object
   * @throws IOException
   *           If there is input/output trouble
   * @throws ClassNotFoundException
   *           if the Meals class can't be found from the given file.
   */
  public static Meals deserializeMeal(final String fileName)
      throws IOException, ClassNotFoundException
  {
    FileInputStream fileIn = new FileInputStream(fileName);
    ObjectInputStream in = new ObjectInputStream(fileIn);
    Meals m = (Meals) in.readObject();
    in.close();
    return m;
  }

  /**
   * Saves the given arraylist into a file named "UserIngredients.dat".
   * 
   * @param al
   *          The arraylist being saved into the file.
   * @throws IOException
   *           If there is input/output error
   */
  public static void saveIngredients(final ArrayList<Ingredients> al) throws IOException
  {
    FileOutputStream fileOut = new FileOutputStream(INGREDIENTS);
    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    out.writeObject(al);
    fileOut.close();
  }

  /**
   * Returns an arraylist of all existing user ingredients. The file must be in the same folder as
   * the application.
   * 
   * @return The arraylist.
   * @throws IOException
   *           Input/output error
   * @throws ClassNotFoundException
   *           If one of the Serializable classes isn't recognized.
   */
  public static ArrayList<Ingredients> retrieveIngredients()
      throws IOException, ClassNotFoundException
  {
    FileInputStream fileIn = new FileInputStream(INGREDIENTS);
    ObjectInputStream in = new ObjectInputStream(fileIn);
    @SuppressWarnings("unchecked")
    ArrayList<Ingredients> al = (ArrayList<Ingredients>) in.readObject();
    in.close();
    return al;
  }

}
