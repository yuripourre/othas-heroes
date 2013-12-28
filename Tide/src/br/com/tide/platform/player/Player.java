package br.com.tide.platform.player;

import java.util.HashSet;
import java.util.Set;

import br.com.etyllica.animation.Updatable;
import br.com.etyllica.core.Drawable;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.GeometricLayer;
import br.com.tide.input.controller.Controller;

public class Player extends GeometricLayer implements Drawable, Updatable, PlayerListener{

	protected float health = 100;

	protected String name = "Player";

	protected int walkSpeed = 5;
	
	private Controller controller;

	protected Set<PlayerState> state = new HashSet<PlayerState>();

	
	public Player(float x, float y, float w, float h){
		super(x,y,w,h);
		
		state.add(PlayerState.STAND);
	}

	public void draw(Graphic g) {

	}

	public void update(long now) {

	}

	public void walkLeft(){
		state.add(PlayerState.WALK_LEFT);
		onWalkLeft();
	}
	
	public void stopWalkLeft(){
		state.remove(PlayerState.WALK_LEFT);
		onStopWalkLeft();
	}

	public void walkRight(){
		state.add(PlayerState.WALK_RIGHT);
		onWalkRight();
	}
	
	public void stopWalkRight(){
		state.remove(PlayerState.WALK_RIGHT);
		onStopWalkRight();
	}

	public void walkUp(){
		state.add(PlayerState.WALK_UP);
		onWalkUp();
	}
	
	public void stopWalkUp(){
		state.remove(PlayerState.WALK_UP);
		onStopWalkUp();
	}
	
	public void walkDown(){
		state.add(PlayerState.WALK_DOWN);
		onWalkDown();
	}
	
	public void stopWalkDown(){
		state.remove(PlayerState.WALK_DOWN);
		onStopWalkDown();
	}

	public void stand(){
		state.clear();
		state.add(PlayerState.STAND);
		onStand();
	}
	
	public void attack(){
		state.clear();
		state.add(PlayerState.ATTACK);
		onAttack();
	}
	
	public void stopAttack(){
		stand();
		onStopAttack();
	}

	public void handleEvent(KeyEvent event){

		if(event.isKeyDown(controller.getRightButton())){
			walkRight();
		}else if(event.isKeyUp(controller.getRightButton())){
			stopWalkRight();
		}

		if(event.isKeyDown(controller.getLeftButton())){
			walkLeft();
		}else if(event.isKeyUp(controller.getLeftButton())){
			stopWalkLeft();
		}

		if(event.isKeyDown(controller.getUpButton())){
			walkUp();
		}else if(event.isKeyUp(controller.getUpButton())){
			stopWalkUp();
		}

		if(event.isKeyDown(controller.getDownButton())){
			walkDown();
		}else if(event.isKeyUp(controller.getDownButton())){
			stopWalkDown();
		}
		
		if(event.isKeyDown(controller.getaButton())){
			attack();
		}else if(event.isKeyUp(controller.getaButton())){
			stand();
		}

	}

	public boolean isWalking(){
		return state.contains(PlayerState.WALK_RIGHT)||state.contains(PlayerState.WALK_LEFT)||state.contains(PlayerState.WALK_UP)||state.contains(PlayerState.WALK_DOWN);
	}
	
	public boolean isAttacking(){
		return state.contains(PlayerState.ATTACK);
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void onWalkLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onWalkRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onWalkUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onWalkDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopWalkLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopWalkRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopWalkUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopWalkDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAttack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopAttack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStand() {
		// TODO Auto-generated method stub
		
	}

}
