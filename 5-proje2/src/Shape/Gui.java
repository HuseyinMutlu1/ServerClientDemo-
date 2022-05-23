package Shape;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui extends JFrame  {
	JButton clientJButton ;
	JButton serverJButton ;
	JButton StartJButton ;
	JPanel panel;
    JTextField rectTextField ;
    JTextField circleTextField;
    JTextField triangleTextField;
    public int port =5001;
    
	public Gui(String panelName,int width,int height) {
		super(panelName);
		this.setSize(width, height);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    openingPage();
	    
	    clientListener(this);
	    serverListener(this);
	}
	
	
	 private void openingPage(){
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 panel = new JPanel(new BorderLayout());
	        JPanel serverJPanel = new JPanel();
	        serverJPanel.setLayout(new FlowLayout());
	        JPanel clientJPanel = new JPanel();
	        clientJPanel.setLayout(new FlowLayout());
	         serverJButton = new JButton("Server");
	        serverJButton.setPreferredSize(new Dimension(200,100));
	        serverJButton.setFont(new Font("asd",Font.BOLD, 24));
	        serverJPanel.add(serverJButton);

	        
	         clientJButton = new JButton("Client");
	        clientJButton.setPreferredSize(new Dimension(200,100));
	        clientJButton.setFont(new Font("asd",Font.BOLD, 24));
	        clientJPanel.add(clientJButton);
	
	        panel.add(serverJPanel,BorderLayout.CENTER);
	        panel.add(clientJPanel, BorderLayout.NORTH);
	        this.add(panel);
	        this.setLocationRelativeTo(null);
	        this.setVisible(true);
	    }

	
	

	
	 public void DrawServerInfoPage(){
		 
	    
	      	this.panel.removeAll();
	   
	        panel.setLayout(new GridBagLayout());
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridy=0;
	        gbc.insets = new Insets(1, 1, 1, 1);
	        JLabel lblRect = new JLabel("Rect");
	        JLabel lblCircle = new JLabel("Circle");
	        JLabel lblTriangle = new JLabel("Triangle");
	         rectTextField = new JTextField(10);
	         circleTextField= new JTextField(10);
	         triangleTextField= new JTextField(10);
	      
	        gbc.gridx=0;
	        gbc.gridy=0;
	        panel.add(lblRect, gbc);
	        gbc.gridy=1;
	        panel.add(lblCircle, gbc);
	        gbc.gridy=2;
	        panel.add(lblTriangle, gbc);
	        
	        gbc.gridx=1;
	        gbc.gridy=0;
	        panel.add(rectTextField,gbc);
	        gbc.gridy+=1;
	        panel.add(circleTextField,gbc);
	        gbc.gridy+=1;
	        panel.add(triangleTextField,gbc);
	        gbc.gridx = 0;
	        gbc.gridy+=1;
	        gbc.gridx=1;
	        gbc.gridx=1;
	       
	        StartJButton = new JButton("Start");
	        StartJButton.setPreferredSize(new Dimension(200,50));
	        StartJButton.setFont(new Font("asd",Font.BOLD, 24));
	 
	        panel.add(StartJButton,gbc);
	        startButtonAddActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					panel.removeAll();
					ShapeFactory factory=new ShapeFactory();
					try {
						Shape[] shapes= new Shape[Integer.valueOf(rectTextField.getText())+Integer.valueOf(circleTextField.getText())+Integer.valueOf(triangleTextField.getText())];
						System.out.println(rectTextField.getText() + "  "  + circleTextField.getText() + "  "  + triangleTextField.getText());
						int i = 0;
						for(; i < Integer.valueOf(rectTextField.getText());i++) {
							shapes [i] = factory.getShape("RECT");
						}
						for(; i < Integer.valueOf(circleTextField.getText())+Integer.valueOf(rectTextField.getText());i++) {
							shapes [i] = factory.getShape("CIRCLE");
						}
						for(; i < Integer.valueOf(triangleTextField.getText())+Integer.valueOf(circleTextField.getText())+Integer.valueOf(rectTextField.getText());i++) {
							shapes [i] = factory.getShape("TRIANGLE");
						}
						ShapePanel panel = new ShapePanel(shapes);
						addShapesPanel(panel);

						Server server=new Server(port);
						server.shapes=shapes;
						server.start();
						
					
						
						
					} catch (Exception e2) {
						System.out.println("Please enter only integer value");
					}
					
					
				}
			});
	       
	        panel.updateUI();
	      
	        
	       
	    }

	 public void DrawClientPage() {
			this.panel.removeAll();
		
			ShapeFactory factory=new ShapeFactory();		
				Shape[] shapes={factory.getShape("RECT"),factory.getShape("CIRCLE"),factory.getShape("TRIANGLE")};
				
				ShapePanel panel = new ShapePanel(shapes);
				addShapesPanel(panel);			
				
			        panel.updateUI();
			      
			       
		}

	
	
	public void addShapesPanel(JPanel panel) {
	
		// Container c=getContentPane();
		 add(panel);
		 repaint();
		 panel.updateUI();
		

			
	}
	public void clientButtonAddActionListener(ActionListener listener) {
		clientJButton.addActionListener(listener);
	}
	public void serverButtonAddActionListener(ActionListener listener) {
		serverJButton.addActionListener(listener);
	}
	public void startButtonAddActionListener(ActionListener listener) {
		StartJButton.addActionListener(listener);
	}
	
	private static void clientListener(Gui gui) {
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
				gui.DrawClientPage();
			}
		};
		
		gui.clientButtonAddActionListener(listener);
	}
	

	private static void serverListener(Gui gui) {
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
		
		
				gui.DrawServerInfoPage();
			
		
	}
			
};
gui.serverButtonAddActionListener(listener);
	}
}

	
	



/*

  Thread thread = new Thread() {
               @Override
               public void run() {
                   try {
                       // assume that we are running a job for 10 seconds
                	   while(true) {
                		   
                       Thread.sleep(100);
                       x++;
                       y++;
                       
                	   }
                   } catch (InterruptedException e1) {
                       e1.printStackTrace();
                   }
               }
           };
           thread.start();


*/