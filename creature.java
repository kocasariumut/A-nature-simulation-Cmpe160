package project;

import game.Direction;
import game.Drawable;
import naturesimulator.Action;
import naturesimulator.LocalInformation;
import ui.GridPanel;

/** @author Umut Kocasarý
 * 
 *  Includes common behaviors and fields of Creatures.
 *  Can not create an object of this class.This is
 *  just an interface for child classes. 
 */

public abstract class Creature implements Drawable{

	private int x; //x coordinate of creature
	private int y; //y coordinate of creature

	/**
	 * Helps to create a creature.
	 * @param x x coordinates of the creature
	 * @param y y coordinates of the creature
	 */

	public Creature(int x,int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Getter for x coordinate
	 * @return x coordinate
	 * 
	 */

	public int getX() {

		return this.x;
	}
	/**
	 * Getter for y coordinate
	 * @return y coordinate
	 * 
	 */

	public int getY() {

		return this.y;
	}

	/**
	 * Setter for x coordinate
	 * @param x new x coordinate of creature
	 * 
	 */

	public void setX(int x) {
		this.x = x;

	}

	/**
	 * Setter for y coordinate
	 * @param y new y coordinate of creature
	 * 
	 */
	public void setY(int y) {
		this.y = y;

	}
	/**
	 * Moves the creature to its new coordinates.
	 * @param direction the direction where creature goes
	 */

	public abstract void move(Direction direction);
	/**
	 * Provides to attack to a creature
	 * @param attackedCreature attackedCreature is the creature which is attacked.
	 */

	public abstract void attack(Creature attackedCreature);
	/**
	 * Draws the creature on the screen.
	 * @param panel panel the screen
	 * @see game.Drawable#draw(ui.GridPanel)
	 */

	public abstract void draw(GridPanel panel);
	/**
	 * Getter for health of creatures.
	 * @return health of creature.
	 */
	public abstract double getHealth();
	/**
	 * Setter for health of creatures.
	 * @param new health of creature
	 */
	public abstract void setHealth(double health);
	/**
	 * Chooses the action creature does.
	 * @param createLocalInformationForCreature information about the creature.
	 * @return action which will be done.
	 */
	public abstract Action chooseAction(LocalInformation createLocalInformationForCreature);
	/**
	 * Provides creature to stay.
	 */
	public abstract void stay();	
	/**
	 * Creates a new creature.
	 * @param direction the direction which new creature will be born.
	 * @return new born creature
	 */
	public abstract Creature reproduce(Direction direction);											

}
