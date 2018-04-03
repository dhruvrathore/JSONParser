package test.entity;

public class BooleanEntity {
	
	private boolean isBool;

	public BooleanEntity(){
		
	}
	
	public BooleanEntity(boolean isBool) {
		super();
		this.isBool = isBool;
	}

	public void setIsBool(boolean isBool) {
		this.isBool = isBool;
	}

	public boolean isBool() {
		return isBool;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isBool ? 1231 : 1237);
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
		BooleanEntity other = (BooleanEntity) obj;
		if (isBool != other.isBool)
			return false;
		return true;
	}
	
	

}
