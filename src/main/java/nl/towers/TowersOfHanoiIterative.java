package nl.towers;

import java.util.Stack;

/**
 * @author Erik Pragt
 */
public class TowersOfHanoiIterative {

    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();
    private Stack<Integer> stackC = new Stack<>();

    private int moves = 0;
    private Stack lastMovedTo;

    public int solve(int disks) {
        // Fill stack A
        for (int i = disks; i > 0; i--) {
            stackA.push(i);
        }

        // Turn 1
        if (disks % 2 == 0) {
            stackB.push(stackA.pop());
            moves++;
        } else {
            stackC.push(stackA.pop());
            moves++;
        }

        // Move disks for rest of the game
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            moveDisk(stackA);
            moveDisk(stackB);
            moveDisk(stackC);
        }

        return moves;
    }

    private void moveDisk(Stack<Integer> stack) {
        if(!stack.isEmpty()) {
            Integer disk = stack.peek();

            if (stack == stackA) {
                if (canMoveTo(disk, stackB)) {
                    stackB.push(disk);
                    lastMovedTo = stackB;
                }
                if (canMoveTo(disk, stackC)) {
                    stackC.push(disk);
                    lastMovedTo = stackC;
                }
            }

            if (stack == stackB) {
                if (canMoveTo(disk, stackA)) {
                    stackA.push(disk);
                    lastMovedTo = stackA;
                }
                if (canMoveTo(disk, stackC)) {
                    stackC.push(disk);
                    lastMovedTo = stackC;
                }
            }

            if (stack == stackC) {
                if (canMoveTo(disk, stackA)) {
                    stackA.push(disk);
                    lastMovedTo = stackA;
                }
                if (canMoveTo(disk, stackB)) {
                    stackB.push(disk);
                    lastMovedTo = stackB;
                }
            }
        }
    }

    private boolean canMoveTo(Integer disk, Stack<Integer> otherStack) {
        if(otherStack.isEmpty()) {
            return true;
        }

        if(disk + otherStack.peek() % 2 == 0) {
            return false;
        }

        if(otherStack == lastMovedTo) {
            return false;
        }

        return true;
    }
}
