package com.seabattle.rest.errors;

import com.seabattle.entities.rules.ship_build.exceptions.ShipBuildingException;
import com.seabattle.rest.endpoints.AddShipEndpoint;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(basePackageClasses = AddShipEndpoint.class)
public class AddShipEndpointAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleEndpointException(HttpServletRequest request, ShipBuildingException ex) {
        HttpStatus status = getStatus(request);
        return new ResponseEntity<>(ex.getMessage(), status);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer code = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        HttpStatus status = HttpStatus.resolve(code);
        return (status != null) ? status : HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
