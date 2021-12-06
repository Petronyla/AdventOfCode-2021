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
        System.out.println("First part: " + result);

        int oxygen = Integer.parseInt(countOxygenGeneratorRating(instructionList, length), 2);
        int CO2 = Integer.parseInt(countCO2ScrubberRating(instructionList, length), 2);

        int result2 = oxygen * CO2;
        System.out.println("Second part: " + result2);
    }

    private static String countOxygenGeneratorRating(List<String> list, int len) {
        String res = null;
        List<String> tmpList = new ArrayList<>(list);
        for (int i = 0; i < len; i++) {
            int mostCommonBit = findMostcommonBit(tmpList, i);
            Iterator<String> iterator = tmpList.iterator();
            while (iterator.hasNext() && tmpList.size() > 1) {
                String tmp = iterator.next();
                if (tmp.charAt(i) - '0' != (char) mostCommonBit) {
                    iterator.remove();
                }
            }
            if (tmpList.size() == 1) {
                res = tmpList.get(0);
                break;
            }
        }
        return res;
    }

    private static String countCO2ScrubberRating(List<String> list, int len) {
        List<String> tmpList = new ArrayList<>(list);
        String res = null;
        for (int i = 0; i < len; i++) {
            int mostCommonBit = findMostcommonBit(tmpList, i);
            Iterator<String> iterator = tmpList.iterator();
            while (iterator.hasNext() && tmpList.size() > 1) {
                String tmp = iterator.next();
                if (tmp.charAt(i) - '0' == (char) mostCommonBit) {
                    iterator.remove();
                }
            }
            if (tmpList.size() == 1) {
                res = tmpList.get(0);
                break;
            }
        }
        return res;
    }

    private static int findMostcommonBit(List<String> list, int position) {
        int cnt_0 = 0;

        for (int i = 0; i < list.size(); i++) {
            int tmp = list.get(i).charAt(position);
            if (tmp - '0' == 0)
                cnt_0++;
        }

        if (list.size() - cnt_0 >= cnt_0)
            return 1;
        else
            return 0;
    }

}


