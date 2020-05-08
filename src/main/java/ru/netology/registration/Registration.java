package ru.netology.registration;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@RequiredArgsConstructor
class Registration {
    private final String location;
    private final String date;
    private final String name;
    private final String phone;

    void DateSet() {
        LocalDate dates = LocalDate.now();
        LocalDate localDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        localDate = dates.plusDays(3);
        String futureDate = formatter.format(localDate.plusDays(3));
    }
}





