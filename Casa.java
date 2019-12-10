package tema2;

import java.util.ArrayList;
/**
 * Clasa care functioneaza ca un scope global in care avem toate camerele.
 * Variabile cum ar fi numarul de camere sau temperatura globala se gasesc
 * in aceasta clasa.
 * Avem si 2 functii ajutatoare pentru a returna o anumita camera din array 
 * list pe care le folosim la adaugare.
 */
public class Casa {
	double temperaturaGlobala;
	long timpestampReferinta;
	int nrCamere;
	ArrayList<Camera> camere;
	public Casa() 
	{
		this.camere = new ArrayList<Camera>();
	}
	/**
	 * Metoda folosita la inserarea in unei temperaturi.
	 * Returneaza indexul unei anumite case din ArrayList pentru a face
	 * inserarea dupa index mai usoara
	 * @param s Id-ului unui device
	 * @return indexul camerei
	 */
	int getIndex(String s)
	{
		for (int j = 0; j < camere.size(); j++) {
			if(camere.get(j).id.equals(s))
			{
				return j;
			}
		}
		return -1;
	}
	/**
	 * Metoda folosita la inserarea in unei temperaturi.
	 * Returneaza indexul unei anumite case din ArrayList pentru a face
	 * inserarea dupa index mai usoara
	 * Metoda asta este asemanatoare cu getIndex numai ca asta merge dupa
	 * numele camerei si nu dupa deviceID.
	 * @param s Numele camerei
	 * @return indexul camerei
	 */
	int getIndexNume(String s)
	{
		for (int j = 0; j < camere.size(); j++) {
			if(camere.get(j).nume.equals(s))
			{
				return j;
			}
		}
		return -1;
	}
}
