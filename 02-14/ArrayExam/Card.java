public class Card{
	private double value;
	public Card(double value){
		this.value = value;
	}
	
	public double getValue(){
		return value;
	}
	
	public String toString(){
		return ""+value;
	}
}