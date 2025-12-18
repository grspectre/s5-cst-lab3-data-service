package ru.rksp.shanaurin.data_service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.rksp.shanaurin.data.api.DefaultApi;
import ru.rksp.shanaurin.data.model.UserEvent;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserEventController implements DefaultApi {

    private final UserEventRepository userEventRepository;

    @Override
    public ResponseEntity<List<UserEvent>> eventsGet() {
        var result = userEventRepository.findAll().stream().map(e -> {
            var dto = new UserEvent();
            dto.setEventType(e.getEventType());
            dto.setEventTime(e.getEventTime());
            return dto;
        }).toList();

        return ResponseEntity.ok(result);
    }
}