import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

class numero_in_esecuzione extends JFrame{
	JLabel label;
	int x;
	
	public numero_in_esecuzione(int x){
		super("numero in esecuzione");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(label = new JLabel());

	
	this.x=x;
	 final int y=(int)(Math.random() * x);

		Timer timer = new Timer();
		timer.schedule(new Client(y), 0, 1000); 
		setVisible(true);
			}

	class Client extends TimerTask{

		int time_left = 0;
		public Client(int time_left){ if(time_left > 0)this.time_left = time_left - 1; }
		public void run(){
			++time_left;
			label.setText("Client:    " + time_left);
			if(time_left == x){
 			 cancel();
			//label.setText("è il tuo turno");
			dispose();
			new Entra_o_perdi();
 					 }
				}
			}
	}
