package kr.ac.mjc.hotel.dto;

import kr.ac.mjc.hotel.domain.Inquiry;

public class InquiryForm {
    private String questionType;
    private String title;
    private String content;
    private String name;
    private String email;
    private String phone;
    private boolean agree;

    // 생성자, Getter, Setter 메서드

    public InquiryForm() {
        // 기본 생성자
    }

    public InquiryForm(String questionType, String title, String content, String name, String email, String phone, boolean agree) {
        this.questionType = questionType;
        this.title = title;
        this.content = content;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.agree = agree;
    }

    public Inquiry toEntity(){
        return new Inquiry(questionType,title,content,name,email,phone,agree);
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isAgree() {
        return agree;
    }

    public void setAgree(boolean agree) {
        this.agree = agree;
    }
}