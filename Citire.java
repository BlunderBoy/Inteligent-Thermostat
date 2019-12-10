package tema2;

import java.io.File;

/**
 * Clasa folosita la citire.
 */
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Citire {
	File fisier;
	Scanner sc;
	Citire(String file) throws FileNotFoundException
	{
		this.fisier = new File(file); 
		sc = new Scanner(fisier);
	}
	/**
     * Functie care citeste o linie (String) noua sau returneaza null;
	   * @return O linie noua (String) din fisier.
	   */
	String linieNoua() throws Exception 
	{
		String linie = ""; 
		if(sc.hasNextLine())
		{
			linie = sc.nextLine();
			return linie;
		}
		else
		{
			return null; //end of file (EOF)
		}
	}
	/**
     * Functie care inchide obiectul folosit la citire;
	   */
	void closeScanner()
	{
		sc.close();
	}
}
