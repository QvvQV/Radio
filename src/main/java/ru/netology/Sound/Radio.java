package ru.netology.Sound;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class Radio {


    private int currentVolume;          // текущая громкость
    private int maxCurrentVolume = 100;
    private int minCurrentVolume = 0;
    private int currentRadioStation;        // текущая радиостанция
    private int maxCurrentRadioStation = 9;
    private int minCurrentRadioStation = 0;


    public Radio(int numberOfStations) {
        maxCurrentRadioStation = minCurrentRadioStation + numberOfStations - 1;
    }


    public void setCurrentRadioStation(int newCurrentRadioStation) {  // установка радиостанции
        if (newCurrentRadioStation > maxCurrentRadioStation) {
            return;
        }
        if (newCurrentRadioStation < minCurrentRadioStation) {
            return;
        }
        currentRadioStation = newCurrentRadioStation;
    }


    public void volumeUp() {                // увеличение громкости на 1
        if (currentVolume < maxCurrentVolume) {
            currentVolume++;
        }
    }

    public void volumeDown() {              // уменьшение громкости на 1
        if (currentVolume > minCurrentVolume) {
            currentVolume--;
        }
    }


    public void next() {                // следущая радиостанция
        if (currentRadioStation < maxCurrentRadioStation) {
            currentRadioStation++;
        } else {
            currentRadioStation = minCurrentRadioStation;
        }
    }

    public void prev() {                // предыдущая радиостанция
        if (currentRadioStation > minCurrentRadioStation) {
            currentRadioStation--;
        } else {
            currentRadioStation = maxCurrentRadioStation;
        }
    }

}