package Day3;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Day3 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/Day3/Day3_data.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<String> instructionList = new ArrayList<>();
        String st;
        StringBuilder sb = new StringBuilder();

        while ((st = br.readLine()) != null) {
            instructionList.add(st);
        }

        int length = instructionList.get(0).length();

        for (int i = 0; i < length; i++) {
            sb.append(findMostcommonBit(instructionList, i));
        }

        int gammaRate = Integer.parseInt(sb.toString(), 2);

        for (int i = 0; i < length; i++) {
            if (sb.toString().charAt(i) == '0')
                sb.setCharAt(i, '1');
            else
                sb.setCharAt(i, '0');
        }

        int epsilonRate = Integer.parseInt(sb.toString(), 2);

        int result = gammaRate * epsilonRate;
        System.out.println(result);

    }

    private static int findMostcommonBit(List<String> list, int position) {
        int cnt_0 = 0;

        for (int i = 0; i < list.size(); i++) {
            int tmp = list.get(i).charAt(position);
            if (tmp - '0' == 0)
                cnt_0++;
        }

        if (list.size() - cnt_0 > cnt_0)
            return 1;

        return 0;
    }

}


