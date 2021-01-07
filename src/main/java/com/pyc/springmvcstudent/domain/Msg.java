//IntelliJ IDEA
//springmvcstudent
//Msg
//2021/1/7
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.springmvcstudent.domain;

public class Msg {
    private String title;
    private String content;

    public Msg(String title,String content){
        this.title=title;
        this.content=content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
