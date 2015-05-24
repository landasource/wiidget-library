package com.landasource.wiidget.library.html;

import com.landasource.wiidget.Tag;
import com.landasource.wiidget.Wiidget;
import com.landasource.wiidget.library.BaseTagWiidget;

import java.util.Map;

/**
 * Created by Zsolti on 2015.05.24..
 */
public class XmlTag extends Wiidget {

    private String name;

    private Map<String, Object> attributes;

    @Override
    public void init() {
        super.init();
        startBuffer();
    }

    @Override
    public void run() {

        String content = endBuffer();

        write(Tag.tag(name, attributes, content));

        super.run();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
}
