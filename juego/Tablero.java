package juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.JPanel;

public class Tablero extends JPanel
{
	Pelota pelota = new Pelota(380,220);
	Raquetas raqueta1 = new Raquetas(10, 200);
	Raquetas raqueta2 = new Raquetas(794-10-Raquetas.ANCHO, 200); //Tamaño de nuestro frame menos el tamaño de la raqueta
	
	public Tablero()
	{
		setBackground(Color.black);		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;//Para trabajar con la clase graphics 2d //Mas funcionalidades
		g2.setColor(Color.white);
		dibujar(g2);
		puntuacion(g2);
		actualizar();
	}
	
	public void dibujar(Graphics2D g)
	{
		g.fill(pelota.getPelota());//Coge el valor retorna de nuestra pelota
		g.fill(raqueta1.getRaquetas());
		g.fill(raqueta2.getRaquetas());
	}
	
	public void actualizar()//Actualizar las posiciones de las raquetas
	{
		pelota.movimiento(getBounds(),colision(raqueta1.getRaquetas()),colision(raqueta2.getRaquetas()));//Posiciones de las raquetas
		raqueta1.movimientoRaqueta1(getBounds());//Recoge el tamaño deL JFrame
		raqueta2.movimientoRaqueta2(getBounds());
	}
	
	public void repetirJuego()//Movimientos de los elementos Graphics
	{		
		while(true)
		{
			repaint();
			try 
			{
				Thread.sleep(4);	
			}catch (InterruptedException e) {e.printStackTrace();}
		}		
	}
	
	private boolean colision(Rectangle2D r)//Determinar si dos rectangulos se cruzan
	{
		return pelota.getPelota().intersects(r);
	}
	
	private void puntuacion(Graphics2D g) 
	{
        Graphics2D g1 = g, g2 = g;
        Font puntuacion = new Font("Arial", Font.BOLD, 30);
        g.setFont(puntuacion);

        g1.drawString(Integer.toString(pelota.getJugador1()), (float) getBounds().getCenterX() - 50, 30);
        g2.drawString(Integer.toString(pelota.getJugador2()), (float) getBounds().getCenterX() + 25, 30);
        
        if (pelota.getJugador1() == 5) 
        {
            g.drawString("GANÓ El JUGADOR 1", (float) getBounds().getCenterX() - 180, (float) getBounds().getCenterY() - 100);
            Pelota.finJuego = true;
        }
        
        if (pelota.getJugador2() == 5)
        {
            g.drawString("GANÓ EL JUGADOR 2", (float) getBounds().getCenterX() - 180, (float) getBounds().getCenterY() - 100);
            Pelota.finJuego = true;
        }  
        
        if(Pelota.finJuego)
        {
        	pelota.x=380;
    		pelota.y=1500;
    		raqueta1.x=10;
    		raqueta1.y=200;
    		raqueta2.x=774;
    		raqueta2.y=200;
        }
    }
}
