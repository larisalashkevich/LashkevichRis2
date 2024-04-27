package com.lashkevich;

import jakarta.ejb.Stateless;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Stateless
public class HotelBean {
    private List<Hotel> hotelList;

    public HotelBean() {
        hotelList = new ArrayList<>(Arrays.asList(
                new Hotel(1, "Hotel1", 5, 29.4, true),
                new Hotel(2, "Hotel2", 4, 60.6, true),
                new Hotel(3, "Hotel3", 3, 15053, true),
                new Hotel(4, "Hotel4", 4, 19.1, false)
        ));
    }

    public List<Hotel> getAllHotels() {
        return hotelList;
    }

    public List<Hotel> getHotelsByPriceAndAvailable(double minPrice, double maxPrice, String stringAvailable) {
        boolean available = stringAvailable.equals("available");
        System.out.println(available);
        List<Hotel> matchHotels = new ArrayList<>();
        for (Hotel hotel : hotelList) {
            if (hotel.isAvailable() != available || hotel.getPrice() < minPrice || hotel.getPrice() > maxPrice)
                continue;
            matchHotels.add(hotel);
        }
        return matchHotels;
    }

    public void deleteHotelById(int id) {
        for (Hotel hotel : hotelList) {
            if (hotel.getId() == id) {
                hotelList.remove(hotel);
                break;
            }
        }
    }
}