package org.example.my_bookapi_project.repository;

import org.example.my_bookapi_project.domain.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryRestaurantRepository implements RestaurantRepository {
    private final Map<Long, Restaurant> store = new LinkedHashMap<>();
    private long sequence = 0L;
    @Override public Restaurant save(Restaurant restaurant) { restaurant.setId(++sequence); store.put(restaurant.getId(), restaurant); return restaurant; }
    @Override public List<Restaurant> findAll() { return new ArrayList<>(store.values()); }
    @Override public Optional<Restaurant> findById(Long id) { return Optional.ofNullable(store.get(id)); }
    @Override public Restaurant update(Restaurant restaurant) { store.put(restaurant.getId(), restaurant); return restaurant; }
    @Override public void deleteById(Long id) { store.remove(id); }
}
