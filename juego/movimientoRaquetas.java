package juego;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class movimientoRaquetas extends KeyAdapter //Esta clase nos permite saber que tecla a sido pulsada
{
	static boolean teclaW, teclaS, teclaArriba, teclaAbajo;
	
	public void keyPressed(KeyEvent e)//Reconoce cuando pulsamos una tecla
	{
		int id = e.getKeyCode();//Almacena el codigo de la letra presionada
		
		if(id == KeyEvent.VK_W){ teclaW = true;}
		
		if(id == KeyEvent.VK_S){ teclaS = true;}
		
		if(id == KeyEvent.VK_UP){ teclaArriba = true;}
		
		if(id == KeyEvent.VK_DOWN){ teclaAbajo = true;}
	}
	
	public void keyReleased(KeyEvent e)//Reconoce cuando soltamos una tecla
	{
		int id = e.getKeyCode();
		
		if(id == KeyEvent.VK_W){ teclaW = false;}
		
		if(id == KeyEvent.VK_S){ teclaS = false;}
		
		if(id == KeyEvent.VK_UP){ teclaArriba = false;}
		
		if(id == KeyEvent.VK_DOWN){ teclaAbajo = false;}
	}
}
