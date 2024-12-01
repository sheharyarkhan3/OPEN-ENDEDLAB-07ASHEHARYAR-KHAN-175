package KarachiRealEstateAppLAB07SHEHARYARKHAN175TASK3;
		import java.util.*;

		// Class representing a property
		class Property {
		    private String id;
		    private String address;
		    private double price;

		    public Property(String id, String address, double price) {
		        this.id = id;
		        this.address = address;
		        this.price = price;
		    }

		    public String getId() {
		        return id;
		    }

		    public String getAddress() {
		        return address;
		    }

		    public double getPrice() {
		        return price;
		    }

		    // Validation method for property
		    public static boolean validateProperty(Property property) {
		        return property.getId() != null && !property.getId().isEmpty() &&
		               property.getAddress() != null && !property.getAddress().isEmpty() &&
		               property.getPrice() > 0;
		    }
		}

		// Class managing the real estate properties
		class PropertyManager {
		    private List<Property> propertyList = new ArrayList<>();
		    private Set<String> uniquePropertyIds = new HashSet<>();

		    // Method to add a property
		    public boolean addProperty(Property property) {
		        if (Property.validateProperty(property) && uniquePropertyIds.add(property.getId())) {
		            propertyList.add(property);
		            return true;
		        }
		        return false;
		    }

		    // Method to filter properties by price range
		    public List<Property> filterProperties(double minPrice, double maxPrice) {
		        List<Property> filteredProperties = new ArrayList<>();
		        for (Property property : propertyList) {
		            if (property.getPrice() >= minPrice && property.getPrice() <= maxPrice) {
		                filteredProperties.add(property);
		            }
		        }
		        return filteredProperties;
		    }

		    // Method to get properties with pagination
		    public List<Property> getProperties(int page, int pageSize) {
		        int start = (page - 1) * pageSize;
		        int end = Math.min(start + pageSize, propertyList.size());
		        return propertyList.subList(start, end);
		    }
		}

		// Main class to demonstrate functionality
		
public class KarachiRealEstateAppLAB07SHEHARYARKHAN175TASK3 {
	public static void main(String[] args) {
		        PropertyManager propertyManager = new PropertyManager();

		        // Adding properties
		        propertyManager.addProperty(new Property("1", "B-16 Main University Road, Karachi", 5000000));
		        propertyManager.addProperty(new Property("2", "B-13 Gulshan Road , Karachi", 7500000));
		        propertyManager.addProperty(new Property("3", "B11/A north nazimabad ,Karachi", 3000000));

		        // Filtering properties
		        List<Property> affordableProperties = propertyManager.filterProperties(2000000, 6000000);
		        System.out.println("LAB#07 TASK:03 SHEHARYAR KHAN:");
		        System.out.println("Affordable Properties:");
		        for (Property property : affordableProperties) {
		            System.out.println(property.getAddress() + ":" + property.getPrice());
		        }

		        // Paginated property retrieval
		        List<Property> paginatedProperties = propertyManager.getProperties(1, 2);
		        System.out.println("Paginated Properties:");
		        for (Property property : paginatedProperties) {
		            System.out.println(property.getAddress() + ":" + property.getPrice());
		        }	    
		
		// TODO Auto-generated method stub
	}
}
