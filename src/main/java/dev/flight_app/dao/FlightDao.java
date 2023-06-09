package dev.flight_app.dao;

import dev.flight_app.database.FlightDB;
import dev.flight_app.entities.Flight;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FlightDao implements DAO<Integer, Flight> {

    private Map<Integer, Flight> flights = new HashMap<>();
    private final FlightDB FDB = FlightDB.getFDB();
    public FlightDao(){
        this.flights = FDB.read();
    }

    @Override
    public Map<Integer, Flight> getAll() {
        return flights;
    }

    @Override
    public Optional<Flight> getById(Integer id) {
        return Optional.ofNullable(flights.get(id));
    }

    @Override
    public boolean delete(Integer id) {
        return Optional.ofNullable(flights.remove(id))
                .isPresent();
    }
    @Override
    public boolean save() {
        return FDB.write(flights);
    }
}
