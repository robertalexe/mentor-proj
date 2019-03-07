package com.robert.mentor.exposition.appusers;

import com.robert.mentor.application.appusers.AllApplicationUsers;
import com.robert.mentor.config.MentorProjectApplication;
import com.robert.mentor.domain.Email;
import com.robert.mentor.domain.NameFragment;
import com.robert.mentor.domain.Password;
import com.robert.mentor.domain.UserType;
import com.robert.mentor.domain.appusers.AppUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit4.statements.SpringRepeat;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MentorProjectApplication.class, webEnvironment = RANDOM_PORT)
public class AppUsersResourceLocalIT {

    private final Email email = new Email("test@test.com");
    private final NameFragment firstName = new NameFragment("first");
    private final NameFragment lastName = new NameFragment("last");
    private final String registrationCode = "code";
    private final UserType userType = new UserType("MENTOR");

    @Autowired
    private AppUsersResource sut;

    @Mock
    private AllApplicationUsers allApplicationUsers;

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockApplicationService();
        this.mockMvc = ((DefaultMockMvcBuilder)MockMvcBuilders.webAppContextSetup(wac).apply(SecurityMockMvcConfigurers.springSecurity())).build();
    }

    @Test
    public void get_all_application_users_should_return_one_user() throws Exception {
        ResultActions resultActions = viewListOfAllUsers();

    }


    private ResultActions viewListOfAllUsers() throws Exception{
        return mockMvc
                .perform(get("/api/app-users").accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON));
    }

    private void mockApplicationService() {
        Mockito.when(allApplicationUsers.allApplicationUsers()).thenReturn(Collections.singletonList(new AppUser(
                email, firstName, lastName, true,  userType, registrationCode
        )));
        ReflectionTestUtils.setField(sut, "allApplicationUsers", allApplicationUsers);
    }

}
