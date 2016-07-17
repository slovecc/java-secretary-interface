import java.lang.*;
public class Studente implements Runnable{	
	private Pannello comunica; //risorsa condivisa
	public Studente(Pannello comunica){
		this.comunica=comunica;
		new Thread(this,"Studente").start();	
		}
	public void run(){
		
			comunica.answer();
				
			}
	}
