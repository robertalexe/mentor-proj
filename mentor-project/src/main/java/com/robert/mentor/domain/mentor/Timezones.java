package com.robert.mentor.domain.mentor;

import com.robert.mentor.domain.DDD;

import java.time.ZoneId;
import java.util.List;
import java.util.Set;

@DDD.Repository
public interface Timezones {

    Set<String> allAvailableTimezones();
}
