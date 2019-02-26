package com.robert.mentor.infrastructure;

import com.robert.mentor.config.MentorProjectApplication;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MentorProjectApplication.class)
public class JpaMappingLocalIT {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void loading_mapping_should_not_crash() {
        assertThat(entityManager).isNotNull();
    }
}
