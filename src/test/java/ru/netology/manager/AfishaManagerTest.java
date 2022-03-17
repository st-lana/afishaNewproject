package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Afisha;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {
    private AfishaManager service = new AfishaManager();
    private Afisha first = new Afisha(1, "1-blood", "Бладшот", 1999, "Боевик");
    private Afisha second = new Afisha(2, "2-vpered", "Вперед", 2020, "Мультфильм");
    private Afisha third = new Afisha(3, "34-hotel", "Отель Белград", 1990, "Комедия");
    private Afisha fourth = new Afisha(4, "52-jentlemen", "Джентльмены", 2021, "Боевик");
    private Afisha fifth = new Afisha(5, "333-nevidimka", "Человек-невидимка", 2016, "Ужасы");


    @Test
    void shouldAdd() {
        Afisha[] expected = {first, second, third, fourth, fifth};
        service.add(first);
        service.add(second);
        service.add(third);
        service.add(fourth);
        service.add(fifth);

        assertArrayEquals(expected, service.findAll());

    }

    @Test
    void shouldFindLast() {
        Afisha[] expected = {fifth, fourth, third, second, first};

        service.add(first);
        service.add(second);
        service.add(third);
        service.add(fourth);
        service.add(fifth);

        assertArrayEquals(expected, service.findLast());

    }

    @Test
    void shouldShowOnePositionArray() {
        Afisha[] expected = {first};
        service.add(first);
        assertArrayEquals(expected, service.findAll());
    }
    @Test
    void shouldCheckEmptyArray() {
        assertArrayEquals(null, service.findAll());
    }

    @Test
    void shouldCheckArrayWithUsersConstructor() {
        AfishaManager service = new AfishaManager(3);
        service.add(first);
        service.add(second);
        service.add(third);
        service.add(fourth);

        Afisha[] expected = {first, second, third};
        assertArrayEquals(expected, service.findAll());


    }
}