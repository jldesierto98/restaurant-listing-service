package com.desiertodigital.restaurantlisting.controller;

import com.desiertodigital.restaurantlisting.dto.RestaurantDto;
import com.desiertodigital.restaurantlisting.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
@CrossOrigin
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;


    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDto>> fetchAllRestaurant(){
        List<RestaurantDto> allRestaurants = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(allRestaurants, HttpStatus.OK);
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDto> addRestaurant(@RequestBody RestaurantDto restaurantDto){
       RestaurantDto restaurantAdded = restaurantService.addRestaurant(restaurantDto);
       return new ResponseEntity<>(restaurantAdded, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDto> findRestaurantById(@PathVariable("id") Long id){
        RestaurantDto queriedRestaurant = restaurantService.findRestaurantById(id);
        return new ResponseEntity<>(queriedRestaurant, HttpStatus.OK);
    }


}
