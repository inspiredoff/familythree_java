package Event;

import java.time.LocalDate;
import java.util.List;

import Place.Place;

public class Events {

    private int event_id;
    private String event_name;
    private LocalDate event_date;
    private List<Place> places;

    public Events(String event_name, LocalDate event_date, List<Place> places) {
        this.event_name = event_name;
        this.event_date = event_date;
        this.places = places;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public LocalDate getEvent_date() {
        return event_date;
    }

    public void setEvent_date(LocalDate event_date) {
        this.event_date = event_date;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Place...places) {
        this.places = List.of(places);
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
