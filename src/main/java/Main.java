import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            MatchResultFileReader data = new MatchResultFileReader("Euro2024.csv");
            List<MatchResult> list = data.readfile();

            for (MatchResult teams : list){
                System.out.println(teams.getTeams());
                System.out.println(teams.getGoalScorers().toString());

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        try {
            Statistics statistics = new Statistics("Euro2024.csv");

            System.out.println(statistics.getGoalScorers());

            System.out.println(statistics.getGoalScorersWithTotals());

            System.out.println(statistics.getNumberOfGoals("Wind"));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        //gaysdad
        System.out.println("hej");
        System.out.println("hej");
        System.out.println("hej");

    }
}

