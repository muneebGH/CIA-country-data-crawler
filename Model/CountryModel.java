package mine.Model;

import java.util.ArrayList;
import java.util.Arrays;

public class CountryModel {
    private String name;
    private String url;

    private String hazards;
    private Boolean proneToEQ;
    private boolean hasStarInflag;


    private String flagDesc;
    private int lowestElevation;
    private float forestCoverage;
    private float electricityConsumpTotal;
    private double electricityConsumpCapita;
    private long population;
    private String dominateEthnicity;
    private boolean landlocked;
    private String deathRate;
    private int[] cords;
    private float dominateEthnicityPercentage;
    private int deathRateRank;

    private float agricultureCoverage;


    private String continent;
    private float medianAge;
    private int medianAgeRank;


    public CountryModel(String name, String url) {
        this.name = name;
        this.url = url;
        hazards="none";
        flagDesc="none";
        proneToEQ=false;
        hasStarInflag=false;
        lowestElevation=-1;
        forestCoverage=-1;
        electricityConsumpTotal=-1;
        electricityConsumpCapita=-1;
        population=-1;
        dominateEthnicity="none";
        landlocked=false;
        deathRate="none";
        cords=new int[4];
        dominateEthnicityPercentage=-1;
        deathRateRank=-1;
        medianAge=-1;
        medianAgeRank=-1;
        continent="";
        agricultureCoverage=0;
    }


    public float getAgricultureCoverage() {
        return agricultureCoverage;
    }

    public void setAgricultureCoverage(float agricultureCoverage) {
        this.agricultureCoverage = agricultureCoverage;
    }


    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public float getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(float medianAge) {
        this.medianAge = medianAge;
    }

    public int getMedianAgeRank() {
        return medianAgeRank;
    }

    public void setMedianAgeRank(int medianAgeRank) {
        this.medianAgeRank = medianAgeRank;
    }



    public int getDeathRateRank() {
        return deathRateRank;
    }

    public void setDeathRateRank(int deathRateRank) {
        this.deathRateRank = deathRateRank;
    }

    public float getDominateEthnicityPercentage() {
        return dominateEthnicityPercentage;
    }

    public void setDominateEthnicityPercentage(float dominateEthnicityPercentage) {

        this.dominateEthnicityPercentage = dominateEthnicityPercentage;
    }

    public Boolean getProneToEQ() {
        return proneToEQ;
    }

    public void setProneToEQ(Boolean proneToEQ) {
        this.proneToEQ = proneToEQ;
    }


    public boolean isHasStarInflag() {
        return hasStarInflag;
    }

    public void setHasStarInflag(boolean hasStarInflag) {
        this.hasStarInflag = hasStarInflag;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setHazards(String hazards) {
        this.hazards = hazards;
    }

    public void setFlagDesc(String flagDesc) {
        this.flagDesc = flagDesc;
    }

    public void setLowestElevation(int lowestElevation) {
        this.lowestElevation = lowestElevation;
    }

    public void setForestCoverage(float forestCoverage) {
        this.forestCoverage = forestCoverage;
    }

    public void setElectricityConsumpTotal(float electricityConsumpTotal) {
        this.electricityConsumpTotal = electricityConsumpTotal;
    }

    public void setElectricityConsumpCapita(double electricityConsumpCapita) {
        this.electricityConsumpCapita = electricityConsumpCapita;
    }



    public void setPopulation(long population) {
        this.population = population;
    }

    public void setDominateEthnicity(String dominateEthnicity) {
        this.dominateEthnicity = dominateEthnicity;
    }

    public void setLandlocked(boolean landlocked) {
        this.landlocked = landlocked;
    }

    public void setDeathRate(String deathRate) {
        this.deathRate = deathRate;
    }

    public void setCords(int[] cords) {
        this.cords = cords;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getHazards() {
        return hazards;
    }

    public String getFlagDesc() {
        return flagDesc;
    }

    public int getLowestElevation() {
        return lowestElevation;
    }

    public float getForestCoverage() {
        return forestCoverage;
    }

    public float getElectricityConsumpTotal() {
        return electricityConsumpTotal;
    }

    public double getElectricityConsumpCapita() {
        return electricityConsumpCapita;
    }

    public long getPopulation() {
        return population;
    }

    public String getDominateEthnicity() {
        return dominateEthnicity;
    }

    public boolean isLandlocked() {
        return landlocked;
    }

    public String getDeathRate() {
        return deathRate;
    }

    public int[] getCords() {
        return cords;
    }


    @Override
    public String toString() {
        return "CountryModel{" +
                "name='" + name + '\'' +
                "\n, url='" + url + '\'' +
                "\n, hazards=" + hazards +
                "\n, proneToEQ=" + proneToEQ +
                "\n, hasStarInflag=" + hasStarInflag +
                "\n, flagDesc='" + flagDesc + '\'' +
                "\n, lowestElevation=" + lowestElevation +
                "\n, forestCoverage=" + forestCoverage +
                "\n, electricityConsumpTotal=" + electricityConsumpTotal +
                "\n, electricityConsumpCapita=" + electricityConsumpCapita +
                "\n, population=" + population +
                "\n, dominateEthnicity='" + dominateEthnicity + '\'' +
                "\n, landlocked=" + landlocked +
                "\n, deathRate='" + deathRate + '\'' +
                "\n, cords=" + Arrays.toString(cords) +
                "\n, dominateEthnicityPercentage=" + dominateEthnicityPercentage +
                "\n, deathRateNumber=" + deathRateRank +
                '}';
    }
}