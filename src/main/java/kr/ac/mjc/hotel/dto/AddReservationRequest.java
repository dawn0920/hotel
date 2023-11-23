package kr.ac.mjc.hotel.dto;

import kr.ac.mjc.hotel.domain.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public class AddReservationRequest {

        private java.sql.Date res_f_date;
        private java.sql.Date res_e_date;
        private  String room_type;
        private  int adult_num;
        private int child_num;
        private String request;
        private String res_status;

        public Reservation toEntity(){
            Reservation reservation = new Reservation(this.res_f_date, this.res_e_date, this.room_type,
                    this.adult_num, this.child_num, this.request, this.res_status);
            return reservation;
        }
    }
