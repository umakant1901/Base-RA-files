package testSerializationDeserialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
class TestSerializationDeserialization implements Serializable
{
	int var1=123, var2=456;

}




public class TryingSerializationAndDeserialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		TestSerializationDeserialization t1= new TestSerializationDeserialization();
		
		//Serialization code
		FileOutputStream fos=new FileOutputStream("Test.txt");
		ObjectOutputStream oos= new ObjectOutputStream(fos);
		oos.writeObject(t1);
		
		//Deserialization code
		
		FileInputStream fis=new FileInputStream("Test.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		
		TestSerializationDeserialization t2=(TestSerializationDeserialization) ois.readObject();
		System.out.println(t2.var1+" "+t2.var2);
		
		
		
		
		
	}

}
