import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *	Population - Loads a list of approx. 30,000 US cities into a List. 
 * 		Each entry specifies the state name, city name, type of city, 
 * 		and population. The list can be sorted by ascending population
 * 		order, descending population order, alphabetical order by name,
 * 		and reverse alphabetical order by name. Also gives lists of 
 * 		most populous cities in a given state and all cities matching a
 * 		given name sorted by population.
 *
 *	Requires FileUtils and Prompt classes.
 *
 *	@author	Daphne Guo
 *	@since	January 9, 2023
 */
public class Population {
	
	// List of cities
	private List<City> cities;
	
	// Instance of SortMethods
	private SortMethods sort;
	
	// Record elapsed time per sort
	private long startMillisec, endMillisec;
	
	// US data file
	private final String DATA_FILE = "usPopData2017.txt";
	
	/**
	 * Constructor
	 */
	public Population() {
		cities = new ArrayList<City>();
		sort = new SortMethods();
		startMillisec = 0;
		endMillisec = 0;
	}
	
	/**	Prints the introduction to Population */
	public void printIntroduction() {
		System.out.println("   ___                  _       _   _");
		System.out.println("  / _ \\___  _ __  _   _| | __ _| |_(_) ___  _ __ ");
		System.out.println(" / /_)/ _ \\| '_ \\| | | | |/ _` | __| |/ _ \\| '_ \\ ");
		System.out.println("/ ___/ (_) | |_) | |_| | | (_| | |_| | (_) | | | |");
		System.out.println("\\/    \\___/| .__/ \\__,_|_|\\__,_|\\__|_|\\___/|_| |_|");
		System.out.println("           |_|");
		System.out.println();
	}
	
	/**	Print out the choices for population sorting */
	public void printMenu() {
		System.out.println("1. Fifty least populous cities in USA (Selection Sort)");
		System.out.println("2. Fifty most populous cities in USA (Merge Sort)");
		System.out.println("3. First fifty cities sorted by name (Insertion Sort)");
		System.out.println("4. Last fifty cities sorted by name descending (Merge Sort)");
		System.out.println("5. Fifty most populous cities in named state");
		System.out.println("6. All cities matching a name sorted by population");
		System.out.println("9. Quit");
	}
	
	public static void main(String[] args) {
		Population p = new Population();
		p.run();
	}
	
	/**
	 * Runs the program
	 */
	public void run() {
		printIntroduction();
		loadData();
		int i = 0;
		while(i != 9) {
			i = 0;
			System.out.println();
			printMenu();
			do {
				i = Prompt.getInt("Enter selection");
			}
			while(i < 1 || i > 6 && i!= 9);
			startMillisec = System.currentTimeMillis();
			switch(i) {
				case 1: cities = leastPop(cities); 
					break;
				case 2: cities = mostPop(cities); 
					break;
				case 3: firstName(); 
					break;
				case 4: lastName(); 
					break;
				case 5: topInState(); 
					break;
				case 6: matchName(); 
					break;
				case 9:
					break;
			}
			if(i >= 1 && i <= 4) {
				printData(50, cities);
			}
		}
		System.out.println("\nThanks for using Population!\n");
	}
	
	/**
	 * Read list of cities from the file usPopData2017.txt and enters
	 * the entries into the list
	 */
	public void loadData() {
	/*	Scanner infile = FileUtils.openToRead(DATA_FILE);
		infile.useDelimiter("[\t\n]")
		while(infile.hasNextLine()) {
			String state = infile.next();
			String name = infile.next();
			String designation = infile.next();
			int population = infile.nextInt();
			City c = new City(name, state, designation, population);
			cities.add(c);
		} */
	}
	
	/**
	 * Prints the first x entries in a given list of cities, formatted 
	 * like a table
	 * @param x				number of entries to print
	 * @param printList		list of cities to be printed
	 */
	public void printData(int x, List<City> printList) {
	/*	System.out.println(String.format("%5s %-22s %-22s %-12s %12s", " ",
											"state", "city", "type", "population")); 
		for(int i = 1; i <= x; i++) {
			System.out.print(String.format("%5s ", "" + i + ": "));
			System.out.println(printList.get(i - 1).toString());
		} */
		System.out.println("\nElapsed time: " + (endMillisec - startMillisec) + "\n");
	}
	
	/**
	 * Sorts cities in ascending population order (selection sort)
	 * @param sortList		list of cities to be sorted
	 * @return				the sorted list
	 */
	public List<City> leastPop(List<City> sortList) {
	//	sort.selectionSort(sortList);
		endMillisec = System.currentTimeMillis();
		return sortList;
	}
	
	/**
	 * Sorts cities in descending population order (merge sort)
	 * @param sortList		list of cities to be sorted
	 * @return				the sorted list
	 */
	public List<City> mostPop(List<City> sortList) {
	//	sort.mergeSort(sortList);
		List<City> backwardsList = new ArrayList<City>();
		for(int i = sortList.size(); i >= 0; i--) {
			backwardsList.add(sortList.get(i));
		}
		endMillisec = System.currentTimeMillis();
		return backwardsList;
	}
	
	/**
	 * Sorts cities in ascending name order (insertion sort)
	 */
	public void firstName() {
		
		endMillisec = System.currentTimeMillis();
	}
	
	/**
	 * Sorts cities in descending name order (merge sort)
	 */
	public void lastName() {
		mergeSortName(cities);
		endMillisec = System.currentTimeMillis();
	}
	
	/**
	 * Merge sort algorithm - descending name order
	 * @param sortList		list of cities to be sorted
	 */
	public void mergeSortName(List<City> sortList) {
		
	}
	
	/**
	 * List of most populous cities in a given state
	 */
	public void topInState() {
		boolean isDone = false;
		List<City> stateCities = new ArrayList<City>();
		String state = "";
		while(!isDone) {
			stateCities = new ArrayList<City>();
			state = Prompt.getString("Enter state name (ie. \"Alabama\")");
			for(int i = 0; i < cities.size(); i++) {
				if(cities.get(i).getState().equals(state)) {
					stateCities.add(cities.get(i));
					isDone = true;
				}
			}
			if(!isDone) {
				System.out.println("ERROR: " + state + " is not valid");
			}
		}
		startMillisec = System.currentTimeMillis();
		stateCities = mostPop(stateCities);
		printData(50, stateCities);
	}
	
	/**
	 * List of all cities with a given name sorted in descending
	 * population order
	 */
	public void matchName() {
		boolean isDone = false;
		List<City> nameCities = new ArrayList<City>();
		String name = "";
		while(!isDone) {
			nameCities = new ArrayList<City>();
			name = Prompt.getString("Enter city name (ie. \"Abbeville\")");
			for(int i = 0; i < cities.size(); i++) {
				if(cities.get(i).getName().equals(name)) {
					nameCities.add(cities.get(i));
					isDone = true;
				}
			}
			if(!isDone) {
				System.out.println("ERROR: " + name + " is not valid");
			}
		}
		startMillisec = System.currentTimeMillis();
		nameCities = leastPop(nameCities);
		printData(50, nameCities);
	}
}