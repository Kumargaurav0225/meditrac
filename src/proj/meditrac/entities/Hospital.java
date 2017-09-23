package proj.meditrac.entities;

public class Hospital 
{
	private String insertionId,state,hosName,hosCode,city,district,date,specialities,verified,blacklisted,email,telephone,zip;
    
	public class Verified {
		public static final String TRUE = "TRUE";
		public static final String FALSE = "FALSE";
	}

	public class Blacklisted {
		public static final String TRUE = "TRUE";
		public static final String FALSE = "FALSE";
	}
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVerified() {
		return verified;
	}
	public void setVerified(String verified) {
		this.verified = verified;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getHosName() {
		return hosName;
	}
	public void setHosName(String hosName) {
		this.hosName = hosName;
	}
	public String getHosCode() {
		return hosCode;
	}
	public String getBlacklisted() {
		return blacklisted;
	}
	public void setBlacklisted(String blacklisted) {
		this.blacklisted = blacklisted;
	}
	public void setHosCode(String hosCode) {
		this.hosCode = hosCode;
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
	public String getDate() {
		return date;
	}
	public String getInsertionId() {
		return insertionId;
	}
	public void setInsertionId(String insertionId) {
		this.insertionId = insertionId;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSpecialities() {
		return specialities;
	}
	public void setSpecialities(String specialities) {
		this.specialities = specialities;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "Hospital [insertionId=" + insertionId + ", state=" + state + ", hosName=" + hosName + ", hosCode="
				+ hosCode + ", city=" + city + ", district=" + district + ", date=" + date + ", specialities="
				+ specialities + ", verified=" + verified + ", blacklisted=" + blacklisted + ", zip=" + zip + "]";
	}
    
}
