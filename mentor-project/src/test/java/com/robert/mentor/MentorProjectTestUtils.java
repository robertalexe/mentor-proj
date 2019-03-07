package com.robert.mentor;

import com.robert.mentor.domain.DayOFWeek;
import com.robert.mentor.domain.Id;
import com.robert.mentor.domain.mentor.WorkingHours;
import com.robert.mentor.domain.mentor.WorkingTimes;
import com.robert.mentor.domain.training.Training;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static com.robert.mentor.domain.DayOFWeek.*;
import static java.time.LocalTime.of;

public class MentorProjectTestUtils {

    public static WorkingTimes generateWorkingTimes() {
        Map<DayOFWeek, WorkingHours> map = new HashMap<>();
        map.put(MONDAY, new WorkingHours(of(10, 00), of(12,00)));
        map.put(TUESDAY, new WorkingHours(of(12, 00), of(14,00)));
        map.put(WEDNESDAY, new WorkingHours(of(12, 40), of(14,00)));
        map.put(THURSDAY, new WorkingHours(of(10, 00), of(12,00)));
        map.put(FRIDAY, new WorkingHours(of(10, 00), of(12,00)));
        return new WorkingTimes(map);
    }

    public static Training generateTraining() {
        Training training = new Training(
                new Id(),
                "JAVA 8",
                new BigDecimal("400")
        );
        return training;
    }
}
