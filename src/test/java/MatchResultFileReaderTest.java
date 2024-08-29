import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MatchResultFileReaderTest {

    @Test

    void readFileTest() {

        List<MatchResult> realData = new ArrayList<>();


        List<String> namesTest = new ArrayList<>();
        namesTest.add("Højlund");
        MatchResult testDate = new MatchResult("Denmark-Finland", namesTest);


        try {
            MatchResultFileReader file = new MatchResultFileReader("Euro2024.csv");
            realData = file.readfile();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String realValue1 = realData.get(0).getTeams();

        Assertions.assertEquals(realValue1, testDate.getTeams());


    }

}