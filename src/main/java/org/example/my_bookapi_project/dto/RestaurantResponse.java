package org.example.my_bookapi_project.dto;

public record RestaurantResponse(Long id, String name, String location, double rating, String mainMenu, String category) {}
