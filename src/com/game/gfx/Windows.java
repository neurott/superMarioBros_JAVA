package com.game.gfx;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.game.main.Game;

//generar frames
public class Windows  {

	//variables
	// no puedo ver el tutorial y escribir en español sorry
	private JFrame frame; //frame of the window, holds our game
	
	private Dimension size; //it's an object that hold our width and
							//height the size for our game
	
	public Windows(int width, int height, String title, Game game) { // faltaba el canvas en la wea
		//initialize heightwidthsize
		
		size = new Dimension(width, height);
		frame = new JFrame(title);
		
		frame.setPreferredSize(size);// frame renders its set to that siuze
		frame.setMaximumSize(size);
		frame.setMinimumSize(size);// el maximo y el minimo po klsadjglkdas
		
		
		//esto crea la funcionalidad de cuando tu le des X a la ventana, se cierre
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //the x corner
		

		frame.setResizable(false); // no podemos resize la window
		
		frame.setLocationRelativeTo(null);//set the frame to the center of the screen
		//when it loads
		
		frame.add(game);// add the game to our frame
		frame.setVisible(true);
		
		
	}
}
