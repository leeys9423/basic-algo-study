package _0x04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class P1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String init = br.readLine();
        List<Character> list = new LinkedList<>();
        for (char c : init.toCharArray()) {
            list.add(c);
        }
        // index 기준
        int cursorLocation = list.size();
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            String input = br.readLine();
            if (input.equals("L")) {
                if (cursorLocation > 0) {
                    cursorLocation--;
                }
            } else if (input.equals("D")) {
                if (cursorLocation < list.size()) {
                    cursorLocation++;
                }
            } else if (input.equals("B")) {
                if (cursorLocation > 0) {
                    list.remove(--cursorLocation);
                }
            } else if (input.startsWith("P")){
                char c = input.charAt(2);
                list.add(cursorLocation++, c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
