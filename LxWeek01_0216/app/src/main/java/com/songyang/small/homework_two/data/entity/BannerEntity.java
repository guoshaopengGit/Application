package com.songyang.small.homework_two.data.entity;

import java.util.List;

public class BannerEntity {

    /**
     * result : [{"imageUrl":"http://172.17.8.100/images/small/banner/cj.png",
     * "jumpUrl":"http://172.17.8.100/htm/lottery/index.html","rank":5,"title":"抽奖"},{"imageUrl
     * ":"http://172.17.8.100/images/small/banner/hzp.png",
     * "jumpUrl":"wd://commodity_list?arg=1001007005","rank":5,"title":"美妆工具"},{"imageUrl":"http
     * ://172.17.8.100/images/small/banner/lyq.png","jumpUrl":"wd://commodity_info?arg=83",
     * "rank":5,"title":"连衣裙"},{"imageUrl":"http://172.17.8.100/images/small/banner/px.png",
     * "jumpUrl":"wd://commodity_info?arg=165","rank":5,"title":"跑鞋"},{"imageUrl":"http://172.17
     * .8.100/images/small/banner/wy.png","jumpUrl":"wd://commodity_list?arg=1001002004",
     * "rank":5,"title":"卫衣"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * imageUrl : http://172.17.8.100/images/small/banner/cj.png
         * jumpUrl : http://172.17.8.100/htm/lottery/index.html
         * rank : 5
         * title : 抽奖
         */

        private String imageUrl;
        private String jumpUrl;
        private int rank;
        private String title;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getJumpUrl() {
            return jumpUrl;
        }

        public void setJumpUrl(String jumpUrl) {
            this.jumpUrl = jumpUrl;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
