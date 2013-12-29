package br.com.othas.model;

import java.util.List;

import br.com.etyllica.util.SVGColor;

public abstract class Hero extends Character{

	public Hero(int x, int y, String rightPath, String leftPath) {
		super(x, y, rightPath, leftPath);
	}
	
	public void update(long now, List<Character> targets) {
		super.update(now);
		
		if(isAttacking()){
		
			for(Character target: targets){
				if(colide(target)){
					target.beignHit(this, now);
					target.setOffsetX(-5);
				}
			}
			
		}
		
		this.lifeBarColor = SVGColor.GREEN;
		
		for(Character target: targets){
			if(colide(target)){
				this.lifeBarColor = SVGColor.ROYAL_BLUE;
			}
		}
		
	}
	
	private boolean colide(Character target){
		return layer.colideRetangular(target.layer);
	}
	
}
