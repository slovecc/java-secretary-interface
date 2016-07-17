import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
public class FrAme extends JFrame{
	JTextField secondo;
	JTextArea primo;
      //public String buffer=null;
public String buffer;
	public FrAme(){
		super("Segretaria-Studente");
		setSize(600,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container areaCentrale=getContentPane();
		areaCentrale.setLayout(new GridLayout(2,3));
//creo componenti
		ImagePanel pnlimage1 = new ImagePanel("men.jpg");
		ImagePanel pnlimage2 = new ImagePanel("women.jpg");
		JPanel immagine1=new JPanel();
		JPanel immagine2=new JPanel();
		immagine1.add(pnlimage1);
//immagine1.setBorder(new LineBorder(Color.red));
//immagine2.setBorder(new TitledBorder("segretaria"));
		immagine2.add(pnlimage2);
		primo=new JTextArea();
		primo.setEditable(false);
		Font font = new Font("Verdana", Font.BOLD, 12);
		primo.setFont(font);
		primo.setForeground(Color.BLUE);

	        secondo=new JTextField(15);
		Font font1 = new Font("Verdana", Font.BOLD, 12);
		secondo.setFont(font1);
		secondo.setForeground(Color.RED);
		secondo.setEditable(true);
//immagini
		JPanel p=new JPanel();
		ImagePanel pnlimage = new ImagePanel("logouniud.jpg");
		p.add(pnlimage);


//aggiungo in ordine i componenti

		areaCentrale.add(p);
//		areaCentrale.add(Box.createRigidArea(new Dimension(200,250))); //area rigida
		//areaCentrale.add(l1);
		areaCentrale.add(primo);
		areaCentrale.add(immagine2);
		areaCentrale.add(immagine1);
		areaCentrale.add(secondo);
		secondo.addActionListener(new EnterTextListener());
		pack();
		//areaCentrale.add(Box.createRigidArea(new Dimension(200,250)));
		setVisible(true);
		
		}

	class EnterTextListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {


		buffer=String.valueOf(secondo.getText());

		secondo.setText("");


				}
			}//chiusura actionListener



}


class ImagePanel extends JPanel {
	private Image img;
	public ImagePanel(String imgname) {
		ImageIcon imageico = new ImageIcon(imgname);
		this.img = imageico.getImage();
		Dimension size = new Dimension(200,250);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
	}
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0,null);
	}
}

