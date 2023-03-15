package com.seabattle.rest.endpoints;

import com.seabattle.entities.dto.DeckShip;
import com.seabattle.entities.rules.ship_build.exceptions.DeckShipBuildingException;
import com.seabattle.usecase.AddDeckShip;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.seabattle.rest.EndpointURL.*;

@RestController
public class AddDeckShipEndpoint {

    private AddDeckShip addDeckShip;

    public AddDeckShipEndpoint(AddDeckShip addDeckShip) {
        this.addDeckShip = addDeckShip;
    }

    @PostMapping(value = API_V1_ADD_SHIP, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeckShip> execute(@RequestBody List<String> coordinates) throws DeckShipBuildingException {
        DeckShip newShip = addDeckShip.execute(coordinates);
        return ResponseEntity.status(HttpStatus.CREATED).body(newShip);
    }

}
