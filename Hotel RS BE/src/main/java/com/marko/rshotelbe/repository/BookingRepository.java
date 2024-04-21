package com.marko.rshotelbe.repository;

import com.marko.rshotelbe.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByRoomRoomId(Long roomId);
    Booking findByBookingConfirmationCode(String confirmationCode);
}
