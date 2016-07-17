import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
	public class Scelta extends JFrame
		{
		JCheckBox checks[]; /*  bottoni check box */
  		JRadioButton radios[]; /*  bottoni radio */  
  		ButtonGroup cbg[]; /* gruppo di bottoni radio */
		boolean certificato=false,piano=false,tesi=false,richieste=false;
                boolean cer_ric=false, cer_cons=false, piano_mod=false, piano_ric=false;
		boolean tesi_cons=false, tesi_ric=false;
		int nclick;
		public Scelta(){
			setTitle("Buttons");
			setSize(300,300);
   			setLayout(new GridLayout(5,3));
			setDefaultCloseOperation(EXIT_ON_CLOSE);

			checks=new JCheckBox[4];



		/* crea i 4 bottoni check box */
   			checks[0]=new JCheckBox("certificato");

   			checks[1]=new JCheckBox("Piano studi");

    			checks[2]=new JCheckBox("modulo tesi");

    			checks[3]=new JCheckBox("altre richieste");

//aggiungo ascoltatori ai bottoni check box!
			for(int i=0;i<4;i++){
				checks[i].addItemListener(new JCheckBoxItemListener());
				}

			radios=new JRadioButton[6];
			cbg=new ButtonGroup[3];
 /* crea i gruppi di bottoni radio e i bottoni radio */   
			cbg[0] = new ButtonGroup();
    	//radios = new Checkbox[2];
			radios[0]=new JRadioButton("consegna");
			radios[1]=new JRadioButton("richiesta");
			cbg[0].add(radios[0]);
			cbg[0].add(radios[1]);

       			cbg[1] = new ButtonGroup();
    	//radios = new Checkbox[2];
			radios[2]=new JRadioButton("modifica");
			radios[3]=new JRadioButton("richiesta");
			cbg[1].add(radios[2]);
			cbg[1].add(radios[3]);

			cbg[2] = new ButtonGroup();
    //	radios = new CheckbBox[2];
			radios[4]=new JRadioButton("consegna");
			radios[5]=new JRadioButton("richiesta");
			cbg[2].add(radios[4]);
			cbg[2].add(radios[5]);
//aggiungo ascoltatori ai bottoni radio!
for(int i=0;i<6;i++){
radios[i].addItemListener(new JCheckBoxItemListener1());
}

			add(checks[0]);
			add(radios[0]);
			add(radios[1]);
			add(checks[1]);
			add(radios[2]);
			add(radios[3]);
			add(checks[2]);
			add(radios[4]);
			add(radios[5]);
			add(checks[3]);
			add(Box.createRigidArea(new Dimension(100,100)));
			add(Box.createRigidArea(new Dimension(100,100)));
			add(Box.createRigidArea(new Dimension(100,100)));
			JButton esci=new JButton("fatto!");
			esci.addActionListener(new AscButton());
			add(esci);
 			pack();
  }

// ascoltatore JCheckBox
	class JCheckBoxItemListener implements ItemListener {
			public void itemStateChanged(ItemEvent e) {

				Object target = e.getItem();
				int status = e.getStateChange();
				if((target.equals(checks[0])) && (status == ItemEvent.SELECTED)){
					certificato=true;
									
						}
				if((target.equals(checks[1])) && (status == ItemEvent.SELECTED)){
					piano=true;
					
						}
				if((target.equals(checks[2])) && (status == ItemEvent.SELECTED)){
					tesi=true;
						
						}
				if((target.equals(checks[3])) && (status == ItemEvent.SELECTED)){
					richieste=true;
			
						}

					}

				}

class JCheckBoxItemListener1 implements ItemListener {
			public void itemStateChanged(ItemEvent e) {

				Object target1 = e.getItem();
				int status1 = e.getStateChange();
				
						if(target1.equals(radios[0]) && status1==ItemEvent.SELECTED) cer_cons=true;
						if(target1.equals(radios[1]) && status1==ItemEvent.SELECTED) cer_ric=true;			
						
						if(target1.equals(radios[2]) && status1==ItemEvent.SELECTED) piano_mod=true;
						if(target1.equals(radios[3]) && status1==ItemEvent.SELECTED) piano_ric=true;
						
						if(target1.equals(radios[4]) && status1==ItemEvent.SELECTED) tesi_cons=true;
						if(target1.equals(radios[5]) && status1==ItemEvent.SELECTED) tesi_ric=true;
						
						}

					}

				
	
		class AscButton implements ActionListener{
				public void actionPerformed(ActionEvent ev){
					nclick++;
	
						}
					}

				}


	
