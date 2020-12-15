package HundirFlota;

import java.util.Scanner;

public class Teclado implements InterficieTeclado {

	Scanner s = new Scanner(System.in);
	
	@Override
	public int pedirCoordenadas() {
		// TODO Auto-generated method stub
		return s.nextInt();
	}

}
