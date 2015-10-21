package nl.towers;

import org.junit.Test;

import static nl.towers.TowersOfHanoiRecursive.solve;
import static org.junit.Assert.assertEquals;

/**
 * @author Erik Pragt
 */
public class TowersOfHanoiTest {

    @Test
    public void test1Disk() {
        assertEquals(1, solve(1));
    }

    @Test
    public void test2Disks() {
        assertEquals(3, solve(2));
    }

    @Test
    public void test3Disks() {
        assertEquals(15, solve(4));
    }

    @Test
    public void test100Disks() {
        assertEquals(1023, solve(20));
    }
}
