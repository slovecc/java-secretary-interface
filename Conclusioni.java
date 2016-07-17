import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
	public class Conclusioni extends JFrame{
		
		private boolean certificato,piano,tesi,richieste;
		private boolean cer_cons, cer_ric, piano_mod, piano_ric, tesi_cons, tesi_ric;
		private Studente_info stud;
		public Conclusioni(boolean certificato, boolean piano, boolean tesi, boolean richieste, 
		boolean cer_cons, boolean cer_ric,boolean piano_mod,boolean piano_ric, boolean tesi_cons, 
		boolean tesi_ric, Studente_info stud){
		super("resoconto");
		setSize(400,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container areaCentrale=getContentPane();
		tripanel pannello=new tripanel();
		
		this.stud=stud;

		
		this.certificato=certificato;
		this.piano=piano;
		this.tesi=tesi;
		this.richieste=richieste;
		this.cer_cons=cer_cons;
		this.cer_ric=cer_ric;
		this.piano_mod=piano_mod;
		this.piano_ric=piano_ric;
		this.tesi_cons=tesi_cons;
		this.tesi_ric=tesi_ric;

		JTextArea primo=new JTextArea();
  		//System.out.println("cert_cons: "+cer_cons);
		primo.setLineWrap(true);	
		primo.setEditable(false);
		//JScrollPane scrPane=new JScrollPane(primo,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
		this.setResizable(false);
	
		primo.setLineWrap(true);
		primo.setText("lo studente:\t\n nome: "+stud.getNome()+" \ncognome: "+stud.getCognome()+"\n matricola: "+stud.getMatricola()+"\n\n\n"+
		"iscritto alla facoltà di: \t"+stud.getFacolta()+"\n\n\n"+
		"corso di laurea in; \t"+stud.getCorso()+"\n\n\n"+
		"ha richiesto le seguenti operazioni:\t"+"\n\n\n"+
		"richiesto o rilascio certificato?\t "+certificato+"\n\n\n");
		if(certificato&&cer_cons){	
		primo.append("(consegna)\n\n");
		}else if(certificato&&cer_ric){
		primo.append("(richiesta)\n\n");
		}
 		primo.append("modifica o richesto il piano di studi?\t"+piano+"\n\n\n");
		if(piano&&piano_mod){
		primo.append("(modifica)\n\n");
		}else if(piano&&piano_ric){
		primo.append("(richiesta)\n\n");
		}
		primo.append("consegna o richiesta modulo tesi?:\t"+tesi+"\n\n\n");
		if(tesi&&tesi_ric){
		primo.append("(richiesta)\n\n");
		}else if(tesi&&tesi_cons){
		primo.append("(consegna)\n\n");
		}
		primo.append("altre richieste?\t"+richieste);
		
		areaCentrale.add(primo);
		//areaCentrale.add(scrPane,"Center");
		
		setVisible(true);
	}
}
