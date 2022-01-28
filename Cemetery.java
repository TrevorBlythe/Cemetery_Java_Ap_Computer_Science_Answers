/**

 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

public class  Cemetary{
   //////// MAIN ////////
   public static void main (String[] args)
   {
      File file = new File("cemetery.txt");
      int numEntries = countEntries(file);
      // System. out. println(file);
      Person[] cemetery = new Person[numEntries];
      
      cemetery = readIntoArray(file, numEntries);
      
      // //TESTING ONLY: un-comment the 2 lines below to see if array was created properly
      // for (int i = 0; i < cemetery.length; i++) {
      //   System.out.println(cemetery[i].getName() + " " + cemetery[i].getAge());
      // }
      
      int min = locateMinAgePerson(cemetery);
      int max = locateMaxAgePerson(cemetery);
      System.out.println("In the St. Mary Magdelene Old Fish Cemetery --> ");
      System.out.println("Name of youngest person: " + cemetery[min].getName());
      System.out.println("Age of youngest person: " + cemetery[min].getAge());
      System.out.println("Name of oldest person: " + cemetery[max].getName());
      System.out.println("Age of oldest person: " + cemetery[max].getAge());
   }
   
   //////// METHODS (Cemetery) ////////

   /* Counts and returns the number of entries in File f.
    * Uses a try-catch block.
    * @param f -- the file object
   */
   public static int countEntries(File f)
   {
       int i = 0;
       try
       {
           Scanner scan = new Scanner(f);
           while (scan.hasNextLine())
           {
               i++;
               scan.nextLine();
           }
       }
       catch (Exception e)
       {
           System.out.println("Check filename.");
       }
       
       return i;
   }

   /* Reads the data.
    * Fills the array with Person objects.
    * Uses a try-catch block.
    * @param f -- the file object
    *        num -- the number of lines in the File f
    */
   public static Person[] readIntoArray (File f, int num)
   {
      Person[] dumbarray;
      dumbarray = new Person[num];
      int i = 0;
      try{
           Scanner scan = new Scanner(f);

           while (scan.hasNextLine())
           {
               
               String data = scan.nextLine();
               
               //System.out.println(gay);
           
          
        dumbarray[i] = makePerson(data);
        i++;
           }
      scan.close();
          } catch (FileNotFoundException e) {
        //do something with e, or handle this case
    }
      return dumbarray;
   }
   
   /* A helper method that instantiates one Person object.
    * @param entry -- one line of the input file.
    */
   private static Person makePerson(String data)
   {
return new Person(data.substring(0,25),data.substring(25,37),data.substring(37,42));
   }
   
   /* Finds and returns the location (the index) of the Person
    * who is the youngest.
    * @param arr -- an array of Person objects.
    */
   public static int locateMinAgePerson(Person[] arr)
   {
     int minIndex = 0;
      for (int i = 0; i < arr.length; i++) {
        if(arr[i].getAge() < arr[minIndex].getAge()){
          minIndex = i;
        }
      }
      return minIndex;
      
   }
   
  //  /* Finds and returns the location (the index) of the Person
  //     who is the oldest.
  //     @param arr -- an array of Person objects.
  //   */
   public static int locateMaxAgePerson(Person[] arr)
   {
     int minIndex = 0;
      for (int i = 0; i < arr.length; i++) {
        if(arr[i].getAge() > arr[minIndex].getAge()){
          minIndex = i;
        }
      }
      return minIndex;
   }
}

class Person
{
   //// FIELDS ////
   
   /* Declare fields for the name, the burial date, and the age. */
   private String name;
   private String burialDate;
   private double age;
      
   ////// CONSTRUCTOR //////
   
   /* @param n -- a String representing a name from the input file.
    *        bd -- a String representing a burial date from the input file.
    *        a -- a String representing an age from the input file.
    */
   public Person(String n, String bd, String a)
   {
       name = n;
      //  System.out.println(name);
       burialDate = bd;
      //  System.out.println(burialDate);
       age = calculateAge(a);
      //  System.out.println(" " + age);
   }
   
   //////// METHODS (Person) ////////

   /* Calculates the numerical equivalent of an age in String format.
    * If the String contains a "w" (weeks) or "d" (days), calculates appropriate portion
    * of a year.
      @param a -- a String representing a person's age.
   */
   public double calculateAge(String a)
   {
      //System.out.println(a);
       double numericalAge = 0.0;
       if(a.contains("w"))
       {
           int pos = a.indexOf("w");
           double numWeeks = Double.parseDouble(a.substring(0,pos));
           numericalAge = numWeeks/52.0;
       }
       else if(a.contains("d"))
       {
           int pos = a.indexOf("d");
           double numWeeks = Double.parseDouble(a.substring(0,pos));
           numericalAge = numWeeks/365.0;
       }
       else
       {
            return Double.parseDouble(a);
       }
      //System.out.println(a);
       return numericalAge;
   }
   
   ////////// ACCESSOR METHODS (Person) //////////
   
   /* Write 3 accessor methods for the fields of the Person class.
    * (See the main method in the Cemetery class.)
    */
    public double getAge(){
      return age;
    }

    public String getName(){
      return name;
    }

    public String getBurialDate(){
      return burialDate;
      
    }
   
}
