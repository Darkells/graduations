package com.dark.graduations.vo;

import lombok.Data;

import java.util.List;

@Data
public class Menus {
    private Integer id;

    private String menuname;

    private String path;

    private List<Menus> children;


    public Menus(Integer id, String menuname, String path, List<Menus> children) {
        this.id = id;
        this.menuname = menuname;
        this.path = path;
        this.children = children;
    }
}
