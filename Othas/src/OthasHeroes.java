

import br.com.etyllica.EtyllicaFrame;
import br.com.etyllica.context.Application;
import br.com.othas.OthasHeroesApplication;

public class OthasHeroes extends EtyllicaFrame {

	private static final long serialVersionUID = 1L;

	public OthasHeroes() {
		super(480, 320);
	}
	
	public static void main(String[] args){
		OthasHeroes tide = new OthasHeroes();
		tide.init();
	}
	
	@Override
	public Application startApplication() {
				
		//Etyllica tries to find the resources as your Application should be
		//To avoid this you should put your /assets/images in /Project/bin/examples/etyllica/tutorial1/
		
		//Upping three directories we have /Project/bin/assets/images
				
		return new OthasHeroesApplication(w,h);
		
	}
	
}
