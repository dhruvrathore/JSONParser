package entity;

public class Country {
	private CountriesCity india;
	private CountriesCity usa;
	
	public Country(){};
	public CountriesCity getIndia() {
		return india;
	}
	public void setIndia(CountriesCity india) {
		this.india = india;
	}
	public CountriesCity getUsa() {
		return usa;
	}
	public void setUsa(CountriesCity usa) {
		this.usa = usa;
	}
	
	
}
