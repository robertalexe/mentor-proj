package com.robert.mentor.application;

import com.robert.mentor.application.mentor.FindCurrentMentor;
import com.robert.mentor.domain.*;
import com.robert.mentor.domain.mentor.Mentor;
import com.robert.mentor.domain.mentor.Mentors;
import com.robert.mentor.domain.mentor.WorkingHours;
import com.robert.mentor.domain.mentor.WorkingTimes;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.time.LocalTime.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class findCurrentMentorDetailsSteps {

    private IdentitySupplier mockIdentitySupplier = mock(IdentitySupplier.class);
    private Mentors mockMentors = mock(Mentors.class);

    private FindCurrentMentor sut;

    private Mentor actualMentor;
    private Exception actualException;
    
    @Given("^I am logged in by email \"([^\"]*)\"$")
    public void setLoggedInUser(String email) {
        when(mockIdentitySupplier.get()).thenReturn(new Email(email));
    }

    @Given("^there is an already signedUp mentor with the following details:$")
    public void setMentorDetails(Map<String, String> mentorDetails) {
        Mentor existingMentor = parseMentorDetails(mentorDetails);
        when(mockMentors.findOne(new Email(mentorDetails.get("email")))).thenReturn(Optional.of(existingMentor));
    }

    @When("^I consult my profile details$")
    public void consultMyMentorProfile() {
        sut = new FindCurrentMentor(mockIdentitySupplier, mockMentors);
        actualMentor = sut.findCurrentMentor();
    }

    @Then("^I can see the following information:$")
    public void checkMentorProfileInfo(Map<String, String> mentorDetails) {
        assertThat(actualMentor).isNotNull();
        assertThat(actualMentor.getId()).isEqualTo(new Email(mentorDetails.get("email")));
        assertThat(actualMentor.getYearsOfExperience()).isEqualTo(Integer.parseInt(mentorDetails.get("yearsOfExp")));
        assertThat(actualMentor.getLastName()).isEqualTo(new NameFragment(mentorDetails.get("lastName")));
    }

    @Given("^there is no user with email \"([^\"]*)\"$")
    public void assertNoUserWithEmail(String email) {
        assertThat(mockIdentitySupplier.get().getValue()).isNotEqualTo(email);
        when(mockMentors.findOne(new Email(email))).thenReturn(Optional.empty());
    }

    @When("^I consult the profile details for \"([^\"]*)\"$")
    public void consultNonExistentMentor(String email) {
        sut = new FindCurrentMentor(mockIdentitySupplier, mockMentors);
        try {
            sut.findCurrentMentor();
        } catch (Exception e) {
            actualException = e;
        }
    }

    @Then("^I receive an exception$")
    public void checkExistingException() {
        assertThat(actualException).isInstanceOf(UsernameNotFoundException.class);
    }

    private Mentor parseMentorDetails(Map<String, String> mentorDetails){
        Map<DayOFWeek, WorkingHours> map = new HashMap<>();
        map.put(DayOFWeek.valueOf(mentorDetails.get("workingTimes")), new WorkingHours(of(10, 00), of(12, 00)));
        Mentor mentor = new Mentor(
                new Email(mentorDetails.get("email")),
                new Password(mentorDetails.get("password")),
                new NameFragment(mentorDetails.get("firstName")),
                new NameFragment(mentorDetails.get("lastName")),
                new ContactNumber(mentorDetails.get("contactNo")),
                LocalDateTime.now(),
                ZoneId.of(mentorDetails.get("zoneId")),
                new WorkingTimes(map),
                Collections.emptySet(),
                new Url(mentorDetails.get("linkedInUrl")),
                Integer.parseInt(mentorDetails.get("yearsOfExp")),
                Collections.emptyList()
        );
        return mentor;
    }
}
