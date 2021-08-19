package Kata;

import java.awt.Point;
import java.util.*;

public class BefungeInterpreter {
    private final Stack<Integer> stack = new Stack<>();
    private CodeArray codeArray;
    private CodePointer codePointer;
    private boolean isStringMode = false;
    private StringBuilder output = new StringBuilder();
    private Scanner input = new Scanner("");

    public String interpret(String code) {
        return run(code);
    }

    public void setInput(String input) {
        this.input = new Scanner(input);
    }

    public String run(String code) {
        setCode(code);
        return run();
    }

    public void setCode(String code) {
        codeArray = CodeArray.of(code);
        codePointer = new CodePointer(codeArray.getColumnsNumber(), codeArray.getRowsNumber());
    }

    public String run() {
        while (interpretCharacter())
            codePointer.increment();
        return output();
    }

    private StringBuilder replaceAll(StringBuilder output) {
        for (int i = 0; i < output.length() ; i++) {
            if (output.charAt(i) == ' ') {
                output.deleteCharAt(i);
            }
        }
        return output;
    }

    private boolean interpretCharacter() {
        char character = codeArray.getCharAt(codePointer);
        return isStringMode ? interpretAsAscii(character) : interpretCommand(character);
    }

    private boolean interpretAsAscii(char character) {
        if (character == '"')
            isStringMode = !isStringMode;
        else
            stack.push((int) character);
        return true;
    }

    private boolean interpretCommand(char character) {
        switch (character) {
            case '+':
                add();
                return true;
            case '-':
                subtract();
                return true;
            case '*':
                multiply();
                return true;
            case '/':
                divide();
                return true;
            case '%':
                modulo();
                return true;
            case '!':
                logicalNot();
                return true;
            case '`':
                greaterThan();
                return true;
            case '>':
                codePointer.setDirection(CodePointer.Direction.RIGHT);
                return true;
            case '<':
                codePointer.setDirection(CodePointer.Direction.LEFT);
                return true;
            case '^':
                codePointer.setDirection(CodePointer.Direction.UP);
                return true;
            case 'v':
                codePointer.setDirection(CodePointer.Direction.DOWN);
                return true;
            case '?':
                setRandomDirection();
                return true;
            case '_':
                popAndMoveHorizontally();
                return true;
            case '|':
                popAndMoveVertically();
                return true;
            case '"':
                isStringMode = !isStringMode;
                return true;
            case ':':
                duplicateLast();
                return true;
            case '\\':
                swapTop();
                return true;
            case '$':
                stack.pop();
                return true;
            case '.':
                outputAsInt();
                return true;
            case ',':
                outputAsAscii();
                return true;
            case '#':
                codePointer.increment();
                return true;
            case 'p':
                putCommand();
                return true;
            case 'g':
                getCommand();
                return true;
            case '&':
                inputAsInt();
                return true;
            case '~':
                inputAsAscii();
                return true;
            case '@':
                return false;
            default:
                pushIfDigit(character);
                return true;
        }
    }

    private void add() {
        int a = pop();
        int b = pop();
        stack.push(a + b);
    }

    private Integer pop() {
        return stack.isEmpty() ? 0 : stack.pop();
    }

    private void subtract() {
        int a = pop();
        int b = pop();
        stack.push(b - a);
    }

    private void multiply() {
        int a = pop();
        int b = pop();
        stack.push(a * b);
    }

    private void divide() {
        int a = pop();
        int b = pop();
        stack.push(a == 0 ? 0 : b / a);
    }

    private void modulo() {
        int a = pop();
        int b = pop();
        stack.push(a == 0 ? 0 : b % a);
    }

    private void logicalNot() {
        int value = pop();
        stack.push(value == 0 ? 1 : 0);
    }

    private void greaterThan() {
        int a = pop();
        int b = pop();
        stack.push(b > a ? 1 : 0);
    }

    private void duplicateLast() {
        if (stack.isEmpty())
            stack.push(0);
        stack.push(stack.peek());
    }

    private void swapTop() {
        int a = pop();
        int b = pop();
        stack.push(a);
        stack.push(b);
    }

    private void outputAsInt() {
        String integer = pop().toString();
        output.append(integer);
    }

    private void outputAsAscii() {
        char character = (char) pop().intValue();
        if (character != '\0')
            output.append(character);
    }

    private void setRandomDirection() {
        CodePointer.Direction direction = RandomEnum.of(CodePointer.Direction.class);
        codePointer.setDirection(direction);
    }

    private void popAndMoveHorizontally() {
        int value = pop();
        codePointer.setDirection(value == 0 ? CodePointer.Direction.RIGHT : CodePointer.Direction.LEFT);
    }

    private void popAndMoveVertically() {
        int value = pop();
        codePointer.setDirection(value == 0 ? CodePointer.Direction.DOWN : CodePointer.Direction.UP);
    }

    private void putCommand() {
        int row = pop();
        int column = pop();
        char command = (char) pop().intValue();
        codeArray.setCharAt(row, column, command);
    }

    private void getCommand() {
        int row = pop();
        int column = pop();
        char command = codeArray.getCharAt(row, column);
        stack.push((int) command);
    }

    private void inputAsInt() {
        while (input.hasNext() && !input.hasNextInt())
            input.next();
        stack.push(input.hasNextInt() ? input.nextInt() : 0);
    }

    private void inputAsAscii() {
        stack.push(input.hasNext() ? (int) input.next().charAt(0) : -1);
    }

    private void pushIfDigit(char character) {
        if (Character.isDigit(character))
            stack.push(Character.getNumericValue(character));
    }

    private String output() {
        String outputString = output.toString();
        output.setLength(0);
        return outputString;
    }

    public void reset() {
        stack.clear();
        codePointer.setLocation(0, 0);
        isStringMode = false;
        output.setLength(0);
        input = new Scanner("");
    }

    public Stack<Integer> getStack() {
        return stack;
    }
}

class CodeArray {

    private char[][] array;

    private CodeArray(char[][] array) {
        this.array = array;
    }

    public static CodeArray of(String code) {
        String[] lines = code.split("\n");
        boolean seen = false;
        int best = 0;
        for (String line : lines) {
            int length = line.length();
            if (!seen || length > best) {
                seen = true;
                best = length;
            }
        }
        int maxWidth = (seen ? OptionalInt.of(best) : OptionalInt.empty()).getAsInt();
        char[][] array = new char[lines.length][];

        for (int i = 0; i < array.length; ++i) {
            array[i] = Arrays.copyOf(lines[i].toCharArray(), maxWidth);
        }

        return new CodeArray(array);
    }

    public char getCharAt(CodePointer codePointer) {
        int column = codePointer.x;
        int row = codePointer.y;
        return getCharAt(row, column);
    }

    public char getCharAt(int row, int column) {
        if (row >= getRowsNumber() || column >= getColumnsNumber()) return '\0';
        return array[row][column];
    }

    public void setCharAt(CodePointer codePointer, char character) {
        int column = codePointer.x;
        int row = codePointer.y;
        setCharAt(row, column, character);
    }

    public void setCharAt(int row, int column, char character) {
        array[row][column] = character;
    }

    public int getColumnsNumber() {
        return array[0].length;
    }

    public int getRowsNumber() {
        return array.length;
    }
}

class CodePointer extends Point {
    public enum Direction {
        RIGHT(1, 0),
        LEFT(-1, 0),
        UP(0, -1),
        DOWN(0, 1);

        int x;
        int y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private Direction direction = Direction.RIGHT;
    private int maxX;
    private int maxY;

    /**
     * watching for max of coordinates
     */
    public CodePointer(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public void increment() {
        int newX = Math.floorMod(x + direction.x, maxX);
        int newY = Math.floorMod(y + direction.y, maxY);
        move(newX, newY);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}

class RandomEnum {
    private static final Random random = new Random();

    public static <E extends Enum<E>> E of(Class<E> c) {
        E[] enums = c.getEnumConstants();
        int index = random.nextInt(enums.length);
        return enums[index];
    }
}
