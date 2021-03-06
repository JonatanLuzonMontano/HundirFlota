package HundirFlota;

import static org.junit.Assert.*;


import org.junit.Assert;
import org.junit.Test;
	
public class BoardTest {

	@Test
	public void testIniciar() {
		Board b=new Board();
		int num_filas=10;
		int num_columnas=10;
		int[][] tablero=b.getTablero();
		assertEquals(num_filas, tablero.length);
		assertEquals(num_columnas, tablero[0].length);
		assertEquals(num_columnas, tablero[9].length);
		assertEquals(num_columnas, tablero[5].length);
		//limit and frontier values
		assertEquals(0, tablero[0][0]);
		assertEquals(0, tablero[0][9]);
		assertEquals(0, tablero[9][0]);
		assertEquals(0, tablero[9][9]);
		assertEquals(0, tablero[5][4]);
		
		//Loop testing
		int[][] Tablero2;
		Tablero2=new int[10][10];
		for(int i=0;i<1;i++) {
			for(int j=0;j<1;j++) {
				Tablero2[i][j]=0;
			}
		}
		assertNotEquals(tablero,Tablero2);
		int[][] Tablero3;
		Tablero3=new int[10][10];
		for(int i=0;i<1;i++) {
			for(int j=0;j<2;j++) {
				Tablero3[i][j]=0;
			}
		}
		int[][] Tablero10;
		Tablero10=new int[10][10];
		for(int i=0;i<1;i++) {
			for(int j=0;j<5;j++) {
				Tablero10[i][j]=0;
			}
		}
		assertNotEquals(tablero,Tablero10);
		int[][] Tablero4;
		Tablero4=new int[10][10];
		for(int i=0;i<1;i++) {
			for(int j=0;j<9;j++) {
				Tablero4[i][j]=0;
			}
		}assertNotEquals(tablero,Tablero4);
		int[][] Tablero5;
		Tablero5=new int[10][10];
		for(int i=0;i<1;i++) {
			for(int j=0;j<10;j++) {
				Tablero5[i][j]=0;
			}
		}assertNotEquals(tablero,Tablero5);
		int[][] Tablero6;
		Tablero6=new int[10][10];
		for(int i=0;i<2;i++) {
			for(int j=0;j<10;j++) {
				Tablero6[i][j]=0;
			}
		}assertNotEquals(tablero,Tablero6);
		int[][] Tablero9;
		Tablero9=new int[10][10];
		for(int i=0;i<5;i++) {
			for(int j=0;j<10;j++) {
				Tablero9[i][j]=0;
			}
		}
		assertNotEquals(tablero,Tablero9);
		int[][] Tablero7;
		Tablero7=new int[10][10];
		for(int i=0;i<9;i++) {
			for(int j=0;j<10;j++) {
				Tablero7[i][j]=0;
			}
		}assertNotEquals(tablero,Tablero7);
		int[][] Tablero8;
		Tablero8=new int[10][10];
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				Tablero8[i][j]=0;
			}
		}assertEquals(tablero,Tablero8);
	}
	@Test
	public void testGetBarcos(){
		//Used mock Object to set boats in a board
		MockOb2 mock=new MockOb2();
		Board b = new Board();
		b.insertBoatLastPosition(1, 0, 1, 4, 5);
		b.insertBoatLastPosition(9, 1, 9, 4, 4);
		b.insertBoatfirstpos(5, 5, 1);
		assertNotNull(b.getBarcos());
		assertEquals(b.getBarcos().get(0).getTypeOfBoat(),mock.getBarco(0).getTypeOfBoat());
		assertEquals(b.getBarcos().get(1).getTypeOfBoat(),mock.getBarco(1).getTypeOfBoat());
		assertEquals(b.getBarcos().get(2).getTypeOfBoat(),mock.getBarco(2).getTypeOfBoat());
		
	}
	@Test
	public void testgetBarco() {
		Board b = new Board();
		b.insertBoatLastPosition(1, 0, 1, 4, 5);
		b.insertBoatLastPosition(9, 1, 9, 4, 4);
		b.insertBoatfirstpos(5, 5, 1);
		assertEquals(b.getBarco(1, 0),b.getBarcos().get(0));
		assertEquals(b.getBarco(1, 4),b.getBarcos().get(0));
		assertEquals(b.getBarco(1, 2),b.getBarcos().get(0));
		assertEquals(b.getBarco(0, 0),null);
		assertEquals(b.getBarco(0, 0),null);
		assertNotEquals(b.getBarco(5, 5),b.getBarcos().get(1));
		//Limit values
		assertEquals(b.getBarco(9, 1),b.getBarcos().get(1));
		assertEquals(b.getBarco(9, 3),b.getBarcos().get(1));
		assertEquals(b.getBarco(9, 4),b.getBarcos().get(1));
		//White box test
		assertEquals(b.getBarco(9, 0),null);
		assertEquals(b.getBarco(8, 1),null);
		assertNotEquals(b.getBarco(7, 6),b.getBarcos().get(1));
		
		assertEquals(b.getBarco(5, 5),b.getBarcos().get(2));
		assertEquals(b.getBarco(6, 6),null);
		assertEquals(b.getBarco(4, 4),null);
		assertNotEquals(b.getBarco(1, 0),b.getBarcos().get(1));	
	}
	@Test
	public void testGet() {
		Board b=new Board();
		assertEquals(b.getFilas(), 10);
		assertEquals(b.getColumnas(), 10);
	}
	
	//First implementation of Create Boats test (After creating this test, we make the full function
	// on Board.java but the test find errors always)
	public void testcrear() {
		Board b=new Board();
		//b.CrearBarcos();
		//Esta funcion debe interactuar por consola con el usuario
		//Como comprobar que el tablero esta correctamente ocupado, necesitamos saber
		//La decision del usuario
		//int[][] tablero=b.getTablero();
		/*
		assertEquals(1, tablero[0][0]);
		assertEquals(1, tablero[0][9]);
		assertEquals(1, tablero[9][0]);
		assertEquals(1, tablero[9][9]);
		assertEquals(1, tablero[5][4]);
		*/
		int pos=b.posicionesOcupadas();
		assertEquals(pos, 27);
	}
	@Test
	public void testMostrarTablero() {
		String res_0="\n    0:1:2:3:4:5:6:7:8:9\n\n"
				+  "0:  0 0 0 0 0 0 0 0 0 0 \n"
				+  "1:  0 0 0 0 0 0 0 0 0 0 \n"
				+  "2:  0 0 0 0 0 0 0 0 0 0 \n"
				+  "3:  0 0 0 0 0 0 0 0 0 0 \n"
				+  "4:  0 0 0 0 0 0 0 0 0 0 \n"
				+  "5:  0 0 0 0 0 0 0 0 0 0 \n"
				+  "6:  0 0 0 0 0 0 0 0 0 0 \n"
				+  "7:  0 0 0 0 0 0 0 0 0 0 \n"
				+  "8:  0 0 0 0 0 0 0 0 0 0 \n"
				+  "9:  0 0 0 0 0 0 0 0 0 0 \n";
		Board tablero= new Board();
		Assert.assertEquals(tablero.mostrarTablero(), res_0);
		
	}
	@Test
	public void testPosicionesOcupadas() {
		MockOb mock=new MockOb();
		Board b = new Board();
		int[][] a=mock.getTablero(0);
		b.setTablero(a);
		int pos=b.posicionesOcupadas();
		assertEquals(pos,0);
		Board b2 = new Board();
		int[][] c=mock.getTablero(1);
		b2.setTablero(c);
		int pos2=b2.posicionesOcupadas();
		assertEquals(pos2,5);
		Board b3 = new Board();
		int[][] d=mock.getTablero(2);
		b3.setTablero(d);
		int pos3=b3.posicionesOcupadas();
		assertEquals(pos3,10);
		Board b4 = new Board();
		int[][] f=mock.getTablero(3);
		b4.setTablero(f);
		int pos4=b4.posicionesOcupadas();
		assertEquals(pos4,4);
		
	}
	
	@Test
	public void testInsertBoats1() {
		Board b=new Board();
		//When Board is empty
		boolean res=b.insertBoatfirstpos(0, 0, 5);
		assertTrue(res);
		//Limit values
		boolean res2=b.insertBoatfirstpos(0, 9, 5);
		assertTrue(res2);
		boolean res3=b.insertBoatfirstpos(9, 0, 5);
		assertTrue(res3);
		boolean res4=b.insertBoatfirstpos(9, 9, 5);
		assertTrue(res4);
		boolean res5=b.insertBoatfirstpos(4, 5, 5);
		assertTrue(res5);
		//Frontier values + White box test
		boolean res6=b.insertBoatfirstpos(-1, 0, 5);
		assertFalse(res6);
		boolean res7=b.insertBoatfirstpos(0, 10, 5);
		assertFalse(res7);
		boolean res8=b.insertBoatfirstpos(10, 0, 5);
		assertFalse(res8);
		boolean res9=b.insertBoatfirstpos(0, 10, 5);
		assertFalse(res9);
		boolean res20=b.insertBoatfirstpos(-1, -1, 5);
		assertFalse(res20);
		boolean res22=b.insertBoatfirstpos(10, 10, 5);
		assertFalse(res22);
		boolean res23=b.insertBoatfirstpos(0, -4, 5);
		assertFalse(res23);
		//When the position choosed is occupied
		MockOb mock=new MockOb();
		int[][] a=mock.getTablero(1);
		b.setTablero(a);
		boolean res10=b.insertBoatfirstpos(0, 1 ,4);
		assertFalse(res10);
		boolean res11=b.insertBoatfirstpos(0, 4, 4);
		assertFalse(res11);
		boolean res12=b.insertBoatfirstpos(0, 5, 4);
		assertTrue(res12);
		boolean res13=b.insertBoatfirstpos(9, 9, 1);
		assertTrue(res13);
		//Integration proves
		MockOb mock2=new MockOb();
		int[][] a2=mock2.getTablero(2);
		b.setTablero(a2);
		boolean value6=b.insertBoatfirstpos(0, 7, 5);	
		assertFalse(value6);
		boolean value2=b.insertBoatfirstpos(1, 0, 5);
		assertFalse(value2);
		boolean value7=b.checkSpace(0, 9, 5);
		assertFalse(value7);				
		boolean value8=b.checkSpace(9, 0, 5);
		assertTrue(value8);
		boolean value9=b.checkSpace(9, 4, 5);
		assertTrue(value9);		
		boolean value10=b.checkSpace(9, 9, 5);
		assertTrue(value10);
		boolean value11=b.checkSpace(9, 9, 1);
		assertTrue(value11);
	}
	@Test
	public void testCheckSpace() {
		//The user can not put boats together in the same direction
		Board b=new Board();
		MockOb mock=new MockOb();
		int[][] a=mock.getTablero(2);
		b.setTablero(a);
		System.out.println(b.mostrarTablero());
		//Portaviones
		boolean value=b.checkSpace(0, 5, 5);  //vertical space from first line true (nearest to another boat)
		assertTrue(value);
		boolean value5=b.checkSpace(0, 6, 5);	//vertical space from first line true
		assertTrue(value5);
		boolean value6=b.checkSpace(0, 7, 5);	//vertical space from first line (with another boat at the same direction in the right column)
		assertFalse(value6);
		boolean value2=b.checkSpace(1, 0, 5);		//horizontal space false (another boat at the same direction in a line updown)
		assertFalse(value2);
		boolean val=b.checkSpace(1, 1, 5);		//horizontal space true (another boat at the same direction in a line updown)
		assertTrue(val);
		//At this point we discover that the checkSpaceTest has to be called from the insert
		//boatFirstPosition to tell the user if the boat can be landed there although the 
		//firstPosition is empty
		//Knowing that, we can reduce the test to values inside the limits of the board, the other values
		//are checked in the function InsertBoatFirstPosition
		
		//Testing the coverage of the board class at this point we can see that this function is coverage
		//at 55 per cent, so we have to add more sentences to complete the full coverage
		
		//Limit values
		//And white box tests
		//vertical space left false
		boolean value7=b.checkSpace(0, 9, 5);
		assertFalse(value7);
		
		//vertical space from last line true
		boolean value8=b.checkSpace(9, 0, 5);
		assertTrue(value8);
		
		//vertical space from a middle line true
		boolean value9=b.checkSpace(9, 4, 5);
		assertTrue(value9);
		
		//Horizontal space from last line true
		boolean value10=b.checkSpace(9, 9, 5);
		assertTrue(value10);
		
		////Horizontal space from middle line left true
		boolean value11=b.checkSpace(7, 6, 5);
		assertTrue(value11);
		
		//New board to test the other cases
		Board b2=new Board();
		MockOb mock2=new MockOb();
		int[][] a2=mock2.getTablero(4);
		b2.setTablero(a2);
		System.out.println(b2.mostrarTablero());
		
		//Horizontal space left line false up
		boolean value12=b2.checkSpace(3, 9, 5);
		assertFalse(value12);
				
		////Horizontal space left line down false
		boolean value13=b2.checkSpace(5, 9, 5);
		assertFalse(value13);
		
		//vertical space left false from down
		boolean value14=b2.checkSpace(8, 0, 5);
		assertFalse(value14);
				
		//vertical space right from down false
		boolean value15=b2.checkSpace(8, 2, 5);
		assertFalse(value15);
				
		//horizontal space up right false
		boolean value16=b2.checkSpace(1, 1, 5);
		assertFalse(value16);
		
		//at this point we need to check the true cases at the conditions
		//White box tests
		
		//Horizontal space left line true up
		boolean value17=b2.checkSpace(3, 8, 5);
		assertTrue(value17);
				
		//Horizontal space left line down true
		boolean value18=b2.checkSpace(5, 8, 5);
		assertTrue(value18);
		
		//vertical space left true from true
		boolean value19=b2.checkSpace(7, 0, 5);
		assertTrue(value19);
				
		//vertical space right from down true
		boolean value20=b2.checkSpace(7, 2, 5);
		assertTrue(value20);
				
		//horizontal space up right true
		boolean value21=b2.checkSpace(0, 1, 5);
		assertTrue(value21);

		boolean value22=b2.checkSpace(5, 0, 5);
		assertTrue(value22);

		boolean value23=b2.checkSpace(5, 2, 5);
		assertTrue(value23);
		
		
		//Horizontal space right line true up
		boolean value24=b2.checkSpace(3, 4, 5);
		assertTrue(value24);
				
		//Horizontal space right line down true
		boolean value25=b2.checkSpace(5, 4, 5);
		assertTrue(value25);
		
		//So after adding more cases to get full coverage, we need to check for the other types of boats
		
	}
	@Test
	public void testCheckSpace2() {
		//The user can not put boats together in the same direction
		//More white box test to coverage with the new boats
		//Black Box tests included
		Board b=new Board();
		MockOb mock=new MockOb();
		int[][] a=mock.getTablero(5);
		b.setTablero(a);
		System.out.println(b.mostrarTablero());
		//Buque (4 positions)
		boolean value=b.checkSpace(0, 5, 4);  //vertical space from first line true (nearest to another boat)
		assertTrue(value);
		boolean value5=b.checkSpace(0, 6, 4);	//vertical space from first line true
		assertTrue(value5);
		boolean value6=b.checkSpace(0, 7, 4);	//vertical space from first line (with another boat at the same direction in the right column)
		assertFalse(value6);
		boolean value2=b.checkSpace(1, 0, 4);		//horizontal space false (another boat at the same direction in a line updown)
		assertFalse(value2);
		boolean val=b.checkSpace(1, 1, 4);		//horizontal space true (another boat at the same direction in a line updown)
		assertTrue(val);
		
		//vertical space left false
		boolean value7=b.checkSpace(0, 9, 4);
		assertFalse(value7);
		
		//vertical space from last line true
		boolean value8=b.checkSpace(9, 0, 4);
		assertTrue(value8);
		
		//vertical space from a middle line true
		boolean value9=b.checkSpace(9, 4, 4);
		assertTrue(value9);
		
		//Horizontal space from last line true
		boolean value10=b.checkSpace(9, 9, 4);
		assertTrue(value10);
		
		////Horizontal space from middle line left true
		boolean value11=b.checkSpace(7, 6, 4);
		assertTrue(value11);
		
		//New board to test the other cases
		Board b2=new Board();
		MockOb mock2=new MockOb();
		int[][] a2=mock2.getTablero(6);
		b2.setTablero(a2);
		System.out.println(b2.mostrarTablero());
		
		//Horizontal space left line false up
		boolean value12=b2.checkSpace(3, 8, 4);
		assertFalse(value12);
				
		////Horizontal space left line down false
		boolean value13=b2.checkSpace(5, 8, 4);
		assertFalse(value13);
		
		//vertical space left false from down
		boolean value14=b2.checkSpace(7, 0, 4);
		assertFalse(value14);
				
		//vertical space right from down false
		boolean value15=b2.checkSpace(7, 2, 4);
		assertFalse(value15);
				
		//horizontal space up right false
		boolean value16=b2.checkSpace(1, 1, 4);
		assertFalse(value16);
		
		//Horizontal space left line true up
		boolean value17=b2.checkSpace(3, 9, 4);
		assertTrue(value17);
				
		//Horizontal space left line down true
		boolean value18=b2.checkSpace(5, 9, 4);
		assertTrue(value18);
		
		//vertical space left true from true
		boolean value19=b2.checkSpace(8, 0, 4);
		assertTrue(value19);
				
		//vertical space right from down true
		boolean value20=b2.checkSpace(8, 2, 4);
		assertTrue(value20);
				
		//horizontal space up right true
		boolean value21=b2.checkSpace(0, 1, 4);
		assertTrue(value21);

		boolean value22=b2.checkSpace(5, 2, 4);
		assertTrue(value22);
		

		boolean value23=b2.checkSpace(5, 0, 4);
		assertTrue(value23);
		
		
		//Horizontal space right line true up
		boolean value24=b2.checkSpace(3, 4, 4);
		assertTrue(value24);
				
		//Horizontal space right line down true
		boolean value25=b2.checkSpace(5, 4, 4);
		assertTrue(value25);
		
	}
	
	@Test
	public void testCheckSpace3() {
		//The user can not put boats together in the same direction
		Board b=new Board();
		MockOb mock=new MockOb();
		int[][] a=mock.getTablero(6);
		b.setTablero(a);
		System.out.println(b.mostrarTablero());
		//Limit values
		//Lancha (1 position)
		boolean value=b.checkSpace(0, 0, 1);  //Corner
		assertTrue(value);
		boolean value5=b.checkSpace(0, 9, 1);	//Corner
		assertTrue(value5);
		boolean value6=b.checkSpace(9, 9, 1);	//Corner
		assertTrue(value6);
		boolean value2=b.checkSpace(1, 6, 1);		//MidValue
		assertTrue(value2);
		boolean val=b.checkSpace(3, 2, 1);		//Boat up there
		assertFalse(val);
		boolean val2=b.checkSpace(3, 7, 1);		//Boat down there
		assertFalse(val2);
		boolean val6=b.checkSpace(6, 2, 1);		//Boat left there
		assertFalse(val6);
		boolean val7=b.checkSpace(6, 0, 1);		//Boat right there
		assertFalse(val7);
		boolean val8=b.checkSpace(4, 0, 5);		
		assertTrue(val8);
		//White box tests
		boolean val9=b.checkSpace(5, 0, 5);		
		assertTrue(val9);
		boolean val10=b.checkSpace(4, 0, 5);		
		assertTrue(val10);
		boolean val11=b.checkSpace(3, 0, 4);		
		assertTrue(val11);
		boolean val12=b.checkSpace(3, 0, 3);		
		assertTrue(val12);
		boolean val13=b.checkSpace(2, 0, 0);		
		assertFalse(val13);
		boolean val15=b.checkSpace(3, 0, 5);		
		assertTrue(val15);
		boolean val16=b.checkSpace(3, 2, 5);		
		assertTrue(val16);
		boolean val17=b.checkSpace(2, 6, 5);		
		assertTrue(val17);
		boolean val18=b.checkSpace(2, 0, 5);		
		assertFalse(val18);
		boolean val19=b.checkSpace(3, 0, 4);		
		assertTrue(val19);
		boolean val20=b.checkSpace(4, 5, 4);		
		assertTrue(val20);
		boolean val22=b.checkSpace(6, 0, 4);		
		assertTrue(val22);
		boolean val21=b.checkSpace(5, 5, 4);		
		assertFalse(val21);
		boolean val23=b.checkSpace(5, 2, 4);		
		assertTrue(val23);
		System.out.println(b.mostrarTablero() + "PathCoverageTest");
		boolean val24=b.checkSpace(5, 6, 4);		
		assertTrue(val24);
		boolean val25=b.checkSpace(5, 5, 4);		
		assertFalse(val25);
		boolean val26=b.checkSpace(5, 8, 4);		
		assertFalse(val26);
		boolean val27=b.checkSpace(4, 2, 4);		
		assertFalse(val27);
		boolean val28=b.checkSpace(4, 0, 4);		
		assertFalse(val28);
		boolean val29=b.checkSpace(5, 0, 4);		
		assertTrue(val29);
		boolean val30=b.checkSpace(5, 4, 4);		
		assertTrue(val30);
		boolean val31=b.checkSpace(7, 2, 4);		
		assertFalse(val31);
		boolean val32=b.checkSpace(8, 2, 4);		
		assertTrue(val32);
		boolean val33=b.checkSpace(6, 2, 4);		
		assertTrue(val33);
		boolean val34=b.checkSpace(4, 9, 4);		
		assertTrue(val34);
		boolean val35=b.checkSpace(3, 5, 4);		
		assertFalse(val35);
		boolean val36=b.checkSpace(6, 5, 4);		
		assertTrue(val36);
		boolean val37=b.checkSpace(3, 5, 4);		
		assertFalse(val37);
		boolean val38=b.checkSpace(1, 5, 4);		
		assertTrue(val38);
		boolean val39=b.checkSpace(2, 5, 4);		
		assertTrue(val39);
		boolean val40=b.checkSpace(4, 5, 4);		
		assertTrue(val40);
	}
	
	@Test
	public void testInsertLastPos() {
		Board b=new Board();
		MockOb mock=new MockOb();
		int[][] a=mock.getTablero(2);
		b.setTablero(a);
		System.out.println(b.mostrarTablero());
		//Combinations of black box test, limit values, frontier values and white box tests
		//Aircraft carriers
		boolean value=b.insertBoatLastPosition(0, 5, 0, 9, 5);		//There is a boat there	
		assertFalse(value);
		boolean value5=b.insertBoatLastPosition(0, 6, 4, 6, 5);	
		assertTrue(value5);
		boolean value6=b.insertBoatLastPosition(6, 7, 6, 8, 5);  //Boat is bigger 	
		assertFalse(value6);
		boolean value2=b.insertBoatLastPosition(2, 0, 2, 9, 5);  //Boat is smaller			
		assertFalse(value2);
		boolean val=b.insertBoatLastPosition(0, 4, 0, 0, 5);	//There is a boat there		
		assertFalse(val);
		boolean val2=b.insertBoatLastPosition(3, 5, 3, 9, 5);	//There is a boat there		
		assertFalse(val2);
		boolean val3=b.insertBoatLastPosition(0, 2, 0, 6, 5);	
		assertFalse(val3);
		boolean val4=b.insertBoatLastPosition(6, 2, 6, 6, 5);	
		assertTrue(val4);
		boolean valfalse=b.insertBoatLastPosition(0, 10, 0, 6, 5);	
		assertFalse(valfalse);
		boolean valfalse2=b.insertBoatLastPosition(6, 2, 6, -3, 5);	
		assertFalse(valfalse2);
		boolean valfalse3=b.insertBoatLastPosition(6, 2, 6, 2, 5);	
		assertFalse(valfalse3);
		boolean valfalse6=b.insertBoatLastPosition(1, 2, 3, 4, 5);	
		assertFalse(valfalse6);
		boolean val5=b.insertBoatLastPosition(9, 9, 9, 5, 5);	
		assertTrue(val5);
		boolean valfalse4=b.insertBoatLastPosition(6, 2, 7, 2, 5);	
		assertFalse(valfalse4);
		System.out.println(b.mostrarTablero());
		boolean val6=b.insertBoatLastPosition(9, 1, 5, 1, 5);	
		assertTrue(val6);
		System.out.println(b.mostrarTablero());
		boolean val7=b.insertBoatLastPosition(6, 9, 6, 5, 5);	
		assertFalse(val7);
		boolean val8=b.insertBoatLastPosition(6, 9, 6, 6, 5);	
		assertFalse(val8);
		boolean val9=b.insertBoatLastPosition(3, 3, 3, 7, 5);	
		assertFalse(val9);
		boolean val10=b.insertBoatLastPosition(8, 8, 8, 7, 5);	
		assertFalse(val10);
		boolean val11=b.insertBoatLastPosition(4, 9, 4, 5, 5);	
		assertFalse(val11);
		//More white box tests
		Board b2=new Board();
		MockOb mock2=new MockOb();
		int[][] a2=mock2.getTablero(2);
		b2.setTablero(a2);
		System.out.println(b2.mostrarTablero());
		boolean val14=b2.insertBoatLastPosition(5, 0, 5, 4, 5);	
		assertTrue(val14);
		boolean val12=b2.insertBoatLastPosition(4, 3, 7, 3, 4);	
		assertFalse(val12);
		System.out.println(b2.mostrarTablero());
		boolean val13=b2.insertBoatLastPosition(6, 3, 3, 3, 4);	
		assertFalse(val13);
		boolean val15=b2.insertBoatLastPosition(6, 3, 4, 3, 4);	
		assertFalse(val15);
		boolean val16=b2.insertBoatLastPosition(6, 3, 6, 3, 4);	
		assertFalse(val16);
		//Combination of values
		boolean valfalse10=b.insertBoatLastPosition(6, 6, 6, 6, 5);	
		assertFalse(valfalse10);
		boolean valfalse11=b.insertBoatLastPosition(-1, 6, 6, 6, 5);	
		assertFalse(valfalse11);
		boolean valfalse12=b.insertBoatLastPosition(-1, -1, 6, 6, 5);	
		assertFalse(valfalse12);
		boolean valfalse13=b.insertBoatLastPosition(-1, -1, -1, -2, 5);	
		assertFalse(valfalse13);
		boolean valfalse14=b.insertBoatLastPosition(-1, -1, -1, -2, 5);	
		assertFalse(valfalse14);
		boolean valfalse15=b.insertBoatLastPosition(10, 6, 6, 6, 5);	
		assertFalse(valfalse15);
		boolean valfalse16=b.insertBoatLastPosition(10, 11, 6, 6, 5);	
		assertFalse(valfalse16);
		boolean valfalse17=b.insertBoatLastPosition(10, 11, 12, 6, 5);	
		assertFalse(valfalse17);
		boolean valfalse18=b.insertBoatLastPosition(10, 11, 12, 11, 5);	
		assertFalse(valfalse18);
		boolean valfalse19=b.insertBoatLastPosition(6, 11, 6, 11, 5);	
		assertFalse(valfalse19);
		boolean valfalse20=b.insertBoatLastPosition(6, 6, 6, 11, 5);	
		assertFalse(valfalse20);
		boolean valfalse21=b.insertBoatLastPosition(11, 6, 11, 6, 5);	
		assertFalse(valfalse21);
		boolean valfalse22=b.insertBoatLastPosition(11, 6, 11, 5, 5);	
		assertFalse(valfalse22);
		boolean valfalse23=b.insertBoatLastPosition(6, 11, 4, 12, 5);	
		assertFalse(valfalse23);
	}
	@Test
	public void testisEveryBoatSunk() {
		//Integration + black box test
		Player p = new Player();
		p.getTablero().insertBoatLastPosition(1, 0, 1, 4, 5);
		p.getTablero().insertBoatLastPosition(9, 1, 9, 4, 4);
		p.getTablero().insertBoatfirstpos(5, 5, 1);
		
		p.disparar(p.getTablero(), 5, 5);
		assertFalse(p.getTablero().isEveryBoatSunk());
		//White box tests
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
		assertTrue(p.getTablero().isEveryBoatSunk());
	}
	@Test
	public void testnumberOfBoatsAlive()  {
		//We create 1 aircraft, 2 vessels and 3 motor boats
		//Black box and white box tests
		Player p = new Player();
		p.getTablero().insertBoatLastPosition(1, 0, 1, 4, 5);
		p.getTablero().insertBoatLastPosition(7, 1, 7, 4, 4);
		p.getTablero().insertBoatLastPosition(9, 1, 9, 4, 4);
		p.getTablero().insertBoatfirstpos(5, 5, 1);
		p.getTablero().insertBoatfirstpos(0, 9, 1);
		p.getTablero().insertBoatfirstpos(3, 3, 1);
		System.out.println(p.getTablero().mostrarTablero());
		//We check that we initialized it properly
		int[] x = new int[3];
		x=p.getTablero().numberOfBoatsAlive();
		assertEquals(x[0],1);
		assertEquals(x[1],2);
		assertEquals(x[2],3);
		//We sunk a motor boat
		p.disparar(p.getTablero(), 5, 5);
		x=p.getTablero().numberOfBoatsAlive();
		assertEquals(x[0],1);
		assertEquals(x[1],2);
		assertEquals(x[2],2);
		//We sunk a motor boat
		p.disparar(p.getTablero(), 0, 9);
		x=p.getTablero().numberOfBoatsAlive();
		assertEquals(x[0],1);
		assertEquals(x[1],2);
		assertEquals(x[2],1);
		//We sunk 2 vessels
		p.disparar(p.getTablero(), 9, 1);
		p.disparar(p.getTablero(), 9, 2);
		p.disparar(p.getTablero(), 9, 3);
		p.disparar(p.getTablero(), 9, 4);
		
		p.disparar(p.getTablero(), 7, 1);
		p.disparar(p.getTablero(), 7, 2);
		p.disparar(p.getTablero(), 7, 3);
		p.disparar(p.getTablero(), 7, 4);
		x=p.getTablero().numberOfBoatsAlive();
		assertEquals(x[0],1);
		assertEquals(x[1],0);
		assertEquals(x[2],1);
		//We sunk a motor boat
		p.disparar(p.getTablero(), 3, 3);
		x=p.getTablero().numberOfBoatsAlive();
		assertEquals(x[0],1);
		assertEquals(x[1],0);
		assertEquals(x[2],0);

		//We sunk the aircraft
		p.disparar(p.getTablero(), 1, 0);
		p.disparar(p.getTablero(), 1, 1);
		p.disparar(p.getTablero(), 1, 2);
		p.disparar(p.getTablero(), 1, 3);
		p.disparar(p.getTablero(), 1, 4);
		x=p.getTablero().numberOfBoatsAlive();
		assertEquals(x[0],0);
		assertEquals(x[1],0);
		assertEquals(x[2],0);
		

	}
}
