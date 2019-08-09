package com.member;

public class MemberDto { // 자바에서 사용자정의 데이터타입으로 레코드 셀과 매핑
   private int num;
   private String name;
   private String addr;
   
   public MemberDto() {}
   public MemberDto(int num, String name, String addr) {
      this.num = num;
      this.name = name;
      this.addr = addr;
   }
   public int getNum() {
      return num;
   }
   public void setNum(int num) {
      this.num = num;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getAddr() {
      return addr;
   }
   public void setAddr(String addr) {
      this.addr = addr;
   }
   
   
}