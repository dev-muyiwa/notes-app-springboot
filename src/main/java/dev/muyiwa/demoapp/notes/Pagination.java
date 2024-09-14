package dev.muyiwa.demoapp.notes;

import java.util.List;

public class Pagination<T> {
    private final List<T> content;
    private final int currentPage;
    private final boolean hasPreviousPage;
    private final boolean hasNextPage;
    private final String previousPageUrl;
    private final String nextPageUrl;
    private final int size;
    private final long totalData;

    public Pagination(List<T> content, int currentPage, boolean hasPreviousPage, boolean hasNextPage,
                      String previousPageUrl, String nextPageUrl, int size, long totalData) {
        this.content = content;
        this.currentPage = currentPage;
        this.hasPreviousPage = hasPreviousPage;
        this.hasNextPage = hasNextPage;
        this.previousPageUrl = previousPageUrl;
        this.nextPageUrl = nextPageUrl;
        this.size = size;
        this.totalData = totalData;
    }

    public List<T> getContent() {
        return content;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public String getPreviousPageUrl() {
        return previousPageUrl;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public int getSize() {
        return size;
    }

    public long getTotalData() {
        return totalData;
    }

    public int getCurrentPage() {
        return currentPage;
    }
}
