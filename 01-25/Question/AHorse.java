public class AHorse implements Horse
{
	private String name;
	private int weight;
	
	public AHorse(String name, int weight)
	{
		this.name = name;
		this.weight = weight;
	}
	
	/** @return the horse's name */
	public String getName()
	{
		return name; 
	}
	/** @return the horse's weight */
	public int getWeight()
	{
		return weight;
	}	
	
	// There may be methods that are not shown.
}
