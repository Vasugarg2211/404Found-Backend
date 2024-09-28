package com.__found.found.logs.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Log {
    String message;
    String serviceName;
    String logType;
    String time;
}
