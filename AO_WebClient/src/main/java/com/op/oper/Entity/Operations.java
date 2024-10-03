package com.op.oper.Entity;

public class Operations {

        private Integer a;
        private Integer b;
        private String op;
        private Integer res;
        
        public Operations(Integer a, Integer b, String op) {
            this.a = a;
            this.b = b;
            this.op = op;
        }

        public Integer getA() {
            return a;
        }
        public void setA(Integer a) {
            this.a = a;
        }
        public Integer getB() {
            return b;
        }
        public void setB(Integer b) {
            this.b = b;
        }
        public String getOp() {
            return op;
        }
        public void setOp(String op) {
            this.op = op;
        }
        public Integer getRes() {
            return res;
        }
        public void setRes(Integer res) {
            this.res = res;
        }
        

}
