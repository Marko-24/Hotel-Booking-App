package com.marko.rshotelbe.service.impl;

import com.marko.rshotelbe.exceptions.InvalidBookingRequestException;
import com.marko.rshotelbe.model.Booking;
import com.marko.rshotelbe.model.Room;
import com.marko.rshotelbe.repository.BookingRepository;
import com.marko.rshotelbe.service.BookingService;
import com.marko.rshotelbe.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final RoomService roomService;

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> getAllBookingsByRoomId(Long roomId) {
        return bookingRepository.findByRoomRoomId(roomId);
    }

    @Override
    public void cancelBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    @Override
    public String saveBooking(Long roomId, Booking bookingRequest) {
        if(bookingRequest.getCheckOutDate().isBefore(bookingRequest.getCheckInDate())) {
            throw new InvalidBookingRequestException("Check-In date must come before Check-Out date.");
        }
        Room room = roomService.getRoomById(roomId).get();
        List<Booking> bookings = room.getBookings();
        boolean roomIsAvailable = roomIsAvailable(bookingRequest, bookings);
        if(roomIsAvailable) {
            room.addBooking(bookingRequest);
            bookingRepository.save(bookingRequest);
        } else {
            throw new InvalidBookingRequestException("Sorry, the selected dates have already been booked." +
                                                     "Please try selecting different ones.");
        }
        return bookingRequest.getBookingConfirmationCode();
    }

    @Override
    public Booking findByBookingConfirmationCode(String confirmationCode) {
        return bookingRepository.findByBookingConfirmationCode(confirmationCode);
    }

    /** Private methods */

    private boolean roomIsAvailable(Booking bookingRequest, List<Booking> bookings) {
        return bookings.stream()
                       .noneMatch(booking -> bookingRequest.getCheckInDate().equals(booking.getCheckInDate())
                                          || bookingRequest.getCheckOutDate().isBefore(booking.getCheckOutDate())
                                          || (bookingRequest.getCheckInDate().isAfter(booking.getCheckInDate())
                                          && bookingRequest.getCheckInDate().isBefore(booking.getCheckOutDate()))
                                          || (bookingRequest.getCheckInDate().isBefore(booking.getCheckInDate())

                                          && bookingRequest.getCheckOutDate().equals(booking.getCheckOutDate()))
                                          || (bookingRequest.getCheckInDate().isBefore(booking.getCheckInDate())

                                          && bookingRequest.getCheckOutDate().isAfter(booking.getCheckOutDate()))

                                          || (bookingRequest.getCheckInDate().equals(booking.getCheckOutDate())
                                          && bookingRequest.getCheckOutDate().equals(booking.getCheckInDate()))

                                          || (bookingRequest.getCheckInDate().equals(booking.getCheckOutDate())
                                          && bookingRequest.getCheckOutDate().equals(bookingRequest.getCheckInDate()))
                       );
    }
}
