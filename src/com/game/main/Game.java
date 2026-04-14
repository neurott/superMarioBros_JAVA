package com.game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.game.gfx.Windows;
import com.game.object.util.Handler;

public class Game extends Canvas implements Runnable {
	
	//game constant
	private static final int MILLIS_PER_SEC = 1000;
	private static final int NANOS_PER_SEC = 1000000000;
	private static final double NUM_TICKS = 60.0;
	private static final String NAME = "Super Mario Bros";
	
	private static final int WINDOW_WIDTH = 960;
	private static final int WINDOW_HEIGHT = 720;
	//game variables
	private boolean running;
	
	
	//game components
	private Thread thread;
	
	private Handler handler;

	public Game() {
		initialize();
	}
	
	public static void main(String[] args) {
		new Game();
		
	}
	
	private void initialize() {
		handler = new Handler();
		new Windows(WINDOW_WIDTH, WINDOW_HEIGHT, NAME, this);
		start();
	}
	
	private synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	
	private synchronized void stop() {
		try {
			thread.join();
			running = false;

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = NUM_TICKS;
		double ns = NANOS_PER_SEC / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		int updates = 0;
		
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >=1) {
				tick();
				updates++;
				delta --;
			}
			
			if (running) {
				render();
				frames++;
			}
			
			
			
			if (System.currentTimeMillis() - timer > MILLIS_PER_SEC) {
				timer += MILLIS_PER_SEC;
				System.out.println("FPS: " + frames + " TPS: " + updates);
				updates = 0;
				frames = 0;
			}
		}
		
		stop();
		
		
	}
	
	private void tick() {
		handler.tick();
	}

	private void render() { // lo llaman en el game loop
		
	
		BufferStrategy buf = this.getBufferStrategy(); /// its sort of a way to
		//create multiple frames
		if(buf == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		//dibujando los graphics /
		Graphics g = buf.getDrawGraphics(); // its the thing that we draw onto
		
		handler.render(g);
		g.setColor(Color.BLACK);// set the colors ot he graphics black
		
		g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT); //crea un rectangulo en este grafic
		// y usa el color q tu le pasai
		
		//clean for next frame
		g.dispose(); 
		// limpia el objeto graphic
		
		buf.show();// renders the next buffer thats in the buffer strategy or the next frame
		
	}
	
	public static int getWindowHeight() {
		return WINDOW_HEIGHT;
	}
	
	public static int getWindowWidth() {
		return WINDOW_WIDTH;
	}
	
	
	
}

