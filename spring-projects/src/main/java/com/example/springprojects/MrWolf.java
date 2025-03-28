package com.example.springprojects;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ShellComponent
public class MrWolf {
    @ShellMethod(value="Get the time, if you are lucky!", key="what-time-is-it")
    public String whatTimeIsIt(@ShellOption(defaultValue = "evil", help = "Must be either evil or good.") String alignment) {
        String response = "Lunch Time!";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String now = LocalDateTime.now().format(formatter);

        if(alignment.equals("evil")) {
            int attack = (Math.random() < 0.5) ? 0 : 1;
                if(attack == 0) {
                    response = now;

            }
        } else if(alignment.equals("good")) {
            response = now;
        } else {
            response = "Alignment must be good or evil";
        }

        return response;
    }
}
