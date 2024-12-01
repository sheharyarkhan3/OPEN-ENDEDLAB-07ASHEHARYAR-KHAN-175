# OPEN-ENDEDLAB-07ASHEHARYAR-KHAN-175
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
package KarachiRealEstateAppLAB07SHEHARYARKHAN175TASK4;
		import java.util.ArrayList;
		import java.util.List;
		// Class representing a property
		class Property {
		    private String id;
		    private String address;
		    private long price;

		    public Property(String id, String address, long price) {
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

		    public long getPrice() {
		        return price;
		    }
		}

		// Thread for calculating total property value
		class CalculationThread extends Thread {
		    private List<Property> properties;
		    private long totalValue;

		    public CalculationThread(List<Property> properties) {
		        this.properties = properties;
		    }

		    @Override
		    public void run() {
		    	System.out.println("LAB#07 TASK:04 SHEHARYAR KHAN:");
		        System.out.println("Starting calculation...");
		        // Simulate some processing time
		        try {
		            Thread.sleep(1000); // Sleep for 1 second
		            for (Property property : properties) {
		                totalValue += property.getPrice();
		            }
		            System.out.println("Total property value: " + totalValue);
		        } catch (InterruptedException e) {
		            System.out.println("Calculation interrupted.");
		        }
		    }

		    public long getTotalValue() {
		        return totalValue;
		    }
		}

		// Thread for logging property details
		class LoggingThread extends Thread {
		    private List<Property> properties;

		    public LoggingThread(List<Property> properties) {
		        this.properties = properties;
		    }

		    @Override
		    public void run() {
		        System.out.println("Starting logging...");
		        // Simulate some processing time
		        try {
		            Thread.sleep(500); // Sleep for 500 milliseconds
		            for (Property property : properties) {
		                System.out.println("Logging property: " + property.getAddress() + " - " + property.getPrice());
		            }
		        } catch (InterruptedException e) {
		            System.out.println("Logging interrupted.");
		        }
		    }
		}

		// Main class to demonstrate multithreading
		public class KarachiRealEstateAppLAB07SHEHARYARKHAN175TASK4 {

			public static void main(String[] args) {
		        List<Property> propertyList = new ArrayList<>();
		        propertyList.add(new Property("1", "B-16 Main University Road,Karachi", 5000000));
		        propertyList.add(new Property("2", "B-13 Gulshan Road,Karachi", 7500000));
		        propertyList.add(new Property("3", "B11/A north nazimabad Road,Karachi", 3000000));
		        // Create threads for calculation and logging
		        CalculationThread calculationThread = new CalculationThread(propertyList);
		        LoggingThread loggingThread = new LoggingThread(propertyList);

		        // Start the calculation thread first
		        calculationThread.start();

		        try {
		            // Use join() to wait for the calculationThread to complete before starting logging
		            calculationThread.join();
		        } catch (InterruptedException e) {
		            System.out.println("Main thread interrupted while waiting for calculation.");
		        }

		        // Start the logging thread after calculation is complete
		        loggingThread.start();

		        try {
		            // Use join() to wait for the loggingThread to complete
		            loggingThread.join();
		        } catch (InterruptedException e) {
		            System.out.println("Main thread interrupted while waiting for logging.");
		        }

		        System.out.println("All tasks completed.");
		// TODO Auto-generated method stub
	}
}
package KarachiRealEstateAppLAB07SHEHARYARKHAN175TASK5;
		import java.util.LinkedList;
		import java.util.Queue;
		// Shared buffer for properties
		class PropertyBuffer {
		    private final Queue<Property> properties = new LinkedList<>();
		    private final int capacity;

		    public PropertyBuffer(int capacity) {
		        this.capacity = capacity;
		    }
		    // Synchronized method for the producer to add properties
		    public synchronized void addProperty(Property property) throws InterruptedException {
		        while (properties.size() == capacity) {
		            wait(); // Wait until there is space in the buffer
		        }
		        properties.add(property);
		        System.out.println("OFFERED:" + property.getAddress());
		        notify(); // Notify the consumer that a property has been added
		    }

		    // Synchronized method for the consumer to remove properties
		    public synchronized Property removeProperty() throws InterruptedException {
		        while (properties.isEmpty()) {
		            wait(); // Wait until there is a property to consume
		        }
		        Property property = properties.poll();
		        System.out.println("OWNED:" + property.getAddress());
		        notify(); // Notify the producer that space is available
		        return property;
		    }
		}
		// Producer thread that adds properties
		class OFFERED extends Thread {
		    private final PropertyBuffer buffer;

		    public OFFERED(PropertyBuffer buffer) {
		        this.buffer = buffer;
		    }

		    @Override
		    public void run() {
		        String[] addresses = {
		            "B-16 Main University Road, Karachi",
		            "B-13 Gulshan Road, Karachi",
		            "B11/A north nazimabad Road, Karachi"
		        };

		        try {
		            for (String address : addresses) {
		                Property property = new Property(String.valueOf(address.hashCode()), address, Math.random() * 10000000);
		                buffer.addProperty(property);
		                Thread.sleep(1000); // Simulate time taken to add a property
		            }
		        } catch (InterruptedException e) {
		            Thread.currentThread().interrupt();
		        }
		    }
		}

		// Consumer thread that removes properties
		class OWNED extends Thread {
		    private final PropertyBuffer buffer;

		    public OWNED(PropertyBuffer buffer) {
		        this.buffer = buffer;
		    }
		    @Override
		    public void run() {
		        try {
		            for (int i = 0; i < 3; i++) {
		                Property property = buffer.removeProperty();
		                Thread.sleep(1500); // Simulate time taken to process a property
		            }
		        } catch (InterruptedException e) {
		            Thread.currentThread().interrupt();
		        }
		    }
		}
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
		}
		// Main class to demonstrate inter-thread communication
		public class KarachiRealEstateAppLAB07SHEHARYARKHAN175TASK5 {
			public static void main(String[] args) {
		        PropertyBuffer buffer = new PropertyBuffer(2); // Set buffer capacity
		        OFFERED offered = new OFFERED (buffer);
		        OWNED owned  = new OWNED (buffer);
		        offered .start();
		        owned.start();
		        try {
		            offered .join();
		            owned .join();
		        } catch (InterruptedException e) {
		            Thread.currentThread().interrupt();
		        }
		        System.out.println("LAB#07 TASK:05 SHEHARYAR KHAN!!!!");
		        System.out.println("ALL TASK COMPLETE SUCCESSFULLY !!!!");
		// TODO Auto-generated method stub
	}
}
