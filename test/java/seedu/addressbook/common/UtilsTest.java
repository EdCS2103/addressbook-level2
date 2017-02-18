package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {
    @Test
    public void isAnyNull() {
        // empty list
        assertFalse(Utils.isAnyNull());

        // Any non-empty list
        assertFalse(Utils.isAnyNull(new Object(), new Object()));
        assertFalse(Utils.isAnyNull("test"));
        assertFalse(Utils.isAnyNull(""));
        assertFalse(Utils.isAnyNull(5));
        assertFalse(Utils.isAnyNull(false));

        // non empty list with just one null at the beginning
        assertTrue(Utils.isAnyNull((Object) null));
        assertTrue(Utils.isAnyNull(null, "", new Object()));
        assertTrue(Utils.isAnyNull(null, new Object(), new Object()));
        assertTrue(Utils.isAnyNull(null, ""));
        assertTrue(Utils.isAnyNull(null, 5));

        // non empty list with nulls in the middle
        assertTrue(Utils.isAnyNull(new Object(), null, null, "test"));
        assertTrue(Utils.isAnyNull("", null, new Object()));
        assertTrue(Utils.isAnyNull(1,2,3,null,new Object(), "", new ArrayList<String>()));

        // non empty list with one null as the last element
        assertTrue(Utils.isAnyNull("", new Object(), null));
        assertTrue(Utils.isAnyNull(new Object(), new Object(), null));
        assertTrue(Utils.isAnyNull(1,2,3, "helloWorld", new Object(), new int[]{1,2},null));
        

        // confirms nulls inside the list are not considered
        List<Object> nullList = Arrays.asList((Object) null);
        assertFalse(Utils.isAnyNull(nullList));
    }

    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");
        assertAreUnique(new int[]{});

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);
        assertAreUnique(new int[]{}, new int[]{});
        assertAreUnique(new String("Strings"), new String("String"));
        assertAreUnique(1,"abc");
        assertAreUnique(1,new Object());
        assertAreUnique(new Object(), new Object(), new Object());

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
        assertNotUnique(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2);
        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[]{4,5,6};
        int[] arr3 = arr2;
        assertAreUnique(arr1,arr2);
        assertNotUnique(arr3,arr2);
        arr3=null;
        assertAreUnique(arr3,arr2);
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
