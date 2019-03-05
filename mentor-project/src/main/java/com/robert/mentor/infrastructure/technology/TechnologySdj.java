package com.robert.mentor.infrastructure.technology;

import com.robert.mentor.domain.technology.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologySdj extends JpaRepository<Technology, Technology> {
}
