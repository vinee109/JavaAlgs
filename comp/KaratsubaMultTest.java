package comp;

import junit.framework.TestCase;

public class KaratsubaMultTest extends TestCase {

    public void testMultiply() throws Exception {
        assertEquals(KaratsubaMult.multiply(2, 2), 4);
        assertEquals(KaratsubaMult.multiply(11, 11), 121);
        assertEquals(KaratsubaMult.multiply(10, 10), 100);
        assertEquals(KaratsubaMult.multiply(8, 9), 72);
    }
}
