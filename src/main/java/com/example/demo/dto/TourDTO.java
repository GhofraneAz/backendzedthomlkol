package com.example.demo.dto;


public class TourDTO {
	private Long id;
    private Long codeTour;
    private String codeDistrict;
    private String libelleTour;
  
    public TourDTO() {}

    public TourDTO(Long codeTour,Long id, String codeDistrict, String libelleTour) {
        this.codeTour = codeTour;
        this.codeDistrict = codeDistrict;
        this.libelleTour = libelleTour;
        this.id=id;
    }

    public Long getCodeTour() {
        return codeTour;
    }

    public void setCodeTour(Long codeTour) {
        this.codeTour = codeTour;
    }

    public String getCodeDistrict() {
        return codeDistrict;
    }

    public void setCodeDistrict(String codeDistrict) {
        this.codeDistrict = codeDistrict;
    }

    public String getLibelleTour() {
        return libelleTour;
    }

    public void setLibelleTour(String libelleTour) {
        this.libelleTour = libelleTour;
    }
}

