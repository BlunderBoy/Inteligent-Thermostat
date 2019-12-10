package tema2;

/**
 * Clasa folosita la afisare.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Afisare {
	FileWriter sc;
	File out;
	/**
	 * Constructor care instantiaza un fisier nou in care se face afisarea si
	 * instantiaza un nou FileWriter.
	 */
	Afisare() throws IOException
	{
		out = new File("therm.out");
		out.createNewFile();
		out.setWritable(true);
		sc = new FileWriter(out);
	}
	/**
	 * Metoda semanatoare cu cea din System.out facuta cu un scop cu acelasi nume
	 * ca sa pod modifica System.out in numele obiectului meu de afisare.
	 */
	void print(String s) throws IOException
	{
		sc.write(s);
	}
	/**
	 * Metoda semanatoare cu cea din System.out facuta cu un scop cu acelasi nume
	 * ca sa pod modifica System.out in numele obiectului meu de afisare.
	 */
	void println(String s) throws IOException
	{
		sc.write(s);
		sc.write("\n");
	}
	/**
	 * Metoda semanatoare cu cea din System.out facuta cu un scop cu acelasi nume
	 * ca sa pod modifica System.out in numele obiectului meu de afisare.
	 */
	void println() throws IOException
	{
		sc.write("\n");
	}
	/**
	 * Metoda care inchide scannerul de afisare.
	 */
	void close() throws IOException
	{
		sc.close();
	}
}
