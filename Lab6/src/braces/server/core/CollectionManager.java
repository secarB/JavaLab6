package braces.server.core;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import braces.server.fields.*;

/**
 *Class to operate with collections
 */
public class CollectionManager {
    private TreeMap<String, SpaceMarine> map;
    private final CSVParser csvParser = new CSVParser();
    public static HashSet<Integer> IDChecker = new HashSet<Integer>();

    /**
     * Get treemap from CSVParse
     * @param fileName file name
     */
    public void readInput(String fileName)  {
        map = csvParser.parse(fileName);
    }
    /**
     * Get date creation from CSVParse
     * @return date creation
     */
    public String getCreationDate()
    {
        Date date = new Date();
        date = csvParser.getDateCreateCollection();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        return dateFormat.format(date);
    }

    /**
     * Return size of treemap
     * @return current treemap size
     */
    public long getSize()
    {
        return map.size();
    }

    /**
     * Show info of all object in treemap
     */
    public String show(){
    	String s1 = null;
    	if (map.size() == 0) return("Collection is empty"); else {
	        Set<String> keySet = map.keySet();
	        for (String key : keySet) {
	            s1 =  s1 + map.get(key).info();
	        }
    	}
    	return s1;
    }

    /**
     * Print information about the collection
     * @return 
     */
    public String info()
    {
        return("Type: treemap \n" +
                "Date of initialization : " + this.getCreationDate() + "\n" +
                "Size: " + this.getSize());
    }

    /**
     * Print all command can use with the collection
     * @return 
     */
    public String help(){
        return("help: display help for available commands  \n" +
            "info: print information about the collection (type, date of initialization, number of elements, etc.) to standard output \n" +
            "show: display all elements of the collection in string representation to standard output \n" +
            "insert null {element}: add a new element with the given key \n" +
            "update id {element}: update the value of the collection element whose id is equal to the given \n" +
            "remove_key null: remove an item from the collection by its key \n" +
            "clear: clear the collection \n" +
            "save: save the collection to a file \n" +
            "execute_script file_name: read and execute the script from the specified file. The script contains commands in the same form in which the user enters them interactively. \n" +
            "exit: exit the program (without saving to file) \n" +
            "remove_greater {element}: remove all elements greater than the specified one from the collection \n" +
            "remove_lower {element}: remove all elements from the collection that are less than the given one \n" +
            "replace_if_greater null {element}: replace value by key if new value is greater than old \n" +
            "average_of_health: Print the average of the health field for all items in the collection \n" +
            "min_by_health: remove any object from the collection that has the minimum health value \n" +
            "count_greater_than_height height: Print the number of elements whose height field value is greater than the given one");
    }

    /**
     * Adds an element with the given key
     * @param key key to be added
     * @param spaceMarine element needs to be added
     * @return true/false if the element was successfully added
     */
    public boolean add (String key,SpaceMarine spaceMarine)
    {
        if (map.containsKey(key)) return false;
        map.put(key,spaceMarine);
        return true;
    }

    /**
     * Updates an element with the given id
     * @param id id to be updated
     * @param spaceMarine element needs to be updated
     * @return true/false if the element was successfully updated
     */
    public boolean update (long id, SpaceMarine spaceMarine)
    {
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            if (map.get(key).getId() == id)
            {
            	spaceMarine.setId(id);
                map.put(key,spaceMarine);
                
                return true;
            }
        }
        return false;
    }

    /**
     * Removes element with given key
     * @param key given key
     * @return true/false if the element was successfully removed
     */
    public boolean remove(int key)
    {
        if (!map.containsKey(key)) return false;
        map.remove(key);
        return true;
    }

    /**
     * This method removes all elements greater than the given element
     * @param spaceMarine given element
     */
    public void removeGreater(SpaceMarine spaceMarine)
    {
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            map.values().removeIf(s -> s.compareTo(spaceMarine) > 0);
        }
    }

    /**
     * This method removes all elements lower than the given element
     * @param spaceMarine given element
     */
    public void removeLower(SpaceMarine spaceMarine) {
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            map.values().removeIf(s -> s.compareTo(spaceMarine) < 0);
        }
    }

    /**
     *Replaces element by key if new element is greater than old
     * @param key key
     * @param spaceMarine the new element
     * @return true/false if the new element is successfully replaced
     */
    public boolean replaceGreater(String key,SpaceMarine spaceMarine) {
        if (spaceMarine.compareTo(map.get(key)) > 0)
        {
            map.put(key,spaceMarine); return true;
        }
        return false;
    }

    /**
     * Returns current average of health
     * @return current average of health
     */
    public String getAverageOfHealth()
    {	
    	if (map.size() == 0) return "Collection is empty"; else {
    		long res = 0;
	        Set<String> keySet = map.keySet();
	        for (String key : keySet) {
	            res += map.get(key).getHealth();
	        }
	        return String.valueOf(res /= map.size()); }
    }

    /**
     * Clears all elements of the collection
     * @return 
     */
    public String clear()
    {
         map.clear();
        return "Cleared";
        
    }

    /**
     * Removes object from the collection that has the minimum health value
     */
    public String minByHealth()
    {
    	if (map.size() == 0) return("Collection is empty"); else {
	        long health = Long.MAX_VALUE;
	        String keyy = "";
	        Set<String> keySet = map.keySet();
	        for (String key : keySet) {
	            if (health > map.get(key).getHealth())
	            {
	                keyy = key;
	                health = map.get(key).getHealth();
	            }
	        }
	        map.remove(keyy);
	        return("Removed successfully");
    	}
    }

    /**
     * This method prints the number of elements whose height field value is greater than the given one
     * @param height given height
     */
    public String countGreaterThanHeight (long height)
    {
        long res = 0;
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
           if (map.get(key).getHeight() - height > 0) {
               res ++;
           }
        }
        return Long.toString(res);
    }

    /**
     * This method saves the collection to CSV file
     * @param fileName the filename that the collection will save to
     */
    public void save(String fileName)
    {
        try {
            BufferedOutputStream stream=new BufferedOutputStream(new FileOutputStream(fileName));
            Set<String> keySet = map.keySet();
            for (String key : keySet) {
                SpaceMarine out = map.get(key);
                String[] output = new String[14];
                output[0] = String.valueOf(out.getId());
                output[1] = out.getName();
                output[2] = String.valueOf(out.getCoordinates().getXCoordinate());
                output[3] = String.valueOf(out.getCoordinates().getYCoordinate());
                output[4] = out.getCreationDate().toString();
                output[5] = String.valueOf(out.getHealth());
                output[6] = String.valueOf(out.getHeight());
                output[7] = out.getCategory().toString();
                output[8] = out.getMeleeWeapon().toString();
                output[9] = out.getChapter().getName();
                output[10] = out.getChapter().getParentLegion();
                output[11] = out.getChapter().getParentLegion();
                output[12] = String.valueOf(out.getChapter().getMarinesCount());
                output[13] = out.getChapter().getWorld();
                for (int i = 0 ; i < 14 ; i++)
                {
                    stream.write(output[i].getBytes());
                    stream.write(",".getBytes());
                }
                stream.write(System.lineSeparator().getBytes());
            }
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
