package com.everis.d4i.tutorial.entities;

import java.time.LocalDate;
import java.util.*;
import com.everis.d4i.tutorial.*;

public class Film extends Content {

    //region Fields

    private String directorName;
    private int publishingYear;

    //endregion

    //region Constructors

    public Film(UUID id) {
        super(id);
    }

    public Film(UUID id, String name, LocalDate reproductionDate) {
        super(id, name, reproductionDate);
    }

    public Film(UUID id, String name, LocalDate reproductionDate, String directorName, int publishingYear) {
        super(id, name, reproductionDate);

        setDirectorName(directorName);
        setPublishingYear(publishingYear);
    }

    //endregion

    //region Getters and setters

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = Check.notNullOrEmpty(directorName, "directorName");
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = Check.notValid(publishingYear, "publishingYear");
    }

    //endregion

    //region Behaviors

    @Override
    public String toString() {
        return super.toString() + String.format(", %s, %s", this.getDirectorName(), this.getPublishingYear());
    }

    //endregion
}