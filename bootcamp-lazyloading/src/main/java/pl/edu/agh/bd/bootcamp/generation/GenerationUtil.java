package pl.edu.agh.bd.bootcamp.generation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class GenerationUtil {
	private static Random random = new Random();

	private static String[] names = { "Sophia", "Emma", "Olivia", "Isabella", "Ava", "Lily", "Zoe", "Chloe", "Mia",
			"Madison", "Emily", "Ella", "Madelyn", "Abigail", "Aubrey", "Addison", "Avery", "Layla", "Hailey",
			"Amelia", "Hannah", "Charlotte", "Kaitlyn", "Harper", "Kaylee", "Sophie", "Mackenzie", "Peyton", "Riley",
			"Grace", "Brooklyn", "Sarah", "Aaliyah", "Anna", "Arianna", "Ellie", "Natalie", "Isabelle", "Lillian",
			"Evelyn", "Elizabeth", "Lyla", "Lucy", "Claire", "Makayla", "Kylie", "Audrey", "Maya", "Leah", "Gabriella",
			"Aiden", "Jackson", "Ethan", "Liam", "Mason", "Noah", "Lucas", "Jacob", "Jayden", "Jack", "Logan", "Ryan",
			"Caleb", "Benjamin", "William", "Michael", "Alexander", "Elijah", "Matthew", "Dylan", "James", "Owen",
			"Connor", "Brayden", "Carter", "Landon", "Joshua", "Luke", "Daniel", "Gabriel", "Nicholas", "Nathan",
			"Oliver", "Henry", "Andrew", "Gavin", "Cameron", "Eli", "Max", "Isaac", "Evan", "Samuel", "Grayson",
			"Tyler", "Zachary", "Wyatt", "Joseph", "Charlie", "Hunter", "David" };

	private static String[] surnames = { "Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia",
			"Rodriguez", "Wilson", "Altiery", "Altig", "Altimus", "Altizer", "Altken", "Altman", "Altmann", "Altmark",
			"Altmiller", "Altmire", "Alto", "Altobell", "Altobelli", "Altobello", "Altom", "Altomare", "Altomari",
			"Altomonte", "Alton", "Altonen" };

	private static String capitalLetters = "QWERTYUIOPASDFGHJJKLZXCVBNM";
	private static String letters = "qwertyuiopasdfghjklzxcvbnm";

	private static String[] titles = { "Mr.", "Ms.", "Dr", "Prof." };

	private static String[] countries = { "Andorra", "United Arab Emirates", "Afghanistan", "Antigua and Barbuda",
			"Anguilla", "Albania", "Armenia", "Netherlands Antilles", "Angola", "Antarctica", "Argentina",
			"American Samoa", "Austria", "Australia", "Aruba", "Åland Islands", "Azerbaijan", "Bosnia and Herzegovina",
			"Barbados", "Bangladesh", "Belgium", "Burkina Faso", "Bulgaria", "Bahrain", "Burundi", "Benin", "Bermuda",
			"Brunei", "Bolivia", "Brazil", "Bahamas", "Bhutan", "Bouvet Island", "Botswana", "Belarus", "Belize",
			"Canada", "Cocos Islands", "The Democratic Republic Of Congo", "Central African Republic", "Congo",
			"Switzerland", "Côte d'Ivoire", "Cook Islands", "Chile", "Cameroon", "China", "Colombia", "Costa Rica",
			"Serbia and Montenegro", "Cuba", "Cape Verde", "Christmas Island", "Cyprus", "Czech Republic", "Germany",
			"Djibouti", "Denmark", "Dominica", "Dominican Republic", "Algeria", "Ecuador", "Estonia", "Egypt",
			"Western Sahara", "Eritrea", "Spain", "Ethiopia", "Finland", "Fiji", "Falkland Islands", "Micronesia",
			"Faroe Islands", "France", "Gabon", "United Kingdom", "Grenada", "Georgia", "French Guiana", "Guernsey",
			"Ghana", "Gibraltar", "Greenland", "Gambia", "Guinea", "Guadeloupe", "Equatorial Guinea", "Greece",
			"South Georgia And The South Sandwich Islands", "Guatemala", "Guam", "Guinea-Bissau", "Guyana",
			"Hong Kong", "Heard Island And McDonald Islands", "Honduras", "Croatia", "Haiti", "Hungary", "Indonesia",
			"Ireland", "Israel", "Isle Of Man", "India", "British Indian Ocean Territory", "Iraq", "Iran", "Iceland",
			"Italy", "Jersey", "Jamaica", "Jordan", "Japan", "Kenya", "Kyrgyzstan", "Cambodia", "Kiribati", "Comoros",
			"Saint Kitts And Nevis", "North Korea", "South Korea", "Kuwait", "Cayman Islands", "Kazakhstan", "Laos",
			"Lebanon", "Saint Lucia", "Liechtenstein", "Sri Lanka", "Liberia", "Lesotho", "Lithuania", "Luxembourg",
			"Latvia", "Libya", "Morocco", "Monaco", "Moldova", "Montenegro", "Madagascar", "Marshall Islands",
			"Macedonia", "Mali", "Myanmar", "Mongolia", "Macao", "Northern Mariana Islands", "Martinique",
			"Mauritania", "Montserrat", "Malta", "Mauritius", "Maldives", "Malawi", "Mexico", "Malaysia", "Mozambique",
			"Namibia", "New Caledonia", "Niger", "Norfolk Island", "Nigeria", "Nicaragua", "Netherlands", "Norway",
			"Nepal", "Nauru", "Niue", "New Zealand", "Oman", "Panama", "Peru", "French Polynesia", "Papua New Guinea",
			"Philippines", "Pakistan", "Poland", "Saint Pierre And Miquelon", "Pitcairn", "Puerto Rico", "Palestine",
			"Portugal", "Palau", "Paraguay", "Qatar", "Reunion", "Romania", "Serbia", "Russia", "Rwanda",
			"Saudi Arabia", "Solomon Islands", "Seychelles", "Sudan", "Sweden", "Singapore", "Saint Helena",
			"Slovenia", "Svalbard And Jan Mayen", "Slovakia", "Sierra Leone", "San Marino", "Senegal", "Somalia",
			"Suriname", "Sao Tome And Principe", "El Salvador", "Syria", "Swaziland", "Turks And Caicos Islands",
			"Chad", "French Southern Territories", "Togo", "Thailand", "Tajikistan", "Tokelau", "Timor-Leste",
			"Turkmenistan", "Tunisia", "Tonga", "Turkey", "Trinidad and Tobago", "Tuvalu", "Taiwan", "Tanzania",
			"Ukraine", "Uganda", "United States Minor Outlying Islands", "United States", "Uruguay", "Uzbekistan",
			"Vatican", "Saint Vincent And The Grenadines", "Venezuela", "British Virgin Islands",
			"U.S. Virgin Islands", "Vietnam", "Vanuatu", "Wallis And Futuna", "Samoa", "Yemen", "Mayotte",
			"South Africa", "Zambia", "Zimbabwe" };

	private static String companies[] = { "CARBON POLYMERS LIMITED", "CARDIA BIOPLASTICS LIMITED",
			"CARDINAL RESOURCES LIMITED", "CARDNO LIMITED", "CAREERS MULTILIST LIMITED", "CARINDALE PROPERTY TRUST",
			"CARLTON INVESTMENTS LIMITED", "CARNARVON PETROLEUM LIMITED", "CARNAVALE RESOURCES LIMITED",
			"CARNEGIE WAVE ENERGY LIMITED", "CARPATHIAN RESOURCES LIMITED", "CARPENTARIA EXPLORATION LIMITED",
			"CARSALES.COM LIMITED", "CASH CONVERTERS INTERNATIONAL", "CASSINI RESOURCES LIMITED",
			"CASTLE MINERALS LIMITED", "CATALYST METALS LIMITED", "CAULDRON ENERGY LIMITED",
			"CAZALY RESOURCES LIMITED", "CB AUSTRALIA LIMITED", "CBD ENERGY LIMITED", "CEDAR WOODS PROPERTIES LIMITED",
			"CELAMIN HOLDINGS NL", "CELL AQUACULTURE LIMITED", "CELLMID LIMITED", "CELLNET GROUP LIMITED",
			"CELSIUS COAL LIMITED", "CENTAURUS METALS LIMITED", "CENTIUS GOLD LIMITED" };

	private static String streets[] = { "Floyd Bennett Field", "Flushing Avenue", "Folsom Place", "Forbell Street",
			"Force Tube Avenue", "Ford Street", "Forest Place", "Forrest Street", "Fort Greene Place",
			"Fort Hamilton Parkway", "Fort Hill Place", "Foster Avenue", "Fountain Avenue", "Frank Court",
			"Franklin Street", "Franklin Avenue", "Freeman Street", "Margaret Court", "Marginal Street",
			"Marine Parkway", "Marine Avenue", "Marion Street", "Market Street", "Marlborough Road",
			"Marlborough Court", "Marshall Street", "Martense Court", "Martense Street", "Martin Luther King Place",
			"Maspeth Avenue" };

	private static String[] cities = { "Paris", "Marseille", "Lyon", "Toulouse", "Nice", "Nantes", "Strasbourg",
			"Montpellier", "Bordeaux", "Lille", "Rennes", "Reims", "Le Havre", "Saint-Étienne", "Toulon", "Grenoble",
			"Angers", "Dijon", "Brest", "Nîmes", "Le Mans	Sarthe", "Aix-en-Provence	Bouches-du-Rhône",
			"Clermont-Ferrand", "Saint-Denis	Réunion", "Limoges	Haute-Vienne", "Villeurbanne", "Amiens", "Metz",
			"Besançon", "Perpignan", "Orléans", "Mulhouse" };

	public static String getString(int maxSize) {
		String ret = capitalLetters.charAt(random.nextInt(capitalLetters.length())) + "";
		int sz = random.nextInt(maxSize / 2) + maxSize / 2 + 1;
		if (sz < 3)
			sz = 3;
		while (sz-- != 0) {
			ret += letters.charAt(random.nextInt(letters.length()));
		}
		return ret;
	}

	public static String getNumber() {
		return random.nextInt(1000) + "";
	}

	public static String getTitle() {
		return titles[random.nextInt(titles.length)];
	}

	public static String getName() {
		return names[random.nextInt(names.length)];
	}

	public static String getSurname() {
		return surnames[random.nextInt(surnames.length)];
	}

	public static String getCountry() {
		return countries[random.nextInt(countries.length)];
	}

	public static String getCompany() {
		return companies[random.nextInt(companies.length)];
	}

	public static String getPhone() {
		return "00" + (random.nextInt(90) + 10) + " " + (random.nextInt(900) + 100) + " " + (random.nextInt(900) + 100)
				+ " " + (random.nextInt(900) + 100);
	}

	public static String getPostalCode() {
		return (random.nextInt(90) + 10) + "-" + (random.nextInt(900) + 100);
	}

	public static String getAddress() {
		return streets[random.nextInt(streets.length)];
	}

	public static String getContact() {
		return getName() + " " + getSurname();
	}

	public static String getCity() {
		return cities[random.nextInt(cities.length)];
	}

	public static int nextInt(int n) {
		return random.nextInt(n);
	}

	public static <T> List<T> pickSome(List<T> items, int n) {
		if (items.size() == 0) {
			throw new RuntimeException("Couldn't pick random elements. You probably didn't generate related data");
		}
		List<T> list = new ArrayList<T>();
		List<Integer> indices = new ArrayList<Integer>();
		for (int i = 0; i < items.size(); i++) {
			indices.add(i);
		}
		for (int i = 0; i < n; i++) {
			if (items.size() == 0)
				break;
			int ind = indices.remove(random.nextInt(indices.size()));
			list.add(items.get(ind));
		}
		return list;
	}

	public static <T> T pickOne(List<T> items) {
		if (items.size() == 0) {
			throw new RuntimeException("Couldn't pick random elements. You probably didn't generate related data");
		}
		return items.get(random.nextInt(items.size()));
	}

	public static boolean nextBoolean() {
		return random.nextBoolean();
	}

	public static double nextDouble() {
		return random.nextDouble() * random.nextInt(1000);
	}

	public static String getWww() {
		return "www." + getString(20) + ".com";
	}

	public static String getRegion() {
		return getString(8);
	}

	@SuppressWarnings("deprecation")
	public static Date getBirthDate() {
		Date date = new Date();
		date.setYear(random.nextInt(100));
		date.setMonth(random.nextInt(12));
		return date;
	}

	@SuppressWarnings("deprecation")
	public static Date getOrderDate() {
		Date date = new Date();
		date.setYear(random.nextInt(10) + 100);
		date.setMonth(random.nextInt(12));
		date.setHours(random.nextInt(100));
		return date;
	}
}
