package org.example.my_bookapi_project.service;

import org.example.my_bookapi_project.domain.Restaurant;
import org.example.my_bookapi_project.dto.*;
import org.example.my_bookapi_project.repository.RestaurantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository repository;
    public RestaurantService(RestaurantRepository repository) { this.repository = repository; }
    public RestaurantResponse create(RestaurantRequest r) { return toResponse(repository.save(new Restaurant(null,r.name(),r.location(),r.rating(),r.mainMenu(),r.category()))); }
    public List<RestaurantResponse> findAll() { return repository.findAll().stream().map(this::toResponse).toList(); }
    public RestaurantResponse findById(Long id) { return toResponse(findRestaurant(id)); }
    public RestaurantResponse update(Long id, RestaurantRequest r) {
        Restaurant x=findRestaurant(id); x.setName(r.name()); x.setLocation(r.location()); x.setRating(r.rating()); x.setMainMenu(r.mainMenu()); x.setCategory(r.category());
        return toResponse(repository.update(x));
    }
    public void delete(Long id) { findRestaurant(id); repository.deleteById(id); }
    private Restaurant findRestaurant(Long id) { return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Restaurant not found: "+id)); }
    private RestaurantResponse toResponse(Restaurant x) { return new RestaurantResponse(x.getId(),x.getName(),x.getLocation(),x.getRating(),x.getMainMenu(),x.getCategory()); }
}
