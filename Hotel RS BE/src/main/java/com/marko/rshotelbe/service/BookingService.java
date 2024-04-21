package com.marko.rshotelbe.service;

import com.marko.rshotelbe.model.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> getAllBookingsByRoomId(Long roomId);

    void cancelBooking(Long bookingId);

    String saveBooking(Long roomId, Booking bookingRequest);

    Booking findByBookingConfirmationCode(String confirmationCode);

    List<Booking> getAllBookings();
}
