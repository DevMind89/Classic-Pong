package juego;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class Ventana extends JFrame
{
	private final int ANCHO = 800, ALTO = 500;
	private Tablero tablero;
	
	public Ventana()
	{
		setTitle("PONG");
		setSize(ANCHO,ALTO);
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/iconos/pong.png")));
		setLocationRelativeTo(null);
		setResizable(false);		
		tablero = new Tablero();
		add(tablero);
		addKeyListener(new movimientoRaquetas());//Llamar al movimiento de las raquetas
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		tablero.repetirJuego();
	}
}
