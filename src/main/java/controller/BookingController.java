package controller;


import exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.BookingRepository;
import travel_appModel.Activity;
import travel_appModel.Booking;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/booking")

public class BookingController {
    @Autowired
    BookingRepository bookingRepository;

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>>getAllBookings(@RequestParam(required = false)String Title){
        return (ResponseEntity<List<Booking>>) bookingRepository.findAll();
    }

    @GetMapping("/bookings/{booking_id}")
    public ResponseEntity<Booking>getBookingsById(@PathVariable("id")long booking_id){
        Booking booking = bookingRepository.findById(booking_id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not exist with id :" + booking_id));
        return ResponseEntity.ok(booking);
    }

    @PostMapping("/bookings")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking){
        Booking b = bookingRepository.save(booking);
        return new ResponseEntity<Booking>(b,HttpStatus.OK);
    }

    @PutMapping("/bookings/{booking_id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable("booking_id") long booking_id, @RequestBody Booking booking ) {
        Booking booking1 = bookingRepository.findById(booking_id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not exist with id :" + booking_id));
        booking.setBooking_id(booking.getBooking_id());
        booking.setBooking_date(booking.getBooking_date());
        Booking updatedBooking = bookingRepository.save(booking);
        return ResponseEntity.ok(updatedBooking);
    }

    @DeleteMapping("/bookings/{booking_id}")
    public ResponseEntity<HttpStatus> deleteBooking(@PathVariable("booking_id") long booking_id) {
        Booking booking = bookingRepository.findById(booking_id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not exist with id :" + booking_id));
        bookingRepository.delete(booking);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return new ResponseEntity<HttpStatus>( HttpStatus.OK);
    }

    @DeleteMapping("/bookings")
    public ResponseEntity<HttpStatus> deleteAllTutorials(){
        bookingRepository.deleteAll();
        return new ResponseEntity<HttpStatus>( HttpStatus.OK);
    }



}
