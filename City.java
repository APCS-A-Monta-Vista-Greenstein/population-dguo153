/**
 *	City data - the city name, state name, location designation,
 *				and population est. 2017
 *
 *	@author	Daphne Guo
 *	@since	January 9, 2023
 */
public class City implements Comparable<City> {
	
	// fields
	private String name, state, designation;
	private int population;
	
	// constructor
	public City(String cName, String sName, String cType, int p) {
		name = cName;
		state = sName;
		designation = cType;
		population = p;
	}
	
	/**	Compare two cities populations
	 *	@param other		the other City to compare
	 *	@return				the following value:
	 *		If populations are different, then returns (this.population - other.population)
	 *		else if states are different, then returns (this.state - other.state)
	 *		else returns (this.name - other.name)
	 */
	public int compareTo(City other) {
		if(this.population != other.population) {
			return this.population - other.population;
		}
		else if(!this.getState().equals(other.getState())) {
			return this.state.compareTo(other.state);
		}
		else {
			return this.name.compareTo(other.name);
		}
	}
	
	/**	Equal city name and state name
	 *	@param other		the other City to compare
	 *	@return				true if city name and state name equal; false otherwise
	 */
	public boolean equals(City other) {
		return this.name.equals(other.name) && this.state.equals(other.state);
	}
	
	/**
	 * Accessor method for city name
	 * @return				the name of the city
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Accessor method for state name
	 * @return				the name of the state
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Accessor method for city designation
	 * @return				the designation of the city
	 */
	public String getDesignation() {
		return designation;
	}
	
	/**
	 * Accessor method for city population
	 * @return				the population of the city
	 */
	public int getPopulation() {
		return population;
	}
	
	/**	
	 * toString 
	 * @return				formatted String listing state, city name, 
	 * 						designation, population
	 */
	@Override
	public String toString() {
		return String.format("%-22s %-22s %-12s %,12d", state, name, designation,
						population);
	}
}
