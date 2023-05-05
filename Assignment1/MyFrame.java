package Assignment1;

import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;

public class MyFrame extends Frame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MyFrame (boolean Visibility,String Title,int x,int y,int height,int width) {
		this.setVisible(Visibility);
		this.setTitle(Title);
		this.setBounds(x,y,height,width);
		
		Label FirstNoLabel = new Label("First No");
		FirstNoLabel.setBounds(50, 50, 80, 30);
				
		Label SecondNoLabel = new Label("Second No");
		SecondNoLabel.setBounds(250, 50, 80, 40);
		
		
		Label AnswerLabel = new Label("Answer is");
		AnswerLabel.setBounds(50, 100, 80, 40);
		
		
		TextField FirstNo = new TextField();
		FirstNo.setBounds(150,50,80,30);
		
		
		TextField SecondNo = new TextField();
		SecondNo.setBounds(350,50,80,30);
		
		
		TextField Answer = new TextField();
		Answer.setBounds(150, 100, 80, 30);
		
		
//		
		Button AddButton = new Button("Add");
		AddButton.setBounds(100,150,80,30);
		
		
		Button SubButton = new Button("Subtract");
		SubButton.setBounds(200,150,80,30);
		
		
		Button MultiplyButton = new Button("Multiply");
		MultiplyButton.setBounds(300,150,80,30);
		
		
		
		Button DivisionButton = new Button("Division");
		DivisionButton.setBounds(400,150,80,30);
		
		
		
		
		add(FirstNoLabel);
		add(SecondNoLabel);
		add(AnswerLabel);
		add(FirstNo);
		add(SecondNo);
		add(Answer);
		this.add(AddButton);
		this.add(SubButton);
		this.add(MultiplyButton);
		this.add(DivisionButton);
		
		
		this.setLayout(null);
		
				
		//for Events related to window it is window listener ,related to mouse MouseListener and events related to Buttons is Actionlistener
		
		AddButton.addActionListener(new ActionHandler(FirstNo,SecondNo,Answer));
		SubButton.addActionListener(new ActionHandler(FirstNo,SecondNo,Answer));
		MultiplyButton.addActionListener(new ActionHandler(FirstNo,SecondNo,Answer));
		DivisionButton.addActionListener(new ActionHandler(FirstNo,SecondNo,Answer));
		
		
		this.addWindowListener(new WindowHandler());
		//		this.addMouseListener(new MouseHandler());
		//		this.addMouseMotionListener(new MouseMotionHandler());

	//Above example where three different event handlers created and three different objects for the same created and called in bracket as new	
	// Below only one Event handler created for all the events e g..events related to window,events related to mouse etc and only one object of the same created and passed	
		this.addWindowListener(new MasterWindowHandler());
		this.addMouseListener(new MasterWindowHandler());
		this.addMouseMotionListener(new MasterWindowHandler());
		
				
		
				
		
	}

}
