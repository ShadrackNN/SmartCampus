package com.curiositylabs.apps.smartcampus;



class Book {

    private String description;
    private String downloadURL;

    public Book(String description, String downloadURL) {
        this.description = description;
        this.downloadURL = downloadURL;
    }

    Book() {
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    String getDownloadURL() {
        return downloadURL;
    }

    void setDownloadURL(String downloadURL) {
        this.downloadURL = downloadURL;
    }

    @Override
    public String toString() {
        return "Book{" +
                "description='" + description + '\'' +
                ", downloadURL='" + downloadURL + '\'' +
                '}';
    }
}
