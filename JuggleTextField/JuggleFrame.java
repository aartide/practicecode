package JuggleTextField;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowListener;

public class JuggleFrame extends Frame {

private static final long serialVersionUID = 1L;


	public JuggleFrame(boolean Visibility, String FrameTitle, int i, int j, int k, int l) {
		// TODO Auto-generated constructor stub
		
		this.setVisible(Visibility);
		this.setTitle(FrameTitle);
		this.setBounds(i,j,k,l);
		
		Label FirstNoLabel = new Label("Enter Any No");
		FirstNoLabel.setBounds(150, 150, 80, 30);		
		
		TextField FirstNo = new TextField();
		FirstNo.setBounds(250,150,80,30);
		
		TextField SecondNo = new TextField();
		SecondNo.setBounds(350,150,80,30);
		
		TextField ThirdNo = new TextField();
		ThirdNo.setBounds(450,150,80,30);
		
		Button ClockWise = new Button("ClockWise");
		ClockWise.setBounds(350,200,80,30);
		
		Button AntiClockWise = new Button("AntiClockWise");
		AntiClockWise.setBounds(450,200,80,30);
		
		add(FirstNoLabel);
		add(FirstNo);
		add(SecondNo);
		add(ThirdNo);
		this.add(ClockWise);
		this.add(AntiClockWise);
		
		this.setLayout(null);
		
		this.addWindowListener(new JuggleWindowHandler());
		this.addMouseListener(new JuggleMouseHandler());
		
		ClockWise.addActionListener(new JuggleActionHandler(FirstNo,SecondNo,ThirdNo));
		AntiClockWise.addActionListener(new JuggleActionHandler(FirstNo,SecondNo,ThirdNo));
	
	
	}	
}
