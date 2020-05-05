package ru.netology.registration;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
class Registration {
        private final String location;
        private final String date;
        private final String name;
        private final String phone;
}



