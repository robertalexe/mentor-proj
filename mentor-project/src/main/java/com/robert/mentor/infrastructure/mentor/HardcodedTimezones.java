package com.robert.mentor.infrastructure.mentor;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.mentor.Timezones;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.List;
import java.util.Set;

@DDD.RepositoryImpl
@Component
public class HardcodedTimezones implements Timezones {

    @Override
    public Set<String> allAvailableTimezones() {
        return ZoneId.getAvailableZoneIds();
    }
}
