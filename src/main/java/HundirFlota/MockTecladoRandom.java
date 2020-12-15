package HundirFlota;

public class MockTecladoRandom implements InterficieTeclado{
	int i;
	@Override
	public int pedirCoordenadas() {
		i = (int) Math.floor(Math.random()*(9-0+1)+0);
		return i; 
	}

}
