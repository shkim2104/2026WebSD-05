package org.example.my_bookapi_project.repository;

import org.example.my_bookapi_project.domain.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository {
    Restaurant save(Restaurant restaurant);
    List<Restaurant> findAll();
    Optional<Restaurant> findById(Long id);
    Restaurant update(Restaurant restaurant);
    void deleteById(Long id);
}
