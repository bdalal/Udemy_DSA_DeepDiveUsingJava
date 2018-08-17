package deepdive.hashtable;

import deepdive.employee.Employee;

public class SimpleHashtable {

    private Employee[] hashTable;

    public SimpleHashtable() {
        hashTable = new Employee[10];
    }

    private int hashKey(String key) {
        return key.length() % hashTable.length;
    }

    public void put(String key, Employee value) {
        int hashedKey = hashKey(key);
        if (isOccupied(hashedKey)) {
            int stopIndex = hashedKey;
            if (hashedKey == hashTable.length - 1)
                hashedKey = 0;
            else
                hashedKey++;
            while (isOccupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1) % hashTable.length;
            }
        }
        if (isOccupied(hashedKey)) {
            System.out.println("Object already present at " + hashedKey);
            return;
        }
        hashTable[hashedKey] = value;
    }

    public Employee get(String key) {
        return hashTable[hashKey(key)];
    }

    public void printHashtable() {
        for (Employee o : hashTable)
            System.out.println(o);
    }

    private boolean isOccupied(int index) {
        return hashTable[index] != null;
    }

}
