package programmers;

class DialPosition {
    int x;
    int y;

    public DialPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDistance(DialPosition next) {
        return Math.abs(this.x - next.x) + Math.abs(this.y - next.y);
    }
}

// 프로그래머스 수식 최대화 문제
class FormulaMaximum {
    static DialPosition leftHand, rightHand;
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        char handChar = hand.toUpperCase().charAt(0);

        leftHand = new DialPosition(3, 0);
        rightHand = new DialPosition(3, 2);

        for (int number : numbers) {
            answer.append(whichHand(number, handChar));
        }
        return answer.toString();
    }

    public char whichHand(int number, char handChar) {
        DialPosition nextPosition = getNextPosition(number);
        if(number == 1 || number == 4 || number == 7) {
            leftHand = nextPosition;
            return 'L';
        }
        if(number == 3 || number == 6 || number == 9){
            rightHand = nextPosition;
            return 'R';
        }

        int leftDistance = leftHand.getDistance(nextPosition);
        int rightDistance = rightHand.getDistance(nextPosition);

        if(leftDistance < rightDistance) {
            leftHand = nextPosition;
            return 'L';
        }

        if(leftDistance > rightDistance) {
            rightHand = nextPosition;
            return 'R';
        }

        if(handChar == 'L') {
            leftHand = nextPosition;
        }else {
            rightHand = nextPosition;
        }
        return handChar;
    }

    public DialPosition getNextPosition(int number) {
        if (number == 0) {
            return new DialPosition(3, 1);
        }

        int x = number / 3;
        int y = number % 3;

        x = y == 0 ? x - 1 : x;
        y = y == 0 ? 2 : y - 1;

        return new DialPosition(x, y);
    }
}