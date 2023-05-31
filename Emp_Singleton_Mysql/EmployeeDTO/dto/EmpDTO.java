
package EmployeeDTO.dto;

public class EmpDTO {
	
	private int EmpIdDTO;
	private String  empnameDTO;
	private boolean pfDTO,mealDTO,npsDTO,gratuityDTO,medicalDTO;
	private String officeLocationDTO;
	private String genderDTO;
	private String addressDTO;
	private double salaryDTO;
	
	
		public int getEmpIdDTO() {
		return EmpIdDTO;
		}
		public void setEmpIdDTO(int empIdDTO) {
		EmpIdDTO = empIdDTO;
		}
		public String getEmpnameDTO() {
		return empnameDTO;
		}
		public void setEmpnameDTO(String empnameDTO) {
		this.empnameDTO = empnameDTO;
		}
		public boolean isPfDTO() {
		return pfDTO;
		}
		public void setPfDTO(boolean pfDTO) {
		this.pfDTO = pfDTO;
		}
		public boolean isMealDTO() {
		return mealDTO;
		}
		public void setMealDTO(boolean mealDTO) {
		this.mealDTO = mealDTO;
		}
		public boolean isNpsDTO() {
		return npsDTO;
		}
		public void setNpsDTO(boolean npsDTO) {
		this.npsDTO = npsDTO;
		}
		public boolean isGratuityDTO() {
		return gratuityDTO;
		}
		public void setGratuityDTO(boolean gratuityDTO) {
		this.gratuityDTO = gratuityDTO;
		}
		public boolean isMedicalDTO() {
		return medicalDTO;
		}
		public void setMedicalDTO(boolean medicalDTO) {
			this.medicalDTO = medicalDTO;
		}
		public String getOfficeLocationDTO() {
		return officeLocationDTO;
		}
		public void setOfficeLocationDTO(String officeLocationDTO) {
		this.officeLocationDTO = officeLocationDTO;
		}
		public String getGenderDTO() {
		return genderDTO;
		}
		public void setGenderDTO(String genderDTO) {
		this.genderDTO = genderDTO;
		}
		public String getAddressDTO() {
		return addressDTO;
		}
		public void setAddressDTO(String addressDTO) {
		this.addressDTO = addressDTO;
		}
				
		public double getSalaryDTO() {
		return salaryDTO;
		}
		public void setSalaryDTO(double salaryDTO) {
		this.salaryDTO = salaryDTO;
		}
	
	
	@Override
	public String toString() {
	/*	return "EmpDTO [EmpIdDTO=" + EmpIdDTO + ", empnameDTO=" + empnameDTO + ", pfDTO=" + pfDTO + ", mealDTO="
				+ mealDTO + ", npsDTO=" + npsDTO + ", gratuityDTO=" + gratuityDTO + ", medicalDTO=" + medicalDTO
				+ ", officeLocationDTO=" + officeLocationDTO + ", genderDTO=" + genderDTO + ", addressDTO=" + addressDTO
				+ ", salaryDTO=" + salaryDTO + "]";*/
		

			return "EmpDTO [empnameDTO=" + empnameDTO + ", pfDTO=" + pfDTO + ", mealDTO="
					+ mealDTO + ", npsDTO=" + npsDTO + ", gratuityDTO=" + gratuityDTO + ", medicalDTO=" + medicalDTO
					+ ", officeLocationDTO=" + officeLocationDTO + ", genderDTO=" + genderDTO + ", addressDTO=" + addressDTO
					+ ", salaryDTO=" + salaryDTO + "]";
	}	
	
}
