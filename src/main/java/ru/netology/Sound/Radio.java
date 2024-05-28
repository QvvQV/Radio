package ru.netology.Sound;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class Radio {
    private int maxStation = 9; // Максмимальная станция
    private int minStation = 0; // Минимальная станция
    private int currentStation; // Выбранная станция
    private int numberStation; // Количество станций
    private int maxVolume = 100; // Максимальная громкость
    private int minVolume = 0; // Минимальная громкость
    private int currentVolume; // Выбранная громкость

    // Опции Радиостанций
    public void setNumberStation(int numberStation) {
        if (numberStation > maxStation) {
            this.numberStation = 9;
        }
        if (numberStation < minStation) {
            this.numberStation = 0;
        }
        if (numberStation <= maxStation & numberStation >= minStation) {
            this.numberStation = numberStation - 1;
        }
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation > numberStation) {
            return;
        }
        if (currentStation < minStation) {
            return;
        }
        this.currentStation = currentStation;
    }

    public void nextCurrentStation() {
        int currentStation = this.currentStation;
        if (currentStation >= numberStation) {
            this.currentStation = minStation;
        } else {
            this.currentStation = currentStation + 1;
        }
    }

    public void prevCurrentStation() {
        int currentStation = this.currentStation;
        if (currentStation <= minStation) {
            this.currentStation = numberStation;
        } else {
            this.currentStation = currentStation - 1;
        }
    }

    public void remoteCurrentStation(int currentStation) {
        if (currentStation > maxStation) {
            this.currentStation = maxStation;
        } else
        if (currentStation < minStation) {
            this.currentStation = minStation;
        } else {
            this.currentStation = currentStation;
        }
    }

    // Опции Громкости
    public void setCurrentVolume(int currentVolume) {
        if (currentVolume > maxVolume) {
            return;
        }
        if (currentVolume < minVolume) {
            return;
        }
        this.currentVolume = currentVolume;
    }

    public void nextCurrentVolume() {
        int currentVolume = this.currentVolume;
        if (currentVolume >= maxVolume) {
            this.currentVolume = maxVolume;
        } else {
            this.currentVolume = currentVolume + 1;
        }
    }

    public void prevCurrentVolume() {
        int currentVolume = this.currentVolume;
        if (currentVolume <= minVolume) {
            this.currentVolume = minVolume;
        } else {
            this.currentVolume = currentVolume - 1;
        }
    }
}