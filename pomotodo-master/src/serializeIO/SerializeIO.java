package serializeIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class SerializeIO {
	public void save(String fileName, Object object ) {
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut = null;

	    
        try {
           fileOut = new FileOutputStream(fileName);
           (objOut = new ObjectOutputStream(fileOut)).writeObject(object);
           objOut.close();
           fileOut.close();
        } catch (IOException e) {
           e.printStackTrace();
        } 

	}
	
	protected static Object read(String fileName) {


		ObjectInputStream objInp =null;
      Object obj = null;
  
        try {
        	FileInputStream fileInp = new FileInputStream(fileName);
			obj = (objInp = new ObjectInputStream(fileInp)).readObject();
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        } 

      return obj;
   }
	
	public abstract Object loadDataFromSerFile();
	public abstract void saveDataToSerFile(Object obj);
}
