package com.seabattle.rest.endpoints;

import com.seabattle.entities.dto.DeckShip;
import com.seabattle.entities.rules.ship_build.exceptions.ShipBuildingException;
import com.seabattle.usecase.AddShip;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.seabattle.rest.EndpointURL.*;

@RestController
public class AddShipEndpoint {

    private AddShip addShip;

    public AddShipEndpoint(AddShip addShip) {
        this.addShip = addShip;
    }

    @PostMapping(API_V1_ADD_SHIP)
    public ResponseEntity<DeckShip> execute(List<String> coordinates) throws ShipBuildingException {
        DeckShip newShip = addShip.execute(coordinates);
        return ResponseEntity.status(HttpStatus.CREATED).body(newShip);
    }

}
