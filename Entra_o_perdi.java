import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.*;
import java.awt.*;

	public class Entra_o_perdi extends JFrame{
 		Container cnt;
		static JLabel label;
 
		private AscPulsante adpBN=new AscPulsante();

		public Entra_o_perdi(){
		
		super("Timer");
	


		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cnt=getContentPane();
		cnt.setLayout(new GridLayout(2,1));

		cnt.add(label = new JLabel());

		JButton bottone=new JButton("entra o perdi il turno");
		bottone.addActionListener(adpBN);
		setVisible(true);
		cnt.add(bottone);

		Timer timer = new Timer();
		timer.schedule(new ContoRovescia(5), 0, 1000); 

		setVisible(true);
		}
//classe interna
	static class AscPulsante implements ActionListener{	
		static int nclick=0;
		public void actionPerformed(ActionEvent ev){
		nclick=nclick+1;

		
	
		if((ContoRovescia.time_left>0) & (nclick==1)){	

		Pannello prova=new Pannello();
	//	prova.setLocationRelativeTo(null);
		new Segretaria(prova);
		new Studente(prova);
		
		}
	}
  }

	static class ContoRovescia extends TimerTask{

		static int time_left = 0;



		public ContoRovescia(int time_left){ if(time_left > 0)this.time_left = time_left + 1; }

		public void run(){

			--time_left;
			label.setOpaque(true);
			label.setBackground(Color.RED);
			label.setText("Tempo Restante: " + time_left);
	
			if((time_left == 0) &&(AscPulsante.nclick==0)){

  				cancel();
				label.setText("tempo scaduto: hai perso il turno!");
  				}
			else if((time_left>=0)&&(AscPulsante.nclick==1)){
				cancel();
				
				}

			}

		}

	}

