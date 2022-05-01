package com.azold6.m_capital.controllers;

import com.azold6.m_capital.dto.RoutesResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/routes")
public class RouteController {

    @GetMapping(value = {"/{graphId}/from/{town1}/to/{town2}?maxStops={maxStops}", "/{graphId}/from/{town1}/to/{town2}"})
    public ResponseEntity<String> findRoutesWithMaxStops(@PathVariable Integer graphId,
                                                         @PathVariable Character town1,
                                                         @PathVariable Character town2,
                                                         @RequestParam(required = false) Integer maxStops){
        System.out.println(graphId);
        System.out.println(town1);
        System.out.println(town2);
        System.out.println(maxStops); //returns null

        return ResponseEntity.ok().body("It worked out!");
    }
}
