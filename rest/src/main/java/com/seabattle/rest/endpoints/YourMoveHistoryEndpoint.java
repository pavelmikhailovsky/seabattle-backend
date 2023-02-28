package com.seabattle.rest.endpoints;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.usecase.YourMoveHistory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.seabattle.rest.EndpointURL.*;

@RestController
public class YourMoveHistoryEndpoint {

    private YourMoveHistory yourMoveHistory;

    public YourMoveHistoryEndpoint(YourMoveHistory yourMoveHistory) {
        this.yourMoveHistory = yourMoveHistory;
    }

    @GetMapping(API_V1_YOUR_MOVE_HISTORY)
    public List<Coordinate> execute() {
        return yourMoveHistory.execute();
    }

}
