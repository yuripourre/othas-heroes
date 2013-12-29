

import br.com.etyllica.Etyllica;
import br.com.othas.OthasHeroes;

public class TideBeatEmUp extends Etyllica {

	private static final long serialVersionUID = 1L;

	public TideBeatEmUp() {
		super(480, 320);
	}
	
	@Override
	public void startGame() {
				
		//Etyllica tries to find the resources as your Application should be
		//To avoid this you should put your /assets/images in /Project/bin/examples/etyllica/tutorial1/
		
		//Upping three directories we have /Project/bin/assets/images
				
		setMainApplication(new OthasHeroes(w,h));
		
	}
	
}
