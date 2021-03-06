package HundirFlota;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testconstructor() {
		Player p1 = new Player();
		p1.setNombre("Arnau");
		assertNotNull(p1.getTablero());
		assertEquals("Arnau",p1.getNombre());
		assertEquals(0,p1.getTurno());
	
		Player p2 = new Player();
		p2.setNombre("Arnau");
		assertNotNull(p2.getTablero());
		assertEquals("Arnau",p2.getNombre());
		assertEquals(0,p2.getTurno());
	}
	@Test
	public void testgetTablero() {
		Player p = new Player();
		Board b = new Board();
		assertNotNull(p.getTablero());
		assertEquals(b.getColumnas(),p.getTablero().getColumnas());
		assertEquals(b.getFilas(),p.getTablero().getFilas());
		assertEquals(b.getColumnas(),p.getTablero().getColumnas());
		
	}
	@Test
	public void testmostrarTableroInfo(){
		Board b = new Board();
		Player p1 = new Player();
		p1.iniciarTableroInfo();
		String tableroAux="\n     0:  1:  2:  3:  4:  5:  6:  7:  8:  9:\n\n"
						+ 	"0:  [-] [-] [-] [-] [-] [-] [-] [-] [-] [-] \n"
						+	"1:  [-] [-] [-] [-] [-] [-] [-] [-] [-] [-] \n"
						+ 	"2:  [-] [-] [-] [-] [-] [-] [-] [-] [-] [-] \n"
						+ 	"3:  [-] [-] [-] [-] [-] [-] [-] [-] [-] [-] \n"
						+ 	"4:  [-] [-] [-] [-] [-] [-] [-] [-] [-] [-] \n"
						+ 	"5:  [-] [-] [-] [-] [-] [-] [-] [-] [-] [-] \n"
						+ 	"6:  [-] [-] [-] [-] [-] [-] [-] [-] [-] [-] \n"
						+ 	"7:  [-] [-] [-] [-] [-] [-] [-] [-] [-] [-] \n"
						+ 	"8:  [-] [-] [-] [-] [-] [-] [-] [-] [-] [-] \n"
						+ 	"9:  [-] [-] [-] [-] [-] [-] [-] [-] [-] [-] \n";
		assertEquals(tableroAux,p1.mostrarTableroInfo());
		String [][] tablero=p1.getTableroInfo();
		p1.disparar(b, 0, 0);
		p1.disparar(b, 9, 9);
		p1.disparar(b, 5, 4);
		p1.disparar(b, 13, 3);
		String tableroAux2="\n     0:  1:  2:  3:  4:  5:  6:  7:  8:  9:\n\n"
						+  	 "0:  [O] [-] [-] [-] [-] [-] [-] [-] [-] [-] \n"
						+    "1:  [-] [-] [-] [-] [-] [-] [-] [-] [-] [-] \n"
						+ 	 "2:  [-] [-] [-] [-] [-] [-] [-] [-] [-] [-] \n"
						+ 	 "3:  [-] [-] [-] [-] [-] [-] [-] [-] [-] [-] \n"
						+ 	 "4:  [-] [-] [-] [-] [-] [-] [-] [-] [-] [-] \n"
						+ 	 "5:  [-] [-] [-] [-] [O] [-] [-] [-] [-] [-] \n"
						+ 	 "6:  [-] [-] [-] [-] [-] [-] [-] [-] [-] [-] \n"
						+ 	 "7:  [-] [-] [-] [-] [-] [-] [-] [-] [-] [-] \n"
						+ 	 "8:  [-] [-] [-] [-] [-] [-] [-] [-] [-] [-] \n"
						+ 	 "9:  [-] [-] [-] [-] [-] [-] [-] [-] [-] [O] \n";

		assertEquals(tableroAux2,p1.mostrarTableroInfo());
		b.insertBoatLastPosition(0, 8, 4, 8, 5);
		//we shoot every position from the boat inserted
		p1.disparar(b, 0, 8);
		p1.disparar(b, 1, 8);
		p1.disparar(b, 2, 8);
		p1.disparar(b, 3, 8);
		p1.disparar(b, 4, 8);
		//we shoot around the boat inserted
		p1.disparar(b, 0, 7);
		p1.disparar(b, 1, 7);
		p1.disparar(b, 2, 7);
		p1.disparar(b, 3, 7);
		p1.disparar(b, 4, 7);
		p1.disparar(b, 5, 7);
		p1.disparar(b, 5, 8);
		p1.disparar(b, 5, 9);
		p1.disparar(b, 0, 9);
		p1.disparar(b, 1, 9);
		p1.disparar(b, 2, 9);
		p1.disparar(b, 3, 9);
		p1.disparar(b, 4, 9);
		//we repeat some shoots
		p1.disparar(b, 1, 9);
		p1.disparar(b, 2, 9);
		p1.disparar(b, 3, 9);
		p1.disparar(b, 4, 9);
		
		
		String tableroAux3="\n     0:  1:  2:  3:  4:  5:  6:  7:  8:  9:\n\n"
						+  	 "0:  [O] [-] [-] [-] [-] [-] [-] [O] [X] [O] \n"
						+    "1:  [-] [-] [-] [-] [-] [-] [-] [O] [X] [O] \n"
						+ 	 "2:  [-] [-] [-] [-] [-] [-] [-] [O] [X] [O] \n"
						+ 	 "3:  [-] [-] [-] [-] [-] [-] [-] [O] [X] [O] \n"
						+ 	 "4:  [-] [-] [-] [-] [-] [-] [-] [O] [X] [O] \n"
						+ 	 "5:  [-] [-] [-] [-] [O] [-] [-] [O] [O] [O] \n"
						+ 	 "6:  [-] [-] [-] [-] [-] [-] [-] [-] [-] [-] \n"
						+ 	 "7:  [-] [-] [-] [-] [-] [-] [-] [-] [-] [-] \n"
						+ 	 "8:  [-] [-] [-] [-] [-] [-] [-] [-] [-] [-] \n"
						+ 	 "9:  [-] [-] [-] [-] [-] [-] [-] [-] [-] [O] \n";
		assertEquals(tableroAux3,p1.mostrarTableroInfo());

		
		

	}
	@Test
	public void iniciarTableroInfo() {
		Player b = new Player();
		b.iniciarTableroInfo();
		String [][] tablero=b.getTableroInfo();
		assertEquals("[-]", tablero[0][0]);
		assertEquals("[-]", tablero[0][9]);
		assertEquals("[-]", tablero[9][0]);
		assertEquals("[-]", tablero[9][9]);
		assertEquals("[-]", tablero[5][4]);
		
		//Loop test
		String [][] tableroInfo2;
		tableroInfo2=new String[10][10];
		for(int i=0;i<1;i++) {
			for(int j=0;j<1;j++) {
				tableroInfo2[i][j]="[-]";
			}
		}
		assertNotEquals(tablero, tableroInfo2);
		String [][] tableroInfo3;
		tableroInfo3=new String[10][10];
		for(int i=0;i<1;i++) {
			for(int j=0;j<2;j++) {
				tableroInfo3[i][j]="[-]";
			}
		}
		String [][] tableroInfo9;
		tableroInfo9=new String[10][10];
		for(int i=0;i<1;i++) {
			for(int j=0;j<5;j++) {
				tableroInfo9[i][j]="[-]";
			}
		}
		assertNotEquals(tablero, tableroInfo3);
		assertNotEquals(tablero, tableroInfo9);
		String [][] tableroInfo4;
		tableroInfo4=new String[10][10];
		for(int i=0;i<1;i++) {
			for(int j=0;j<9;j++) {
				tableroInfo4[i][j]="[-]";
			}
		}
		
		assertNotEquals(tablero, tableroInfo4);
		String [][] tableroInfo5;
		tableroInfo5=new String[10][10];
		for(int i=0;i<1;i++) {
			for(int j=0;j<10;j++) {
				tableroInfo5[i][j]="[-]";
			}
		}
		assertEquals("[-]", tableroInfo5[0][0]);
		assertNotEquals("[-]", tableroInfo5[9][9]);
		assertNotEquals("[-]", tableroInfo5[5][4]);
		assertNotEquals(tablero, tableroInfo5);
		String [][] tableroInfo6;
		tableroInfo6=new String[10][10];
		for(int i=0;i<2;i++) {
			for(int j=0;j<10;j++) {
				tableroInfo6[i][j]="[-]";
			}
		}
		assertEquals("[-]", tableroInfo6[0][0]);
		assertNotEquals("[-]", tableroInfo6[9][9]);
		assertNotEquals("[-]", tableroInfo6[5][4]);
		assertNotEquals(tablero, tableroInfo6);
		String [][] tableroInfo10;
		tableroInfo10=new String[10][10];
		for(int i=0;i<5;i++) {
			for(int j=0;j<10;j++) {
				tableroInfo10[i][j]="[-]";
			}
		}
		assertEquals("[-]", tableroInfo10[0][0]);
		assertNotEquals("[-]", tableroInfo10[9][9]);
		assertNotEquals("[-]", tableroInfo10[5][4]);
		assertNotEquals(tablero, tableroInfo10);
		String [][] tableroInfo7;
		tableroInfo7=new String[10][10];
		for(int i=0;i<9;i++) {
			for(int j=0;j<10;j++) {
				tableroInfo7[i][j]="[-]";
			}
		}
		
		assertNotEquals(tablero, tableroInfo7);
		String [][] tableroInfo8;
		tableroInfo8=new String[10][10];
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				tableroInfo8[i][j]="[-]";
			}
		}
		assertEquals("[-]", tableroInfo7[0][0]);
		assertNotEquals("[-]", tableroInfo7[9][9]);
		assertEquals("[-]", tableroInfo7[5][4]);
		assertEquals(tablero, tableroInfo8);
		assertEquals("[-]", tableroInfo8[0][0]);
		assertEquals("[-]", tableroInfo8[0][9]);
		assertEquals("[-]", tableroInfo8[9][0]);
		assertEquals("[-]", tableroInfo8[9][9]);
		assertEquals("[-]", tableroInfo8[5][4]);
	}
	@Test
	public void testDisparar() {
		//Black box tests with limit values and frontier values
		Board b = new Board();
		Player p1 = new Player();
		p1.iniciarTableroInfo();
		String [][] tablero=p1.getTableroInfo();
		p1.disparar(b, 0, 0);
		assertFalse(p1.disparar(b, 9, 9));
		p1.disparar(b, 5, 4);
		p1.disparar(b, 13, 3);
		assertEquals("[O]", tablero[0][0]);
		assertEquals("[-]", tablero[0][9]);
		assertEquals("[-]", tablero[9][0]);
		assertEquals("[O]", tablero[9][9]);
		assertEquals("[O]", tablero[5][4]);
		//White box tests
		p1.getTablero().insertBoatLastPosition(0, 8, 4, 8, 5);
		//Included More frontier values
		System.out.println(b.mostrarTablero()+"aaaa");
		p1.disparar(p1.getTablero(), 0, 8);
		assertEquals("[X]", tablero[0][8]);
		assertFalse(p1.disparar(p1.getTablero(), 0, 14));
		assertFalse(p1.disparar(p1.getTablero(), -1, 14));
		assertFalse(p1.disparar(p1.getTablero(), 0, -9));
		assertFalse(p1.disparar(p1.getTablero(), -2, -3));
		assertFalse(p1.disparar(p1.getTablero(), 14, 14));
		p1.disparar(p1.getTablero(), 0, 8);
		assertFalse(p1.disparar(p1.getTablero(), 0, 8));
		Player p = new Player();
		p.getTablero().insertBoatLastPosition(1, 0, 1, 4, 5);
		p.getTablero().insertBoatLastPosition(9, 1, 9, 4, 4);
		p.getTablero().insertBoatfirstpos(5, 5, 1);
		
		p.disparar(p.getTablero(), 5, 5);
		assertFalse(p.getTablero().isEveryBoatSunk());
		
		p.disparar(p.getTablero(), 9, 1);
		p.disparar(p.getTablero(), 9, 2);
		p.disparar(p.getTablero(), 9, 3);
		p.disparar(p.getTablero(), 9, 4);
		assertFalse(p.getTablero().isEveryBoatSunk());
		
		p.disparar(p.getTablero(), 1, 0);
		p.disparar(p.getTablero(), 1, 1);
		p.disparar(p.getTablero(), 1, 2);
		p.disparar(p.getTablero(), 1, 3);
		p.disparar(p.getTablero(), 1, 4);
		
		
	}
	@Test
	public void testsetygetNombre() {
		Player b = new Player();
		b.setNombre("Arnau");
		String res_0 = "Arnau";
		assertEquals(res_0,b.getNombre());
	}

	@Test
	public void testsetygetTurno() {
		Player b = new Player();
		b.setTurno(1);
		int res_0 = 1;
		assertEquals(res_0,b.getTurno());
	}



}
