public class Solution {

    private short minimum = Short.MIN_VALUE;
    private short maximum = Short.MAX_VALUE;
    private boolean higher;
    private int previousResult;
    private short previousSolution = 0;
    private int result = 0;
    private short solution = 0;

    public boolean guessNumber(short password) {
        this.result = this.guess(password);
        if (this.firstGuess()) {
            return true;
        }
        for (int i = 0; i < 15; i++) {
            this.previousResult = this.result;
            this.result = this.guess(password);
            if (this.result == 0) {
                return true;
            }
            this.compareResults();
            this.previousSolution = this.solution;
            this.solution = this.getNextNumber();
            if (i == 14 && this.higher && this.maximum == Short.MAX_VALUE) {
                if (this.guess(password) == 0) {
                    return true;
                }
            }
        }
        System.out.println("Letzter Versuch: " + this.solution + " Passwort:" + password);
        return false;
    }

    private boolean firstGuess() {
        if (this.previousResult > this.result) {
            this.solution = this.getNewGuess(this.solution, this.minimum);
            this.higher = false;
            return false;
        } else if (this.previousResult < this.result) {
            this.solution = this.getNewGuess(this.solution, this.maximum);
            this.higher = true;
            return false;
        } else {
            return true;
        }
    }

    private short getNextNumber() {
        if (this.higher) {
            return this.getNewGuess(this.solution, this.maximum);
        } else {
            return this.getNewGuess(this.solution, this.minimum);
        }
    }

    private void compareResults() {
        if (this.higher && this.result != this.previousResult) {
            this.higher = false;
            this.minimum = this.previousSolution;
        } else if (!this.higher && this.result != this.previousResult) {
            this.higher = true;
            this.maximum = this.previousSolution;
        }
    }

    private short getNewGuess(short solution, short valueToAdd) {
        if (this.higher && this.solution == Short.MAX_VALUE - 1) {
            return Short.MAX_VALUE;
        }
        return (short) ((solution + valueToAdd) / 2);
    }


    private int guess(short password) {
        if (password > this.solution) {
            return 1;
        } else if (password < this.solution) {
            return -1;
        } else {
            return 0;
        }
    }

}
