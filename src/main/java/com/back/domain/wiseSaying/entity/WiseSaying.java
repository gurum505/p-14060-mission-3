package com.back.domain.wiseSaying.entity;
//역할 : 명언 객체(번호/명언내용/작가)
//
//이 클래스는 컨트롤러, 서비스, 리포지터리 모두에서 사용가능
public class WiseSaying {
    private static int lastId = 0;
    private int id;
    private String content;
    private String author;

    public WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public int getId() {
        return this.id;
    }
    public String getContent() {
        return content;
    }
    public String getAuthor() {
        return author;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public int getLastId () {
        return lastId;
    }
    public void setLastId(int lastId) {
        WiseSaying.lastId = lastId;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
