package proj.meditrac.entities;

public class Doctor {
	private String dID,doctorName,gender,specialisation,experience,dob,email,city,district,state,phone,ptc;


	private Hospital hospital;
	private Patient patient;
	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public String getDoctorName() {
		return doctorName;
	}


	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}


	public Hospital getHospital() {
		return hospital;
	}


	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}


	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Doctor(String dID, String doctorName, String gender,
			String specialisation, String experience, String dob, String email,
			String city, String district, String state, String phone, String ptc) {
		super();
		this.dID = dID;
		this.doctorName = doctorName;
		this.gender = gender;
		this.specialisation = specialisation;
		this.experience = experience;
		this.dob = dob;
		this.email = email;
		this.city = city;
		this.district = district;
		this.state = state;
		this.phone = phone;
		this.ptc = ptc;
	}

	

	public String getdID() {
		return dID;
	}


	public void setdID(String dID) {
		this.dID = dID;
	}


	public String getdoctorName() {
		return doctorName;
	}


	public void setdoctorName(String doctorName) {
		this.doctorName = doctorName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getSpecialisation() {
		return specialisation;
	}


	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}


	public String getExperience() {
		return experience;
	}


	public void setExperience(String experience) {
		this.experience = experience;
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


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPtc() {
		return ptc;
	}


	public void setPtc(String ptc) {
		this.ptc = ptc;
	}


	@Override
	public String toString() {
		return "Doctor [dID=" + dID + ", doctorName=" + doctorName
				+ ", gender=" + gender + ", specialisation=" + specialisation
				+ ", experience=" + experience + ", dob=" + dob + ", email="
				+ email + ", city=" + city + ", district=" + district
				+ ", state=" + state + ", phone=" + phone + ", ptc=" + ptc
				+ "]";
	}

	
	}
