package project;

import java.awt.Color;

import game.Direction;
import naturesimulator.Action;
import naturesimulator.LocalInformation;
import ui.GridPanel;

public class Food extends Creature {

	private double health;
	
	public Food(int x,int y) {
		super(x,y);
		this.health = 1;
	}
	
	@Override
	public void move(Direction direction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack(Creature attackedCreature) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(GridPanel panel) {
		
		panel.drawSquare(this.getX(),this.getY(),new Color(200,220,0));
		
	}

	@Override
	public double getHealth() {
		// TODO Auto-generated method stub
		return this.health;
	}

	@Override
	public void setHealth(double health) {
		this.health = health;
		
	}

	@Override
	public Action chooseAction(LocalInformation createLocalInformationForCreature) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stay() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Creature reproduce(Direction direction) {
		// TODO Auto-generated method stub
		return null;
	}

}
