package ru.netology.Sound;

public class Radio {
    public int currentRadioStation;
    public int currentVolume;

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public void setRadioStation(int newNumberCurrentRadio) {
        if (newNumberCurrentRadio < 0 || newNumberCurrentRadio > 9) {
            return;
        }
        currentRadioStation = newNumberCurrentRadio;
    }

    public void next(){
        if (currentRadioStation==9) {
            currentRadioStation = 0;
        } else {
            currentRadioStation++;
        }
    }

    public void prev(){
        if (currentRadioStation==0) {
            currentRadioStation = 9;
        } else {
            currentRadioStation--;
        }

    }

    public int getCurrentVolume(){
        return currentVolume;
    }

    public void increaseVolume() { //увеличение звука
        if (currentVolume<100){
            currentVolume = currentVolume + 1;
        }

    }

    public void setCurrentVolume (int newCurrentVolume) {
        if( newCurrentVolume < 0 || newCurrentVolume > 100) {
            return;
        }
        currentVolume = newCurrentVolume;
    }

    public void volumeUp() { //для цикла
        if (currentVolume == 100) {
            return;
        } currentVolume++;
    }

    }