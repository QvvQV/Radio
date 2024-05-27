package ru.netology.Sound;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class Radio {
    private int currentRadioStation;
    private int maxQuantityRadioStation = 10;
    private int maxVolume = 100;
    private int minVolume = 0;
    private int currentVolume = minVolume;

    public Radio(int maxQuantityRadioStation) {
        this.maxQuantityRadioStation = maxQuantityRadioStation;
    }

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public void setRadioStation(int newNumberCurrentRadio) {
        if (newNumberCurrentRadio < 0 || newNumberCurrentRadio >= maxQuantityRadioStation) {
            return;
        }
        currentRadioStation = newNumberCurrentRadio;
    }

    public void next() {
        if (currentRadioStation == maxQuantityRadioStation - 1) {
            currentRadioStation = 0;
        } else {
            currentRadioStation++;
        }
    }

    public void prev() {
        if (currentRadioStation == 0) {
            currentRadioStation = maxQuantityRadioStation - 1;
        } else {
            currentRadioStation--;
        }

    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void increaseVolume() { //увеличение звука
        if (currentVolume < maxVolume) {
            currentVolume = currentVolume + 1;
        }

    }

    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume < minVolume || newCurrentVolume > maxVolume) {
            return;
        }
        currentVolume = newCurrentVolume;
    }

    public void volumeUp() { //для цикла
        if (currentVolume == maxVolume) {
            return;
        }
        currentVolume++;
    }

}