package juego;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Raquetas
{
	public int x,y;
	static final int ANCHO = 15, ALTO = 60;
	
	public Raquetas(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Rectangle2D getRaquetas()
	{
		return new Rectangle2D.Double(x,y,ANCHO,ALTO);
	}
	
	public void movimientoRaqueta1(Rectangle limites)
	{
		if(movimientoRaquetas.teclaW && y > limites.getMinY())//Si la tecla pulsa es W, la raqueta subira
		{
			y--; //Su posicion se resta para subir la raqueta
		}
		
		if(movimientoRaquetas.teclaS && y < limites.getMaxY()-ALTO)//Si la tecla pulsa es S, la raqueta bajara
		{
			y++; //Su posicion se suma para bajar la raqueta
		}
	}
	
	public void movimientoRaqueta2(Rectangle limites)
	{
		if(movimientoRaquetas.teclaArriba && y > limites.getMinY())//Si la tecla pulsa es flecha arribba, la raqueta subira
		{
			y--; //Su posicion se resta para subir la raqueta
		}
		
		if(movimientoRaquetas.teclaAbajo && y < limites.getMaxY()-ALTO)//Si la tecla pulsa es flecha abajo, la raqueta bajara
		{
			y++; //Su posicion se suma para bajar la raqueta
		}
	}
}
