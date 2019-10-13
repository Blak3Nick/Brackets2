import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Brackets {
    HashMap< Character, Character> matches = new HashMap<>();


    public String eval(String input) {
        int count = 1;
        matches.put('(', ')');
        matches.put('{', '}');
        matches.put('[', ']');
        LinkedList<Character> stack = new LinkedList<>();
        for (char a: input.toCharArray() ) {
            if(a == '(' || a == '[' || a == '{') {
                stack.add(a);
            }
            else {
                if (a == ')' || a == '}' || a == ']') {
                    if(stack.isEmpty()) {
                        return Integer.toString(count);
                    }
                    char b = stack.removeLast();
//                    System.out.println(a);
//                    System.out.println(b);
                    if (matches.get(b) == a) {
                        //do nothing
                    }
                    else {
                        return Integer.toString(count);
                    }
                }
            }
            count ++;
        }
        if(stack.isEmpty()) {
            return "Success";
        }

        return  Integer.toString(--count);
    }
    public static void main(String[] args) {
        Brackets brackets = new Brackets();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(brackets.eval(input));

    }
}
