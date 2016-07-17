import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


 class tripanel extends JFrame{
	 JPanel pan1=new JPanel();
	int nclick=0;
	static public String cmd;
	Container area=getContentPane();
	public final int x= (int)(Math.random() * 80 );
	
	public tripanel(){

	super("pannello iniziale");
	setSize(400,400);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	area.setLayout(new GridLayout(2,2));
	JButton btn1=new JButton("Scienze FF.MM.NN.");
	btn1.setFont(new Font("Verdana",Font.PLAIN,15));
	//aggiungo un bordo alla bottone scienze 	
 	btn1.setBorder(BorderFactory.createLineBorder(Color.red,5));
	btn1.addActionListener(new ascButton());
	JButton btn2=new JButton("Ingegneria");
	btn2.setFont(new Font("Verdana",Font.PLAIN,15));
	//aggiungo un bordo alla bottone ingegneria	
 	btn2.setBorder(BorderFactory.createLineBorder(Color.blue,5));
	btn2.addActionListener(new ascButton());
	area.add(btn1);
	area.add(pan1);
	area.add(btn2);
	}

 class ascButton implements ActionListener{
        
 	public void actionPerformed(ActionEvent e){
	cmd = e.getActionCommand();
	nclick++;
	JTextField primo=new JTextField(10);
	JLabel l1=new JLabel("numero ottenuto");

	String testo="numero :"+x;
	//primo.add(l1);
	if(nclick==1){			//stampa sul primo pannello il numero di turno
	primo.setText(testo);
	
	//primo.setFont(new Font("Verdana",Font.PLAIN,15));

	primo.setEditable(false);
	pan1.add(l1);
	pan1.add(Box.createRigidArea(new Dimension(0,70)));
	pan1.add(primo);
	setVisible(true);
	
        	area.add(new numero_in_esecuzione1(x));
         	setVisible(true);
	}
       
      }
  }
		
}



