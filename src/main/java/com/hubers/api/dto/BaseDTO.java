package com.hubers.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lgl
 */
@Data
public class BaseDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @JsonIgnore
    private Long id;

    /**
     * 用户访问凭证
     */
    private String credentials;

    /**
     * 数据创建时间
     */
    private String dataCreateTime;
    /**
     * 数据更新时间
     */
    private String dataUpdateTime;
    /**
     * 排序字段名称
     */
    private String sort;
    /**
     * 排序
     * Constants.ASC or Constants.DESC
     */
    private String order;

    private Limit limit = new Limit();

    public static class Limit {
        /**
         * 开始行号
         */
        private int startRow = 0;
        /**
         * 当前页
         */
        private int currentPage = 1;
        /**
         * 页大小(每页显示数据量)
         */
        private int pageSize = 10;

        private void init() {
            if (currentPage < 1) {
                currentPage = 1;
            }
            if (pageSize < 1) {
                pageSize = 10;
            }
            this.startRow = (currentPage - 1) * pageSize;
        }

        public Limit() {
        }

        public Limit(String currentPage, String pageSize) {
            this(Integer.parseInt(currentPage), Integer.parseInt(pageSize));
        }

        public Limit(int currentPage, int pageSize) {
            this.currentPage = currentPage;
            this.pageSize = pageSize;
            this.init();
        }

        /**
         * 获取当前页号
         */
        public int getCurrentPage() {
            return currentPage;
        }

        /**
         * 获取页大小
         */
        public int getPageSize() {
            return pageSize;
        }

        /**
         * 设置当前页
         */
        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
            this.init();
        }

        /**
         * 设置页大小
         */
        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
            this.init();
        }

        /**
         * 获取开始行
         */
        public int getStartRow() {
            return this.startRow;
        }
    }
}
