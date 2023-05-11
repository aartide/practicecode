package Employee_DTO.View;

import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import Employee_DTO.Controller.EmployeeHandler;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
public class EmpFrame extends Frame	 {
	private Label LabelEmployeeid;
	private Label LabelEmployeeName;
	private TextField txtEmpId;
	private TextField txtEmpNm;
	
	private Label lblLocation;
	private Choice officeLocation;
	
	private Label lblEmpAddress;
	private TextArea addressTxt;
	
	private Label lblEmpSalary;
	private TextField empsalaryTxt;
	
	
	private Label lblEmployeePerk;
	private Checkbox pfOptionChk;
	private Checkbox mealptionChk;
	private Checkbox npsChk;
	private Checkbox gratuityChk;
	private Checkbox MediclaimChk;
	
	private CheckboxGroup GenderGroup;	
	private Label lblGender;
	private Checkbox maleChk;
	private Checkbox femaleChk;
	private Checkbox otherChk;
	
	
	
	private Button btnSave;
	private Button btnDelete;
	private Button btnUpdate;
	private Button btnSearch;
	private Button btnFirst;
	private Button btnLast;
	private Button btnNext;
	private Button btnPrev;
	
	
//Frame f = new EmpFrame();
	
	public EmpFrame () {
	
		
		
		this.setBounds(50,50,700,700);
		this.setTitle("Employee Information");
		this.setVisible(true);
		this.setLayout(null);
		
		GenderGroup = new CheckboxGroup();
		
		
		LabelEmployeeid = new Label("Employee Id");
		LabelEmployeeid.setBounds(20, 50,100, 20);
		this.add(LabelEmployeeid);
				
	    LabelEmployeeName = new Label("Employee Name");
		LabelEmployeeName.setBounds(20, 80,100,20);
		this.add(LabelEmployeeName);
		
		txtEmpId = new TextField();
		txtEmpId.setBounds(140,50, 100, 20);
		this.add(txtEmpId);
				
		txtEmpNm= new TextField();
		txtEmpNm.setBounds(140,80, 100, 20);
		this.add(txtEmpNm);
		
		lblGender = new Label("Employee Gender");
		lblGender.setBounds(20, 110, 100, 20);
		this.add(lblGender);
		
		maleChk = new Checkbox("Male",false,GenderGroup);
		maleChk.setBounds(140, 110, 80, 20);	
		this.add(maleChk);
		
		
		femaleChk = new Checkbox("Female",true,GenderGroup);
		femaleChk.setBounds(230, 110, 100, 20);
		this.add(femaleChk);
		
		otherChk = new Checkbox("Other",false,GenderGroup);
		otherChk.setBounds(340, 110, 100, 20);	
		this.add(otherChk);
				
		lblEmployeePerk = new Label("Employee Perks");
		lblEmployeePerk.setBounds(20, 140, 100, 20);
		this.add(lblEmployeePerk);
		
		//(y,x,heght,width)		
		pfOptionChk = new Checkbox("PF");
		pfOptionChk.setBounds(150, 100, 100, 100);
		this.add(pfOptionChk);
		
		mealptionChk = new Checkbox("Meal");
		mealptionChk.setBounds(250, 100, 100, 100);
		this.add(mealptionChk);
		
		npsChk = new Checkbox("NPS");
		npsChk.setBounds(350, 100, 100, 100);
		this.add(npsChk);
		
		gratuityChk = new Checkbox("Gratuity");
		gratuityChk.setBounds(450, 100, 100, 100);
		this.add(gratuityChk);
		
		MediclaimChk = new Checkbox("Mediclaim");
		MediclaimChk.setBounds(550, 100, 100, 100);
		this.add(MediclaimChk);
		
		lblLocation = new Label("Employee Office Location");
		lblLocation.setBounds(20, 200, 150, 20);
		this.add(lblLocation);
				
		officeLocation = new Choice();
		officeLocation.setBounds(170,200 , 100, 100);
		officeLocation.add("Pune");
		officeLocation.add("Bengluru");
		officeLocation.add("Chennai");
		officeLocation.add("Hyderabad");
		officeLocation.add("Hubali");
		this.add(officeLocation);
		
		//(y,x,height,width)
		lblEmpAddress = new Label (" Employee Address");
		lblEmpAddress.setBounds(320, 200, 120, 20);
		this.add(lblEmpAddress);
		
		addressTxt = new TextArea("Link Road, Baner");
		addressTxt.setBounds(460, 200, 100, 100);
		this.add(addressTxt);
		
		lblEmpSalary = new Label (" Employee Salary");
		lblEmpSalary.setBounds(20, 300, 100, 20);
		this.add(lblEmpSalary);
		
		empsalaryTxt = new TextField();
		empsalaryTxt.setBounds(140, 300, 100, 20);
		this.add(empsalaryTxt);
				
		btnSave= new Button("Save");
		btnSave.setBounds(50,450 ,80, 20);
		this.add(btnSave);
		
		btnSave.addActionListener(new EmployeeHandler(this));
				
		btnUpdate= new Button("Update");
		btnUpdate.setBounds(140,450 ,80, 20);
		this.add(btnUpdate);
		btnUpdate.addActionListener(new EmployeeHandler(this));
		
		btnDelete= new Button("Delete");
		btnDelete.setBounds(230,450 ,80, 20);
		this.add(btnDelete);
		btnDelete.addActionListener(new EmployeeHandler(this));
		
		btnSearch = new Button("Search");
		btnSearch.setBounds(320,450 ,80, 20);
		this.add(btnSearch);
		btnSearch.addActionListener(new EmployeeHandler(this));
		
		btnFirst = new Button("First");
		btnFirst.setBounds(50,500 ,80, 20);
		this.add(btnFirst);
		btnFirst.addActionListener(new EmployeeHandler(this));
		
			
		btnNext = new Button("Next");
		btnNext.setBounds(140,500 ,80, 20);
		this.add(btnNext);
		btnNext.addActionListener(new EmployeeHandler(this));
		
		btnPrev = new Button("Prev");
		btnPrev.setBounds(230,500 ,80, 20);
		this.add(btnPrev);
		btnPrev.addActionListener(new EmployeeHandler(this));
		
		
		btnLast = new Button("Last");
		btnLast.setBounds(320,500 ,80, 20);
		this.add(btnLast);
		btnLast.addActionListener(new EmployeeHandler(this));
		
		
	//	this.addWindowListener(new EmployeeHandler());
		this.addWindowListener( new WindowAdapter() {
				public void windowClosing(WindowEvent e)
				{
			// TODO Auto-generated method stub
			EmpFrame ef = (EmpFrame)e.getSource();
			ef.dispose();

				}
		}
		
		);		
	}

	public Label getLabelEmployeeid() {
		return LabelEmployeeid;
	}

	public void setLabelEmployeeid(Label labelEmployeeid) {
		LabelEmployeeid = labelEmployeeid;
	}

	public Label getLabelEmployeeName() {
		return LabelEmployeeName;
	}

	public void setLabelEmployeeName(Label labelEmployeeName) {
		LabelEmployeeName = labelEmployeeName;
	}

	public TextField getTxtEmpId() {
		return txtEmpId;
	}

	public void setTxtEmpId(TextField txtEmpId) {
		this.txtEmpId = txtEmpId;
	}

	public TextField getTxtEmpNm() {
		return txtEmpNm;
	}

	public void setTxtEmpNm(TextField txtEmpNm) {
		this.txtEmpNm = txtEmpNm;
	}

	public Label getLblLocation() {
		return lblLocation;
	}

	public void setLblLocation(Label lblLocation) {
		this.lblLocation = lblLocation;
	}

	
	public Choice getOfficeLocation() {
		return officeLocation;
	}

	public void setOfficeLocation(Choice officeLocation) {
		this.officeLocation = officeLocation;
	}

	public Label getLblEmpAddress() {
		return lblEmpAddress;
	}

	public void setLblEmpAddress(Label lblEmpAddress) {
		this.lblEmpAddress = lblEmpAddress;
	}

	public TextArea getAddressTxt() {
		return addressTxt;
	}

	public void setAddressTxt(TextArea addressTxt) {
		this.addressTxt = addressTxt;
	}

	public Label getLblEmpSalary() {
		return lblEmpSalary;
	}

	public void setLblEmpSalary(Label lblEmpSalary) {
		this.lblEmpSalary = lblEmpSalary;
	}

	public TextField getEmpsalaryTxt() {
		return empsalaryTxt;
	}

	public void setEmpsalaryTxt(TextField empsalaryTxt) {
		this.empsalaryTxt = empsalaryTxt;
	}

	public Label getLblEmployeePerk() {
		return lblEmployeePerk;
	}

	public void setLblEmployeePerk(Label lblEmployeePerk) {
		this.lblEmployeePerk = lblEmployeePerk;
	}

	public Checkbox getPfOptionChk() {
		return pfOptionChk;
	}

	public void setPfOptionChk(Checkbox pfOptionChk) {
		this.pfOptionChk = pfOptionChk;
	}

	public Checkbox getMealptionChk() {
		return mealptionChk;
	}

	public void setMealptionChk(Checkbox mealptionChk) {
		this.mealptionChk = mealptionChk;
	}

	public Checkbox getNpsChk() {
		return npsChk;
	}

	public void setNpsChk(Checkbox npsChk) {
		this.npsChk = npsChk;
	}

	public Checkbox getGratuityChk() {
		return gratuityChk;
	}

	public void setGratuityChk(Checkbox gratuityChk) {
		this.gratuityChk = gratuityChk;
	}

	public Checkbox getMediclaimChk() {
		return MediclaimChk;
	}

	public void setMediclaimChk(Checkbox mediclaimChk) {
		MediclaimChk = mediclaimChk;
	}

	public CheckboxGroup getGenderGroup() {
		return GenderGroup;
	}

	public void setGenderGroup(CheckboxGroup genderGroup) {
		GenderGroup = genderGroup;
	}

	public Label getLblGender() {
		return lblGender;
	}

	public void setLblGender(Label lblGender) {
		this.lblGender = lblGender;
	}

	public Checkbox getMaleChk() {
		return maleChk;
	}

	public void setMaleChk(Checkbox maleChk) {
		this.maleChk = maleChk;
	}

	public Checkbox getFemaleChk() {
		return femaleChk;
	}

	public void setFemaleChk(Checkbox femaleChk) {
		this.femaleChk = femaleChk;
	}

	public Checkbox getOtherChk() {
		return otherChk;
	}

	public void setOtherChk(Checkbox otherChk) {
		this.otherChk = otherChk;
	}

	public Button getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(Button btnSave) {
		this.btnSave = btnSave;
	}

	public Button getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(Button btnDelete) {
		this.btnDelete = btnDelete;
	}

	public Button getBtnUpdate() {
		return btnUpdate;
	}

	public void setBtnUpdate(Button btnUpdate) {
		this.btnUpdate = btnUpdate;
	}

	public Button getBtnSearch() {
		return btnSearch;
	}

	public void setBtnSearch(Button btnSearch) {
		this.btnSearch = btnSearch;
	}

	public Button getBtnFirst() {
		return btnFirst;
	}

	public void setBtnFirst(Button btnFirst) {
		this.btnFirst = btnFirst;
	}

	public Button getBtnLast() {
		return btnLast;
	}

	public void setBtnLast(Button btnLast) {
		this.btnLast = btnLast;
	}

	public Button getBtnNext() {
		return btnNext;
	}

	public void setBtnNext(Button btnNext) {
		this.btnNext = btnNext;
	}

	public Button getBtnPrev() {
		return btnPrev;
	}

	public void setBtnPrev(Button btnPrev) {
		this.btnPrev = btnPrev;
	}

//	public Frame getF() {
//		return f;
//	}

//	public void setF(Frame f) {
//		this.f = f;
//	}

	
}
