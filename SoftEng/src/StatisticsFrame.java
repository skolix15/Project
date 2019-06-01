import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StatisticsFrame extends JFrame{
	
	private JPanel panel;
	private JMenuBar mb;
	private JMenu orderMenu;
	private JMenu storageMenu;
	private JMenu statisticsMenu;
	private JMenu centralMenu_Menu;
	private JPanel menuPanel;
	private JMenuItem i1,i2,i3,i4,i5,iCentralMenu;

	private JButton dailyStatisticsButton;
	private JButton generalStatisticsButton;
	private JButton timePeriodStatisticsButton;
	
	private JPanel buttonsPanel;
	
	JFrame frame = this;
	private db conn;

	public StatisticsFrame(db connection) {
		
		conn= connection;
		
		// Dimiourgia buttons
		
		dailyStatisticsButton = new JButton("Daily Statistics");
		generalStatisticsButton = new JButton("General Statistics");
		timePeriodStatisticsButton = new JButton("Time Period Statistics");
		
		// Dimiourgia Listener gia ta buttons
		
		timePeriodStatisticsButton.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent arg0) {

				//new TimePeriodStatisticsFrame(conn);
				dispose();
				
			}
			
		});
		
		// Dimiourgia baras menu
		
		mb = new JMenuBar();
		
		// Dimiourgia twn triwn menu
		
		orderMenu = new JMenu("Order");
		storageMenu = new JMenu("Storage");
		statisticsMenu = new JMenu("Statistics");
		centralMenu_Menu = new JMenu("Central Menu");
		
		// Dimiourgia epilogwn-pediwn gia kathe lista ( Paraggelia, Apothiki, Statistika )
		
		i1 = new JMenuItem("Prescription");  
	    i2 = new JMenuItem("Supply");  
	    i3 = new JMenuItem("Add");  
	    i4 = new JMenuItem("Delete"); 
	    i5 = new JMenuItem("Show Statistics");
	    iCentralMenu = new JMenuItem("Go to Central Menu");
	    
	    // Eisagwgi ActionListener gia ta pedia tou Menu
	    
	    JTablePopupMenuListener listener = new JTablePopupMenuListener();
	    i1.addActionListener(listener);
	    i2.addActionListener(listener);
	    i3.addActionListener(listener);
	    i4.addActionListener(listener);
	    i5.addActionListener(listener);
	    iCentralMenu.addActionListener(listener);
	    
	    // Prosthiki eikonas kai listener gia aythn
		
	 		ImageIcon icon = new ImageIcon("hospital1.png");
	 		JLabel lb = new JLabel(icon);
	 	
	 		lb.addMouseListener(new MouseAdapter() {
	 			public void mouseClicked(MouseEvent e) 
	 		    {	 
	 				dispose();
	 				new GlobalHomeFrame(conn);              
			     
	 		    }
	 			
	 		}	);
	    
	    // Eisagwgi twn pediwn sto antistoixo menu
	    
	    centralMenu_Menu.add(iCentralMenu);
	    
	    orderMenu.add(i1);
	    orderMenu.add(i2);
	    
	    storageMenu.add(i3);
	    storageMenu.add(i4);
	    
	    statisticsMenu.add(i5);
	    
	    
	    // Eisagwgi twn menu sth bara menu
	    
	    mb.add(centralMenu_Menu);
	    mb.add(orderMenu);
	    mb.add(storageMenu);
	    mb.add(statisticsMenu);
	    mb.add(lb);
	    
	    // Dimiourgia Panel
	    
	    menuPanel = new JPanel();
	    panel = new JPanel();
	    buttonsPanel = new JPanel();
	    
	    // Prosthiki olwn twn menu sto antistoixo panel 
	    
	    menuPanel.add(mb);
	    menuPanel.setAlignmentX(Component.TOP_ALIGNMENT);
	    
	    // Prosthiki olwn twn buttons sto antistoixo panel
	    
	    buttonsPanel.add(dailyStatisticsButton);
	    buttonsPanel.add(timePeriodStatisticsButton);
	    buttonsPanel.add(generalStatisticsButton);
	    
	    buttonsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
	    // Prosthiki twn parapanw panel sto teliko panel 
	    
	    panel.add(menuPanel);
	    
	    panel.add(buttonsPanel);
		
		
		
		
		
		
		this.setContentPane(panel);
		
		this.setVisible(true);;
		this.setSize(600,400);
		this.setTitle("/Supply Chain/Pharmacist/Statistics/Show Statistics");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class JTablePopupMenuListener implements ActionListener {


		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand().equals("Go to Central Menu")){
				
				dispose();
				new SupplyChainMainFrame(conn);
			}
			
			else if(e.getActionCommand().equals("Prescription") ) {
					
				dispose();
				new PrescriptionAndSupplyFrame(true,conn);
				
			}
			
			else if(e.getActionCommand().equals("Supply")){
				
				dispose();
				new PrescriptionAndSupplyFrame(false,conn);
				
			}
			
			else if(e.getActionCommand().equals("Add")) {
				
				dispose();
				new AddFrame(conn);
			}
			
			else if(e.getActionCommand().equals("Delete")) {
				
				dispose();
				new DeleteFrame(conn);
			}
			
			else if(e.getActionCommand().equals("Show Statistics")) {
				
				dispose();
				new StatisticsFrame(conn);
			}
			
		}
			
	 }

}

