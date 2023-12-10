package kr.ac.mjc.hotel.dto;

import kr.ac.mjc.hotel.domain.Hotelroom;
import kr.ac.mjc.hotel.domain.Reservation;
import kr.ac.mjc.hotel.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public class AddReservationRequest {


        private String email;
        private java.sql.Date res_f_date;
        private java.sql.Date res_e_date;
        private String room_type;
        private User rester;
        private  int adult_num;
        private int child_num;
        private String request;
        private String res_status;

        public Reservation toEntity() {
            Reservation reservation = new Reservation();
            reservation.setRes_f_date(this.res_f_date);
            reservation.setRes_e_date(this.res_e_date);
            reservation.setAdult_num(this.adult_num);
            reservation.setChild_num(this.child_num);
            reservation.setRequest(this.request);
            // 다른 필드들도 설정해 주세요
            return reservation;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getRoom_type() {
            return room_type;
        }

        public void setRoom_type(String room_type) {
            this.room_type = room_type;
        }

    }
