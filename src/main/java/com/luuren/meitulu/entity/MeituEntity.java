
package com.luuren.meitulu.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "meitu")
@Data
public class MeituEntity {

    private Agency agency;
    private String cover;
    private String detail_url;
    private List<String> images;
    private Model model;
    private List<Tag> tags;
    private String title;
    private int total_num;

}
