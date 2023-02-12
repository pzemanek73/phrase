package com.pz.phrase.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectsRoot {
    private int pageNumber;
    private List<ProjectInfo> content;
    private int numberOfElements;
    private int totalElements;
    private int pageSize;
    private int totalPages;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List<ProjectInfo> getContent() {
        return content;
    }

    public void setContent(List<ProjectInfo> content) {
        this.content = content;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public String toString() {
        return "ProjectsRoot{" +
                "pageNumber=" + pageNumber +
                ", content=" + content +
                ", numberOfElements=" + numberOfElements +
                ", totalElements=" + totalElements +
                ", pageSize=" + pageSize +
                ", totalPages=" + totalPages +
                '}';
    }
}
