package com.iflytek.tms.pojo;
/**
 * CREATE TABLE `t_musictype` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `name` varchar(10) DEFAULT NULL,
 *   `note` varchar(20) DEFAULT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8
 */

/**
 * @author XiaoFeng
 * @date 2019/4/29 - 18:57
 * 乐器类型
 */
public class MusicType {
    private  Integer id;
    private String name;
    private  String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
