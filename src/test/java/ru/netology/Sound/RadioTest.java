package ru.netology.Sound;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class RadioTest {

    @Test
        // приём первой станции. Отсчёт с 0
    void setMinRadioStation() {
        Radio radio = new Radio();
        radio.setRadioStation(0);
        int expect = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expect, actual);
    }

    @Test
        // приём последеней станции. отсчёт с 0
    void setRadioStationIfNotSetQuantity() {
        Radio radio = new Radio();
        radio.setRadioStation(9);
        int expect = 9;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expect, actual);
    }

    @Test
        //до минимального значения приём станции
    void setUnderMinRadioStation() {
        Radio radio = new Radio();
        radio.setRadioStation(-1);
        int expect = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expect, actual);
    }

    @Test
        //новое максимальное значение и его отработка. Отсчёт с 0
    void setOverMaxNumberRadio() {
        Radio radio = new Radio(35);
        radio.setRadioStation(35);
        int expect = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expect, actual);
    }

    @Test
        //замена максимального значения радио и приём нового пограничного значения
    void setBeforeMaxNumberRadio() {
        Radio radio = new Radio(45);
        radio.setRadioStation(44);
        int expect = 44;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expect, actual);
    }

    @Test
        // актуальная станция в диапазоне 0<=х<=34
    void setNewNumberRadio() {
        Radio radio = new Radio(35); //сколько доступных волн, отсчёт от 0
        radio.setRadioStation(21);
        int expect = 21;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expect, actual);
    }

    @Test
        //если станций не 10, а заданное кол-во
    void nextNumberRadioIfMax() {
        Radio radio = new Radio(37);
        radio.setRadioStation(36);
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
        //переключение станции на предыдущую при другом максимальном кол-ве
    void prevNumberRadioIfMin() {
        Radio radio = new Radio(35);
        radio.setRadioStation(0);
        radio.prev();
        int expect = 34;
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