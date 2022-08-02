package com.shashwat.LibraryManagementSystem.DAO;

public class SearchRequest {

    /*1 for author
      2 for books
      3 for bookCategory
    * */
    private int searchChoice;

    private String title;

    private int pageLimit;

    private int page_no;

    public int getSearchChoice() {
        return searchChoice;
    }

    public void setSearchChoice(int searchChoice) {
        this.searchChoice = searchChoice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageLimit() {
        return pageLimit;
    }

    public void setPageLimit(int pageLimit) {
        this.pageLimit = pageLimit;
    }

    public int getPage_no() {
        return page_no;
    }

    public void setPage_no(int page_no) {
        this.page_no = page_no;
    }
}
