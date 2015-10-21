package nl.ing;

/**
 * @author Erik Pragt
 */
public class TowersOfHanoiRecursive {

    private static int counter = 0;

    public static int solve(int disks) {
        return solve(disks, "L","M","R");
    }

    private static int solve(int diskNumber, String left, String middle, String right) {
        if (diskNumber == 1) {
            countMove(diskNumber, left, right);
        } else {
            solve(diskNumber - 1, left, right, middle);
            countMove(diskNumber, left, right);
            solve(diskNumber - 1, middle, left, right);
        }

        return counter;
    }

    private static void countMove(int disk, String from, String to) {
        System.out.println(counter + ": Moving disk " + disk + " from " + from + " to " + to);
        counter++;

    }
}
