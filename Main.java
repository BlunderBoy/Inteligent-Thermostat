package tema2;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws Exception {
		Afisare writer = new Afisare();
		Citire cititor = new Citire("therm.in");
		Casa casa = new Casa(); //initializare camere
		String casaInitial = cititor.linieNoua();
		String[] token;
		String buffer;
		token = casaInitial.split(" ");
 		casa.nrCamere = Integer.parseInt(token[0]);
		casa.temperaturaGlobala = Double.parseDouble(token[1]);
		casa.timpestampReferinta = Integer.parseInt(token[2]);
		for (int i = 0; i < casa.nrCamere; i++) 
		{
			token = cititor.linieNoua().split(" ");
			int suprafata = Integer.parseInt(token[2]);
			Camera bufferCamera = new Camera(token[0], suprafata, token[1]); //initializare intervale
			for (int j = 0; j <= 24; j++) {
				Interval gol = new Interval();
				bufferCamera.intervale.add(gol);
			}
			casa.camere.add(bufferCamera);
		}
		while((buffer = cititor.linieNoua()) != null)
		{
			token = buffer.split(" ");
			if (token[0].equals("OBSERVE")) 
			{
				 if(Integer.parseInt(token[2]) > casa.timpestampReferinta)
				 {
					 continue;
				 }
				 int indexInterval = (int) ((casa.timpestampReferinta - Integer.parseInt(token[2])) / 3600);
				 if(indexInterval > 25){continue;}  // error-checking
				 int indexCamera = casa.getIndex(token[1]);
				 casa.camere.get(indexCamera).intervale.get(indexInterval).temperaturi.add(Double.parseDouble(token[3]));
			}
			if (token[0].equals("TRIGGER")) 
			{
				double tempMedie = 0;
				double suprafataTotala = 0;
				for (int j = 0; j < casa.nrCamere; j++) 
				{
					int i = 0;
					while(casa.camere.get(j).intervale.get(i).temperaturi.isEmpty())
					{
						i++;
					}
					tempMedie += casa.camere.get(j).suprafata * casa.camere.get(j).intervale.get(i).temperaturi.first();
					suprafataTotala +=  casa.camere.get(j).suprafata;
				}
				double tempTrigger = tempMedie / suprafataTotala;
				if(tempTrigger > casa.temperaturaGlobala)
				{
					writer.println("NO");
				}
				else
				{
					writer.println("YES");
				}
			}
			if (token[0].equals("LIST")) 
			{
				int indexCamera = casa.getIndexNume(token[1]);
				int startInterval = (int) ((casa.timpestampReferinta - Integer.parseInt(token[3])) / 3600);
				int stopInterval = (int) ((casa.timpestampReferinta - Integer.parseInt(token[2])) / 3600);
				writer.print(token[1] + " ");
				for (int j = startInterval; j < stopInterval; j++) {
					TreeSet<Double> aux = new TreeSet<>(casa.camere.get(indexCamera).intervale.get(j).temperaturi);
					while(aux.size() != 0)
					{
						DecimalFormat auxScriere = new DecimalFormat("#.00", new DecimalFormatSymbols(Locale.US));
						writer.print(auxScriere.format(aux.pollFirst()) + " ");
					}
				}
				writer.println();
			}
			if (token[0].equals("TEMPERATURE")) 
			{
				casa.temperaturaGlobala = Double.parseDouble(token[1]);
			}			
		}
		writer.close();
	}
}
