package com.everis.d4i.tutorial.entities;

import java.time.*;
import java.util.*;

/**
 * Documental
 */
public class DocumentaryFilm extends Film  {

    //region Constructors

    public DocumentaryFilm(UUID id) {
        super(id);
    }
    
    public DocumentaryFilm(UUID id, String name, LocalDate reproductionDate) {
        super(id, name, reproductionDate);
    }

    public DocumentaryFilm(UUID id, String name, LocalDate reproductionDate, String directorName, int publishingYear) {
        super(id, name, reproductionDate, directorName, publishingYear);
    }

    //endregion

}