package Assignment1;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
	private TextField firstTf;
	private TextField secondTf;
	private TextField AnswerTf;

	public ActionHandler(TextField firstNo, TextField secondNo, TextField answer) {
		// TODO Auto-generated constructor stub
		
		this.firstTf = firstNo;
		this.secondTf = secondNo;
		this.AnswerTf = answer;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Integer i = Integer.parseInt(firstTf.getText());
		Integer j = Integer.parseInt(secondTf.getText());
		Integer K;
		
			if (e.getActionCommand().equalsIgnoreCase("Add"))
			{
				K  = i + j;				
				AnswerTf.setText(String.valueOf(K));						
			}
			else if (e.getActionCommand().equalsIgnoreCase("Subtract"))
			{
				if( i > j)
				{
				  K = i-j;
				AnswerTf.setText(String.valueOf(K));				
				}
				else  
				K = j-i;
				AnswerTf.setText(String.valueOf(K));				
			}
			
			else if (e.getActionCommand().equalsIgnoreCase("Multiply"))
			{
				K = i * j;
				AnswerTf.setText(String.valueOf(K));
							
			}
			else if (e.getActionCommand().equalsIgnoreCase("Division"))
			{
				K = i / j;
				AnswerTf.setText(String.valueOf(K));
				
			}
	}

}
