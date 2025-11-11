/* This is a stub for the Library class */

import java.util.Hashtable;
import java.util.Map;

public class Library extends Building implements LibraryRequirements {

  private Hashtable<String, Boolean> collection;

  public Library(String name, String address, int nFloors) {
    System.out.println("You have built a library: 📖");
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
  }

  public void addTitle(String title){
      collection.put(title, true);
  }

  public String removeTitle(String title){
    if(collection.containsKey(title)){
      collection.remove(title);
      return title;
    }else{
      throw new IllegalArgumentException(title + "not found in the collection.");
    }
  }

  public void checkOut(String title){
    if(collection.containsKey(title)){
      if(collection.get(title)){
        collection.put(title, false);
      }else{
        throw new IllegalArgumentException(title + "has been checked out.");
      }
    }else{
      throw new IllegalArgumentException(title + "is not in the collection.");
    }
  }


  public void returnBook(String title){
    if(collection.containsKey(title)){
      if(!collection.get(title)){
        collection.put(title,true);
      }else{
        throw new IllegalArgumentException(title + "is in the collection already.");
      }
    }else{
      throw new IllegalArgumentException(title + "is not in the collection.");
    }
  }


  public boolean containsTitle(String title){
    return collection.containsKey(title);
  }
  
  
  public boolean isAvailable(String title){
    return collection.getOrDefault(title, false);
  }

  public void printCollection(){
    System.out.println("Library Collection: \n");
    for (Map.Entry<String, Boolean> entry : collection.entrySet()) {
      if(entry.getValue()){
        System.out.println("Title: "+ entry.getKey()+ "; Status: Available" );
      }else{
        System.out.println("Title: "+ entry.getKey()+ "; Status: Checked Out" );
      }
    }
  }


  public static void main(String[] args) {
    Library myLib = new Library("Neilson", "7 Neilson drive", 20);
    myLib.addTitle("CSC 120 Textbook");
    myLib.addTitle("SDS 291 Textbook");

    myLib.removeTitle("SDS 291 Textbook");

    myLib.checkOut("CSC 120 Textbook");

    myLib.returnBook("CSC 120 Textbook");

    System.out.println(myLib.containsTitle("CSC 120 Textbook"));

    System.out.println(myLib.isAvailable("CSC 120 Textbook"));

    myLib.printCollection();
  }

}