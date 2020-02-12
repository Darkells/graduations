package com.dark.graduations.dto;

import com.dark.graduations.vo.Menus;

import java.util.LinkedList;
import java.util.List;

//默认生成结果
public class MenusDto {
    //默认模板超级管理菜单
    public static List<Menus> buildMenus() {
        List<Menus> result = new LinkedList<Menus>();

        List<Menus> children1 = new LinkedList<Menus>();
        children1.add(new Menus(101, "管理员列表", "/admin/admins", null));
        children1.add(new Menus(102, "教师列表", "/admin/admins", null));
        children1.add(new Menus(103, "学生列表", "/admin/students", null));

        List<Menus> children2 = new LinkedList<Menus>();
        children2.add(new Menus(201, "课程列表", "/admin/lessons", null));
        children2.add(new Menus(202, "选课列表", "/admin/orders", null));

        List<Menus> children3 = new LinkedList<Menus>();
        children3.add(new Menus(301, "系统统计", "/admin/statistics", null));

        result.add(new Menus(1, "用户管理", null, children1));
        result.add(new Menus(2, "课程管理", null, children2));
        result.add(new Menus(3, "系统信息", null, children3));

        return result;
    }

    public static List<Menus> teacher() {
        List<Menus> results = new LinkedList<Menus>();

        List<Menus> children1 = new LinkedList<Menus>();
        children1.add(new Menus(101, "评分", "/admin/garde", null));

        results.add(new Menus(1, "选课管理", null, children1));
        return results;
    }

}
