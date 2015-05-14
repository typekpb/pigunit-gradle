package com.github.pigunitgradle;

import java.io.IOException;

import org.apache.pig.pigunit.PigTest;
import org.apache.pig.tools.parameters.ParseException;
import org.junit.Test;

public class TopQueriesTest {

    private static final String PIG_PREFIX = "./src/test/resources/";
    private static final String PIG_TOP_QUERIES = PIG_PREFIX + "top_queries.pig";

    @Test
    public void testTop2Queries() throws IOException, ParseException {
        String[] args = { "n=2", };
        PigTest test = new PigTest(PIG_TOP_QUERIES, args);
        String[] input = { "yahoo", "yahoo", "yahoo", "twitter", "facebook",
                "facebook", "linkedin", };
        String[] expected = { "(yahoo,3)", "(facebook,2)", };
        test.assertOutput("data", input, "queries_limit", expected);
    }
}
