package com.game.object;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.object.util.ObjectId;

public abstract class GameObject {
	
	//instanciar las variables
	private float x;
	private float y; // position of the game object x y
	private ObjectId id; // object type
	private float velX, velY; // som speed
	private float width, height; // how tall is the object or width
	private int scale; //scale on the width 
	
	public GameObject(float x, float y, ObjectId id, float width, float height, int scale) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.width = width * scale;
		this.height = height * scale;
		this.scale = scale;
	}
	

	public abstract void tick(); //update function, any positional update, any update
	public abstract void render(Graphics g); // hold all the graphics update
	public abstract Rectangle getBounds(); //Define the bounding box
	//applygravity function
	public void applyGravity() {
		velY += 0.5f; // increasing the velocity, how fast object moves
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}

	public void setId(ObjectId id) {this.id = id;}
	
	public void setVelX(float velX) {this.velX = velX;}
	
	public void setVelY(float velY) {this.velY = velY;}
	
	public void setWidth(float width) {this.width = width * scale;}
	
	public void setHeight(float height) {this.height = height*scale;}
	
	public void setScale(int scale) {this.scale = scale;}
	
	public float getX() {return x;}
	
	public float getY() {return y;}
	
	public ObjectId getId() {return id;}
	
	public float getVelX() {return velX;}
	
	public float getVelY() {return velY;}
	
	public float getWidth() {return width;}
	
	public float getHeight() {return height;}
	
	
}
