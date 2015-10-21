package nl.ing;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Erik Pragt
 */
public class TowersOfHanoiIterativeTest {

    @Test
    public void test1Disk() {
        assertEquals(1, new TowersOfHanoiIterative().solve(1));
    }

    @Test
    public void test2Disks() {
        assertEquals(3, new TowersOfHanoiIterative().solve(2));
    }

}