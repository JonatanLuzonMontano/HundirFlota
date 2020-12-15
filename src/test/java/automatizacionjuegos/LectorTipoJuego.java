package automatizacionjuegos;

import java.io.File;
import java.io.IOException;

import HundirFlota.MockTecladoManual;
import HundirFlota.MockTecladoRandom;

public class LectorTipoJuego {
	
	
	
	public static void main(String[]args) throws IOException, InterruptedException {
		
		File file = null;
		Juego juego;
		
		if(0<args.length) {

			if(args[0].equals("manual")) {
				juego = new Juego(new MockTecladoManual());
				file = new File("src/test/java/automatizacionjuegos/" + args[1]);
				Juego.añadirCoordenadas(file);
				juego.juego();
			} else {
				if(args[0].equals("random")) {
					juego = new Juego(new MockTecladoRandom());
					for(int i = 0; i < Integer.parseInt(args[1]); i++) {
						juego.juego();
					}
				} else {
					System.out.println("parámetros incorrectos");
				}
			}
		} else {
			System.exit(0);
		}
	
	}
}
