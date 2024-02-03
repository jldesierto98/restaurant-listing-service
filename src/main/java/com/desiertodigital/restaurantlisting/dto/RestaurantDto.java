package com.desiertodigital.restaurantlisting.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class RestaurantDto {

    private Long id;
    private String name;
    private String address;
    private String city;
    private String restaurantDescription;

}
