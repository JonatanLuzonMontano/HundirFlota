package HundirFlota;

import java.util.ArrayList;

public class MockTecladoManual implements InterficieTeclado{
	
	public ArrayList<Integer> valores = new ArrayList<Integer>();
	
	public void anadirInt(int valor) {
		valores.add(valor);
	}
	
	@Override
	public int pedirCoordenadas() {
		return valores.remove(0);
	}
}
