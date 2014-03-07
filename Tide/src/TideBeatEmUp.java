

import br.com.etyllica.EtyllicaFrame;
import br.com.etyllica.context.Application;
import br.com.othas.OthasHeroes;

public class TideBeatEmUp extends EtyllicaFrame {

	private static final long serialVersionUID = 1L;

	public TideBeatEmUp() {
		super(480, 320);
	}
	
	public static void main(String[] args){
		TideBeatEmUp tide = new TideBeatEmUp();
		tide.init();
	}
	
	@Override
	public Application startApplication() {
				
		//Etyllica tries to find the resources as your Application should be
		//To avoid this you should put your /assets/images in /Project/bin/examples/etyllica/tutorial1/
		
		//Upping three directories we have /Project/bin/assets/images
				
		return new OthasHeroes(w,h);
		
	}
	
}
