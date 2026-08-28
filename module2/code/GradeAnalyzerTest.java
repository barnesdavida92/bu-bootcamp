package module2.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; 
import java.util.ArrayList; 
import java.util.Arrays;

public class GradeAnalyzerTest {
    @Test
    void calculateAverage_returnsZero_whenListIsEmpty() { 
        ArrayList<Integer> scores = new ArrayList<>();
        assertEquals(0.0, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    void calculateAverage_returnsCorrectAverage_forTypicalScores() { 
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(70, 78, 86));
        assertEquals(78.0, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    void calculateAverage_returnsSingleValue_whenListHasOneItem() { 
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(92));
        assertEquals(92.0, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    void calculateAverage_returnsDouble_notInteger() { 
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(66, 67));
        assertEquals(66.5, GradeAnalyzer.calculateAverage(scores));
    }

    @Test 
    void calculateAverage_handlesAllSameValues() { 
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(90, 90, 90, 90, 90, 90));
        assertEquals(90.0, GradeAnalyzer.calculateAverage(scores));
    }

    @Test 
    void calculateAverage_listWithSomeNegatives() { 
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(90, -10, 70, 10));
        assertEquals(40.0, GradeAnalyzer.calculateAverage(scores));
    }
}
