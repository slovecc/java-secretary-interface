import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.*;
import javax.swing.*;

public class AppJComboJList extends JFrame {
	private String[] desJCombo = {"","Fisica","Matematica","Chimica"};
	private String[] desJCombo1={"","Ingegneria edile","Ingegneria civile"};
	private JTextField txt;
	private JComboBox cbx;
	public String facolta;
	public AppJComboJList (int hSize, int vSize){
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setTitle(getClass().getName());
		setSize(hSize,vSize);
		Container cnt=getContentPane();
		cnt.setLayout(new FlowLayout());
		tripanel pannello=new tripanel();
		String sceltaIniziale=pannello.cmd;
		JPanel panJCombo=new JPanel();
		panJCombo.setLayout(new FlowLayout());
		panJCombo.setBorder(new TitledBorder ("Corso di laurea"));
		txt=new JTextField(15);
		panJCombo.add(txt);
		cbx= new JComboBox();
		if(sceltaIniziale=="Scienze FF.MM.NN."){
			for(int k=0;k< desJCombo.length;k++)
				cbx.addItem(desJCombo[k]);
			}
 		if(sceltaIniziale=="Ingegneria"){
			for(int k=0;k< desJCombo1.length;k++)
				cbx.addItem(desJCombo1[k]);
			}
		cbx.setEditable(false);
		cbx.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent ev){
					txt.setText(""+ ((JComboBox) ev.getSource()).getSelectedItem());
					facolta=txt.getText();
			}
		});
		
		panJCombo.add(cbx);
		cnt.add(panJCombo);

	}

public String getFacolta(){
	return facolta;
	}	
	
	
}

//Se funziona rendere facolta privata
