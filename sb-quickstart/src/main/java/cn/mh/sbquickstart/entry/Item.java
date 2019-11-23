package cn.mh.sbquickstart.entry;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: mahao
 * @date: 2019/11/3
 */
@Data
public class Item implements Serializable {

    private Long id;

    private String title;

    private String sellPoint;

    private Long price;

    private Integer num;

    private String barcode;

    private String image;

    private Long cid;

    private Byte status;

    private Date created;

    private Date updated;
}
