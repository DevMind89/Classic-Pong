package juego;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Pelota 
{
	public int x;
	public int y;
	public int dx = 1, dy = 1; //Sumador de las posciones x e y
	private final int ANCHO = 15, ALTO = 15;//Ancho y alto de la pelota
	
	private Integer  jugador1 = 0, jugador2 = 0;
	public static boolean finJuego = false;
	
	public Pelota(int x,int y) //Posiciones
	{
		this.x = x;
		this.y = y;
	}
	
	public Rectangle2D getPelota()
	{
		return new Rectangle2D.Double(x,y,ANCHO,ALTO);
	}
	
	//Le pasamos como parametro una variable para saber el limite del Tablero
	// Y las posiciones de las raquetas
	public void movimiento(Rectangle limites, boolean colisionRaqueta1, boolean colisionRaqueta2)
	{
		x+=dx;
		y+=dy;
		
		if(colisionRaqueta1)//Si hay colision con la raqueta 1 cambia movimiento
		{
			dx = -dx;
			x = 25; 
		}
		
		if(colisionRaqueta2)//Si hay colision con la raqueta 2 cambia movimiento
		{
			dx = -dx;
			x = 750; 
		}		
		
		if(x>limites.getMaxX()){dx = -dx; jugador1++;x=380;y=220;} //Al meter punto empezar en el centro
		
		if(y>limites.getMaxY()){dy = -dy;}		
		
		if(x<0){dx = -dx; jugador2++;x=380;y=220;}		
		
		if(y<0){dy=-dy;}
	}
	
	public int getJugador1()
	{
		return jugador1;		
	}
	
	public int getJugador2()
	{
		return jugador2;		
	}
}
