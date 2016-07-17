import java.lang.*;
public class Segretaria implements Runnable{	
	private Pannello comunica;
	public Segretaria(Pannello comunica){
		this.comunica=comunica;
		new Thread(this,"Segretaria").start();	
		}
	public void run(){
		
			comunica.ask();
				
			}
	}

		
