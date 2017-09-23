package proj.meditrac.entities;

public class Patient {
	private String patientName,gender,dob,email,city,district,state,complication,pId;
	private String phone,ptc;
	private Doctor doctor;
	private Hospital hospital;
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPhone() {
		return phone;
	}
	public String getPtc() {
		return ptc;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setPtc(String ptc) {
		this.ptc = ptc;
	}
	public Patient(String patientName,String gender,String dob, String email, String city,
			String district, String state, String complication, String phone,
			String ptc) {
		super();
		this.patientName = patientName;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
		this.city = city;
		this.district = district;
		this.state = state;
		this.complication = complication;
		this.phone = phone;
		this.ptc = ptc;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getComplication() {
		return complication;
	}
	public void setComplication(String complication) {
		this.complication = complication;
	}
	@Override
	public String toString() {
		return "Patient [patientName=" + patientName + ", gender=" + gender
				+ ", dob=" + dob + ", email=" + email + ", city=" + city
				+ ", district=" + district + ", state=" + state
				+ ", complication=" + complication + ", phone=" + phone
				+ ", ptc=" + ptc + "]";
	}
	
	

	
}
