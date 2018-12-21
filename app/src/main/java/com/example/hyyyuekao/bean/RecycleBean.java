package com.example.hyyyuekao.bean;

import java.util.List;

public class RecycleBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String sellerName;
        private String sellerid;
        private List<UserBean> list;

        public String getSellerName() {
            return sellerName;
        }

        public void setSellerName(String sellerName) {
            this.sellerName = sellerName;
        }

        public String getSellerid() {
            return sellerid;
        }

        public void setSellerid(String sellerid) {
            this.sellerid = sellerid;
        }

        public List<UserBean> getList() {
            return list;
        }

        public void setList(List<UserBean> list) {
            this.list = list;
        }
        public static class UserBean{
            private String images;
            private int pid;
            private double price;
            private String subhead;
            private String title;

            public void setImages(String images) {
                this.images = images;
            }

            public void setPid(int pid) {
                this.pid = pid;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public void setSubhead(String subhead) {
                this.subhead = subhead;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImages() {

                return images;
            }

            public int getPid() {
                return pid;
            }

            public double getPrice() {
                return price;
            }

            public String getSubhead() {
                return subhead;
            }

            public String getTitle() {
                return title;
            }
        }
    }


}
