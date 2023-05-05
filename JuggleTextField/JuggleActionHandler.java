package JuggleTextField;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuggleActionHandler implements ActionListener {

	private TextField FirstNum;
	private TextField SecondNum;
	private TextField ThirdNum;
	
	public JuggleActionHandler(TextField firstNo, TextField secondNo, TextField thirdNo) {
		// TODO Auto-generated constructor stub
		this.FirstNum = firstNo;
		this.SecondNum = secondNo;
		this.ThirdNum = thirdNo;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Integer NumberFirst;
		Integer NumberSecond;
		Integer NumberThird;
		Integer SaveSecondNo;
		Integer SaveThirdNo;
		
		NumberFirst = Integer.parseInt(FirstNum.getText());
		NumberSecond = Integer.parseInt(SecondNum.getText());
		NumberThird = Integer.parseInt(ThirdNum.getText());
		
		SaveSecondNo = NumberSecond;
		SaveThirdNo = NumberThird;
		
		
		if (e.getActionCommand().equalsIgnoreCase("ClockWise"))
{
			NumberFirst = NumberFirst + 1;
			NumberSecond = NumberSecond + 1;
			NumberThird = NumberThird + 1;
								
			SecondNum.setText(String.valueOf(NumberFirst));
			ThirdNum.setText(String.valueOf(NumberSecond));
			FirstNum.setText(String.valueOf(NumberThird));	
				
}
else if ( e.getActionCommand().equalsIgnoreCase("AntiClockWise"))
{
	NumberFirst = NumberFirst - 1;
	NumberSecond = NumberSecond - 1;
	NumberThird = NumberThird - 1;
	
	SecondNum.setText(String.valueOf(NumberFirst));
	ThirdNum.setText(String.valueOf(NumberSecond));
	FirstNum.setText(String.valueOf(NumberThird));
	
}
	}

}
