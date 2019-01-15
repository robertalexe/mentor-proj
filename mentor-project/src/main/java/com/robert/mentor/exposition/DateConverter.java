package com.robert.mentor.exposition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static org.springframework.util.StringUtils.*;

public final class DateConverter {

    private static final Logger log = LoggerFactory.getLogger(DateConverter.class);

    private DateConverter() {}

    public static LocalDateTime parseDate(String dateAsString) {
        LocalDateTime date = null;
        try {
            if(!isEmpty(dateAsString)) {
                date = LocalDateTime.parse(dateAsString, DateTimeFormatter.ISO_DATE_TIME);
            }
        } catch (DateTimeParseException exc) {
            log.error(exc.getMessage());
        }
        return date;
    }

}
