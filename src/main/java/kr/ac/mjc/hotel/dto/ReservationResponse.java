package kr.ac.mjc.hotel.dto;

import kr.ac.mjc.hotel.domain.Reservation;

public class ReservationResponse {

    private boolean success;
    private String message;
    private Reservation reservation;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}


