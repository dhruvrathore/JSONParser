package test.entity;

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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((india == null) ? 0 : india.hashCode());
		result = prime * result + ((usa == null) ? 0 : usa.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (india == null) {
			if (other.india != null)
				return false;
		} else if (!india.equals(other.india))
			return false;
		if (usa == null) {
			if (other.usa != null)
				return false;
		} else if (!usa.equals(other.usa))
			return false;
		return true;
	}
	
	
	
}
