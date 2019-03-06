package com.robert.mentor.infrastructure.technology;

import com.robert.mentor.config.MentorProjectApplication;
import com.robert.mentor.domain.technology.Technology;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MentorProjectApplication.class)
public class SdjTechnologyLocalIT {

    @Autowired
    private SdjTechnology sut;

    @Autowired
    private TechnologySdj technologySdj;

    @Before
    public void populate_with_two_technologies() {
        technologySdj.deleteAll();
        technologySdj.save(new Technology("technology1"));
        technologySdj.save(new Technology("technology2"));
    }

    @Test
    public void get_all_should_return_two_technologies() {
        List<Technology> actualTechnologies = sut.getAllTechnologies();
        assertThat(actualTechnologies).isNotEmpty();
        assertThat(actualTechnologies).hasSize(2);

    }
}
