import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class SortedArrayListTest {

    private SortedArrayList<String> testArrayList;

    @BeforeEach
    void setup() {
        testArrayList = new SortedArrayList<>();
        testArrayList.add("1"); testArrayList.add("2"); testArrayList.add("3"); testArrayList.add("4");
    }

    @Test
    public void testSize() {
        assertEquals(4, testArrayList.size());
    }

    @Test
    public void testClearAndIsEmpty() {
        assertFalse(testArrayList.isEmpty());

        testArrayList.clear();
        assertTrue(testArrayList.isEmpty());
    }

    @Test
    public void testContains() {
        assertTrue(testArrayList.contains("3"));
        assertFalse(testArrayList.contains("10"));
        assertThrows(IllegalArgumentException.class, () -> testArrayList.contains(null));
    }

    @Test
    public void testIndexOf() {
        SortedArrayList<String> testArrayList = new SortedArrayList<>();
        testArrayList.add("ABW2000"); testArrayList.add("AIA2000"); testArrayList.add("AFG2000"); testArrayList.add("AGO2000");

        //testing if it returns the correct index
        assertEquals(2, testArrayList.indexOf("AGO2000"));
        assertEquals(1, testArrayList.indexOf("AFG2000"));
        assertEquals(0, testArrayList.indexOf("ABW2000"));
        assertEquals(3, testArrayList.indexOf("AIA2000"));

        //testing the location of where an object would go
        assertEquals(-1, testArrayList.indexOf("ABC2000"));
        assertEquals(-2, testArrayList.indexOf("ACD2000"));
        assertEquals(-5, testArrayList.indexOf("AZX2000"));

        //testing empty list
        SortedArrayList<String> testArrayListEmpty = new SortedArrayList<>();
        assertEquals(-1, testArrayListEmpty.indexOf("0"));

        //testing case-sensitive
        testArrayListEmpty.add("A");
        testArrayListEmpty.add("a");
        assertEquals(0, testArrayListEmpty.indexOf("A"));

        //exception handling
        assertThrows(IllegalArgumentException.class, () -> testArrayList.indexOf(null));

    }

    @Test
    public void testIndexOfDuplicates() {
        SortedArrayList<String> testDuplicate = new SortedArrayList<>();
        testDuplicate.add("ABC");
        testDuplicate.add("ABC");
        testDuplicate.add("ABC");
        testDuplicate.add("ABC");
        assertEquals(0, testDuplicate.indexOf("ABC"));
    }

    @Test
    public void testGet() {
        assertEquals("1", testArrayList.get(0));
        assertEquals("4", testArrayList.get(3));
    }


    @Test
    public void testGetWithValueTemplate() {
        SortedArrayList<String> testArrayList = new SortedArrayList<>();
        testArrayList.add("2"); testArrayList.add("3"); testArrayList.add("3"); testArrayList.add("3"); testArrayList.add("4");

        String[] stringArray = testArrayList.get("3", new String[0]);

        // Check the size of the returned array
        assertEquals(100, stringArray.length);

        //check that the values are right
        assertEquals("3", stringArray[0]);
        assertEquals("3", stringArray[1]);
        assertEquals("3", stringArray[2]);

        assertThrows(IllegalArgumentException.class, () -> testArrayList.get(null, new String[0]));
        assertThrows(IllegalArgumentException.class, () -> testArrayList.get("3", null));
    }

    @Test
    public void testRemove() {
        testArrayList.remove(2);
        //assertEquals("3", testArrayList.get(2));
    }


    @Test
    public void testIterator() {
        SortedArrayList<String> testArrayListIterator = new SortedArrayList<>();
        for (String item : testArrayList) {
            testArrayListIterator.add(item);
        }
        assertEquals(4, testArrayListIterator.size());

        Iterator<String> iterator = testArrayListIterator.iterator();
        iterator.next();


    }

    @Test
    public void testToArray() {
        String[] testArray = testArrayList.toArray(new String[0]);
        assertEquals("1", testArray[0]);
        assertEquals("2", testArray[1]);
        assertEquals("3", testArray[2]);
        assertEquals("4", testArray[3]);
        //assertEquals(4, testArray.length);

        assertThrows(IllegalArgumentException.class, () -> testArrayList.toArray(null));

    }

    @Test
    public void testToString() {
        String expectedString = "[1, 2, 3, 4]";
        assertEquals(expectedString, testArrayList.toString());
    }

    @Test
    public void testAddDuplicates() {
        SortedArrayList<String> testString = new SortedArrayList<>();
        testString.add("1");
        testString.add("1");
        testString.add("1");

        assertEquals(3, testString.size());
        assertEquals("1", testString.get(0));
        assertEquals("1", testString.get(1));
        assertEquals("1", testString.get(2));

        assertThrows(IllegalArgumentException.class, () -> testArrayList.add(null));
    }

}