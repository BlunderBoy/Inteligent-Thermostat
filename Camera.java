package tema2;

import java.util.ArrayList;
/**
 * Clasa care dubleaza ca un device pentru ca avem doar unul pe camera.
 * Fiecare camera o sa aiba un ArrayList de intervale.
 */
public class Camera {
	String nume;
	String id;
	double suprafata;
	ArrayList<Interval> intervale; //24 de intervale
	public Camera() {}
	public Camera(String nume, double suprafata, String id) {
		super();
		this.id = id;
		this.nume = nume;
		this.suprafata = suprafata;
		this.intervale = new ArrayList<Interval>();
	}
}
