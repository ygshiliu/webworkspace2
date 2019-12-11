package com.wnn;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/*
* 使用DOM4j实现XML解析步骤：
1.引入jar包：dom4j-1.6.1.jar

* */
public class XmlParse {

    @Test
    public void testDom4j() throws Exception {
        //解析器
        final SAXReader saxReader = new SAXReader();
        //获取文档对象
        final Document document = saxReader.read("students.xml");
//        获取根元素
        final Element rootElement = document.getRootElement();
//        获取元素集合
        final List<Element> list = rootElement.elements("student");
        for (Element ele : list) {
            final String id = ele.attributeValue("id");
            final String name = ele.elementText("name");
            final String age = ele.elementText("age");
            final String desc = ele.elementText("desc");

//            System.out.println(id);
//            System.out.println(name);
//            System.out.println(age);
//            System.out.println(desc);
            final Student student = new Student(Integer.parseInt(id), name, Integer.valueOf(age), desc);
            System.out.println(student);
            System.out.println("--------------------");
        }

    }

    @Test
    public void testxpath() throws Exception {
        //解析器
        final SAXReader saxReader = new SAXReader();
        //获取文档对象
        final Document document = saxReader.read("students.xml");

        final List list = document.selectNodes("/students/student");
        System.out.println(list);

        final Element stu = (Element) document.selectSingleNode("/students/student[@id=2]");
        System.out.println(stu);

        System.out.println(stu.elementText("name"));
        System.out.println(stu.elementText("age"));
        System.out.println(stu.elementText("desc"));
        System.out.println(stu.attributeValue("id"));


    }
}
