package automatizacionjuegos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;

import HundirFlota.Game;
import HundirFlota.InterficieTeclado;
import HundirFlota.MockTecladoManual;
import HundirFlota.Player;

public class Juego {
	static InterficieTeclado teclado;
	Timer t = new Timer(true);
	Game game= new Game();
	
	
	public Juego(InterficieTeclado t) {
		teclado = t;
	}

	public void juego() {
		
		    Player[] players=new Player[2];
			Player p1= new Player();
			p1.setNombre("Player 1");
			p1.setTurno(1);
			Player p2=new Player();
			p2.setNombre("Player 2");
			p2.setTurno(2);
			players[0]=p1;
			players[1]=p2;
			game.crearJugadores(players);
			game.setTeclado(teclado);
			//Players and Boards initialized
			//Proceed to insert boats at the board of each player
			System.out.println("Inicio del Juego");
			game.play();
			System.out.println("Final del Juego");
	}
	
	public static void añadirCoordenadas(File file) throws IOException {
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String linia = br.readLine();
		String[] coord;
		while(linia != null) {
			coord = linia.split(" ");
			for(int i = 0; i < coord.length; i++) {
				((MockTecladoManual) teclado).anadirInt(Integer.parseInt(coord[i]));
			}
			
			linia = br.readLine();
		}
				
		fr.close();
	}

}
