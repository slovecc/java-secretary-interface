import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

class numero_in_esecuzione1 extends JPanel{
	JLabel label;
	JTextArea label1;
	int x;
	
	public numero_in_esecuzione1(int x){
		
		
		
		add(label = new JLabel());
		
		add(label1 = new JTextArea());
	
		this.x=x;
	 final int y=(int)(Math.random() * x);

		Timer timer = new Timer();
		timer.schedule(new Client(y), 0, 1000); 
		
			}

	class Client extends TimerTask{

		int time_left = 0;
		public Client(int time_left){ if(time_left >= 0)this.time_left = time_left - 1; }
		public void run(){
			++time_left;


			label.setText("Numero servito: " );
			
			label1.setText("   "+time_left);

			label1.setEditable(false);
			if(time_left == x){
 			 cancel();
			//label.setText("è il tuo turno");
			


			(new Entra_o_perdi()).setLocationRelativeTo(null);
 					 }
				}
			}
	}
