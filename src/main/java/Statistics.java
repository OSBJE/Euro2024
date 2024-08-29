import java.io.FileNotFoundException;
import java.util.*;


public class Statistics {


    private List<MatchResult> matchResult;

    public Statistics(String filepatch) throws FileNotFoundException {
        this.matchResult = new MatchResultFileReader(filepatch).readfile();
    }

    public Set<String> getGoalScorers(){
        Set<String> goalScorers = new HashSet<>();
        for (MatchResult rls : matchResult){
            goalScorers.addAll(rls.getGoalScorers());
        }

        return goalScorers;

    }


    public Map<String, Integer> getGoalScorersWithTotals(){
        Map<String, Integer> scoreBoard = new HashMap<>();

        Set<String> namesList = this.getGoalScorers();

        int counter = 0;

        ArrayList<String> listOfScores = new ArrayList<>();

        for (MatchResult goals : matchResult){
            listOfScores.addAll(goals.getGoalScorers()); // laver en list med alle spille navne en lang liste
        }

        for (String name : namesList){
            for (String goals : listOfScores) {
                if (name.equals(goals)) {
                    counter++;
                }
            }
            scoreBoard.put(name, counter);
            counter = 0;
        }

        return scoreBoard;


    }


    public int getNumberOfGoals(String goalScorer){

        Map<String, Integer> scoreBoard = this.getGoalScorersWithTotals();
        return scoreBoard.get(goalScorer);

    }



}
