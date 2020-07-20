package com.hubers.utils.web;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

/**
 * @param <T>
 * @author lgl
 */
@Getter
@Setter
@NoArgsConstructor
public class PageInfo<T> {
    public PageInfo(List<T> list, Pagination pagination) {
        this.list = list;
        this.pagination = pagination;
    }

    private List<T> list;
    private Pagination pagination;

    public List<T> getList() {
        if (this.list == null) {
            this.list = new LinkedList<>();
        }
        return list;
    }

    @Getter
    @Setter
    public static class Pagination {
        public Pagination() {
            this.currentPage = 1L;
            this.pageSize = 0;
            this.total = 0L;
            this.totalPage = 0L;
        }

        public Pagination(long currentPage, int pageSize, long total) {
            this.currentPage = currentPage;
            this.pageSize = pageSize;
            this.total = total;
        }

        private long currentPage;
        private int pageSize;
        private long total;
        private Long totalPage;

        public long getTotalPage() {
            if (totalPage == null || totalPage == 0) {
                totalPage = total / pageSize;
                if (total % pageSize != 0) {
                    totalPage++;
                }
            }
            return totalPage;
        }
    }
}
