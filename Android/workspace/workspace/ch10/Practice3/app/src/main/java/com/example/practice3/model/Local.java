package com.example.practice3.model;

import java.io.Serializable;

public class Local implements Serializable {
    public static int total_count;      // 검색어에 검색된 문서수 Integer
    public static int pageable_count;   // total_count 중에 노출가능 문서수 Integer
    public static boolean is_end;       // 현재 페이지가 마지막 페이지인지 여부. 값이 false이면 page를 증가시켜 다음 페이지를 요청할 수 있음. Boolean
    public static String same_name;     // 질의어의 지역/키워드 분석 정보

    private String id;      // 장소 ID String
    private String place_name;  // 장소명, 업체명 String
    private String category_name;   // 카테고리 이름 String
    private String category_group_code; // 중요 카테고리만 그룹핑한 카테고리 그룹 코드. Request에 category_group_code 테이블 참고 String
    private String category_group_name; // 중요 카테고리만 그룹핑한 카테고리 그룹명. Request에 category_group_code 테이블 참고 String
    private String phone;   // 전화번호 String
    private String address_name;    // 전체 지번 주소 String
    private String road_address_name;   // 전체 도로명 주소 String
    private String x;   // X 좌표값 혹은 longitude String
    private String y;   // Y 좌표값 혹은 latitude String
    private String place_url;   // 장소 상세페이지 URL String
    private String distance;    // 중심좌표까지의 거리(x,y 파라미터를 준 경우에만 존재). 단위 meter

    public static int getTotal_count() {
        return total_count;
    }

    public static void setTotal_count(int total_count) {
        Local.total_count = total_count;
    }

    public static int getPageable_count() {
        return pageable_count;
    }

    public static void setPageable_count(int pageable_count) {
        Local.pageable_count = pageable_count;
    }

    public static boolean isIs_end() {
        return is_end;
    }

    public static void setIs_end(boolean is_end) {
        Local.is_end = is_end;
    }

    public static String getSame_name() {
        return same_name;
    }

    public static void setSame_name(String same_name) {
        Local.same_name = same_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_group_code() {
        return category_group_code;
    }

    public void setCategory_group_code(String category_group_code) {
        this.category_group_code = category_group_code;
    }

    public String getCategory_group_name() {
        return category_group_name;
    }

    public void setCategory_group_name(String category_group_name) {
        this.category_group_name = category_group_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress_name() {
        return address_name;
    }

    public void setAddress_name(String address_name) {
        this.address_name = address_name;
    }

    public String getRoad_address_name() {
        return road_address_name;
    }

    public void setRoad_address_name(String road_address_name) {
        this.road_address_name = road_address_name;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getPlace_url() {
        return place_url;
    }

    public void setPlace_url(String place_url) {
        this.place_url = place_url;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
