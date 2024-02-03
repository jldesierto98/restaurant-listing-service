package com.desiertodigital.restaurantlisting.service;

import com.desiertodigital.restaurantlisting.dto.RestaurantDto;

import java.util.List;

public interface RestaurantService {

    List<RestaurantDto> getAllRestaurants();

    RestaurantDto addRestaurant(RestaurantDto restaurantDto);

    RestaurantDto findRestaurantById(Long id);
}
