import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pannello{
	private boolean nome_D=false, nome_R=false;
	private boolean cognome_D=false, cognome_R=false;	
	private boolean matricola_D=false, matricola_R=false;
	private boolean facolta_D=false, facolta_R=false;
	private boolean scelta_D=false, scelta_R=false;
	
	private AppJComboJList prova;
	
	private FrAme f=new FrAme();
	private  Scelta sc;
	public synchronized void ask(){
		if(!nome_D){ 
			f.primo.setText("\n\n\ninserire nome: ");
			nome_D=true;	
			notify();	
			}

		if(nome_D && !nome_R){
			try{
				wait();
			 }
			catch(InterruptedException exc){
				exc.printStackTrace();
				}
			}
//end nome
		if(!cognome_D && nome_R){ 
			f.primo.setText("\n\n\ninserire cognome: ");
			cognome_D=true;	
			notify();	
			}
		if(cognome_D && !cognome_R){
			try{
				wait();
			 }
			catch(InterruptedException exc){
				exc.printStackTrace();
				}
			}
//end cognome
		if(cognome_R && !matricola_D){	
			f.primo.setText("\n\n\ninserire matricola: ");
			matricola_D=true;
			notify();
			}
		if(matricola_D && !matricola_R){
			try{
				wait();
 			}
			catch(InterruptedException exc){
				exc.printStackTrace();
				}

			}

//end matricola
//Begin facolta	
		if(matricola_R && !facolta_D){


			f.primo.setText("\n\n\nseleziona dal menu la \nfacolta:");	
			prova=new AppJComboJList(300,200);
			prova.show();
			prova.setLocationRelativeTo(null);
			facolta_D=true;
			notify();
				}		
		if(facolta_D &&!facolta_R){

			try{
				wait();
 			}
			catch(InterruptedException exc){
				exc.printStackTrace();
					}
		
				}
//end facolta
//begin scelta
		if(facolta_R && !scelta_D){
			f.primo.setText("\n\n\nseleziona operazione \n da eseguire:");	
			sc=new Scelta();
			sc.setVisible(true);
			sc.show();
			sc.setLocationRelativeTo(null);
			scelta_D=true;
			notify();
				}		
		if(scelta_D &&!scelta_R){
			try{
				wait();
 			}
			catch(InterruptedException exc){
				exc.printStackTrace();
					}
		
				}
//end facolta

		}//chiusura ask
	
		public synchronized void answer(){
//________________________________________________nome___________________________________________
boolean control=false;
Studente_info stud=new Studente_info();
			if(!nome_R && nome_D){ 
				do{
		//_____________controlli____________________			
					try{		
						Thread.sleep(2000);
						if(f.buffer.equals("")){
						f.primo.setText("\n\n\nnon hai inserito nulla:\n\ninserisci il nome");
							}
						if(!f.buffer.equals("")){	

							for(int i=0;i<=(f.buffer.length())-1;i++){

								if(Character.isDigit(f.buffer.charAt(i))){

									f.primo.setText("\n\n\ncarattere errato:\n\nreinserisci il nome");
									control=true;
										}
								if(!Character.isDigit(f.buffer.charAt(i))) control=false;
											}
							}
				
					  }
					catch(Exception e){}

				}while(f.buffer==null|| (f.buffer).equals("")||control);
		//___________end controlli_______________________

			nome_R=true;
			stud.setNome(f.buffer);
			
			f.buffer=null;
			notify();
			  }
//__________________________________________-end nome___________________________-
//_________________________________________________cognome__________________________
			if(nome_R && !cognome_D){
				try{
					wait();
				   }
				catch(InterruptedException exc){
					exc.printStackTrace();
					}
				}
	
			if(!cognome_R && cognome_D){ 
                      //_______________________________controlli____________________
				while(f.buffer==null|| (f.buffer).equals("")||control){
					try{		
						Thread.sleep(2000);
						if(f.buffer.equals("")){
							f.primo.setText("\n\n\nnon hai inserito nulla:\n\ninserisci il cognome");
								}
						if(!f.buffer.equals("")){	

							for(int i=0;i<=(f.buffer.length())-1;i++){

									if(Character.isDigit(f.buffer.charAt(i))){

										f.primo.setText("\n\n\ncarattere errato:\n\nreinserisci il cognome");
										control=true;
											}
							if(!Character.isDigit(f.buffer.charAt(i))) control=false;
										}
							}
					   }
					catch(Exception e){}
				}

			cognome_R=true;
			stud.setCognome(f.buffer);
			
			f.buffer=null;
			notify();
			}
//__________________________________________end cognome_____________________________
//___________________________________inizia         matricola____________________________

			if(cognome_R && !matricola_D){
				try{
					wait();
 				}
				catch(InterruptedException exc){
					exc.printStackTrace();
					}
				}
			if(!matricola_R && matricola_D){ 

				while(f.buffer==null|| (f.buffer).equals("")||control){
					try{		
						Thread.sleep(2000);
					if(f.buffer.equals("")){
						f.primo.setText("\n\n\nnon hai inserito nulla:\n\ninserisci la matricola");	
							}
					if(!f.buffer.equals("")){	
						for(int i=0;i<=(f.buffer.length())-1;i++){
							if(!Character.isDigit(f.buffer.charAt(i))){
								f.primo.setText("\n\n\nmatricola errata:\n\nreinserisci la matricola");
								f.buffer="";
								control=true;
									}
							if(Character.isDigit(f.buffer.charAt(i))) control=false;
									}
						}
 					  }
					
					catch(Exception e){}				
					}
			matricola_R=true;
			
			stud.setMatricola(Integer.parseInt(f.buffer));
			f.buffer=null;
			notify();
			}
//end matricola
//begin facolta
			if(!facolta_D && matricola_R){

				try{
					wait();
 				}
				catch(InterruptedException exc){
					exc.printStackTrace();
				}
			}
			if(facolta_D && !facolta_R){

				while(prova.facolta==null){
					try{		
						Thread.sleep(1000);
					  }
					catch(Exception e){}
				}
			facolta_R=true;
			stud.setCorso(prova.getFacolta());
			prova.dispose();
			notify();
			}

//end facolta
//begin scelta
			if(!scelta_D && facolta_R){

				try{
					wait();
 				}
				catch(InterruptedException exc){
					exc.printStackTrace();
						}
					}
			if(scelta_D && !scelta_R){

				while(sc.nclick==0){
					try{		
						Thread.sleep(1000);
	 				 }
					catch(Exception e){}
				    }
			scelta_R=true;
			sc.dispose();
			f.dispose();

			Conclusioni cl=new Conclusioni(sc.certificato,sc.piano,sc.tesi,sc.richieste,sc.cer_cons,sc.cer_ric,sc.piano_mod,
sc.piano_ric,sc.tesi_cons,sc.tesi_ric,stud);
			cl.show();
			
			}


		}//chiusura answer
	}





