package BDD.Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/code/_8CucumberBDD/Features",
        glue="code._8CucumberBDD.StepsDef"
        )

public class CucumberBdd_Runner {

}
