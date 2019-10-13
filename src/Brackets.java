import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Brackets {
    HashMap< Character, Character> matches = new HashMap<>();


    public String eval(String input) {
        int count = 1;
        int non_chars = 0;
        matches.put('(', ')');
        matches.put('{', '}');
        matches.put('[', ']');
        LinkedList<Character> stack = new LinkedList<>();
        for (char a: input.toCharArray() ) {
            //System.out.println(count);
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
                        count --;
                    }
                    else {
                        System.out.println("failed");
                        return Integer.toString(count);
                    }
                }else {
                    non_chars++;
                }
            }
            count ++;
        }
        if(stack.isEmpty()) {
            return "Success";
        }
        int len = stack.size();
        return  Integer.toString(count-len-non_chars);
    }
    public static void main(String[] args) {
        Brackets brackets = new Brackets();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(brackets.eval(input));

    }
}
