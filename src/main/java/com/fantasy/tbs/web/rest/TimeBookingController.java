package com.fantasy.tbs.web.rest;

import com.fantasy.tbs.domain.TimeBookDTO;
import com.fantasy.tbs.service.impl.TimeBookingServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TimeBookingController {

    private final TimeBookingServiceImpl timeBookingService;

    public TimeBookingController(TimeBookingServiceImpl timeBookingService) {
        this.timeBookingService = timeBookingService;
    }

    @PostMapping("/book")
    public ResponseEntity<Void> addTimeBooking(@RequestBody TimeBookDTO timeBookDTO) {
        timeBookingService.bookTime(timeBookDTO);
        return ResponseEntity.ok().build();
    }

    @Scheduled(cron = "0 0 17 * * ?")
    public void triggerFutureTimeBookingCheckAndInform() {
        timeBookingService.triggerFutureTimeBookingCheckAndInform();
    }
}
