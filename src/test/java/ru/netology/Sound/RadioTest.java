package ru.netology.Sound;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class RadioTest {
    @Test
        //граничные значения диапазона 0<=х<=9
    void setRadioStation() {
        Radio radio = new Radio();
        int expect = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expect, actual);
    }

    @Test
        //граничные значения диапазона 0<=х<=9
    void setMaxRadioStation() {
        Radio radio = new Radio();
        radio.setRadioStation(9);
        int expect = 9;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expect, actual);
    }

    @Test
        //выполнение условия диапазона 0<=х<=9
    void setAfterMaxNumberRadio() {
        Radio radio = new Radio();
        radio.setRadioStation(10);
        int expect = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expect, actual);
    }

    @Test
        //выполнение условия диапазона 0<=х<=9
    void setBeforeMinNumberRadio() {
        Radio radio = new Radio();
        radio.setRadioStation(-1);
        int expect = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expect, actual);
    }

    @Test
        // актуальная станция в диапазоне 0<=х<=9
    void setNewNumberRadio() {
        Radio radio = new Radio();
        radio.setRadioStation(7);
        int expect = 7;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expect, actual);
    }

    @Test
        // после 9 станции идёт 0
    void nextNumberRadioMax() {
        Radio radio = new Radio();
        radio.setRadioStation(9);
        radio.next();
        int expect = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expect, actual);
    }

    @Test
        //переключение станции на следующую
    void nextNumberRadio() {
        Radio radio = new Radio();
        radio.setRadioStation(3);
        radio.next();
        int expect = 4;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expect, actual);
    }

    @Test
        // перед 0 идёт 9
    void prevNumberRadioMin() {
        Radio radio = new Radio();
        radio.setRadioStation(0);
        radio.prev();
        int expect = 9;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expect, actual);
    }

    @Test
        //переключение станции на предыдущую
    void prevNumberRadio() {
        Radio radio = new Radio();
        radio.setRadioStation(8);
        radio.prev();
        int expect = 7;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expect, actual);
    }

    @Test
        //максимальное значение звука
    void volumeMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        int expect = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expect, actual);
    }

    @Test
        //граница максимального значение звука
    void volumeMaxUp() {
        Radio radio = new Radio();
        radio.setCurrentVolume(101);
        int expect = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expect, actual);
    }

    @Test
    void volumeUp() {
        Radio radio = new Radio();
        radio.setCurrentVolume(55);
        radio.increaseVolume();
        int expect = 56;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expect, actual);
    }

    @Test
        //отрицательная граница 0
    void volumeMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-1);
        int expect = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expect, actual);
    }

    @Test
        // с беззвучного до максимальной громкости
    void volumeUpIfMax() {
        Radio radio = new Radio();
        for (int i = 0; i <= 100; i++) {
            radio.volumeUp();
        }
        int expect = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expect, actual);
    }
}
