package Day1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

public static void main(String[]args) throws IOException {
    File file = new File("src/Day1/Day1_data.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));
    List<Integer> listOfSignals = new ArrayList<>();

    String st;
    int i;
    int cnt = 0;
    int cnt2 = 0;

    while ((st = br.readLine()) != null) {
        i = Integer.parseInt(st);
        listOfSignals.add(i);
    }

    for (int j = 0; j < listOfSignals.size() - 1; j++) {
        if (listOfSignals.get(j) < listOfSignals.get(j + 1)) {
            cnt++;
        }
    }

    for (int j = 0; j < listOfSignals.size() - 3; j++) {
        int sumA = listOfSignals.get(j) + listOfSignals.get(j+1) + listOfSignals.get(j+2);
        int sumB = listOfSignals.get(j+1) + listOfSignals.get(j+2) + listOfSignals.get(j+3);

        if (sumA < sumB)
            cnt2++;
    }

    System.out.println(cnt);
    System.out.println(cnt2);
    }
}