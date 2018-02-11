package cn.shan.saw.auth.model.vo;

import lombok.Data;

/**
 * Created by shanlehong on 2018/2/11.
 */
@Data
public class Msg {

    private String title;
    private String content;
    private String etraInfo;

    public Msg(String title, String content, String etraInfo) {
        super();
        this.title = title;
        this.content = content;
        this.etraInfo = etraInfo;
    }
}
