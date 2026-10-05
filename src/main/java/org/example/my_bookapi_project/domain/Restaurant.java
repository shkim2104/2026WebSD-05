package org.example.my_bookapi_project.domain;

public class Restaurant {
    private Long id;
    private String name;
    private String location;
    private double rating;
    private String mainMenu;
    private String category;

    public Restaurant() {}
    public Restaurant(Long id, String name, String location, double rating, String mainMenu, String category) {
        this.id=id; this.name=name; this.location=location; this.rating=rating; this.mainMenu=mainMenu; this.category=category;
    }
    public Long getId(){ return id; }
    public void setId(Long id){ this.id=id; }
    public String getName(){ return name; }
    public void setName(String name){ this.name=name; }
    public String getLocation(){ return location; }
    public void setLocation(String location){ this.location=location; }
    public double getRating(){ return rating; }
    public void setRating(double rating){ this.rating=rating; }
    public String getMainMenu(){ return mainMenu; }
    public void setMainMenu(String mainMenu){ this.mainMenu=mainMenu; }
    public String getCategory(){ return category; }
    public void setCategory(String category){ this.category=category; }
}
