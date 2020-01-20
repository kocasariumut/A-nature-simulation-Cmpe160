package project;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



import game.Direction;
import game.Drawable;
import game.GridGame;
import naturesimulator.Action;
import naturesimulator.LocalInformation;
import ui.GridPanel;

public class Snake extends Creature implements Drawable{

	private static final int SIZE_SNAKE = 4;
	private List<Integer> listX;
	private List<Integer> listY;	
	private int size;
	private static int foodX=5;
	private static int foodY=5;

	public Snake(int x, int y) {
		super(x,y);
		listX = new LinkedList<Integer>();
		listY = new LinkedList<Integer>();
		size = SIZE_SNAKE;

		for(int i=0;i<SIZE_SNAKE;i++) {
			listX.add(i+1);
			listY.add(1);		
		}

	}

	@Override
	public void draw(GridPanel panel) {

		for(int i =0;i<this.size;i++) {
			if(i==this.size-1) {
				panel.drawSquare(listX.get(i), listY.get(i),new Color(250,0,0));
			}
			else {
				panel.drawSquare(listX.get(i), listY.get(i),new Color(0,0,200));
			}
		}
	}
	public static int getFoodX() {
		return foodX;
	}
	public static void setFoodX(int foodx) {
		foodX = foodx;
	}
	public static int getFoodY() {
		return foodY;
	}
	public static void setFoodY(int foody) {
		foodY = foody;
	}
	public int getSize() {
		return this.size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<Integer> getListX(){
		return this.listX;
	}	
	public List<Integer> getListY(){
		return this.listY;
	}
	@Override
	public Action chooseAction(LocalInformation createLocalInformationForCreature) {
		if(this.size==8) {
			return new Action(Action.Type.REPRODUCE);
		}

		else if(createLocalInformationForCreature.getCreatureDown() instanceof Food||createLocalInformationForCreature.getCreatureUp() instanceof Food||createLocalInformationForCreature.getCreatureLeft() instanceof Food||createLocalInformationForCreature.getCreatureRight() instanceof Food) {
			//ATTACK

			if(createLocalInformationForCreature.getCreatureDown() instanceof Food) {
				return new Action(Action.Type.ATTACK,Direction.DOWN);
			}
			if(createLocalInformationForCreature.getCreatureUp() instanceof Food) {
				return new Action(Action.Type.ATTACK,Direction.UP);
			}
			if(createLocalInformationForCreature.getCreatureLeft() instanceof Food) {
				return new Action(Action.Type.ATTACK,Direction.LEFT);
			}
			if(createLocalInformationForCreature.getCreatureRight() instanceof Food) {
				return new Action(Action.Type.ATTACK,Direction.RIGHT);
			}		
		}
		else {
			if(Snake.getFoodX()!=-1&&Snake.getFoodY()!=-1) {
				List<Direction> list = new LinkedList<Direction>();
				if(Snake.getFoodX()>this.getX()) {
					list.add(Direction.RIGHT);
				}
				if(Snake.getFoodX()<this.getX()) {
					list.add(Direction.LEFT);
				}
				if(Snake.getFoodY()>this.getY()) {
					list.add(Direction.DOWN);
				}
				if(Snake.getFoodY()<this.getY()) {
					list.add(Direction.UP);
				}
				list.retainAll(createLocalInformationForCreature.getFreeDirections());
				if(list.size()==0) {
					return new Action(Action.Type.MOVE,LocalInformation.getRandomDirection(createLocalInformationForCreature.getFreeDirections()));
				}

				return new Action(Action.Type.MOVE,LocalInformation.getRandomDirection(list));
			}

		}
		return new Action(Action.Type.MOVE,LocalInformation.getRandomDirection(createLocalInformationForCreature.getFreeDirections()));
	}

	@Override
	public void move(Direction direction) {

		if(direction.equals(Direction.RIGHT)) {

			super.setX(super.getX()+1);
			
			listX.add(listX.get(this.size-1)+1);
			listY.add(listY.get(this.size-1));
			listX.remove(0);
			listY.remove(0);

		}
		if(direction.equals(Direction.LEFT)) {
			super.setX(super.getX()-1);
			
			listX.add(listX.get(this.size-1)-1);
			listY.add(listY.get(this.size-1));
			listX.remove(0);
			listY.remove(0);

		}
		if(direction.equals(Direction.UP)) {
			
			super.setY(super.getY()-1);
			listX.add(listX.get(this.size-1));
			listY.add(listY.get(this.size-1)-1);
			listX.remove(0);
			listY.remove(0);

		}
		if(direction.equals(Direction.DOWN)) {
			
			super.setY(super.getY()+1);
			listX.add(listX.get(this.size-1));
			listY.add(listY.get(this.size-1)+1);
			listX.remove(0);
			listY.remove(0);

		}

	}

	@Override
	public void attack(Creature attackedCreature) {

		this.listX.add(attackedCreature.getX());
		this.listY.add(attackedCreature.getY());
		super.setX(attackedCreature.getX());
		super.setY(attackedCreature.getY());
		attackedCreature.setHealth(0.0);
		this.size++;

	}

	@Override
	public double getHealth() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public void setHealth(double health) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stay() {
		// TODO Auto-generated method stub

	}

	@Override
	public Creature reproduce(Direction direction) {
		this.size =4;
		Snake newSnake = new Snake(5,5);
		for(int i =SIZE_SNAKE-1;i>=0;i--) {
			newSnake.listX.add(this.listX.get(i));
			this.listX.remove(i);
			newSnake.listX.remove(0);
			newSnake.listY.add(this.listY.get(i));
			this.listY.remove(i);
			newSnake.listY.remove(0);
		}
		newSnake.setX(newSnake.listX.get(3));
		newSnake.setY(newSnake.listY.get(3));

		return newSnake;
	}
}
