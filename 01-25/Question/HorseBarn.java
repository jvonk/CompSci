public class HorseBarn
{
	/** The spaces in the barn. Each array element holds a reference to the horse
	* that is currently occupying the space. A null value indicates an empty space.
	*/
	private Horse[] spaces;
	
	public HorseBarn(Horse[] spaces)
	{
		this.spaces = spaces;
	}
	
	
	/** Returns the index of the space that contains the horse with the specified name.
	* Precondition: No two horses in the barn have the same name.
	* @param name the name of the horse to find
	* @return the index of the space containing the horse with the specified name;
	* -1 if no horse with the specified name is in the barn.
	*/
	public int findHorseSpace(String name)
	{ /* to be implemented in part (a) */
	}
	
	
	/** Consolidates the barn by moving horses so that the horses are in adjacent spaces,
	* starting at index 0, with no empty space between any two horses.
	* Postcondition: The order of the horses is the same as before the consolidation.
	*/
	public void consolidate()
	{ /* to be implemented in part (b) */ 
	}
	
	public void showBarn()
	{
		int index = 0;
		for(Horse each : spaces )
		{
			if( each == null )
			{
				System.out.println(index + ") null");
			}
			else
			{
				System.out.println(index + ") " + each.getName() + ":" + each.getWeight());
			}
			index++;
		}
	}
	
	// There may be instance variables, constructors, and methods that are not shown.
}

