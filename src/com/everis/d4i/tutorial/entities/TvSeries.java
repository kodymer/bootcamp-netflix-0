package com.everis.d4i.tutorial.entities;

import java.time.LocalDate;
import java.util.*;
import com.everis.d4i.tutorial.*;

/**
 * TvSeries
 */
public class TvSeries extends Content {

    // region Fields

    private String studyName;
    private int totalSeasons;
    private int premiereYear;
    private final Set<Season> seasons;

    // endregion

    // region Constructors
    
    public TvSeries(UUID id, String name, LocalDate reproductionDate, String studyName, int totalSeasons, int premiereYear) {
        super(id, name, reproductionDate);
        
        this.setStudyName(studyName);
        this.setTotalSeasons(totalSeasons);
        this.setPremiereYear(premiereYear);

        seasons = this.generateSeasons();
    }
    
    //endregion
    
    //region Getters and setters
    
    public String getStudyName() {
        return studyName;
    }
    
    public void setStudyName(String studyName) {
        this.studyName = Check.notNullOrEmpty(studyName, "studyName");
    }

    public int getTotalSeasons() {
        return totalSeasons;
    }

    public void setTotalSeasons(int totalSeasons) {
        this.totalSeasons = Check.notNull(totalSeasons, "totalSeasons");
    }
    
    public int getPremiereYear() {
        return premiereYear;
    }

    public void setPremiereYear(int premiereYear) {
        this.premiereYear = Check.notValid(premiereYear, "premiereYear");;
    }

    //endregion

    //region Behaviors

    private HashSet<Season> generateSeasons() { 

        var totalSeasons = getTotalSeasons();
        var seasons = new HashSet<Season>();

        for(int i = 1; i <= totalSeasons; i++) {
            var season = Season.create(i);
            seasons.add(season);
        }

        return seasons;
    }

    public Season getSeason(int id) {

        Check.notValid(id, "id");

        return seasons.stream().filter(s -> s.getId() == id).findFirst().orElseThrow();
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", %s, %s, %s", this.getStudyName(), this.getTotalSeasons(), this.getPremiereYear());
    }

    //endregion

}