package Day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2 {

    public static void main(String[] args) throws IOException {
        File file = new File("src/Day2/Day2_data.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<Instruction> instructionList = new ArrayList<>();

        String st;
        int horizontal = 0;
        int depth = 0;
        int aim = 0;


        while ((st = br.readLine()) != null) {
            String splits[] = st.split(" ");
            Instruction tmp = new Instruction(splits[0], Integer.parseInt(splits[1]));
            instructionList.add(tmp);
        }

        for (int i = 0; i < instructionList.size(); i++) {
            switch (instructionList.get(i).direction) {
                case "forward":
                    horizontal += instructionList.get(i).distance;
                    depth += aim * instructionList.get(i).distance;
                    break;
                case "down":
                    aim += instructionList.get(i).distance;
                    break;
                case "up":
                    aim -= instructionList.get(i).distance;
                    break;
                default:
                    System.out.println("Invalid instruction");
            }
        }

        int result = horizontal * depth;
        System.out.println(result);
    }
}
