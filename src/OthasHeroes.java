

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
		
		String path = OthasHeroes.class.getResource("").toString();
		setPath(path+"../");
				
		return new OthasHeroesApplication(w, h);
	}
	
}
