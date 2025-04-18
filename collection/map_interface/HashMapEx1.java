package collection.map_interface;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx1 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1000, "John");
        map.put(3568, "Jane");
        map.put(6578, "Jack");
        map.put(6556, "Joe");
        map.put(1000, "Joe"); // Overwrites the value for key 1000 (old value: "John", new value: "Joe")
        map.put(null, null); // Allows null key and value

        map.putIfAbsent(1000, "John"); // Does not overwrite the existing value for key 1000
        map.putIfAbsent(1001, "John"); // Adds a new entry for key 1001

        System.out.println("Initial map: " + map);

        System.out.println("Value for key 1000: " + map.get(1000)); // Returns "Joe"
        System.out.println("Value for key 1200: " + map.get(1200)); // Returns "null"

        map.remove(1000); // Removes the entry for key 1000
        System.out.println("Value for key 1000 after removal: " + map.get(1000)); // Returns "null"

        System.out.println("Map size: " + map.size()); // Returns 5

        System.out.println("Map contains key 1000: " + map.containsKey(1000)); // Returns false

        System.out.println("Map contains value 'John': " + map.containsValue("John")); // Returns true

        System.out.println("Map contains value 'Joe': " + map.containsValue("Joe")); // Returns true

        System.out.println("Map is empty: " + map.isEmpty()); // Returns false

        System.out.println("Map keys: " + map.keySet()); // Returns [3568, null, 6578, 1001, 6556]

        System.out.println("Map values: " + map.values()); // Returns [Jane, null, Jack, John, Joe]

        System.out.println("Map entries: " + map.entrySet()); // Returns [3568=Jane, null=null, 6578=Jack, 1001=John, 6556=Joe]

        // Iterating through the map
        System.out.println("Iterating through the map:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        
        // Using forEach to iterate through the map
        System.out.println("Using forEach to iterate through the map:");
        map.forEach((key, value) -> {
            System.out.println("Key: " + key + ", Value: " + value);
        });

    }
}
