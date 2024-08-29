
import  java.io.*;
import java.util.*;

public class MatchResultFileReader {

    private Scanner sc;
    private File file;

    public MatchResultFileReader(String fileName) throws FileNotFoundException {
        this.file = new File(fileName);
        this.sc = new Scanner(file);

    }

    public List<MatchResult> readfile() {

        String line;
        String[] attributes;
        String[] goalScorers;



        List<MatchResult> returnList = new ArrayList<>();


        while(sc.hasNext()){
            ArrayList<String> goalScoresList = new ArrayList<>();

            line = sc.nextLine();
            attributes = line.split(";");

            if (attributes.length > 1 && !attributes[1].isEmpty()){
                goalScorers = attributes[1].split(",");
                for (String goals : goalScorers){
                    goalScoresList.add(goals);
                }
            }

            returnList.add(new MatchResult(attributes[0], goalScoresList));

        }

        sc.close();


        return returnList;


    }


}
