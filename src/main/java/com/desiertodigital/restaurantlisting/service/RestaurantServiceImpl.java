package com.desiertodigital.restaurantlisting.service;

import com.desiertodigital.restaurantlisting.dto.RestaurantDto;
import com.desiertodigital.restaurantlisting.entity.Restaurant;
import com.desiertodigital.restaurantlisting.mapper.RestaurantMapper;
import com.desiertodigital.restaurantlisting.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantDto> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants.stream()
                .map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant))
                .collect(Collectors.toList());
    }

    @Override
    public RestaurantDto addRestaurant(RestaurantDto restaurantDto) {
        Restaurant savedRestaurant =  restaurantRepository.save(RestaurantMapper.INSTANCE.mapRestaurantDtoToRestaurant(restaurantDto));
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(savedRestaurant);
    }

    @Override
    public RestaurantDto findRestaurantById(Long id) {
        Restaurant queriedRestaurant = restaurantRepository.findById(id).get();
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(queriedRestaurant);
    }
}
