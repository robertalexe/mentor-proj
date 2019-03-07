package com.robert.mentor.application;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {"pretty", "html:target/cucumber"},
        tags = "@Mentor"
)
public class MentorAcceptanceLocalIT {
}
