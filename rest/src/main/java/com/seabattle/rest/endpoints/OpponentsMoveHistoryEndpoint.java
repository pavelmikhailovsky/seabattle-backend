package com.seabattle.rest.endpoints;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.usecase.OpponentsMoveHistory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.seabattle.rest.EndpointURL.*;

@RestController
public class OpponentsMoveHistoryEndpoint {

    private OpponentsMoveHistory opponentsMoveHistory;

    public OpponentsMoveHistoryEndpoint(OpponentsMoveHistory opponentsMoveHistory) {
        this.opponentsMoveHistory = opponentsMoveHistory;
    }

    @GetMapping(API_V1_OPPONENTS_MOVE_HISTORY)
    public List<Coordinate> execute() {
        return opponentsMoveHistory.execute();
    }

}
